import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class Service {
/*    private static final Logger logger = Logger.getLogger(Service.class.getName());
    private int port=50051;
    private Server server;

    private void start() throws IOException{

        server = ServerBuilder.forPort(port).addService(new GreeterImpl()).build().start();
        logger.info("Server Started Listen on"+port);

    }

    private void blockUntilShutdown()throws InterruptedException{
        if(server!=null){
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException,InterruptedException {

        final Service service =new Service();
        service.start();
        service.blockUntilShutdown();

    }*/

    private final int port=55551;
    private static final Logger logger=Logger.getLogger(Server.class.getName());
    private Server server;

    private void start() throws IOException{
        server = ServerBuilder.forPort(port).addService(new GreeterImpl()).build().start();
        logger.info("listen on "+port);
    }
    private void stop() throws  InterruptedException{
        if (server!=null){
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws InterruptedException,IOException {
        Service service=new Service();
        service.start();
        service.stop();
    }


}

