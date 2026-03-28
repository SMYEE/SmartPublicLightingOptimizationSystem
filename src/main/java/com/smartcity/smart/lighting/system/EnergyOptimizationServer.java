/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.smart.lighting.system;
import grpc.generated.energy.*;
import grpc.generated.streetlight.*;
import grpc.generated.traffic.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;
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

    static class EnergyServiceImpl extends EnergyOptimizationServiceGrpc.EnergyOptimizationServiceImplBase {

        @Override
        public void optimizeLighting(OptimizationRequest request, StreamObserver<OptimizationResponse> responseObserver) {
             try {
            if (request.getLocationID().isEmpty()) {
            throw new IllegalArgumentException("Location ID cannot be empty");
            } 
            
            // Call Traffic Service
            ManagedChannel trafficChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
                    .usePlaintext()
                    .build();

            TrafficDetectionServiceGrpc.TrafficDetectionServiceBlockingStub trafficStub =
                    TrafficDetectionServiceGrpc.newBlockingStub(trafficChannel)
                    .withDeadlineAfter(3, TimeUnit.SECONDS);
            String jwtToken = JwtUtil.generateToken("Energy-Service");
            Metadata metadata = new Metadata();
            Metadata.Key<String> authKey =
                Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER);
            metadata.put(authKey, jwtToken);
            trafficStub = MetadataUtils.attachHeaders(trafficStub, metadata);
                    
            TrafficResponse traffic = trafficStub.getTrafficLevel(
                    TrafficRequest.newBuilder().setLocationID(request.getLocationID()).build()
            );

            int brightness;

            if (traffic.getTrafficStatus().toLowerCase().equals("low")) {
                brightness = 30;
            } else if (traffic.getTrafficStatus().toLowerCase().equals("medium")) {
                brightness = 60;
            } else {
                brightness = 90;
            }

            OptimizationResponse response = OptimizationResponse.newBuilder()
                    .setRecommendedBrightnessLevel(brightness)
                    .setEstimatedEnergySaving(20.5f)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();

            trafficChannel.shutdown();
        } 
        catch (IllegalArgumentException e) {        
        responseObserver.onError(
                Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException()
        );
        }
        catch (Exception e) 
        {
            responseObserver.onError(Status.INTERNAL.withDescription("Energy service error").asRuntimeException()); 
        }             
    }

        public StreamObserver<OptimizationRequest> monitorEnergy(StreamObserver<OptimizationResponse> responseObserver) 
        { 
            return new StreamObserver<OptimizationRequest>() {
                @Override
                public void onNext(OptimizationRequest request) {
                    int recommendedBrightness = 50; 
                    OptimizationResponse response = OptimizationResponse.newBuilder()
                            .setRecommendedBrightnessLevel(recommendedBrightness)
                            .setEstimatedEnergySaving(15.0f)
                            .build();
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Energy streaming error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
