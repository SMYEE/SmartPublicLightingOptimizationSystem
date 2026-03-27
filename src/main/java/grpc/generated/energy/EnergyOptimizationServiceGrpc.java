package grpc.generated.energy;

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
 * The energy optimization service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: EnergyOptimization.proto")
public final class EnergyOptimizationServiceGrpc {

  private EnergyOptimizationServiceGrpc() {}

  public static final String SERVICE_NAME = "energy.EnergyOptimizationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.generated.energy.OptimizationRequest,
      grpc.generated.energy.OptimizationResponse> getOptimizeLightingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OptimizeLighting",
      requestType = grpc.generated.energy.OptimizationRequest.class,
      responseType = grpc.generated.energy.OptimizationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.generated.energy.OptimizationRequest,
      grpc.generated.energy.OptimizationResponse> getOptimizeLightingMethod() {
    io.grpc.MethodDescriptor<grpc.generated.energy.OptimizationRequest, grpc.generated.energy.OptimizationResponse> getOptimizeLightingMethod;
    if ((getOptimizeLightingMethod = EnergyOptimizationServiceGrpc.getOptimizeLightingMethod) == null) {
      synchronized (EnergyOptimizationServiceGrpc.class) {
        if ((getOptimizeLightingMethod = EnergyOptimizationServiceGrpc.getOptimizeLightingMethod) == null) {
          EnergyOptimizationServiceGrpc.getOptimizeLightingMethod = getOptimizeLightingMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.energy.OptimizationRequest, grpc.generated.energy.OptimizationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "energy.EnergyOptimizationService", "OptimizeLighting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.energy.OptimizationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.energy.OptimizationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EnergyOptimizationServiceMethodDescriptorSupplier("OptimizeLighting"))
                  .build();
          }
        }
     }
     return getOptimizeLightingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.generated.energy.OptimizationRequest,
      grpc.generated.energy.OptimizationResponse> getMonitorEnergyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "monitorEnergy",
      requestType = grpc.generated.energy.OptimizationRequest.class,
      responseType = grpc.generated.energy.OptimizationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.generated.energy.OptimizationRequest,
      grpc.generated.energy.OptimizationResponse> getMonitorEnergyMethod() {
    io.grpc.MethodDescriptor<grpc.generated.energy.OptimizationRequest, grpc.generated.energy.OptimizationResponse> getMonitorEnergyMethod;
    if ((getMonitorEnergyMethod = EnergyOptimizationServiceGrpc.getMonitorEnergyMethod) == null) {
      synchronized (EnergyOptimizationServiceGrpc.class) {
        if ((getMonitorEnergyMethod = EnergyOptimizationServiceGrpc.getMonitorEnergyMethod) == null) {
          EnergyOptimizationServiceGrpc.getMonitorEnergyMethod = getMonitorEnergyMethod = 
              io.grpc.MethodDescriptor.<grpc.generated.energy.OptimizationRequest, grpc.generated.energy.OptimizationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "energy.EnergyOptimizationService", "monitorEnergy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.energy.OptimizationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.generated.energy.OptimizationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EnergyOptimizationServiceMethodDescriptorSupplier("monitorEnergy"))
                  .build();
          }
        }
     }
     return getMonitorEnergyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnergyOptimizationServiceStub newStub(io.grpc.Channel channel) {
    return new EnergyOptimizationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnergyOptimizationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EnergyOptimizationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnergyOptimizationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EnergyOptimizationServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The energy optimization service definition.
   * </pre>
   */
  public static abstract class EnergyOptimizationServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Optimizes lighting based on traffic and energy usage
     * </pre>
     */
    public void optimizeLighting(grpc.generated.energy.OptimizationRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.energy.OptimizationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getOptimizeLightingMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.generated.energy.OptimizationRequest> monitorEnergy(
        io.grpc.stub.StreamObserver<grpc.generated.energy.OptimizationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getMonitorEnergyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOptimizeLightingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.generated.energy.OptimizationRequest,
                grpc.generated.energy.OptimizationResponse>(
                  this, METHODID_OPTIMIZE_LIGHTING)))
          .addMethod(
            getMonitorEnergyMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.generated.energy.OptimizationRequest,
                grpc.generated.energy.OptimizationResponse>(
                  this, METHODID_MONITOR_ENERGY)))
          .build();
    }
  }

  /**
   * <pre>
   * The energy optimization service definition.
   * </pre>
   */
  public static final class EnergyOptimizationServiceStub extends io.grpc.stub.AbstractStub<EnergyOptimizationServiceStub> {
    private EnergyOptimizationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyOptimizationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyOptimizationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyOptimizationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Optimizes lighting based on traffic and energy usage
     * </pre>
     */
    public void optimizeLighting(grpc.generated.energy.OptimizationRequest request,
        io.grpc.stub.StreamObserver<grpc.generated.energy.OptimizationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getOptimizeLightingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.generated.energy.OptimizationRequest> monitorEnergy(
        io.grpc.stub.StreamObserver<grpc.generated.energy.OptimizationResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getMonitorEnergyMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * The energy optimization service definition.
   * </pre>
   */
  public static final class EnergyOptimizationServiceBlockingStub extends io.grpc.stub.AbstractStub<EnergyOptimizationServiceBlockingStub> {
    private EnergyOptimizationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyOptimizationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyOptimizationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyOptimizationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Optimizes lighting based on traffic and energy usage
     * </pre>
     */
    public grpc.generated.energy.OptimizationResponse optimizeLighting(grpc.generated.energy.OptimizationRequest request) {
      return blockingUnaryCall(
          getChannel(), getOptimizeLightingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The energy optimization service definition.
   * </pre>
   */
  public static final class EnergyOptimizationServiceFutureStub extends io.grpc.stub.AbstractStub<EnergyOptimizationServiceFutureStub> {
    private EnergyOptimizationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EnergyOptimizationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnergyOptimizationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EnergyOptimizationServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Optimizes lighting based on traffic and energy usage
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.generated.energy.OptimizationResponse> optimizeLighting(
        grpc.generated.energy.OptimizationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getOptimizeLightingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_OPTIMIZE_LIGHTING = 0;
  private static final int METHODID_MONITOR_ENERGY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnergyOptimizationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnergyOptimizationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_OPTIMIZE_LIGHTING:
          serviceImpl.optimizeLighting((grpc.generated.energy.OptimizationRequest) request,
              (io.grpc.stub.StreamObserver<grpc.generated.energy.OptimizationResponse>) responseObserver);
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
        case METHODID_MONITOR_ENERGY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.monitorEnergy(
              (io.grpc.stub.StreamObserver<grpc.generated.energy.OptimizationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EnergyOptimizationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnergyOptimizationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.generated.energy.EnergyOptimizationServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EnergyOptimizationService");
    }
  }

  private static final class EnergyOptimizationServiceFileDescriptorSupplier
      extends EnergyOptimizationServiceBaseDescriptorSupplier {
    EnergyOptimizationServiceFileDescriptorSupplier() {}
  }

  private static final class EnergyOptimizationServiceMethodDescriptorSupplier
      extends EnergyOptimizationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnergyOptimizationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnergyOptimizationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnergyOptimizationServiceFileDescriptorSupplier())
              .addMethod(getOptimizeLightingMethod())
              .addMethod(getMonitorEnergyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
