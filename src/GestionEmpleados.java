import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionEmpleados {
    public static void main(String[] args) {
        String archivo = "empleados.dat"; // Usamos .dat para indicar que son datos binarios
        List<Empleados> listaEscritura = new ArrayList<>();

        listaEscritura.add(new Empleados("Diana Gallego", 001, 2500.0));
        listaEscritura.add(new Empleados("Jose Maria Garces", 002, 1800.5));
        listaEscritura.add(new Empleados("Maria Gonzalez", 003, 3200.0));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(listaEscritura);
            System.out.println("Lista de empleados guardada en:  " + archivo);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {

            List<Empleados> listaLectura = (List<Empleados>) ois.readObject();

            System.out.println("\nEmpleados recuperados del archivo:");
            for (Empleados emp : listaLectura) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}