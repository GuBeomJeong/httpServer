package httpServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestHandler {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    public Request handle(Socket clientSocket){

        Request request = new Request();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String line = null;
            String[] header;

            header = in.readLine().split(" ");

            request.setMethod(header[0].trim());

            request.setRequestTarget(header[1].trim());

            while ((line = in.readLine()) != null) {


                if ("".equals(line)) {
                    break;
                }

                header = line.split(":",2);

                request.addHeader(header[0],header[1]);

            }

            request.setBodyinput(clientSocket.getInputStream());

            logger.info(request.toString());

        }catch(IOException ioException){

        }

        return request;
    }


}
