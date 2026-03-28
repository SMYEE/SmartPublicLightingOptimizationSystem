package com.smartcity.smart.lighting.system;

import grpc.generated.energy.*;
import grpc.generated.streetlight.*;
import grpc.generated.traffic.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ClientGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smart City Lighting System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 650);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // --- Street Light Control Section ---
        JPanel streetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        streetPanel.setBorder(BorderFactory.createTitledBorder("Street Light Control"));
        streetPanel.add(new JLabel("Light ID:"));
        JTextField lightIDField = new JTextField("LIGHT_1", 8);
        streetPanel.add(lightIDField);
        JButton setBrightnessBtn = new JButton("Set Brightness");
        streetPanel.add(setBrightnessBtn);
        JButton getStatusBtn = new JButton("Get Status");
        streetPanel.add(getStatusBtn);

        JButton clientStreamBtn = new JButton("Adjust Multiple Lights"); // Client streaming
        streetPanel.add(clientStreamBtn);
        panel.add(streetPanel);

        // --- Traffic Detection Section ---
        JPanel trafficPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        trafficPanel.setBorder(BorderFactory.createTitledBorder("Traffic Detection"));
        trafficPanel.add(new JLabel("Location:"));
        JTextField trafficLocField = new JTextField("ZONE_A", 8);
        trafficPanel.add(trafficLocField);
        JButton getTrafficBtn = new JButton("Get Traffic Level"); // unary
        trafficPanel.add(getTrafficBtn);

        JButton serverStreamBtn = new JButton("Stream Traffic Updates"); // Server streaming
        trafficPanel.add(serverStreamBtn);
        panel.add(trafficPanel);

        // --- Energy Optimization Section ---
        JPanel energyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        energyPanel.setBorder(BorderFactory.createTitledBorder("Energy Optimization"));
        energyPanel.add(new JLabel("Location:"));
        JTextField energyLocField = new JTextField("ZONE_A", 8);
        energyPanel.add(energyLocField);
        JButton optimizeBtn = new JButton("Optimize Lighting"); // unary
        energyPanel.add(optimizeBtn);

        JButton bidiStreamBtn = new JButton("Monitor Energy (BiDi Stream)");
        energyPanel.add(bidiStreamBtn); // Bi-directional streaming
        panel.add(energyPanel);

        // --- Result Area ---
        JTextArea resultArea = new JTextArea(15, 70);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);

        // --- Button Actions ---

        // Street Light: unary setBrightness
        setBrightnessBtn.addActionListener(e -> {
            String lightID = lightIDField.getText();
            ManagedChannel channel = null;
            
            try {
                channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

                StreetLightControlServiceGrpc.StreetLightControlServiceBlockingStub stub =
                        StreetLightControlServiceGrpc.newBlockingStub(channel);
                
                stub = attachJwt(stub);

                SetBrightnessResponse response = stub.setBrightness(
                        SetBrightnessRequest.newBuilder()
                                .setLightID(lightID)
                                .setBrightnessLevel(70) // example
                                .build()
                );

                resultArea.append("[Unary] Set brightness for " + lightID + ": " + response.getStatus() + "\n");
            } catch (Exception ex) {
                resultArea.append("Error setting brightness: " + ex.getMessage() + "\n");
            }
        });

        // Street Light: unary getLightStatus
        getStatusBtn.addActionListener(e -> {
            String lightID = lightIDField.getText();
            ManagedChannel channel = null;
            
            try {
                channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
                
                StreetLightControlServiceGrpc.StreetLightControlServiceBlockingStub stub =
                        StreetLightControlServiceGrpc.newBlockingStub(channel);
                
                stub = attachJwt(stub);

                GetLightStatusResponse status = stub.getLightStatus(
                        GetLightStatusRequest.newBuilder().setLightID(lightID).build()
                );

                resultArea.append("[Unary] Status for " + lightID + ": Brightness=" + status.getBrightnessLevel()
                        + ", Power=" + status.getPowerConsumption()
                        + ", Active=" + status.getIsActive() + "\n");
            } catch (Exception ex) {
                resultArea.append("Error getting status: " + ex.getMessage() + "\n");
            }
        });

        // Street Light: client streaming adjustMultipleLights
        clientStreamBtn.addActionListener(e -> {
            try {
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                        .usePlaintext().build();

                StreetLightControlServiceGrpc.StreetLightControlServiceStub stub =
                        StreetLightControlServiceGrpc.newStub(channel);
                
                stub = attachJwt(stub);

                CountDownLatch latch = new CountDownLatch(1);

                StreamObserver<SetBrightnessRequest> requestObserver = stub.adjustMultipleLights(
                        new StreamObserver<SetBrightnessResponse>() {
                            @Override
                            public void onNext(SetBrightnessResponse value) {
                                resultArea.append("[Client Stream] " + value.getMessage() + "\n");
                            }

                            @Override
                            public void onError(Throwable t) {
                                resultArea.append("Client stream error: " + t.getMessage() + "\n");
                                latch.countDown();
                            }

                            @Override
                            public void onCompleted() {
                                resultArea.append("Client streaming completed.\n");
                                latch.countDown();
                            }
                        });

                // Send multiple requests
                requestObserver.onNext(SetBrightnessRequest.newBuilder().setLightID("L1").setBrightnessLevel(50).build());
                requestObserver.onNext(SetBrightnessRequest.newBuilder().setLightID("L2").setBrightnessLevel(60).build());
                requestObserver.onNext(SetBrightnessRequest.newBuilder().setLightID("L3").setBrightnessLevel(70).build());
                requestObserver.onCompleted();

                latch.await();
                channel.shutdown();
            } catch (Exception ex) {
                resultArea.append("Error in client streaming: " + ex.getMessage() + "\n");
            }
        });

        // Traffic: unary getTrafficLevel
        getTrafficBtn.addActionListener(e -> {
            String location = trafficLocField.getText();
            ManagedChannel channel = null;
            try {
                channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

                TrafficDetectionServiceGrpc.TrafficDetectionServiceBlockingStub stub =
                        TrafficDetectionServiceGrpc.newBlockingStub(channel);
                
                stub = attachJwt(stub);

                TrafficResponse traffic = stub.getTrafficLevel(
                        TrafficRequest.newBuilder().setLocationID(location).build()
                );

                resultArea.append("[Unary] Traffic at " + location + ": Vehicles=" + traffic.getVehicleCount()
                        + ", Status=" + traffic.getTrafficStatus() + "\n");
            } catch (Exception ex) {
                resultArea.append("Error getting traffic: " + ex.getMessage() + "\n");
            }
        });

        // Traffic: server streaming streamTrafficUpdates
        serverStreamBtn.addActionListener(e -> {
            String location = trafficLocField.getText();
            try {
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                        .usePlaintext().build();

                TrafficDetectionServiceGrpc.TrafficDetectionServiceStub stub =
                        TrafficDetectionServiceGrpc.newStub(channel);
                
                stub = attachJwt(stub);

                CountDownLatch latch = new CountDownLatch(1);

                stub.streamTrafficUpdates(TrafficRequest.newBuilder().setLocationID(location).build(),
                        new StreamObserver<TrafficResponse>() {
                            @Override
                            public void onNext(TrafficResponse value) {
                                resultArea.append("[Server Stream] Traffic: " + value.getTrafficStatus()
                                        + ", Vehicles: " + value.getVehicleCount() + "\n");
                            }

                            @Override
                            public void onError(Throwable t) {
                                resultArea.append("Server stream error: " + t.getMessage() + "\n");
                                latch.countDown();
                            }

                            @Override
                            public void onCompleted() {
                                resultArea.append("Server streaming completed.\n");
                                latch.countDown();
                            }
                        });

                latch.await();
                channel.shutdown();
            } catch (Exception ex) {
                resultArea.append("Error in server streaming: " + ex.getMessage() + "\n");
            }
        });

        // Energy: unary optimizeLighting
        optimizeBtn.addActionListener(e -> {
            String location = energyLocField.getText();
            ManagedChannel channel = null;            
            
            try {
                channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();

                EnergyOptimizationServiceGrpc.EnergyOptimizationServiceBlockingStub stub =
                        EnergyOptimizationServiceGrpc.newBlockingStub(channel);
                              
                stub = attachJwt(stub);
                
                OptimizationRequest request = OptimizationRequest.newBuilder()
                .setLocationID("ZONE_A")
                .setCurrentEnergyConsumption(50f)
                .build();
                
                OptimizationResponse response = stub
                        .withDeadlineAfter(3, TimeUnit.SECONDS)
                        .optimizeLighting(
                        OptimizationRequest.newBuilder().setLocationID(location).build()
                );

                resultArea.append("[Unary] Energy optimization for " + location + ": Brightness="
                        + response.getRecommendedBrightnessLevel()
                        + ", Estimated Saving=" + response.getEstimatedEnergySaving() + "\n");
                
                channel.shutdown();
            } catch (io.grpc.StatusRuntimeException ex) {
                resultArea.append("Error optimizing energy: " + ex.getStatus().getDescription() + "\n");
            }
        });

        // Energy: bi-directional streaming monitorEnergy
        bidiStreamBtn.addActionListener(e -> {
            String location = energyLocField.getText();
            try {
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                        .usePlaintext().build();

                EnergyOptimizationServiceGrpc.EnergyOptimizationServiceStub stub =
                        EnergyOptimizationServiceGrpc.newStub(channel);
                
                stub = attachJwt(stub);

                CountDownLatch latch = new CountDownLatch(1);

                StreamObserver<OptimizationRequest> requestObserver = stub.monitorEnergy(
                        new StreamObserver<OptimizationResponse>() {
                            @Override
                            public void onNext(OptimizationResponse value) {
                                resultArea.append("[BiDi Stream] Brightness=" + value.getRecommendedBrightnessLevel()
                                        + ", Estimated Saving=" + value.getEstimatedEnergySaving() + "\n");
                            }

                            @Override
                            public void onError(Throwable t) {
                                resultArea.append("BiDi streaming error: " + t.getMessage() + "\n");
                                latch.countDown();
                            }

                            @Override
                            public void onCompleted() {
                                resultArea.append("BiDi streaming completed.\n");
                                latch.countDown();
                            }
                        });

                // Send multiple requests
                requestObserver.onNext(OptimizationRequest.newBuilder().setLocationID(location).build());
                requestObserver.onNext(OptimizationRequest.newBuilder().setLocationID("ZONE_B").build());
                requestObserver.onNext(OptimizationRequest.newBuilder().setLocationID("ZONE_C").build());
                requestObserver.onCompleted();

                latch.await();
                channel.shutdown();
            } catch (Exception ex) {
                resultArea.append("Error in bi-directional streaming: " + ex.getMessage() + "\n");
            }
        });       
    }
    
    // --- for JWT token
    private static <T extends io.grpc.stub.AbstractStub<T>> T attachJwt(T stub) {
        String jwtToken = JwtUtil.generateToken("GUI-Client");

        Metadata metadata = new Metadata();
        Metadata.Key<String> authKey =
            Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER);

        metadata.put(authKey, jwtToken);

        return MetadataUtils.attachHeaders(stub, metadata);
    }
}