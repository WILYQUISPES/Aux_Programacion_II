public class Parqueo {
    int capacidad;
    int cantAuto;
    String[] placas;
    double precioH;

    public Parqueo(int capacidad, double precioH) {
        this.capacidad = capacidad;
        this.cantAuto = 0;
        this.placas = new String[100];
        this.precioH = precioH;
    }

    public void agregarAuto(String placa) {
        if (cantAuto < capacidad) {
            placas[cantAuto] = placa;
            cantAuto++;
            System.out.println("Auto agregado. Placa: " + placa);
        } else {
            System.out.println("No hay capacidad en el parqueo. No se pudo agregar: " + placa);
        }
    }
}
