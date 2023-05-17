package ud08;

import java.time.LocalDate;

public class Profesor extends Persona{
    String especialidad;
    double salario;
  
    // Constructor
    public Profesor(String nombre, String apellidos, LocalDate fechaNacimiento, String especialidad, double salario) {
        super(nombre, apellidos, fechaNacimiento);
        this.especialidad = especialidad;
        this.salario = salario;
    }

    // Métodos getXXXXX
    public String getEspecialidad() {
      return especialidad;
    }
  
    public double getSalario() {
      return salario;
    }
  
    // Métodos setXXXXX
    public void setSalario(double salario) {
      this.salario = salario;
    }
  
    public void setESpecialidad(String especialidad) {
      this.especialidad = especialidad;
    }    

    @Override
    public String getNombre(){
        return "Profesor:\t" + this.nombre;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();

        System.out.printf ("%-18s%s\n", "Especialidad:", this.especialidad);
        System.out.printf ("%-18s%-7.2f €\n", "Salario:", this.salario);
    }    
}
