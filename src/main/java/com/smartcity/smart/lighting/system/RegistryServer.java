/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.smart.lighting.system;

import grpc.generated.registry.RegistryServiceGrpc;
import grpc.generated.registry.ServiceRequest;
import grpc.generated.registry.ServiceResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author darkp
 */
public class RegistryServer {
    private static Map<String, String> services = new HashMap<>();

    public static void main(String[] args) throws Exception {

        services.put("traffic", "localhost:50052");
        services.put("streetlight", "localhost:50051");
        services.put("energy", "localhost:50053");

        Server server;
        server = ServerBuilder.forPort(50050)
                .addService(new RegistryServiceImpl())
                .build();

        server.start();
        System.out.println("Registry Server running...");
        server.awaitTermination();
    }

    static class RegistryServiceImpl extends RegistryServiceGrpc.RegistryServiceImplBase {

        @Override
        public void getService(ServiceRequest request, StreamObserver<ServiceResponse> responseObserver) {

            String address = services.get(request.getServiceName());

            if (address == null) {
                responseObserver.onError(
                    Status.NOT_FOUND.withDescription("Service not found").asRuntimeException()
                );
                return;
            }

            responseObserver.onNext(
                ServiceResponse.newBuilder().setAddress(address).build()
            );
            responseObserver.onCompleted();
        }
    }
}