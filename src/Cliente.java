import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cliente {
    
    public static void main(String[] args) {
        
        System.out.println("Aplicacion Cliente");
        System.out.println("-------------------");

        Socket cliente = new Socket();
        InetSocketAddress direccionServidor = new InetSocketAddress("localhost", 5000);
        System.out.println("Esperando a que el servidor acepte la conexion");

        try {
            Scanner sc = new Scanner(System.in);

            cliente.connect(direccionServidor);
            System.out.println("Comunicacion establecida con el servidor");

            while(true){

                OutputStream salida = cliente.getOutputStream();
                InputStream entrada = cliente.getInputStream();
    
                System.out.println("---- Menu ----");
                System.out.println("1 - Seleccion por ID");
                System.out.println("2 - Seleccion por Nombre");
                System.out.println("3 - Seleccion todo");
                int opcion = Utilidades.pedirEntero("Opcion: ");
                List<Producto> productos = new ArrayList<Producto>();
                ObjectInputStream inOb;
                switch (opcion) {
                    
                    case 1:
                        String id = Utilidades.pedirTexto("Dime el Id a buscar");
                        salida.write((opcion + "," + id).getBytes()); 
                        inOb = new ObjectInputStream(entrada);
                        
                        try {
                            
                            productos = (List<Producto>) inOb.readObject();
    
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        String nombre = Utilidades.pedirTexto("Dime el nombre a buscar");
                        salida.write((opcion + "," + nombre).getBytes()); 
                        inOb = new ObjectInputStream(entrada);
                        
                        try {
                            
                            productos = (List<Producto>) inOb.readObject();
    
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        String opcionS = String.valueOf(opcion);
                        salida.write(opcionS.trim().getBytes()); 
                        inOb = new ObjectInputStream(entrada);
                        
                        try {
                            
                            productos = (List<Producto>) inOb.readObject();
    
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
    
                if(productos.isEmpty()){
                    System.out.println("No se ha encontrado registros");
                }else{
                    System.out.println("LISTA DE PRODUCTOS DEL CSV");
                    System.out.println("-------------------------------");
                    for (Producto producto : productos) {
                        System.out.println(
                            producto.getId() + ", " +
                            producto.getNombre() + ", " +
                            producto.getCantidad() + ", " +
                            producto.getPrecio() + ", " +
                            producto.getDescripcion() + ", " +
                            producto.isDisponible());
                    }
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

