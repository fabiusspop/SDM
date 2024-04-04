package L02_E02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MonoClient implements Runnable {
    private final String hostname;
    private final int port;
    private final int clientNumber;

    public MonoClient(String hostname, int port, int clientNumber) {
        this.hostname = hostname;
        this.port = port;
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String socketName = socket.toString();
            out.println("socket = " + socketName + ", client = " + clientNumber);

            for (int i = 1; i <= 10; i++) {
                String message = "I am " + i + ",  client " + clientNumber;
                out.println(message);
                String response = in.readLine();
                System.out.println("Client " + clientNumber + " received: " + response);
            }

            out.println("END");
        } catch (Exception e) {
            System.out.println("Client " + clientNumber + " exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
