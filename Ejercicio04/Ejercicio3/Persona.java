public class Persona {
    protected String nombre;
    protected int carnet;
    protected int edad;

    public Persona(String nombre, int carnet, int edad) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public int getCarnet()    { return carnet;  }
    public int getEdad()      { return edad;    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCarnet(int carnet)    { this.carnet = carnet; }
    public void setEdad(int edad)        { this.edad = edad;     }

    public void mostrar() {
        System.out.println("Nombre : " + nombre);
        System.out.println("Carnet : " + carnet);
        System.out.println("Edad   : " + edad);
    }
}
