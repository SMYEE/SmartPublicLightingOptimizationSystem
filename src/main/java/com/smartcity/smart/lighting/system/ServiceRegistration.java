/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.smart.lighting.system;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
/**
 *
 * @author darkp
 */
public class ServiceRegistration {

    private static JmDNS jmdns;
    private static ServiceRegistration instance;

    private ServiceRegistration() throws UnknownHostException, IOException {
        jmdns = JmDNS.create(InetAddress.getLocalHost());
        System.out.println("Register: " + InetAddress.getLocalHost());
    }

    public static ServiceRegistration getInstance() throws IOException {
        if (instance == null) {
            instance = new ServiceRegistration();
        }
        return instance;
    }

    public void registerService(String type, String name, int port, String text) throws IOException {

        ServiceInfo serviceInfo = ServiceInfo.create(type, name, port, text);

        jmdns.registerService(serviceInfo);

        System.out.println("Registered Service: " + serviceInfo);
    }
}