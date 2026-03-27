/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.smart.lighting.system;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
/**
 *
 * @author darkp
 */

public class ServiceDiscovery {

    private String serviceType;
    private String serviceName;
    private JmDNS jmdns;
    private String host;
    private int port;

    public ServiceDiscovery(String type, String name) {
        this.serviceType = type;
        this.serviceName = name;
    }

    public String discoverService(long timeout) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Client: " + InetAddress.getLocalHost());

            jmdns.addServiceListener(serviceType, new ServiceListener() {

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service added: " + event.getInfo());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getInfo());
                }

                @Override
                public void serviceResolved(ServiceEvent event) {

                    ServiceInfo info = event.getInfo();
                    String resolvedName = info.getName();

                    System.out.println("Service resolved: " + info);

                    if (resolvedName.contains(serviceName)) {

                        host = info.getHostAddresses()[0];
                        port = info.getPort();

                        System.out.println("Found " + resolvedName + " at " + host + ":" + port);

                        latch.countDown();
                    }
                }
            });

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        latch.await(timeout, TimeUnit.MILLISECONDS);

        return host + ":" + port;
    }

    public void close() throws IOException {
        if (jmdns != null) {
            jmdns.close();
        }
    }
}
