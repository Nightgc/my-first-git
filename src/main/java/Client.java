import com.moensun.grpc.service.GreeterGrpc;
import com.moensun.grpc.service.HelloReply;
import com.moensun.grpc.service.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {

    private final ManagedChannel channel;
    private final GreeterGrpc.GreeterBlockingStub blockingStub;
    private static final Logger logger=Logger.getLogger(Client.class.getName());

    public Client(String host,int port){
        channel = ManagedChannelBuilder.forAddress(host,port).usePlaintext(true).build();
        blockingStub = GreeterGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws  InterruptedException{
        channel.shutdown().awaitTermination(5,TimeUnit.SECONDS);
    }


    public void greet(String name) throws InterruptedException {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();

        HelloReply response;//i think

        Thread.sleep(1000);
        try{
            response = blockingStub.sayHi(request);

        }catch (StatusRuntimeException e){
            logger.log(Level.WARNING,"failed",e.getStatus());
            return;
        }
        logger.info("greeting  "+response.getMessage());
    }

    public static void main(String[] args) throws InterruptedException{
        Client client = new Client("127.0.0.1",55551);
        try{
            String user ="world";
            client.greet(user);
        }finally {
            System.out.println("final");

        }
    }

}
