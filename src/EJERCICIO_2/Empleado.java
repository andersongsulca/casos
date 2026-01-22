package EJERCICIO_2;


public class Empleado {
    private int id;
    private String nombre;
    private double salario;
    private String area;

    public Empleado(int id, String nombre, double salario, String area) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.area = area;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }
    public String getArea() { return area; }

    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSalario(double salario) { this.salario = salario; }
    public void setArea(String area) { this.area = area; }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nombre: " + nombre +
               " | Salario: " + String.format("%.2f", salario) +
               " | Área: " + area;
    }
}
