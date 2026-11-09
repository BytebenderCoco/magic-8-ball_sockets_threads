package magic8ball;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Magic8BallServer {

    private final static Magic8Ball BALL = new Magic8Ball();

    static void main() throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(1235)) {
            try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
                while (true) {
                    try {
                        Socket socket = serverSocket.accept();
                        executor.submit(new ClientHandler(socket, BALL));
                    } catch (IOException e) {
                        System.out.println("Server lost connection " + e.getMessage());
                    }
                }
            }
        }
    }
}