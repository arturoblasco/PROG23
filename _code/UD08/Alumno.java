package ud08;

import java.time.LocalDate;

public class Alumno extends Persona {

    protected String grupo;
    protected double notaMedia;

    // Constructor
    public Alumno(String nombre, String apellidos, LocalDate fechaNacimiento, String grupo, double notaMedia) {
        super(nombre, apellidos, fechaNacimiento);
        this.grupo = grupo;
        this.notaMedia = notaMedia;
    }
  
    // Métodos getXXXXX
    public String getGrupo() {
      return grupo;
    }
  
    public double getNotaMedia() {
      return notaMedia;
    }
  
    // Métodos setXXXXX
    public void setGrupo(String grupo) {
      this.grupo = grupo;
    }
  
    public void setNotaMedia(double notaMedia) {
      this.notaMedia = notaMedia;
    }

    @Override
    public String getNombre(){
        return "Alumno:\t" + this.nombre;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();

        System.out.printf ("%-18s%s\n", "Grupo:", this.grupo);
        System.out.printf ("%-18s%-5.2f\n", "Nota media:", this.notaMedia);
    }
}
