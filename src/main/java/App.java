import httpServer.HttpServer;

public class App {
    static public void main(String[] args){
        HttpServer httpServer = new HttpServer(8080);
        httpServer.run();

    }
}
