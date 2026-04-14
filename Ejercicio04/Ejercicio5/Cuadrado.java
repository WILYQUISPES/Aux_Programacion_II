public class Cuadrado extends Figura {
    private int lado;

    public Cuadrado(String color, int lado) {
        super(color);
        this.lado = lado;
    }

    public int  getLado()         { return lado; }
    public void setLado(int lado) { this.lado = lado; }

    @Override
    public double obtenerArea() {
        return (double) lado * lado;
    }

    @Override
    public void mostrar() {
        System.out.println("--------- CUADRADO ---------");
        System.out.println("Color : " + color);
        System.out.println("Lado  : " + lado);
        System.out.printf ("Area  : %.2f%n", obtenerArea());
        System.out.println("----------------------------");
    }
}
