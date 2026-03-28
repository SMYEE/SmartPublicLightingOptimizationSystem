/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.smart.lighting.system;
import grpc.generated.streetlight.*;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
/**
 *
 * @author darkp
 */

public class StreetLightControlServer {

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new StreetLightServiceImpl())
                .intercept(new JwtServerInterceptor())
                .build();

        server.start();
        System.out.println("StreetLightControl Server started on port 50051");
        server.awaitTermination();
    }

    static class StreetLightServiceImpl extends StreetLightControlServiceGrpc.StreetLightControlServiceImplBase {

        @Override
        public void setBrightness(SetBrightnessRequest request, StreamObserver<SetBrightnessResponse> responseObserver) {
            try{
            if (request.getLightID().isEmpty()) {
            throw new IllegalArgumentException("Light ID cannot be empty");
            }
            
            System.out.println("Setting brightness for " + request.getLightID());

            SetBrightnessResponse response = SetBrightnessResponse.newBuilder()
                    .setStatus(true)
                    .setMessage("Brightness set successfully") 
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();            
            } catch (IllegalArgumentException e) {        
                responseObserver.onError(
                Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException()
                );
            } catch (Exception e) {        
                responseObserver.onError(
                Status.INTERNAL.withDescription("Street light error").asRuntimeException()
                );
            }
        }

        @Override
        public void getLightStatus(GetLightStatusRequest request, StreamObserver<GetLightStatusResponse> responseObserver) {
            try{
                if (request.getLightID().isEmpty()) {
                throw new IllegalArgumentException("Light ID cannot be empty");
                }
                
                GetLightStatusResponse response = GetLightStatusResponse.newBuilder()
                    .setBrightnessLevel(70)
                    .setPowerConsumption(15.5f)
                    .setIsActive(true)
                    .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (IllegalArgumentException e) {        
                responseObserver.onError(
                Status.INVALID_ARGUMENT.withDescription(e.getMessage()).asRuntimeException()
                );
            } catch (Exception e) {        
                responseObserver.onError(
                Status.INTERNAL.withDescription("Street light error").asRuntimeException()
                );
            }
        }
        @Override
        public StreamObserver<SetBrightnessRequest> adjustMultipleLights(StreamObserver<SetBrightnessResponse> responseObserver) { // <<< MODIFIED / NEW
            return new StreamObserver<SetBrightnessRequest>() {
                int count = 0;

                @Override
                public void onNext(SetBrightnessRequest request) {
                    System.out.println("Adjusting light " + request.getLightID() + " to " + request.getBrightnessLevel());
                    count++;
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Client stream error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    SetBrightnessResponse response = SetBrightnessResponse.newBuilder()
                            .setStatus(true)
                            .setMessage("Adjusted " + count + " lights successfully")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }
}