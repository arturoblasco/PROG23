package ud08;

import java.time.LocalDate;


public class PersonaTest {
    
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Jose", "Alcántara Ruíz", LocalDate.of(2000, 10, 18));

        // System.out.println(p1);
        // System.out.println(p2);

        p1.mostrarDatos();
        p2.mostrarDatos();

        Alumno al1 = new Alumno("Carmen", "García Llopis", LocalDate.of(2001,10,16), "A", 7.5);
        al1.mostrarDatos();

        Profesor pr1 = new Profesor("Francisco", "Díaz Gallego", LocalDate.of(1976,8, 19), "Informática", 1750.69);
        pr1.mostrarDatos();
    }
}
