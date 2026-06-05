public class Empleado {
    String nombre;
    String cargo;
    double sueldo;

    public Empleado(String nombre, String cargo) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.sueldo = 0;
    }

    public void asignarSueldo(double s) throws SueldoInvalidoException {
        if (s < 2500) {
            throw new SueldoInvalidoException("El sueldo ingresado (" + s + " Bs) es menor al salario minimo nacional de 2500 Bs.");
        }
        this.sueldo = s;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + " | Cargo: " + cargo + " | Sueldo: " + sueldo + " Bs");
    }
}
