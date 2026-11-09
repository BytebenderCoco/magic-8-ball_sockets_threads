package magic8ball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Magic8BallClient {
    static void main(){
        Scanner scanner = new Scanner(System.in);
        try(
            Socket s = new Socket("localhost", 1235);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {
        System.out.println("8-Ball: " + in.readLine());
        while(scanner.hasNextLine()){
            String message = scanner.nextLine();
            if(message.trim().equalsIgnoreCase("EXIT")) break;
            out.println(message);
            System.out.println("8-Ball: " + in.readLine());
        }
    } catch(IOException e){
        System.out.println("Session stopped " + e.getMessage());
        }
    }
}
