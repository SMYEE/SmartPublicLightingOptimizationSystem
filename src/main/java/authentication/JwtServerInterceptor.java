/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package authentication;
import Util.JwtUtil;
import io.grpc.*;
/**
 *
 * @author darkp
 */

public class JwtServerInterceptor implements ServerInterceptor { 

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {

        // --- Extract JWT ---
        String jwt = headers.get(
                Metadata.Key.of("auth-token", Metadata.ASCII_STRING_MARSHALLER)
        ); 

        // --- Validate JWT ---
        if (jwt == null || !JwtUtil.validateToken(jwt)) { 
            call.close(
                    Status.UNAUTHENTICATED.withDescription("Invalid JWT token"),
                    headers
            );
            return new ServerCall.Listener<ReqT>() {}; 
        }

        // --- Store metadata in context ---
        Context ctx = Context.current().withValue(MetadataContext.METADATA_KEY, headers); 

        return Contexts.interceptCall(ctx, call, headers, next); 
    }
}