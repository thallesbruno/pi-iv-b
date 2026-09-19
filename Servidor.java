import java.io.*;
import java.net.*;

public class Servidor {
  public static void main(String[] args) throws IOException {
    System.out.println("Aguardando cliente na porta 5052...");
    try (ServerSocket servidor = new ServerSocket(5052);
         Socket cliente = servidor.accept();
         BufferedReader entrada = new BufferedReader(
             new InputStreamReader(cliente.getInputStream()));
         PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true)) {
      System.out.println("Cliente: " + cliente.getInetAddress());
      String linha;
      while ((linha = entrada.readLine()) != null) {
        if (linha.equalsIgnoreCase("SAIR")) {
          saida.println("TCHAU");
          break;
        }
        saida.println(linha.toUpperCase());
      }
    }
  }
}
