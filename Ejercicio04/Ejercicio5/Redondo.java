public class Redondo extends Figura {
    private int radio;

    public Redondo(String color, int radio) {
        super(color);
        this.radio = radio;
    }

    public int  getRadio()          { return radio; }
    public void setRadio(int radio) { this.radio = radio; }

    @Override
    public double obtenerArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public void mostrar() {
        System.out.println("--------- REDONDO ----------");
        System.out.println("Color : " + color);
        System.out.println("Radio : " + radio);
        System.out.printf ("Area  : %.2f%n", obtenerArea());
        System.out.println("----------------------------");
    }
}
