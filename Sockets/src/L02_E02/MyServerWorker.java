package L02_E02;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MyServerWorker extends Thread {
    private Socket socket;

    public MyServerWorker(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String text;
            while ((text = input.readLine()) != null) {
                System.out.println(text);
                output.println(text);

                if ("END".equals(text)) {
                    break;
                }
            }

            socket.close();
        } catch (Exception e) {
            System.out.println("Worker exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
