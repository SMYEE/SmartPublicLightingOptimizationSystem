/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.smart.lighting.system;
import grpc.generated.traffic.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
/**
 *
 * @author darkp
 */

public class TrafficDetectionServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50052)
                .addService(new TrafficServiceImpl())
                .build();

        server.start();
        System.out.println("TrafficDetection Server started on port 50052");
        server.awaitTermination();
    }

    static class TrafficServiceImpl extends TrafficDetectionServiceGrpc.TrafficDetectionServiceImplBase {

        @Override
        public void getTrafficLevel(TrafficRequest request, StreamObserver<TrafficResponse> responseObserver) {

            TrafficResponse response = TrafficResponse.newBuilder()
                    .setVehicleCount(25)
                    .setTrafficStatus("Medium")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        @Override
        public void streamTrafficUpdates(TrafficRequest request, StreamObserver<TrafficResponse> responseObserver) { // <<< MODIFIED / NEW
            new Thread(() -> {
                try {
                    for (int i = 0; i < 10; i++) {
                        TrafficResponse response = TrafficResponse.newBuilder()
                                .setVehicleCount(20 + i)
                                .setTrafficStatus(i < 3 ? "Low" : i < 7 ? "Medium" : "High")
                                .build();
                        responseObserver.onNext(response);
                        Thread.sleep(1000); // 1 second
                    }
                    responseObserver.onCompleted();
                } catch (InterruptedException e) {
                    responseObserver.onError(e); // <<< Error handling
                }
            }).start();
        }
    }
}
