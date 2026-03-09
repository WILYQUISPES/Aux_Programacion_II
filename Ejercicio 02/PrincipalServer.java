class Jugador {
    String apodo;
    int diamantes;

    public Jugador(String nombre, int cantidad) {
        apodo = nombre;
        diamantes = cantidad;
    }
}

class ServidorMinecraft {
    Jugador[] lista;
    int totalJugadores;

    public ServidorMinecraft() {
        lista = new Jugador[10];
        totalJugadores = 0;
    }

    public void agregarJugador(String nombre, int gemas) {
        if (totalJugadores < 10) {
            lista[totalJugadores] = new Jugador(nombre, gemas);
            totalJugadores++;
        } else {
            System.out.println("Ya no hay espacio en el server.");
        }
    }

    public void verificarStacks() {
        for (int i = 0; i < totalJugadores; i++) {
            int stacks = lista[i].diamantes / 64;
            System.out.println(lista[i].apodo + " tiene " + stacks + " stacks.");
        }
    }

    public void jugadorMasRico() {
        if (totalJugadores == 0) return;
        
        Jugador millonario = lista[0];
        for (int i = 1; i < totalJugadores; i++) {
            if (lista[i].diamantes > millonario.diamantes) {
                millonario = lista[i];
            }
        }
        System.out.println("El jugador con mas diamantes es: " + millonario.apodo);
    }

    public void totalDiamantesServer() {
        int suma = 0;
        for (int i = 0; i < totalJugadores; i++) {
            suma += lista[i].diamantes;
        }
        System.out.println("En todo el server hay " + suma + " diamantes.");
    }
}

public class PrincipalServer {
    public static void main(String[] args) {
        ServidorMinecraft server = new ServidorMinecraft();
        
        server.agregarJugador("Alex", 130);
        server.agregarJugador("Steve", 65);
        server.agregarJugador("Gamer123", 200);
        
        server.verificarStacks();
        server.jugadorMasRico();
        server.totalDiamantesServer();
    }
}