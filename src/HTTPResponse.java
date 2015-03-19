import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HTTPResponse {

    private static final String DEFAULT_FILE_NAME = "index.html";
    private static final int BUFFER_SIZE = 512;
    private static final String DOCUMENT_ROOT =
            "C:\\Mily-V\\TECHPARK\\SEMESTR_3\\HIGHLOAD\\learning\\ThreadPool\\static";

    public HTTPResponse(){}

    public void getResponse(ResponseBuilder data)
            throws Throwable {
        String method = data.getMethod();
        String path = data.getPath();
        String status;
        ByteBuffer writeBuffer = ByteBuffer.allocate(BUFFER_SIZE);

        /*if (!method.equals("GET") && !method.equals("HEAD")) {
            status = ResponseInfo.getResponseString (ResponseInfo.METHOD_NOT_ALLOWED);
            writeBuffer.put(status.getBytes());
        } else {
            if (path.contains("../")) {
                status = ResponseInfo.getResponseString (ResponseInfo.FORBIDDEN);
                writeBuffer.put(status.getBytes());
            } else {

            }*/


        }


    }

