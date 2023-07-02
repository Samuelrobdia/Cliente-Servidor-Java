import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccesoaDatos{
    
    public static List<Producto> LeerCSV() {
        List<Producto> productos = new ArrayList<Producto>();

        try {
            CsvReader leerProductos = new CsvReader("Productos.csv");
            leerProductos.readHeaders();

            while (leerProductos.readRecord()) {
                int id = Integer.parseInt(leerProductos.get(0));
                String nombre = leerProductos.get(1);
                int cantidad = Integer.parseInt(leerProductos.get(2));
                Float precio = Float.parseFloat(leerProductos.get(3));
                String descripcion = leerProductos.get(4);
                boolean disponible = Boolean.parseBoolean(leerProductos.get(5));

                productos.add(new Producto(id,nombre,cantidad,precio,descripcion,disponible));
            }

            leerProductos.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productos;

    }

    public static List<Producto> LeerCSVporID(String id) {
        
        List<Producto> productos = new ArrayList<Producto>();

        try {
            CsvReader leerProductos = new CsvReader("Productos.csv");
            leerProductos.readHeaders();
            int idNum = Integer.parseInt(id);
            while (leerProductos.readRecord()) {

                if(Integer.parseInt(leerProductos.get(0)) == idNum){
                    int idCSV = Integer.parseInt(leerProductos.get(0));
                    String nombre = leerProductos.get(1);
                    int cantidad = Integer.parseInt(leerProductos.get(2));
                    Float precio = Float.parseFloat(leerProductos.get(3));
                    String descripcion = leerProductos.get(4);
                    boolean disponible = Boolean.parseBoolean(leerProductos.get(5));
                    productos.add(new Producto(idCSV,nombre,cantidad,precio,descripcion,disponible));
                }
               
            }

            leerProductos.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productos;

    }

    public static List<Producto> LeerCSVporNombre(String nombre) {
        
        List<Producto> productos = new ArrayList<Producto>();

        try {
            CsvReader leerProductos = new CsvReader("Productos.csv");
            leerProductos.readHeaders();
            while (leerProductos.readRecord()) {

                if(leerProductos.get(1).equals(nombre)){
                    int idCSV = Integer.parseInt(leerProductos.get(0));
                    String nombreCSV = leerProductos.get(1);
                    int cantidad = Integer.parseInt(leerProductos.get(2));
                    Float precio = Float.parseFloat(leerProductos.get(3));
                    String descripcion = leerProductos.get(4);
                    boolean disponible = Boolean.parseBoolean(leerProductos.get(5));
                    productos.add(new Producto(idCSV,nombreCSV,cantidad,precio,descripcion,disponible));
                }
               
            }

            leerProductos.close();
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productos;

    }

}
