import java.util.Scanner;

public class Main {

    static boolean tieneNumero(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    static String pedirCargo(Scanner sc) {
        String cargo = "";
        boolean valido = false;
        while (!valido) {
            System.out.print("Cargo: ");
            cargo = sc.nextLine();
            try {
                if (tieneNumero(cargo)) {
                    throw new CargoInvalidoException("El cargo no puede contener numeros, ingrese solo letras.");
                }
                valido = true;
            } catch (CargoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return cargo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE RECURSOS HUMANOS ===");
        System.out.print("Nombre de la empresa: ");
        String nombreEmpresa = sc.nextLine();

        System.out.print("Cuantos empleados desea registrar? ");
        int n = sc.nextInt();
        sc.nextLine();

        Empresa empresa = new Empresa(nombreEmpresa, n);

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Empleado " + (i + 1) + " ---");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            String cargo = pedirCargo(sc);

            Empleado emp = new Empleado(nombre, cargo);

            System.out.print("Sueldo (Bs): ");
            double sueldo = sc.nextDouble();
            sc.nextLine();

            try {
                emp.asignarSueldo(sueldo);
            } catch (SueldoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
                emp.sueldo = 2500;
                System.out.println("Se ajusto automaticamente el sueldo a 2500 Bs.");
            }

            empresa.contratar(emp);
        }

        empresa.listar();

        sc.close();
    }
}
