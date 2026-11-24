package adivina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteAdivina {

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader entrada = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(
                     socket.getOutputStream(), true);
             BufferedReader teclado = new BufferedReader(
                     new InputStreamReader(System.in))) {

            System.out.println("Conectado al juego 'Adivina el número'.");
            System.out.println("He pensado un número entre 1 y 100. Adivínalo.");

            String respuesta;
            do {
                salida.println(teclado.readLine());
                respuesta = entrada.readLine();
                System.out.println(respuesta);
            } while (respuesta != null && !respuesta.startsWith("CORRECTO"));

            System.out.println("¡Enhorabuena!");

        } catch (IOException e) {
            System.err.println("Error de comunicación: " + e.getMessage());
        }
    }
}
