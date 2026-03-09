class Bus {
    int capacidad;
    int pasajeros;
    double dinero;

    public Bus(int limite) {
        capacidad = limite;
        pasajeros = 0;
        dinero = 0.0;
    }

    public void subirPasajeros(int nuevos) {
        if (pasajeros + nuevos <= capacidad) {
            pasajeros += nuevos;
            System.out.println("Subieron " + nuevos + " pasajeros.");
        } else {
            System.out.println("El bus esta lleno, no entran todos.");
        }
    }

    public void cobrarPasaje() {
        dinero = pasajeros * 1.50;
        System.out.println("Se cobro un total de: bs. " + dinero);
    }

    public void asientosDisponibles() {
        int libres = capacidad - pasajeros;
        System.out.println("Quedan " + libres + " asientos disponibles.");
    }
}

public class PrincipalBus {
    public static void main(String[] args) {
        Bus miPuma = new Bus(40);
        
        miPuma.subirPasajeros(15);
        miPuma.cobrarPasaje();
        miPuma.asientosDisponibles();
        
        miPuma.subirPasajeros(5);
        miPuma.asientosDisponibles();
    }
}