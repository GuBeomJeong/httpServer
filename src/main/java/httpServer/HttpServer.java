package httpServer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private static final Logger logger = LoggerFactory.getLogger(HttpServer.class);
    public RequestHandler requestHandler = new RequestHandler();
    public ResponseHandler responseHandler = new ResponseHandler();

    int portNumber = 8080;

    public HttpServer(int portNumber){
        this.portNumber = portNumber;
    }

    public void run(){

        try {
            ServerSocket serverSocket=new ServerSocket(portNumber);
            logger.info("server start");
            Socket clientSocket= serverSocket.accept();
            logger.info("client accept");

            Request request = requestHandler.handle(clientSocket);

            Response response = responseHandler.handle(request.getRequestTarget(),clientSocket);


            clientSocket.close();
            serverSocket.close();

        }catch(IOException ioException){
            logger.error("ioException");
        }


    }
}
