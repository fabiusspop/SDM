package L02_E02;

public class MultiClients {
    public static void main(String[] args) {
        final int numberOfClients = 3;
        String hostname = "localhost";
        int port = 12345;

        for (int i = 1; i <= numberOfClients; i++) {
            new Thread(new MonoClient(hostname, port, i)).start();
        }
    }
}

