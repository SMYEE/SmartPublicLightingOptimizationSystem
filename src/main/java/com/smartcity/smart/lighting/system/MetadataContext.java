/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcity.smart.lighting.system;
import io.grpc.Context;
import io.grpc.Metadata;
/**
 *
 * @author darkp
 */

public class MetadataContext {
    public static final Context.Key<Metadata> METADATA_KEY = Context.key("metadata"); 
}
