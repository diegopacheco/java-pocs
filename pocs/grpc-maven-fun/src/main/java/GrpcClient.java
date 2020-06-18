import com.github.diegopacheco.grpc.HelloRequest;
import com.github.diegopacheco.grpc.HelloResponse;
import com.github.diegopacheco.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Diego Pacheco")
                .setLastName("gRPC")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);
        channel.shutdown();
    }
}