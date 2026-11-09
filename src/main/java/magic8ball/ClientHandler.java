package magic8ball;
import java.io.*;
import java.net.Socket;


public class ClientHandler implements Runnable{
    private final Socket socket;
    private final Magic8Ball ball;

    public ClientHandler(Socket socket, Magic8Ball ball){
        this.socket = socket;
        this.ball = ball;
    }

    @Override
    public void run(){
        try(Socket s = socket;
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true)
            ){
            out.println("Greetings from the Magic-8-Ball! You may ask, what's on your heart");
            String line;
            while((line = in.readLine()) != null){
                if (line.trim().equalsIgnoreCase("EXIT")) break;
                out.println( ball.getAnswer());
            }
        }catch (IOException e) {System.out.println("Client disconnected " + e.getMessage());}
    }
}
