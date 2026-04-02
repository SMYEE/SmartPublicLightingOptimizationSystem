/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import authentication.JwtServerInterceptor;
import grpc.generated.traffic.*;
import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author darkp
 */
public class TrafficDetectionServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50052)
                .addService(new TrafficServiceImpl())
                .intercept(new JwtServerInterceptor())
                .build();

        server.start();
        System.out.println("TrafficDetection Server started on port 50052");
        server.awaitTermination();
    }

    static class TrafficServiceImpl extends TrafficDetectionServiceGrpc.TrafficDetectionServiceImplBase {

        @Override
        public void getTrafficLevel(TrafficRequest request, StreamObserver<TrafficResponse> responseObserver) {
            try {
                if (request.getLocationID().isEmpty()) {
                    throw new IllegalArgumentException("Location cannot be empty");
                }
                // vehicle count based on time
                int hour = java.time.LocalTime.now().getHour();
                int vehicleCount;

                // Peak hours
                if ((hour >= 8 && hour <= 10) || (hour >= 17 && hour <= 19)) {
                    vehicleCount = 80 + (int) (Math.random() * 20); // heavy traffic
                } else {
                    vehicleCount = 20 + (int) (Math.random() * 30);
                }

                // Random spike
                if (Math.random() > 0.85) {
                    vehicleCount += 50;
                }
                String status;
                if (vehicleCount < 40) {
                    status = "Low";
                } else if (vehicleCount < 80) {
                    status = "Medium";
                } else {
                    status = "High";
                }

                TrafficResponse response = TrafficResponse.newBuilder()
                        .setVehicleCount(vehicleCount)
                        .setTrafficStatus(status)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (IllegalArgumentException e) {
                responseObserver.onError(
                        Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException()
                );
            } catch (Exception e) {
                responseObserver.onError(
                        Status.INTERNAL.withDescription("Traffic service error").asRuntimeException()
                );
            }
        }

        @Override
        public void streamTrafficUpdates(TrafficRequest request, StreamObserver<TrafficResponse> responseObserver) {
            new Thread(() -> {
                try {
                    if (request.getLocationID().isEmpty()) {
                        throw new IllegalArgumentException("Location cannot be empty");
                    }
                    for (int i = 0; i < 10; i++) {
                        if (Context.current().isCancelled()) {
                            System.out.println("Client cancelled traffic stream");
                            return;
                        }
                        int vehicleCount = (int) (Math.random() * 150);
                        TrafficResponse response = TrafficResponse.newBuilder()
                                .setVehicleCount(vehicleCount)
                                .setTrafficStatus(vehicleCount < 40 ? "Low" : vehicleCount < 80 ? "Medium" : "High")
                                .build();
                        responseObserver.onNext(response);
                        Thread.sleep(1000); // 1 second
                    }
                    responseObserver.onCompleted();
                } catch (InterruptedException e) {
                    responseObserver.onError(
                            Status.INTERNAL.withDescription("Streaming interrupted").asRuntimeException()
                    );
                } catch (IllegalArgumentException e) {
                    responseObserver.onError(
                            Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException()
                    );
                }
            }).start();
        }
    }
}
