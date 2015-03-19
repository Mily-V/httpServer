import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NonBlockingServerSocketChannel {

    private ServerSocketChannel ssChannel;
    private SocketChannel socket;
    private Selector eventSelector;

    public NonBlockingServerSocketChannel(InetSocketAddress port)
            throws IOException {
        ssChannel = ServerSocketChannel.open();             // open - создается канал
        ssChannel.socket().bind(port);                      // bind - связывает сокет канал с локальным адресом
                                                            // и конфигурирует сокет, чтоы прослушивать соединения
    }

    public void start(ThreadPoolExecutor poolThread) {


        try {
            while(true) {
                socket = ssChannel.accept();                //ждет соединения
                System.err.println(socket);
                poolThread.execute(new HTTPConnector(socket));
            }
        } catch (Exception e) {
            System.err.println(e);
            System.exit(-1);
        }





    }

}

