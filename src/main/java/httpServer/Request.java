package httpServer;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Request {
    static public String httpVersion = "HTTP/1.1";
    private String method;
    private String requestTarget;
    private Map<String,String> headers;
    private InputStream bodyinput;
    private InputStream inputStream;

    public Request(){
        this.headers = new HashMap<String,String>();
    }

    public void setBodyinput(InputStream bodyinput) {
        this.bodyinput = bodyinput;
    }

    public String getRequestTarget() {
        return this.requestTarget;
    }

    public void setRequestTarget(String requestTarget) {
        this.requestTarget = requestTarget;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void addHeader(String key,String value){
        headers.put(key,value);

    }

    public String getHeader(String key){
        return headers.get(key);
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", requestTarget='" + requestTarget + '\'' +
                ", headers=" + headers +
                '}';
    }
}
