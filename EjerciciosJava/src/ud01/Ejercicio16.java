/*
 * Ejercicio 16. (Redondear1)
 * Math.round(x) redondea x de manera que este queda sin decimales. 
 * (Math.round(35.5289) da como resultado 36)
 */
package ud01;

import java.util.Scanner;

public class Ejercicio16 {
    public static void main (String[] arg){
        Scanner tec = new Scanner(System.in);
        double numero;
        System.out.println("Introduce un número real: ");
        numero = tec.nextDouble();

        System.out.println("El número "+numero+
            ", redondeado a un decimal es "+(Math.round(numero*10)/(double)10));

    }
}
