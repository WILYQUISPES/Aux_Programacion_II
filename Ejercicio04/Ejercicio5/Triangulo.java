public class Triangulo extends Figura {
    private int lado1;
    private int lado2;
    private int lado3;

    public Triangulo(String color, int lado1, int lado2, int lado3) {
        super(color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public int getLado1() { return lado1; }
    public int getLado2() { return lado2; }
    public int getLado3() { return lado3; }

    public void setLado1(int lado1) { this.lado1 = lado1; }
    public void setLado2(int lado2) { this.lado2 = lado2; }
    public void setLado3(int lado3) { this.lado3 = lado3; }

    // Formula de Heron: s = (a+b+c)/2 -> Area = sqrt(s*(s-a)*(s-b)*(s-c))
    @Override
    public double obtenerArea() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public void mostrar() {
        System.out.println("--------- TRIANGULO ---------");
        System.out.println("Color  : " + color);
        System.out.println("Lado1  : " + lado1);
        System.out.println("Lado2  : " + lado2);
        System.out.println("Lado3  : " + lado3);
        System.out.printf ("Area   : %.2f%n", obtenerArea());
        System.out.println("-----------------------------");
    }
}
