package L02_E01;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String socketName = socket.toString();
            output.println("socket = " + socketName);

            for (int i = 1; i <= 10; i++) {
                String message = "I am " + i;
                output.println(message);
                System.out.println("Sent: " + message);
                String response = input.readLine();
                System.out.println("Echo: " + response);
            }

            output.println("END");

        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
