import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 2;
    private static final int MAX_SIZE_BLOCKING_QUEUE = 5;
    private static final int REQUEST = 4;
    private static final int BUFFER_SIZE = 512;


    public static void main(String args[]) throws IOException {

        ThreadPoolExecutor threadPool =
                new ThreadPoolExecutor(THREAD_POOL_SIZE, MAX_SIZE_BLOCKING_QUEUE);
        System.out.println();
        System.out.println("0 - " + threadPool.threads.get(0).getState());
        System.out.println("1 - " + threadPool.threads.get(1).getState());

        NonBlockingServerSocketChannel server =
                new NonBlockingServerSocketChannel(new InetSocketAddress(PORT));
        System.out.println("Добавился ServerSocketChannel");

        server.start(threadPool);



    }
}
