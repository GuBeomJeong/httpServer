package httpServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

public class ResponseHandler {
    private static final Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    public Response handle(String requestTarget, Socket clientSocket) {


        Response response = new Response();

        try {

            OutputStream out = clientSocket.getOutputStream();

            response.setStatusCode("200");
            response.setReasonPhrase("OK");

            String ContentType;


            String fileType = requestTarget.split("\\.")[1];

            if(fileType.equals("jpg") || fileType.equals("jpeg")){
                ContentType = "image/jpeg;";
            }else{
                ContentType = "text/html;";
            }


            File f = new File("src/main/webapp"+ requestTarget);
            StringBuffer sb = new StringBuffer();
            sb.append("HTTP/1.1 200 OK");
            sb.append("");
            sb.append("\n");
            sb.append("Content-Type:"+ContentType);
            sb.append("\n");
            sb.append("Status:200 OK");
            sb.append("\n");
            sb.append("Content-Length: " + f.length());
            sb.append("\n");
            sb.append("\n"); // 빈줄

            out.write(sb.toString().getBytes());

            FileInputStream fis = null;
            try{
                fis = new FileInputStream(f);
                byte[] buffer = new byte[1024];
                int readCount = 0;
                while((readCount = fis.read(buffer)) != -1){ // 파일의 끝(-1) 까지 읽어들인다.
                    out.write(buffer,0,readCount);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }


        } catch (IOException ioException) {

        }

        return response;

    }
}
