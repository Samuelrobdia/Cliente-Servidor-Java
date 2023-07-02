import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;

public class HiloEscuchador implements Runnable {
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;

    public HiloEscuchador(Socket cliente) {
        numCliente++;
        hilo = new Thread(this, "Cliente" + numCliente);
        this.enchufeAlCliente = cliente;
        hilo.start();
    }

    @Override
    public void run() {
        System.out.println("Estableciendo comunicación con " + hilo.getName());

        while (true) {

            try {

                OutputStream salida = enchufeAlCliente.getOutputStream();
                InputStream entrada = enchufeAlCliente.getInputStream();

                byte[] mensajeOpcion = new byte[100];
                entrada.read(mensajeOpcion);
                String texto = new String(mensajeOpcion);

                String[] opciones = texto.split(",");

                String opcion = opciones[0].trim();
                String aBuscar;
                List<Producto> productos = new ArrayList<Producto>();

                if (opcion.equals("1")) {
                    aBuscar = opciones[1].trim();
                    productos = AccesoaDatos.LeerCSVporID(aBuscar);

                } else if (opcion.equals("2")) {
                    aBuscar = opciones[1].trim();
                    productos = AccesoaDatos.LeerCSVporNombre(aBuscar);

                } else if (opcion.equals("3")) {

                    productos = AccesoaDatos.LeerCSV();

                }

                ObjectOutputStream outOb = new ObjectOutputStream(salida);
                outOb.writeObject(productos);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
