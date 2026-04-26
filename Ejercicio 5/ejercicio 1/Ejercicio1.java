class Libro {
    private String nombre;
    private String autor;
    private int año;

    public Libro(String nombre, String autor, int año) {
        this.nombre = nombre;
        this.autor = autor;
        this.año = año;
    }

    public String getNombre() { return nombre; }
    public String getAutor() { return autor; }
    public int getAño() { return año; }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + año);
    }
}

class Biblioteca {
    private String nombre;
    private int cantLibros;
    private Libro[] libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        cantLibros = 0;
        libros = new Libro[100];
    }

    public void agregarLibro(Libro l) {
        libros[cantLibros] = l;
        cantLibros++;
    }

    public void buscarLibro(String nom) {
        boolean encontrado = false;
        for (int i = 0; i < cantLibros; i++) {
            if (libros[i].getNombre().equalsIgnoreCase(nom)) {
                System.out.println("Libro encontrado:");
                libros[i].mostrar();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El libro no esta en la biblioteca");
        }
    }

    public int getCantLibros() { return cantLibros; }
    public String getNombre() { return nombre; }

    public void mostrar() {
        System.out.println("Biblioteca: " + nombre);
        System.out.println("Cantidad libros: " + cantLibros);
        for (int i = 0; i < cantLibros; i++) {
            System.out.println("Libro " + (i + 1) + ":");
            libros[i].mostrar();
        }
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca("Biblioteca 1");
        Biblioteca b2 = new Biblioteca("Biblioteca 2");

        b1.agregarLibro(new Libro("El Aleph", "Borges", 1949));
        b1.agregarLibro(new Libro("Cien anos de soledad", "Garcia Marquez", 1967));
        b1.agregarLibro(new Libro("Don Quijote", "Cervantes", 1605));

        b2.agregarLibro(new Libro("1984", "Orwell", 1949));
        b2.agregarLibro(new Libro("Harry Potter", "Rowling", 1997));

        System.out.println("--- Datos b1 ---");
        b1.mostrar();
        System.out.println("--- Datos b2 ---");
        b2.mostrar();

        System.out.println("--- Buscar El Aleph en b1 ---");
        b1.buscarLibro("El Aleph");

        System.out.println("--- Buscar Harry Potter en b1 ---");
        b1.buscarLibro("Harry Potter");

        System.out.println("--- Biblioteca con mas libros ---");
        if (b1.getCantLibros() > b2.getCantLibros()) {
            System.out.println(b1.getNombre() + " con " + b1.getCantLibros() + " libros");
        } else if (b2.getCantLibros() > b1.getCantLibros()) {
            System.out.println(b2.getNombre() + " con " + b2.getCantLibros() + " libros");
        } else {
            System.out.println("Empate, ambas tienen " + b1.getCantLibros() + " libros");
            System.out.println(b1.getNombre());
            System.out.println(b2.getNombre());
        }
    }
}
