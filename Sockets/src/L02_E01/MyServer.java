package L02_E01;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection accepted: " + socket);

                new MyServerWorker(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
