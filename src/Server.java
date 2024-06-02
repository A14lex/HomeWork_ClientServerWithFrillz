import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // использую порт 8080, как в задании рекомендовано
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения



                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
//                    Диалог
                    String msg;
                    System.out.println("Начали диалог");
                    out.println("Write your name");
                    final String clientName = in.readLine();
                    out.println("Are you child? (yes/no)");
                    final String clientLevel = in.readLine();
                    if (clientLevel.equals("no")) {
                        out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", clientName));
                    } else if (clientLevel.equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play!", clientName));
                    }
                    System.out.println("Диалог завершен");
                    break;


                }

            }

        } catch (IOException e) {
            System.out.println("Ошибка на сервере");
            e.printStackTrace();
        }


    }
}
