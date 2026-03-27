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
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
/**
 *
 * @author darkp
 */

public class EnergyOptimizationServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50053)
                .addService(new EnergyServiceImpl())
                .build();

        server.start();
        System.out.println("EnergyOptimization Server started on port 50053");
        server.awaitTermination();
    }

    static class EnergyServiceImpl extends EnergyOptimizationServiceGrpc.EnergyOptimizationServiceImplBase {

        @Override
        public void optimizeLighting(OptimizationRequest request, StreamObserver<OptimizationResponse> responseObserver) {
             try {
            // Call Traffic Service
            ManagedChannel trafficChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
                    .usePlaintext()
                    .build();

            TrafficDetectionServiceGrpc.TrafficDetectionServiceBlockingStub trafficStub =
                    TrafficDetectionServiceGrpc.newBlockingStub(trafficChannel);

            TrafficResponse traffic = trafficStub.getTrafficLevel(
                    TrafficRequest.newBuilder().setLocationID(request.getLocationID()).build()
            );

            int brightness;

            if (traffic.getTrafficStatus().equals("Low")) {
                brightness = 30;
            } else if (traffic.getTrafficStatus().equals("Medium")) {
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
        } catch (Exception e) 
        {
            responseObserver.onError(e); 
        }             
    }

        public StreamObserver<OptimizationRequest> monitorEnergy(StreamObserver<OptimizationResponse> responseObserver) 
        { 
            return new StreamObserver<OptimizationRequest>() {
                @Override
                public void onNext(OptimizationRequest request) {
                    int recommendedBrightness = 50; // simulate calculation
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
