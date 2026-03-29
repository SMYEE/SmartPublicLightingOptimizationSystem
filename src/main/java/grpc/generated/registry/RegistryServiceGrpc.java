package grpc.generated.registry;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Registry.proto")
public final class RegistryServiceGrpc {

  private RegistryServiceGrpc() {}

  public static final String SERVICE_NAME = "RegistryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.registry.ServiceRequest,
      grpc.generated.registry.ServiceResponse> getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getService",
      requestType = grpc.generated.registry.ServiceRequest.class,
      responseType = grpc.generated.registry.ServiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.registry.ServiceRequest,
      grpc.generated.registry.ServiceResponse> getGetServiceMethod() {
    io.grpc.MethodDescriptor<grpc.generated.registry.ServiceRequest, grpc.generated.registry.ServiceResponse> getGetServiceMethod;
    if ((getGetServiceMethod = RegistryServiceGrpc.getGetServiceMethod) == null) {
      synchronized (RegistryServiceGrpc.class) {
        if ((getGetServiceMethod = RegistryServiceGrpc.getGetServiceMethod) == null) {
          RegistryServiceGrpc.getGetServiceMethod = getGetServiceMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.registry.ServiceRequest, grpc.generated.registry.ServiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "RegistryService", "getService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.registry.ServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.registry.ServiceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RegistryServiceMethodDescriptorSupplier("getService"))
                  .build();
          }
        }
     }
     return getGetServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegistryServiceStub newStub(io.grpc.Channel channel) {
    return new RegistryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RegistryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegistryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RegistryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RegistryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getService(grpc.generated.registry.ServiceRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.registry.ServiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.registry.ServiceRequest,
                grpc.generated.registry.ServiceResponse>(
                  this, METHODID_GET_SERVICE)))
          .build();
    }
  }

  /**
   */
  public static final class RegistryServiceStub extends io.grpc.stub.AbstractStub<RegistryServiceStub> {
    private RegistryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistryServiceStub(channel, callOptions);
    }

    /**
     */
    public void getService(grpc.generated.registry.ServiceRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.registry.ServiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegistryServiceBlockingStub extends io.grpc.stub.AbstractStub<RegistryServiceBlockingStub> {
    private RegistryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.generated.registry.ServiceResponse getService(grpc.generated.registry.ServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegistryServiceFutureStub extends io.grpc.stub.AbstractStub<RegistryServiceFutureStub> {
    private RegistryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RegistryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RegistryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.registry.ServiceResponse> getService(
        grpc.generated.registry.ServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SERVICE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegistryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegistryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_SERVICE:
          serviceImpl.getService((grpc.generated.registry.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.registry.ServiceResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.registry.Registry.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegistryService");
    }
  }

  private static final class RegistryServiceFileDescriptorSupplier
      extends RegistryServiceBaseDescriptorSupplier {
    RegistryServiceFileDescriptorSupplier() {}
  }

  private static final class RegistryServiceMethodDescriptorSupplier
      extends RegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegistryServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RegistryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegistryServiceFileDescriptorSupplier())
              .addMethod(getGetServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
