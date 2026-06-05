public class Empresa {
    String nombre;
    Empleado[] empleados;
    int cant;

    public Empresa(String nombre, int capacidad) {
        this.nombre = nombre;
        this.empleados = new Empleado[capacidad];
        this.cant = 0;
    }

    public void contratar(Empleado e) {
        if (cant < empleados.length) {
            empleados[cant] = e;
            cant++;
        }
    }

    public void listar() {
        System.out.println("\nPersonal registrado en la empresa " + nombre + ":");
        for (int i = 0; i < cant; i++) {
            System.out.print((i + 1) + ") ");
            empleados[i].mostrar();
        }
    }
}
