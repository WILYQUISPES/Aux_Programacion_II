public class Docente extends Persona {
    private int    antiguedad;
    private double sueldo;

    public Docente(String nombre, int carnet, int edad, int antiguedad, double sueldo) {
        super(nombre, carnet, edad);
        this.antiguedad = antiguedad;
        this.sueldo     = sueldo;
    }

    public int    getAntiguedad() { return antiguedad; }
    public double getSueldo()     { return sueldo;     }

    public void setAntiguedad(int antiguedad) { this.antiguedad = antiguedad; }
    public void setSueldo(double sueldo)      { this.sueldo     = sueldo;     }

    @Override
    public void mostrar() {
        System.out.println("=========== DOCENTE ============");
        System.out.println("Nombre     : " + nombre);
        System.out.println("Carnet     : " + carnet);
        System.out.println("Edad       : " + edad);
        System.out.println("Antiguedad : " + antiguedad + " años");
        System.out.println("Sueldo     : " + sueldo + " Bs.");
        System.out.println("================================");
    }
}
