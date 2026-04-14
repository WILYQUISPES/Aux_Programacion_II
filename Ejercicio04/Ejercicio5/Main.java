public class Main {

    public static void main(String[] args) {

        Cuadrado  c1 = new Cuadrado ("Rojo",     5);
        Cuadrado  c2 = new Cuadrado ("Azul",     8);
        Triangulo t1 = new Triangulo("Verde",    3, 4,  5);
        Triangulo t2 = new Triangulo("Amarillo", 6, 8, 10);
        Redondo   r1 = new Redondo  ("Morado",   4);
        Redondo   r2 = new Redondo  ("Naranja",  7);

        System.out.println("========== CUADRADOS ==========");
        c1.mostrar();
        c2.mostrar();

        System.out.println("\n========== TRIANGULOS ==========");
        t1.mostrar();
        t2.mostrar();

        System.out.println("\n========== REDONDOS ==========");
        r1.mostrar();
        r2.mostrar();

        System.out.println("\n===== COMPARACION CUADRADO vs TRIANGULO =====");
        Cuadrado  compC = new Cuadrado ("Cyan",    6);
        Triangulo compT = new Triangulo("Magenta", 5, 12, 13);

        System.out.printf("Cuadrado  [%s] -> Area: %.2f%n", compC.getColor(), compC.obtenerArea());
        System.out.printf("Triangulo [%s] -> Area: %.2f%n", compT.getColor(), compT.obtenerArea());

        if (compC.obtenerArea() > compT.obtenerArea()) {
            System.out.println("La figura con mayor area es el CUADRADO de color: " + compC.getColor());
        } else if (compT.obtenerArea() > compC.obtenerArea()) {
            System.out.println("La figura con mayor area es el TRIANGULO de color: " + compT.getColor());
        } else {
            System.out.println("Ambas figuras tienen exactamente la misma area.");
        }
    }
}
