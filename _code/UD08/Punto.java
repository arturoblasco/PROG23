package ud08;

public class Punto {
    private double x;
    private double y;

    public Punto(){
        this.x = 0;
        this.y = 0;
    }

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Punto(Punto p1){
        this.x = p1.x;
        this.y = p1.y;
    }

    public double getX(){
        return this.x;
    }
    public void setX(double x){
        this.x = x;
    }

    public double getY(){
        return this.y;
    }
    public void setY(double y){
        this.y = y;
    }    

    @Override
    public String toString(){
        return "Las coordenadas del punto son:\nx: " + this.x +
                "\ny: " + this.y;
    }
}
