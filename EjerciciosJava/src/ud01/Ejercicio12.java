/*
 * Ejercicio 12. (Dados)
 * Escribir un programa que simula el lanzamiento de dos dados.
 */
package ud01;

public class Ejercicio12 {
    public static void main (String[] arg) {
        int dau1, dau2;

        dau1 = (int)(Math.random()*6+1);
        System.out.println("Tirem el dau 1 i ha eixit el valor:"+dau1);
        dau2 = (int)(Math.random()*6+1);
        System.out.println("Tirem el dau 1 i ha eixit el valor:"+dau2);
        System.out.println("El valor de la tirada és:"+(dau1+dau2));
    }

}
