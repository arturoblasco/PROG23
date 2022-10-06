package ud01;
import javax.swing.JOptionPane;

public class EjemploJOptionPane {
    public static void main (String[] arg){
        String cadena;
        int entero;
        char letra;
        double decimal;

        cadena = JOptionPane.showInputDialog ("texto en descripción de ventana:");
        entero = Integer.parseInt( JOptionPane.showInputDialog ("inserta un número entero:"));
        decimal= Double.parseDouble( JOptionPane.showInputDialog ("inserta un número decimal:"));
        letra= JOptionPane.showInputDialog ("inserta una letra:").charAt(0);

        // mostrar en ventana los valores:
        JOptionPane.showMessageDialog(null, "la cadena es: "+cadena);
        JOptionPane.showMessageDialog(null, "el número entero es: "+entero);
        JOptionPane.showMessageDialog(null, "la número decimal es: "+decimal);
        JOptionPane.showMessageDialog(null, "la letra es: "+letra);
    }
}