/*
 * Ejercicio 14. (PenultimaCifra)
 * Escribir un programa que muestre la penúltima cifra de un 
 * número entero que introduce el usuario por teclado.
 */
package ud01;

import java.util.Scanner;

public class Ejercicio14 {
    public static void main (String[] arg){
        Scanner tec = new Scanner(System.in);
        int entero;
        System.out.println("Introduce un número entero: ");
        entero = tec.nextInt();

        System.out.println("La penúltima cifra es: "+(entero/10%10));

    }
}