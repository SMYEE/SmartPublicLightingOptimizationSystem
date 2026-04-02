/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import authentication.JwtServerInterceptor;
import Util.JwtUtil;
import static Util.ServiceClientUtil.getServiceAddress;
import grpc.generated.energy.*;
import grpc.generated.traffic.*;
import io.grpc.Context;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkp
 */
public class EnergyOptimizationServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50053)
                .addService(new EnergyServiceImpl())
                .intercept(new JwtServerInterceptor())
                .build();

        server.start();
        System.out.println("EnergyOptimization Server started on port 50053");
        server.awaitTermination();
    }

    private static int calculateBrightness(String traffic) {
        int hour = java.time.LocalTime.now().getHour();
        String weather = Math.random() > 0.5 ? "clear" : "rainy";

        int baseBrightness;

        // Traffic
        switch (traffic) {
            case "low":
                baseBrightness = (int) (Math.random() * 30);
                break;
            case "medium":
                baseBrightness = (int) (Math.random() * 60);
                break;
            default:
                baseBrightness = (int) (Math.random() * 80);
        }

        // Time (if night time, brighter)
        if (hour >= 18 || hour <= 6) {
            baseBrightness += (int) (Math.random() * 10);
        }

        // Weather (if rain, brighter)
        if (weather.equals("rainy")) {
            baseBrightness += (int) (Math.random() * 10);
        }

        // Cap max
        int brightness = Math.min(baseBrightness, 100);
        return brightness;
    }

    public static float calculateSaving(int brightness) {
        // calculate enegy saving
        int baselineBrightness = 90; // default
        float maxPower = 100; // watts at full brightness
        float currentPower = (brightness / 100.0f) * maxPower;
        float baselinePower = (baselineBrightness / 100.0f) * maxPower;

        float energySaving = ((baselinePower - currentPower) / baselinePower) * 100;
        energySaving = Math.max(0, energySaving);
        return Math.round(energySaving * 10.0) / 10.0f;
    }

    static class EnergyServiceImpl extends EnergyOptimizationServiceGrpc.EnergyOptimizationServiceImplBase {

        @Override
        public void optimizeLighting(OptimizationRequest request, StreamObserver<OptimizationResponse> responseObserver) {
            try {
                if (request.getLocationID().isEmpty()) {
                    throw new IllegalArgumentException("Location ID cannot be empty");
                }

                // Call Traffic Service
                String address = getServiceAddress("traffic");
                String[] parts = address.split(":");

                ManagedChannel trafficChannel = ManagedChannelBuilder
                        .forAddress(parts[0], Integer.parseInt(parts[1]))
                        .usePlaintext()
                        .build();

                TrafficDetectionServiceGrpc.TrafficDetectionServiceBlockingStub trafficStub
                        = TrafficDetectionServiceGrpc.newBlockingStub(trafficChannel)
                                .withDeadlineAfter(3, TimeUnit.SECONDS);

                // JWT authentication
                String jwtToken = JwtUtil.generateToken("Energy-Service");
                Metadata metadata = new Metadata();
                Metadata.Key<String> authKey
                        = Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER);
                metadata.put(authKey, jwtToken);
                trafficStub = MetadataUtils.attachHeaders(trafficStub, metadata);
                // get traffic
                TrafficResponse traffic = trafficStub.getTrafficLevel(
                        TrafficRequest.newBuilder().setLocationID(request.getLocationID()).build()
                );
                // calculate recommend brightness
                int brightness = calculateBrightness(traffic.getTrafficStatus().toLowerCase());
                // calculate energy saving
                float energySaving = calculateSaving(brightness);
                OptimizationResponse response = OptimizationResponse.newBuilder()
                        .setRecommendedBrightnessLevel(brightness)
                        .setEstimatedEnergySaving(energySaving)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();

                trafficChannel.shutdown();
            } catch (IllegalArgumentException e) {
                responseObserver.onError(
                        Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException()
                );
            } catch (Exception e) {
                responseObserver.onError(Status.INTERNAL.withDescription("Energy service error").asRuntimeException());
            }
        }

        public StreamObserver<OptimizationRequest> monitorEnergy(StreamObserver<OptimizationResponse> responseObserver) {
            return new StreamObserver<OptimizationRequest>() {
                @Override
                public void onNext(OptimizationRequest request) {
                    try {
                        // service cancellation 
                        if (Context.current().isCancelled()) {
                            System.out.println("Client cancelled energy monitoring");
                            return;
                        }
                        // Call Traffic Service
                        String address = getServiceAddress("traffic");
                        String[] parts = address.split(":");

                        ManagedChannel trafficChannel = ManagedChannelBuilder
                                .forAddress(parts[0], Integer.parseInt(parts[1]))
                                .usePlaintext()
                                .build();

                        TrafficDetectionServiceGrpc.TrafficDetectionServiceBlockingStub trafficStub
                                = TrafficDetectionServiceGrpc.newBlockingStub(trafficChannel)
                                        .withDeadlineAfter(3, TimeUnit.SECONDS);

                        // JWT authentication
                        String jwtToken = JwtUtil.generateToken("Energy-Service");
                        Metadata metadata = new Metadata();
                        Metadata.Key<String> authKey
                                = Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER);
                        metadata.put(authKey, jwtToken);
                        trafficStub = MetadataUtils.attachHeaders(trafficStub, metadata);
                        // get traffic data
                        TrafficResponse traffic = trafficStub.getTrafficLevel(
                                TrafficRequest.newBuilder().setLocationID(request.getLocationID()).build()
                        );
                        // calculate recommend brightness
                        int recommendedBrightness = calculateBrightness(traffic.getTrafficStatus().toLowerCase());
                        // calculate energy saving
                        float energySaving = calculateSaving(recommendedBrightness);

                        OptimizationResponse response = OptimizationResponse.newBuilder()
                                .setLocationID(request.getLocationID())
                                .setRecommendedBrightnessLevel(recommendedBrightness)
                                .setEstimatedEnergySaving(energySaving)
                                .setTrafficStatus(traffic.getTrafficStatus())
                                .build();
                        responseObserver.onNext(response);
                    } catch (Exception ex) {
                        Logger.getLogger(EnergyOptimizationServer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Energy streaming error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                   responseObserver.onCompleted();
    //trafficChannel.shutdown();                    
                }
            };
        }
    }
}
