public class ResponseBuilder {

    private String path;
    private String method;

    public ResponseBuilder() { }

    public void setPathToFile(String path) {
        this.path = path;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }
}
