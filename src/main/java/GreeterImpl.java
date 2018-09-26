import com.moensun.grpc.service.GreeterGrpc;
import com.moensun.grpc.service.HelloReply;
import com.moensun.grpc.service.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
   /* @Override
    public void sayHi(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply=HelloReply.newBuilder().setMessage((request.getName())).build();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }*/
   @Override
    public void sayHi(HelloRequest request,StreamObserver<HelloReply> responseObserver){
       HelloReply reply=HelloReply.newBuilder().setMessage((request.getName())).build();
       responseObserver.onNext(reply);
       responseObserver.onCompleted();
   }
}
