import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) throws IOException {
    try (Socket socket = new Socket("localhost", 5052);
         BufferedReader entrada = new BufferedReader(
             new InputStreamReader(socket.getInputStream()));
         PrintWriter saida = new PrintWriter(socket.getOutputStream(), true);
         Scanner teclado = new Scanner(System.in)) {
      String msg;
      do {
        System.out.print("> ");
        msg = teclado.nextLine();
        saida.println(msg);
        System.out.println("Servidor: " + entrada.readLine());
      } while (!msg.equalsIgnoreCase("SAIR"));
    }
  }
}
