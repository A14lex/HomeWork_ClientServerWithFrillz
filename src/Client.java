import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
//        String host = "localhost";

        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))

        ) {

//          Диалог
            System.out.println("Диалог начали");

            String msgName;
            String msgAnswer;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            String resp = in.readLine();
            if(resp.equals("Write your name")){
                System.out.println(resp);
                msgName = br.readLine();
                out.println(msgName);

            }
            resp = in.readLine();
            if(resp.equals("Are you child? (yes/no)")){
                System.out.println(resp);
                msgAnswer = br.readLine();
                out.println(msgAnswer);

            }
            resp = in.readLine();


            System.out.println(resp);
            System.out.println("Диалог завершен");
            br.close();
        } catch (RuntimeException | IOException e) {
            System.out.println("Ошибка клиента" + e.getMessage());

        }
    }
}
