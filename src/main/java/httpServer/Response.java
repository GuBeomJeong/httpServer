package httpServer;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {
    public  String httpVersion = "HTTP/1.1";
    private String statusCode;
    private String reasonPhrase;
    private Map<String,String> headers;

    private String statusLine;
    private OutputStream outputStream;
    private String headerString;

    public Response(){
        this.headers = new HashMap<String,String>();
    }

    public void setStatusLine(String statusLine) {
        this.statusLine = statusLine;
    }

    public void setHeaderString(String headerString) {
        this.headerString = headerString;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public void addHeader(String key, String value){

    }

    @Override
    public String toString() {
        return "httpVersion:'" + httpVersion + '\'' +
                "statusCode:'" + statusCode + '\'' +
                ", reasonPhrase='" + reasonPhrase + '\'' +
                ", headers=" + headers +
                '}';
    }

}
