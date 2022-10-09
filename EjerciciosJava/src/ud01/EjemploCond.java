package ud01;
import java.util.*;
public class EjemploCond {
    public static void main (String[] arg){
        Scanner tec = new Scanner(System.in);
        int mayor, exp1, exp2;

        System.out.print("Dame el primer número: ");
        exp1 = tec.nextInt();
        System.out.print("Dame el segundo número: ");
        exp2 = tec.nextInt();

        System.out.println("El número mayor es: "+((exp1>exp2)?exp1:exp2));
    }
}