import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ejercicio 2: Sistema de Gestion de Inventario de Productos
 *
 * Programa con menu interactivo que permite:
 *  1. Agregar producto (nombre, precio, stock)
 *  2. Listar todos los productos
 *  3. Buscar producto por nombre
 *  4. Modificar el stock de un producto
 *  5. Eliminar un producto
 *  6. Mostrar el valor total del inventario
 *  7. Salir
 *
 * Usa Programacion Orientada a Objetos (clase Producto)
 * y una ArrayList para almacenar dinamicamente los productos.
 */
public class Ejercicio2 {

    // ArrayList para guardar los productos. Es dinamica (crece sola).
    static ArrayList<Producto> inventario = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        // Bucle principal del menu, sigue hasta que el usuario elija salir (7)
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Limpia el salto de linea pendiente

            // Segun la opcion, llamamos al metodo correspondiente
            switch (opcion) {
                case 1: agregarProducto(); break;
                case 2: listarProductos(); break;
                case 3: buscarProducto(); break;
                case 4: modificarStock(); break;
                case 5: eliminarProducto(); break;
                case 6: mostrarValorTotal(); break;
                case 7: System.out.println("Saliendo... Hasta luego!"); break;
                default: System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        } while (opcion != 7);

        sc.close();
    }

    /** Muestra el menu principal en pantalla. */
    static void mostrarMenu() {
        System.out.println("\n===== INVENTARIO DE PRODUCTOS =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Modificar stock");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Mostrar valor total del inventario");
        System.out.println("7. Salir");
        System.out.print("Elige una opcion: ");
    }

    /** Pide los datos y agrega un nuevo producto al inventario. */
    static void agregarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        System.out.print("Stock inicial: ");
        int stock = sc.nextInt();
        sc.nextLine();

        // Validamos que precio y stock no sean negativos
        if (precio < 0 || stock < 0) {
            System.out.println("Error: precio y stock no pueden ser negativos.");
            return;
        }

        // Creamos un nuevo objeto Producto y lo agregamos a la lista
        inventario.add(new Producto(nombre, precio, stock));
        System.out.println("Producto agregado correctamente.");
    }

    /** Lista todos los productos del inventario. */
    static void listarProductos() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacio.");
            return;
        }

        System.out.println("\n--- Lista de productos ---");
        // Recorremos la lista con un for-each
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + ". " + inventario.get(i));
        }
    }

    /** Busca un producto por nombre (ignora mayusculas/minusculas). */
    static void buscarProducto() {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();

        int indice = buscarIndicePorNombre(nombre);
        if (indice == -1) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println("Encontrado: " + inventario.get(indice));
        }
    }

    /** Permite cambiar el stock de un producto existente. */
    static void modificarStock() {
        System.out.print("Nombre del producto a modificar: ");
        String nombre = sc.nextLine();

        int indice = buscarIndicePorNombre(nombre);
        if (indice == -1) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Nuevo stock: ");
        int nuevoStock = sc.nextInt();
        sc.nextLine();

        if (nuevoStock < 0) {
            System.out.println("El stock no puede ser negativo.");
            return;
        }

        // Modificamos el atributo stock del producto encontrado
        inventario.get(indice).setStock(nuevoStock);
        System.out.println("Stock actualizado correctamente.");
    }

    /** Elimina un producto del inventario por su nombre. */
    static void eliminarProducto() {
        System.out.print("Nombre del producto a eliminar: ");
        String nombre = sc.nextLine();

        int indice = buscarIndicePorNombre(nombre);
        if (indice == -1) {
            System.out.println("Producto no encontrado.");
            return;
        }

        inventario.remove(indice);
        System.out.println("Producto eliminado correctamente.");
    }

    /** Calcula y muestra el valor total del inventario (precio * stock). */
    static void mostrarValorTotal() {
        double total = 0;
        // Sumamos precio*stock de cada producto
        for (Producto p : inventario) {
            total += p.getPrecio() * p.getStock();
        }
        System.out.printf("Valor total del inventario: $%.2f%n", total);
    }

    /**
     * Metodo auxiliar: busca un producto por nombre.
     * Retorna el indice si lo encuentra, -1 si no existe.
     */
    static int buscarIndicePorNombre(String nombre) {
        for (int i = 0; i < inventario.size(); i++) {
            // equalsIgnoreCase ignora mayusculas/minusculas
            if (inventario.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Clase Producto: representa un articulo del inventario.
 * Tiene atributos privados (encapsulamiento) con getters y setters.
 */
class Producto {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor: inicializa los atributos al crear el objeto
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters: permiten leer los atributos privados desde fuera
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    // Setter: permite modificar el stock
    public void setStock(int stock) { this.stock = stock; }

    /**
     * toString() devuelve la representacion del producto como String.
     * Java la usa automaticamente cuando hacemos System.out.println(producto).
     */
    @Override
    public String toString() {
        return String.format("%-20s | Precio: $%-8.2f | Stock: %d", nombre, precio, stock);
    }
}
