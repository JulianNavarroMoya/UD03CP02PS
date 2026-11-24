// ServidorAdivina.java
package adivina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorAdivina {

    public static void main(String[] args) {
        final int PUERTO = 5000;

        try (ServerSocket ss = new ServerSocket(PUERTO)) {
            System.out.println("Servidor 'Adivina el número' en puerto " + PUERTO);

            while (true) {
                try (Socket cliente = ss.accept()) {
                    BufferedReader entrada = new BufferedReader(
                            new InputStreamReader(cliente.getInputStream()));
                    PrintWriter salida = new PrintWriter(
                            cliente.getOutputStream(), true);

                    int secreto = (int) (Math.random() * 100) + 1;
                    System.out.println("Nuevo cliente. Número secreto: " + secreto);

                    int intentos = 0;
                    String linea;
                    while ((linea = entrada.readLine()) != null) {
                        int intento = Integer.parseInt(linea);
                        intentos++;

                        if (intento < secreto) {
                            salida.println("MAYOR");
                        } else if (intento > secreto) {
                            salida.println("MENOR");
                        } else {
                            salida.println("CORRECTO " + intentos);
                            System.out.println("Cliente acertó en " + intentos + " intentos.");
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}