package grpc.generated.traffic;

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
 * The traffic detection service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: TrafficDetection.proto")
public final class TrafficDetectionServiceGrpc {

  private TrafficDetectionServiceGrpc() {}

  public static final String SERVICE_NAME = "traffic.TrafficDetectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.traffic.TrafficRequest,
      grpc.generated.traffic.TrafficResponse> getGetTrafficLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrafficLevel",
      requestType = grpc.generated.traffic.TrafficRequest.class,
      responseType = grpc.generated.traffic.TrafficResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.traffic.TrafficRequest,
      grpc.generated.traffic.TrafficResponse> getGetTrafficLevelMethod() {
    io.grpc.MethodDescriptor<grpc.generated.traffic.TrafficRequest, grpc.generated.traffic.TrafficResponse> getGetTrafficLevelMethod;
    if ((getGetTrafficLevelMethod = TrafficDetectionServiceGrpc.getGetTrafficLevelMethod) == null) {
      synchronized (TrafficDetectionServiceGrpc.class) {
        if ((getGetTrafficLevelMethod = TrafficDetectionServiceGrpc.getGetTrafficLevelMethod) == null) {
          TrafficDetectionServiceGrpc.getGetTrafficLevelMethod = getGetTrafficLevelMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.traffic.TrafficRequest, grpc.generated.traffic.TrafficResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "traffic.TrafficDetectionService", "GetTrafficLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.traffic.TrafficRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.traffic.TrafficResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TrafficDetectionServiceMethodDescriptorSupplier("GetTrafficLevel"))
                  .build();
          }
        }
     }
     return getGetTrafficLevelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.generated.traffic.TrafficRequest,
      grpc.generated.traffic.TrafficResponse> getStreamTrafficUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamTrafficUpdates",
      requestType = grpc.generated.traffic.TrafficRequest.class,
      responseType = grpc.generated.traffic.TrafficResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.generated.traffic.TrafficRequest,
      grpc.generated.traffic.TrafficResponse> getStreamTrafficUpdatesMethod() {
    io.grpc.MethodDescriptor<grpc.generated.traffic.TrafficRequest, grpc.generated.traffic.TrafficResponse> getStreamTrafficUpdatesMethod;
    if ((getStreamTrafficUpdatesMethod = TrafficDetectionServiceGrpc.getStreamTrafficUpdatesMethod) == null) {
      synchronized (TrafficDetectionServiceGrpc.class) {
        if ((getStreamTrafficUpdatesMethod = TrafficDetectionServiceGrpc.getStreamTrafficUpdatesMethod) == null) {
          TrafficDetectionServiceGrpc.getStreamTrafficUpdatesMethod = getStreamTrafficUpdatesMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.traffic.TrafficRequest, grpc.generated.traffic.TrafficResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "traffic.TrafficDetectionService", "streamTrafficUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.traffic.TrafficRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.traffic.TrafficResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TrafficDetectionServiceMethodDescriptorSupplier("streamTrafficUpdates"))
                  .build();
          }
        }
     }
     return getStreamTrafficUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrafficDetectionServiceStub newStub(io.grpc.Channel channel) {
    return new TrafficDetectionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrafficDetectionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrafficDetectionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrafficDetectionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrafficDetectionServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The traffic detection service definition.
   * </pre>
   */
  public static abstract class TrafficDetectionServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Gets traffic level for a location
     * </pre>
     */
    public void getTrafficLevel(grpc.generated.traffic.TrafficRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.traffic.TrafficResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTrafficLevelMethod(), responseObserver);
    }

    /**
     */
    public void streamTrafficUpdates(grpc.generated.traffic.TrafficRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.traffic.TrafficResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamTrafficUpdatesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetTrafficLevelMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.traffic.TrafficRequest,
                grpc.generated.traffic.TrafficResponse>(
                  this, METHODID_GET_TRAFFIC_LEVEL)))
          .addMethod(
            getStreamTrafficUpdatesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.generated.traffic.TrafficRequest,
                grpc.generated.traffic.TrafficResponse>(
                  this, METHODID_STREAM_TRAFFIC_UPDATES)))
          .build();
    }
  }

  /**
   * <pre>
   * The traffic detection service definition.
   * </pre>
   */
  public static final class TrafficDetectionServiceStub extends io.grpc.stub.AbstractStub<TrafficDetectionServiceStub> {
    private TrafficDetectionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrafficDetectionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrafficDetectionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrafficDetectionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets traffic level for a location
     * </pre>
     */
    public void getTrafficLevel(grpc.generated.traffic.TrafficRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.traffic.TrafficResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTrafficLevelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamTrafficUpdates(grpc.generated.traffic.TrafficRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.traffic.TrafficResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamTrafficUpdatesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The traffic detection service definition.
   * </pre>
   */
  public static final class TrafficDetectionServiceBlockingStub extends io.grpc.stub.AbstractStub<TrafficDetectionServiceBlockingStub> {
    private TrafficDetectionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrafficDetectionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrafficDetectionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrafficDetectionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets traffic level for a location
     * </pre>
     */
    public grpc.generated.traffic.TrafficResponse getTrafficLevel(grpc.generated.traffic.TrafficRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTrafficLevelMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.generated.traffic.TrafficResponse> streamTrafficUpdates(
        grpc.generated.traffic.TrafficRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamTrafficUpdatesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The traffic detection service definition.
   * </pre>
   */
  public static final class TrafficDetectionServiceFutureStub extends io.grpc.stub.AbstractStub<TrafficDetectionServiceFutureStub> {
    private TrafficDetectionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrafficDetectionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrafficDetectionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrafficDetectionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets traffic level for a location
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.traffic.TrafficResponse> getTrafficLevel(
        grpc.generated.traffic.TrafficRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTrafficLevelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TRAFFIC_LEVEL = 0;
  private static final int METHODID_STREAM_TRAFFIC_UPDATES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrafficDetectionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrafficDetectionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TRAFFIC_LEVEL:
          serviceImpl.getTrafficLevel((grpc.generated.traffic.TrafficRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.traffic.TrafficResponse>) responseObserver);
          break;
        case METHODID_STREAM_TRAFFIC_UPDATES:
          serviceImpl.streamTrafficUpdates((grpc.generated.traffic.TrafficRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.traffic.TrafficResponse>) responseObserver);
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

  private static abstract class TrafficDetectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrafficDetectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.traffic.TrafficDetectionServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrafficDetectionService");
    }
  }

  private static final class TrafficDetectionServiceFileDescriptorSupplier
      extends TrafficDetectionServiceBaseDescriptorSupplier {
    TrafficDetectionServiceFileDescriptorSupplier() {}
  }

  private static final class TrafficDetectionServiceMethodDescriptorSupplier
      extends TrafficDetectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrafficDetectionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TrafficDetectionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrafficDetectionServiceFileDescriptorSupplier())
              .addMethod(getGetTrafficLevelMethod())
              .addMethod(getStreamTrafficUpdatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
