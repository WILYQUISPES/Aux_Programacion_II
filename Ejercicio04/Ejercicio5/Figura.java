public abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    public String getColor()          { return color; }
    public void   setColor(String c)  { this.color = c; }

    public abstract double obtenerArea();

    public void mostrar() {
        System.out.println("Color : " + color);
        System.out.printf("Area  : %.2f%n", obtenerArea());
    }
}
