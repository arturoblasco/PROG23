/*
 * Ejercicio 13. (UltimaCifra)
 * Escribir un programa que muestre la última cifra de un
 * número entero que introduce el usuario por teclado. Pista: ¿Qué devuelve a%10 ?
 */
package ud01;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main (String[] arg){
        Scanner tec = new Scanner(System.in);
        int entero;
        System.out.println("Introduce un número entero: ");
        entero = tec.nextInt();

        System.out.println("La última cifra es: "+(entero%10));

    }
}
