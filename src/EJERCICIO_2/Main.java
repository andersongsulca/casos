package EJERCICIO_2;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();

        int cantidad = leerEnteroMinimo("¿Cuántos empleados desea registrar? (mínimo 5): ", 5);

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("\nEmpleado #" + i);

            int id = leerEntero("ID: ");
            System.out.print("Nombre: ");
            String nombre = SC.nextLine().trim();

            double salario = leerDouble("Salario: ");
            System.out.print("Área: ");
            String area = SC.nextLine().trim();

            empleados.add(new Empleado(id, nombre, salario, area));
        }

        System.out.println("\n=== Empleados registrados ===");
        for (Empleado e : empleados) {
            System.out.println(e);
        }
    }

    private static int leerEnteroMinimo(String prompt, int minimo) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v >= minimo) return v;
                System.out.println("Debe ser un número entero mayor o igual a " + minimo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static int leerEntero(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static double leerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = SC.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número decimal válido (use punto como separador).");
            }
        }
    }
}
