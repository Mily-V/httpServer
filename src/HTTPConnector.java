import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HTTPConnector implements Runnable{

    private static final String DOCUMENT_ROOT =
            "C:\\Mily-V\\TECHPARK\\SEMESTR_3\\HIGHLOAD\\learning\\ThreadPool\\static";
    private static final int BUFFER_SIZE = 512;

    private SocketChannel socket;
    private int bytesRead;
    private int bytesWrite;
    private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);

    public HTTPConnector(SocketChannel socket) {
        this.socket = socket;
        try {
            bytesRead = socket.read(readBuffer);
            if (readBuffer.position() < readBuffer.limit()) {
                System.out.println("В буфере что-то есть: " + readBuffer.toString());
            } else
                System.out.println("В буфере нет ничего: ");

        } catch (Exception e) {
            System.err.println(e);
            System.exit(-1);
        }
    }


    @Override
    public void run() {
        try {
            System.out.println("Запуск run HTTPConnection");

            //bytesWrite = socket.write(writeBuffer);
        }  catch (Exception e) {
            System.err.println(e);
            System.exit(-1);
        }

    }
}
