import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Videojuego juego1 = new Videojuego("Fifa", "PlayStation");
        Videojuego juego2 = new Videojuego("Halo", "Xbox", 2);

        juego1.agregarJugadores();

        System.out.println("Cuantos jugadores quieres agregar al juego 2?");
        int nuevos = entrada.nextInt();
        juego2.agregarJugadores(nuevos);

        String[] nombres = {"Luis", "Aracely"};
        int[] puntajes = {67, 89};
        Aula miClase = new Aula("Lab 1", 3, nombres, puntajes);

        System.out.println("DATOS DEL AULA");
        miClase.mostrarDatos();
        
        System.out.println("ESTADO DE ALUMNOS");
        miClase.mostrarDatos(true);
        entrada.close();
    }
}