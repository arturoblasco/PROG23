package ud08;

public class Rectangulo {
    private Punto vertice1;
    private Punto vertice2;

    public Rectangulo(){
        this.vertice1 = new Punto(0, 0);
        this.vertice2 = new Punto(1, 1);
    }

    public Rectangulo(double x1, double y1, double x2, double y2){
        this.vertice1 = new Punto(x1, y1);
        this.vertice2 = new Punto(x2, y2);        
    }

    // IMPLEMENTACIÓN INCORRECTA:
    // public Rectangulo(Punto v1, Punto v2){
    //     this.vertice1 = v1;
    //     this.vertice2 = v2;
    // }

    // OPCION 1:
    // public Rectangulo(Punto v1, Punto v2){
    //     this.vertice1 = new Punto(v1.getX(), v1.getY());
    //     this.vertice2 = new Punto(v2.getX(), v2.getY());
    // }

    // OPCION 2:
    public Rectangulo(Punto v1, Punto v2){
        this.vertice1 = new Punto(v1);
        this.vertice2 = new Punto(v2);
    }

    public Rectangulo(double base, double altura){
        this.vertice1 = new Punto(0,0);
        this.vertice2 = new Punto(base, altura);
    }

    public Rectangulo(Rectangulo r1){
        this.vertice1 = new Punto(r1.getVertice1());
        this.vertice2 = new Punto(r1.getVertice2());
    }


    public double calculoSuperficie(){
        double base, altura;

        base = vertice2.getX() - vertice1.getX();
        altura = vertice2.getY() - vertice2.getY();
        return base * altura;
    }

    public double calculoPerimetro(){
        double base, altura;

        base = vertice2.getX() - vertice1.getX();
        altura = vertice2.getY() - vertice2.getY();
        return 2*base + 2*altura;
    }

    public Punto getVertice1(){
        return new Punto(vertice1);
    }
    public Punto getVertice2(){
        return new Punto(vertice2);
    }

}
