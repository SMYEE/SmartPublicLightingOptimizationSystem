/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import grpc.generated.registry.RegistryServiceGrpc;
import grpc.generated.registry.ServiceRequest;
import grpc.generated.registry.ServiceResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 *
 * @author darkp
 */
public class ServiceClientUtil {

    public static String getServiceAddress(String serviceName) throws Exception {

        ManagedChannel registryChannel = ManagedChannelBuilder
                .forAddress("localhost", 50050)
                .usePlaintext()
                .build();

        RegistryServiceGrpc.RegistryServiceBlockingStub registryStub =
                RegistryServiceGrpc.newBlockingStub(registryChannel);

        ServiceResponse response = registryStub.getService(
                ServiceRequest.newBuilder()
                        .setServiceName(serviceName)
                        .build()
        );

        registryChannel.shutdown();

        return response.getAddress();
    }
}
