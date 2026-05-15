import java.util.Scanner;

/**
 * Ejercicio 1: Sistema de Gestion de Notas de Estudiantes
 *
 * El programa pide la cantidad de estudiantes, luego para cada uno
 * registra su nombre y 3 notas (parcial 1, parcial 2, final).
 * Calcula el promedio de cada estudiante, define si aprueba o reprueba,
 * y al final muestra estadisticas del curso: mejor promedio, peor promedio,
 * promedio general, y cantidad de aprobados y reprobados.
 */
public class Ejercicio1 {

    // Nota minima para aprobar (constante)
    static final double NOTA_APROBACION = 6.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== SISTEMA DE GESTION DE NOTAS ===\n");

        // Pedimos cuantos estudiantes vamos a registrar
        System.out.print("Cuantos estudiantes deseas registrar? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // Limpia el buffer despues de leer un numero

        // Validamos que la cantidad sea positiva
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0. Cerrando programa.");
            sc.close();
            return;
        }

        // Arrays paralelos: misma posicion = mismo estudiante
        String[] nombres = new String[cantidad];
        double[] promedios = new double[cantidad];

        // Recorremos para registrar cada estudiante
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Estudiante " + (i + 1) + " ---");

            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();

            // Llamamos a un metodo auxiliar para leer y validar cada nota
            double parcial1 = leerNota(sc, "Nota parcial 1 (0-10): ");
            double parcial2 = leerNota(sc, "Nota a parcial 2 (0-10): ");
            double notaFinal = leerNota(sc, "Nota final (0-10): ");

            // Calculamos el promedio simple de las 3 notas
            promedios[i] = (parcial1 + parcial2 + notaFinal) / 3.0;

            System.out.printf("Promedio de %s: %.2f%n", nombres[i], promedios[i]);
        }

        // Una vez registrados todos, mostramos las estadisticas
        mostrarEstadisticas(nombres, promedios);

        sc.close();
    }

    /**
     * Lee una nota desde la consola y valida que este entre 0 y 10.
     * Si no es valida, vuelve a pedirla.
     */
    static double leerNota(Scanner sc, String mensaje) {
        double nota;
        while (true) {
            System.out.print(mensaje);
            nota = sc.nextDouble();
            // Validacion: la nota debe estar entre 0 y 10
            if (nota >= 0 && nota <= 10) {
                sc.nextLine(); // Limpia buffer
                return nota;
            }
            System.out.println("Nota invalida. Debe ser entre 0 y 10.");
        }
    }

    /**
     * Calcula y muestra las estadisticas del curso completo.
     */
    static void mostrarEstadisticas(String[] nombres, double[] promedios) {
        double suma = 0;
        double mejor = promedios[0];
        double peor = promedios[0];
        int posMejor = 0;
        int posPeor = 0;
        int aprobados = 0;
        int reprobados = 0;

        // Recorremos todos los promedios para calcular las estadisticas
        for (int i = 0; i < promedios.length; i++) {
            suma += promedios[i];

            // Buscamos el mejor promedio
            if (promedios[i] > mejor) {
                mejor = promedios[i];
                posMejor = i;
            }
            // Buscamos el peor promedio
            if (promedios[i] < peor) {
                peor = promedios[i];
                posPeor = i;
            }
            // Contamos aprobados y reprobados
            if (promedios[i] >= NOTA_APROBACION) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        double promedioGeneral = suma / promedios.length;

        // Imprimimos el reporte final
        System.out.println("\n========= REPORTE FINAL =========");
        System.out.println("Total de estudiantes: " + promedios.length);
        System.out.printf("Promedio general del curso: %.2f%n", promedioGeneral);
        System.out.printf("Mejor promedio: %s con %.2f%n", nombres[posMejor], mejor);
        System.out.printf("Peor promedio: %s con %.2f%n", nombres[posPeor], peor);
        System.out.println("Aprobados: " + aprobados);
        System.out.println("Reprobados: " + reprobados);

        // Lista detallada de cada estudiante
        System.out.println("\n--- Detalle por estudiante ---");
        for (int i = 0; i < nombres.length; i++) {
            String estado = (promedios[i] >= NOTA_APROBACION) ? "APROBADO" : "REPROBADO";
            System.out.printf("%-20s %.2f  [%s]%n", nombres[i], promedios[i], estado);
        }
    }
}
