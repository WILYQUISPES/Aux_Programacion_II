public class Videojuego {
    String nombre;
    String plataforma;
    int jugadores;

    public Videojuego() {
        this.nombre = "Desconocido";
        this.plataforma = "PC";
        this.jugadores = 0;
    }

    public Videojuego(String nom, String plat) {
        this.nombre = nom;
        this.plataforma = plat;
        this.jugadores = 0;
    }

    public Videojuego(String nom, String plat, int cant) {
        this.nombre = nom;
        this.plataforma = plat;
        this.jugadores = cant;
    }

    public void agregarJugadores() {
        this.jugadores++;
    }

    public void agregarJugadores(int masJugadores) {
        this.jugadores = this.jugadores + masJugadores;
    }
}