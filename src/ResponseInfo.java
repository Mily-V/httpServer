import java.util.HashMap;

public class ResponseInfo {

    private static HashMap<Integer, String> response;

    public static final int OK = 200;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;

    public ResponseInfo() {
        response = new HashMap<Integer, String>();
    }

    static {
        response.put(OK, "OK");
        response.put(FORBIDDEN, "Forbidden");
        response.put(NOT_FOUND, "Not Found");
        response.put(METHOD_NOT_ALLOWED, "Method Not Allowed");
    }

    public static String getResponseString (int code) {
        return response.get(code);
    }

}
