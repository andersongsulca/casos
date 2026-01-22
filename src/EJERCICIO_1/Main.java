package EJERCICIO_1;


import java.util.*;

public class Main {

    // Scanner para leer datos desde consola
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {

        // Ingreso dinámico de datos usando ArrayList
        List<Integer> lista = ingresarDatos();

        // Mostrar lista original
        System.out.println("\nLista original ingresada: " + lista);

        // Convertir a arreglo para aplicar Merge Sort
        int[] arreglo = lista.stream().mapToInt(Integer::intValue).toArray();

        // Ordenar usando el algoritmo Merge Sort (recursivo)
        mergeSort(arreglo);

        // Mostrar lista ordenada de menor a mayor
        System.out.println("Lista ordenada (ascendente): " + Arrays.toString(arreglo));
    }

    // Método para ingresar datos y permitir agregar más elementos
    private static List<Integer> ingresarDatos() {
        List<Integer> datos = new ArrayList<>();

        System.out.print("Ingrese la cantidad inicial de elementos a ordenar: ");
        int n = SC.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Elemento #" + (i + 1) + ": ");
            datos.add(SC.nextInt());
        }

        System.out.print("¿Desea agregar más elementos? (s/n): ");
        char opcion = SC.next().toLowerCase().charAt(0);

        while (opcion == 's') {
            System.out.print("¿Cuántos elementos adicionales desea ingresar?: ");
            int m = SC.nextInt();

            for (int i = 0; i < m; i++) {
                System.out.print("Elemento adicional #" + (i + 1) + ": ");
                datos.add(SC.nextInt());
            }

            System.out.print("¿Desea agregar más elementos? (s/n): ");
            opcion = SC.next().toLowerCase().charAt(0);
        }

        return datos;
    }

    // Método principal de Merge Sort (división recursiva)
    private static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    // Divide el arreglo en mitades y las ordena recursivamente
    private static void mergeSort(int[] a, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(a, inicio, medio);
            mergeSort(a, medio + 1, fin);
            mezclar(a, inicio, medio, fin);
        }
    }

    // Mezcla dos subarreglos ordenados en uno solo
    private static void mezclar(int[] a, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        int[] izquierda = new int[n1];
        int[] derecha = new int[n2];

        for (int i = 0; i < n1; i++)
            izquierda[i] = a[inicio + i];
        for (int j = 0; j < n2; j++)
            derecha[j] = a[medio + 1 + j];

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (izquierda[i] <= derecha[j])
                a[k++] = izquierda[i++];
            else
                a[k++] = derecha[j++];
        }

        while (i < n1)
            a[k++] = izquierda[i++];

        while (j < n2)
            a[k++] = derecha[j++];
    }
}
