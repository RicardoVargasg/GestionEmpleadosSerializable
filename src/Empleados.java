import java.io.Serializable;

// Implementar Serializable es obligatorio para usar ObjectOutputStream
public class Empleados implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int id;
    private double salario;

    public Empleados(String nombre, int id, double salario) {
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Salario: " + salario + "€";
    }
}