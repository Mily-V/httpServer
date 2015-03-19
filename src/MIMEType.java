import java.util.HashMap;

public class MIMEType {

    private static HashMap<String, String> type = new HashMap<String, String>();

    MIMEType () {}

    static {
        type.put(".html", "text/html");
        type.put(".css", "text/css");
        type.put(".js", "application/js");
        type.put(".jpg", "image/jpeg");
        type.put(".jpeg", "image/jpeg");
        type.put(".png", "image/png");
        type.put(".gif", "image/gif");
        type.put(".swf", "application/swf");
    }

    public static String getType(String fileType) {
        return type.get(fileType);
    }

}
