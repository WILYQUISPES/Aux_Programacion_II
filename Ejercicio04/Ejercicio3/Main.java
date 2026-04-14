public class Main {

    public static boolean mismaCarrera(Estudiante e1, Estudiante e2) {
        return e1.getCarrera().equalsIgnoreCase(e2.getCarrera());
    }

    public static void main(String[] args) {

        Estudiante e1 = new Estudiante("Carlos Mamani", 12345678, 22, 1001, "Informatica");
        Estudiante e2 = new Estudiante("Ana Quispe",    87654321, 45, 1002, "Matematicas");
        Docente    d1 = new Docente("Mario Flores", 11111111, 45, 10, 8500.0);

        e1.mostrar();
        System.out.println();
        e2.mostrar();
        System.out.println();
        d1.mostrar();

        System.out.println("\n===== VERIFICACION DE EDAD CON EL DOCENTE =====");
        boolean hayCoincidencia = false;

        if (e1.getEdad() == d1.getEdad()) {
            System.out.println(e1.getNombre() + " tiene la misma edad que el docente "
                    + d1.getNombre() + " (" + d1.getEdad() + " anios).");
            hayCoincidencia = true;
        }
        if (e2.getEdad() == d1.getEdad()) {
            System.out.println(e2.getNombre() + " tiene la misma edad que el docente "
                    + d1.getNombre() + " (" + d1.getEdad() + " anios).");
            hayCoincidencia = true;
        }
        if (!hayCoincidencia) {
            System.out.println("Ningun estudiante tiene la misma edad que el docente.");
        }

        System.out.println("\n===== VERIFICACION DE CARRERA =====");
        if (mismaCarrera(e1, e2)) {
            System.out.println(e1.getNombre() + " y " + e2.getNombre()
                    + " estan en la misma carrera: " + e1.getCarrera());
        } else {
            System.out.println(e1.getNombre() + " estudia " + e1.getCarrera()
                    + " y " + e2.getNombre() + " estudia " + e2.getCarrera()
                    + ". Son carreras distintas.");
        }
    }
}
