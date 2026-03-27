package grpc.generated.streetlight;

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
 * <pre>
 * The street light control service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: StreetLightControl.proto")
public final class StreetLightControlServiceGrpc {

  private StreetLightControlServiceGrpc() {}

  public static final String SERVICE_NAME = "streetlight.StreetLightControlService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.streetlight.SetBrightnessRequest,
      grpc.generated.streetlight.SetBrightnessResponse> getSetBrightnessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetBrightness",
      requestType = grpc.generated.streetlight.SetBrightnessRequest.class,
      responseType = grpc.generated.streetlight.SetBrightnessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.streetlight.SetBrightnessRequest,
      grpc.generated.streetlight.SetBrightnessResponse> getSetBrightnessMethod() {
    io.grpc.MethodDescriptor<grpc.generated.streetlight.SetBrightnessRequest, grpc.generated.streetlight.SetBrightnessResponse> getSetBrightnessMethod;
    if ((getSetBrightnessMethod = StreetLightControlServiceGrpc.getSetBrightnessMethod) == null) {
      synchronized (StreetLightControlServiceGrpc.class) {
        if ((getSetBrightnessMethod = StreetLightControlServiceGrpc.getSetBrightnessMethod) == null) {
          StreetLightControlServiceGrpc.getSetBrightnessMethod = getSetBrightnessMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.streetlight.SetBrightnessRequest, grpc.generated.streetlight.SetBrightnessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "streetlight.StreetLightControlService", "SetBrightness"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.streetlight.SetBrightnessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.streetlight.SetBrightnessResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StreetLightControlServiceMethodDescriptorSupplier("SetBrightness"))
                  .build();
          }
        }
     }
     return getSetBrightnessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.generated.streetlight.GetLightStatusRequest,
      grpc.generated.streetlight.GetLightStatusResponse> getGetLightStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLightStatus",
      requestType = grpc.generated.streetlight.GetLightStatusRequest.class,
      responseType = grpc.generated.streetlight.GetLightStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.streetlight.GetLightStatusRequest,
      grpc.generated.streetlight.GetLightStatusResponse> getGetLightStatusMethod() {
    io.grpc.MethodDescriptor<grpc.generated.streetlight.GetLightStatusRequest, grpc.generated.streetlight.GetLightStatusResponse> getGetLightStatusMethod;
    if ((getGetLightStatusMethod = StreetLightControlServiceGrpc.getGetLightStatusMethod) == null) {
      synchronized (StreetLightControlServiceGrpc.class) {
        if ((getGetLightStatusMethod = StreetLightControlServiceGrpc.getGetLightStatusMethod) == null) {
          StreetLightControlServiceGrpc.getGetLightStatusMethod = getGetLightStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.streetlight.GetLightStatusRequest, grpc.generated.streetlight.GetLightStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "streetlight.StreetLightControlService", "GetLightStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.streetlight.GetLightStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.streetlight.GetLightStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StreetLightControlServiceMethodDescriptorSupplier("GetLightStatus"))
                  .build();
          }
        }
     }
     return getGetLightStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.generated.streetlight.SetBrightnessRequest,
      grpc.generated.streetlight.SetBrightnessResponse> getAdjustMultipleLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "adjustMultipleLights",
      requestType = grpc.generated.streetlight.SetBrightnessRequest.class,
      responseType = grpc.generated.streetlight.SetBrightnessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.generated.streetlight.SetBrightnessRequest,
      grpc.generated.streetlight.SetBrightnessResponse> getAdjustMultipleLightsMethod() {
    io.grpc.MethodDescriptor<grpc.generated.streetlight.SetBrightnessRequest, grpc.generated.streetlight.SetBrightnessResponse> getAdjustMultipleLightsMethod;
    if ((getAdjustMultipleLightsMethod = StreetLightControlServiceGrpc.getAdjustMultipleLightsMethod) == null) {
      synchronized (StreetLightControlServiceGrpc.class) {
        if ((getAdjustMultipleLightsMethod = StreetLightControlServiceGrpc.getAdjustMultipleLightsMethod) == null) {
          StreetLightControlServiceGrpc.getAdjustMultipleLightsMethod = getAdjustMultipleLightsMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.streetlight.SetBrightnessRequest, grpc.generated.streetlight.SetBrightnessResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "streetlight.StreetLightControlService", "adjustMultipleLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.streetlight.SetBrightnessRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.streetlight.SetBrightnessResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StreetLightControlServiceMethodDescriptorSupplier("adjustMultipleLights"))
                  .build();
          }
        }
     }
     return getAdjustMultipleLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreetLightControlServiceStub newStub(io.grpc.Channel channel) {
    return new StreetLightControlServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreetLightControlServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StreetLightControlServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreetLightControlServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StreetLightControlServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The street light control service definition.
   * </pre>
   */
  public static abstract class StreetLightControlServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sets brightness for a street light
     * </pre>
     */
    public void setBrightness(grpc.generated.streetlight.SetBrightnessRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.streetlight.SetBrightnessResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetBrightnessMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets current status of a street light
     * </pre>
     */
    public void getLightStatus(grpc.generated.streetlight.GetLightStatusRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.streetlight.GetLightStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetLightStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     *  
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.generated.streetlight.SetBrightnessRequest> adjustMultipleLights(
        io.grpc.stub.StreamObserver<grpc.generated.streetlight.SetBrightnessResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAdjustMultipleLightsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetBrightnessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.streetlight.SetBrightnessRequest,
                grpc.generated.streetlight.SetBrightnessResponse>(
                  this, METHODID_SET_BRIGHTNESS)))
          .addMethod(
            getGetLightStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.streetlight.GetLightStatusRequest,
                grpc.generated.streetlight.GetLightStatusResponse>(
                  this, METHODID_GET_LIGHT_STATUS)))
          .addMethod(
            getAdjustMultipleLightsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.generated.streetlight.SetBrightnessRequest,
                grpc.generated.streetlight.SetBrightnessResponse>(
                  this, METHODID_ADJUST_MULTIPLE_LIGHTS)))
          .build();
    }
  }

  /**
   * <pre>
   * The street light control service definition.
   * </pre>
   */
  public static final class StreetLightControlServiceStub extends io.grpc.stub.AbstractStub<StreetLightControlServiceStub> {
    private StreetLightControlServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreetLightControlServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreetLightControlServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreetLightControlServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets brightness for a street light
     * </pre>
     */
    public void setBrightness(grpc.generated.streetlight.SetBrightnessRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.streetlight.SetBrightnessResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetBrightnessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets current status of a street light
     * </pre>
     */
    public void getLightStatus(grpc.generated.streetlight.GetLightStatusRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.streetlight.GetLightStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetLightStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *  
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.generated.streetlight.SetBrightnessRequest> adjustMultipleLights(
        io.grpc.stub.StreamObserver<grpc.generated.streetlight.SetBrightnessResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAdjustMultipleLightsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * The street light control service definition.
   * </pre>
   */
  public static final class StreetLightControlServiceBlockingStub extends io.grpc.stub.AbstractStub<StreetLightControlServiceBlockingStub> {
    private StreetLightControlServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreetLightControlServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreetLightControlServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreetLightControlServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets brightness for a street light
     * </pre>
     */
    public grpc.generated.streetlight.SetBrightnessResponse setBrightness(grpc.generated.streetlight.SetBrightnessRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetBrightnessMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets current status of a street light
     * </pre>
     */
    public grpc.generated.streetlight.GetLightStatusResponse getLightStatus(grpc.generated.streetlight.GetLightStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetLightStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The street light control service definition.
   * </pre>
   */
  public static final class StreetLightControlServiceFutureStub extends io.grpc.stub.AbstractStub<StreetLightControlServiceFutureStub> {
    private StreetLightControlServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreetLightControlServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreetLightControlServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreetLightControlServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sets brightness for a street light
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.streetlight.SetBrightnessResponse> setBrightness(
        grpc.generated.streetlight.SetBrightnessRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetBrightnessMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets current status of a street light
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.streetlight.GetLightStatusResponse> getLightStatus(
        grpc.generated.streetlight.GetLightStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetLightStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_BRIGHTNESS = 0;
  private static final int METHODID_GET_LIGHT_STATUS = 1;
  private static final int METHODID_ADJUST_MULTIPLE_LIGHTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StreetLightControlServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StreetLightControlServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_BRIGHTNESS:
          serviceImpl.setBrightness((grpc.generated.streetlight.SetBrightnessRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.streetlight.SetBrightnessResponse>) responseObserver);
          break;
        case METHODID_GET_LIGHT_STATUS:
          serviceImpl.getLightStatus((grpc.generated.streetlight.GetLightStatusRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.streetlight.GetLightStatusResponse>) responseObserver);
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
        case METHODID_ADJUST_MULTIPLE_LIGHTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.adjustMultipleLights(
              (io.grpc.stub.StreamObserver<grpc.generated.streetlight.SetBrightnessResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StreetLightControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreetLightControlServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.streetlight.StreetLightControlServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreetLightControlService");
    }
  }

  private static final class StreetLightControlServiceFileDescriptorSupplier
      extends StreetLightControlServiceBaseDescriptorSupplier {
    StreetLightControlServiceFileDescriptorSupplier() {}
  }

  private static final class StreetLightControlServiceMethodDescriptorSupplier
      extends StreetLightControlServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StreetLightControlServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StreetLightControlServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreetLightControlServiceFileDescriptorSupplier())
              .addMethod(getSetBrightnessMethod())
              .addMethod(getGetLightStatusMethod())
              .addMethod(getAdjustMultipleLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
