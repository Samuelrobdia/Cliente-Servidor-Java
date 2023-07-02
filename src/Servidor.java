import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor{
    
    public static void main(String[] args) {            
           
            System.out.println("APLICACION DE SERVIDOR PRODUCTOS");
            System.out.println("--------------------------");
        
            try {

                ServerSocket servidor;
                servidor = new ServerSocket();
                
                InetSocketAddress direccion = new InetSocketAddress("localhost", 5000);
                servidor.bind(direccion);   
                
                System.out.println("Servidor creado y escuchando...");
                System.out.println("Direccion IP: " + direccion.getAddress());
                
                while(true){
                    
                    Socket enchufeAlCliente = servidor.accept();
                    System.out.println("Comunicacion entrante");
                    new HiloEscuchador(enchufeAlCliente);
             
                }
                
            } catch (IOException e) {
                
                e.printStackTrace();
            }
    }

}
