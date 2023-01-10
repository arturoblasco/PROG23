package ud04;
/*
 * author: abc
 * Ejercicio búsqueda binaria/dicotómica en array:
 */

import java.util.Scanner;
import java.util.Arrays;

public class ArrayBusquedaBinaria {
    static final int TAM = 100;
        
    /* método generar array de n elementos aleatorios
     * devuelve array de enteros
     */
    public static int[] generarArray(int n){
        int[] a = new int[n];
        int temp;

        a[0] = (int)(Math.random()*TAM);
        for (int i = 1; i < n; i++)
            a[i] = a[i-1] + (int)(Math.random()*TAM);

        return a;
    }

    /* método búsqueda binaria/dicotómica
     * argumentos: número a buscar y array
     * retorna: entero (posición o -1)
     */
    public static int busquedaBinaria (int n, int[] a){
        int izq = 0;
        int der = a.length-1;
        boolean encontrado = false;

        while (izq<=der && !encontrado){
            int m = (izq+der)/2;

            if (a[m] == n)
                return m;
            else if (a[m] > n)
                    der = m - 1;
                else
                    izq = m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        int tamano;
        int[] vector;

        System.out.print("\nIntroduce el tamaño del array:\t");
        tamano = entrada.nextInt();
        vector = generarArray(tamano);

        System.out.println("\nArray generado:");
        System.out.println(Arrays.toString(vector));

        System.out.print("\nIntroduce el número a buscar:\t");
        numero = entrada.nextInt();

        if (busquedaBinaria(numero, vector) == -1)
            System.out.println("-> No se ha encontrado el elemento "+ numero +" en el array");
        else 
            System.out.println("-> El elemento " + numero + " se encuentra en la posición " + busquedaBinaria(numero, vector));
    }

}
