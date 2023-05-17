package ud08;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
    protected String nombre;
    protected String apellidos;
    protected LocalDate fechaNacimiento;

    //Constructores
    public Persona(){
        this.nombre = "Persona";
        this.apellidos = "Apellidos";
        this.fechaNacimiento = LocalDate.now();
    }

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    // Métodos getXXXXX
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public LocalDate getFechaNacim() {
        return this.fechaNacimiento;
    }
    // Métodos setXXXXX
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setFechaNacim(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString(){
        return String.format("%-15s%s\n%-15s%s\n%-15s%s\n", "Nombre:", this.nombre, "Apellidos:" , this.apellidos, "Fecha nac.:", this.fechaNacimiento);
    }

    public void mostrarDatos() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String stringFecha = formatoFecha.format(this.fechaNacimiento);
      
        System.out.println("------------------------------");
        System.out.printf ("%-18s%s\n", "Nombre:", this.nombre);
        System.out.printf ("%-18s%s\n", "Apellidos:", this.apellidos);
        System.out.printf ("%-18s%s\n", "Fecha nacimiento:", stringFecha);
      }
}