public class Habitacion {
    String nombre;
    double tamanio;
    int cantMuebles;
    Mueble[] muebles;

    public Habitacion(String nombre, double tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.cantMuebles = 0;
        this.muebles = new Mueble[100];
    }

    public void agregarMueble(Mueble m) {
        if (cantMuebles < 100) {
            muebles[cantMuebles] = m;
            cantMuebles++;
        }
    }
}
