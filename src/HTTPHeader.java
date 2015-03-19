
public class HTTPHeader {

    StringBuilder header;

    public HTTPHeader(int responseCode, String comment) {
        header = new StringBuilder();
        header
                .append("HTTP/1.1 ")
                .append(responseCode).append(" ")
                .append(comment).append("\r\n");
    }

    public void setHeader(String key, String value) {
        header.append(key).append(": ").append(value).append("\r\n");
    }


}
