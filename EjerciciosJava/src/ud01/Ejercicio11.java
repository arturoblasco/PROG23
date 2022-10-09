/*
 * Ejercicio 11. (Círculo) 
 * Escribir un programa que calcule la longitud de la circunferencia y
 * el área del círculo para un valor del radio introducido por teclado.
 */
package ud01;

import javax.swing.JOptionPane;

public class Ejercicio11 {
    public static void main(String[] arg){
        final double PI = 3.141592;
        int radi;
        double longitud, area;

        radi = Integer.parseInt(JOptionPane.showInputDialog("Introdueix el radi:"));

        longitud = 2 * PI * radi;
        area = PI * Math.sqrt(radi);

        JOptionPane.showMessageDialog(null, "la longitud és: "+longitud+"\n i l'àrea: "+area);
    }
}
