public class Departamento {
    int nroPuerta;
    int nroHab;
    Habitacion[] hab;
    int nroPiso;

    public Departamento(int nroPuerta, int nroPiso) {
        this.nroPuerta = nroPuerta;
        this.nroPiso = nroPiso;
        this.nroHab = 0;
        this.hab = new Habitacion[100];
    }

    public void agregarHabitacion(Habitacion h) {
        if (nroHab < 100) {
            hab[nroHab] = h;
            nroHab++;
        }
    }

    public void agregarMueble(Mueble m, int indiceHab) {
        if (indiceHab >= 0 && indiceHab < nroHab) {
            hab[indiceHab].agregarMueble(m);
        }
    }

    public int totalMuebles() {
        int total = 0;
        for (int i = 0; i < nroHab; i++) {
            total += hab[i].cantMuebles;
        }
        return total;
    }
}
