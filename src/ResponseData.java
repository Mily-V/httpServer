import java.nio.ByteBuffer;


public class ResponseData {

    private final ByteBuffer response;
    private final String code;
    private final String path;


    public ResponseData(ByteBuffer response, String code, String path) {
        this.response = response;
        this.code = code;
        this.path = path;
    }

    public ByteBuffer getResponse() {
        return response;
    }

    public String getCode() {
        return code;
    }

    public String getPathToFile() {
        return path;
    }

}
