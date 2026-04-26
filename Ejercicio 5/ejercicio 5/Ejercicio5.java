class Animal {
    protected String nombre;
    protected int edad;
    protected String nombreDueño;

    public Animal(String nombre, int edad, String nombreDueño) {
        this.nombre = nombre;
        this.edad = edad;
        this.nombreDueño = nombreDueño;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getNombreDueño() { return nombreDueño; }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + "  Edad: " + edad + "  Dueño: " + nombreDueño);
    }
}

class Perro extends Animal {
    private boolean requiereBosal;
    private boolean ladraFuerte;

    public Perro(String nombre, int edad, String nombreDueño, boolean requiereBosal, boolean ladraFuerte) {
        super(nombre, edad, nombreDueño);
        this.requiereBosal = requiereBosal;
        this.ladraFuerte = ladraFuerte;
    }

    public boolean isRequiereBosal() { return requiereBosal; }
    public boolean isLadraFuerte() { return ladraFuerte; }

    public void mostrar() {
        super.mostrar();
        System.out.println("Requiere bosal: " + requiereBosal + "  Ladra fuerte: " + ladraFuerte);
    }
}

class Gato extends Animal {
    private boolean cazaRatones;
    private boolean tomaLeche;

    public Gato(String nombre, int edad, String nombreDueño, boolean cazaRatones, boolean tomaLeche) {
        super(nombre, edad, nombreDueño);
        this.cazaRatones = cazaRatones;
        this.tomaLeche = tomaLeche;
    }

    public boolean isCazaRatones() { return cazaRatones; }
    public boolean isTomaLeche() { return tomaLeche; }

    public void mostrar() {
        super.mostrar();
        System.out.println("Caza ratones: " + cazaRatones + "  Toma leche: " + tomaLeche);
    }
}

class CentroVeterinario {
    private String nombre;
    private int cantPerros;
    private Perro[] perros;
    private int cantGatos;
    private Gato[] gatos;

    public CentroVeterinario(String nombre) {
        this.nombre = nombre;
        cantPerros = 0;
        perros = new Perro[100];
        cantGatos = 0;
        gatos = new Gato[100];
    }

    public String getNombre() { return nombre; }

    public void agregarPerro(Perro p) {
        perros[cantPerros] = p;
        cantPerros++;
    }

    public void agregarGato(Gato g) {
        gatos[cantGatos] = g;
        cantGatos++;
    }

    public void mostrar() {
        System.out.println("Centro: " + nombre);
        System.out.println("Perros:");
        for (int i = 0; i < cantPerros; i++) {
            perros[i].mostrar();
            System.out.println();
        }
        System.out.println("Gatos:");
        for (int i = 0; i < cantGatos; i++) {
            gatos[i].mostrar();
            System.out.println();
        }
    }

    public void ordenarPerros() {
        for (int i = 0; i < cantPerros - 1; i++) {
            for (int j = 0; j < cantPerros - 1 - i; j++) {
                boolean cambiar = false;
                if (perros[j].getEdad() > perros[j + 1].getEdad()) {
                    cambiar = true;
                } else if (perros[j].getEdad() == perros[j + 1].getEdad()) {
                    int c = perros[j].getNombreDueño().compareTo(perros[j + 1].getNombreDueño());
                    if (c > 0) {
                        cambiar = true;
                    } else if (c == 0) {
                        if (perros[j].getNombre().compareTo(perros[j + 1].getNombre()) > 0) {
                            cambiar = true;
                        }
                    }
                }
                if (cambiar) {
                    Perro aux = perros[j];
                    perros[j] = perros[j + 1];
                    perros[j + 1] = aux;
                }
            }
        }
        System.out.println("Perros ordenados:");
        for (int i = 0; i < cantPerros; i++) {
            perros[i].mostrar();
            System.out.println();
        }
    }

    public void ordenarGatos() {
        for (int i = 0; i < cantGatos - 1; i++) {
            for (int j = 0; j < cantGatos - 1 - i; j++) {
                boolean cambiar = false;
                boolean lj = gatos[j].isTomaLeche();
                boolean lj1 = gatos[j + 1].isTomaLeche();

                if (!lj && lj1) {
                    cambiar = true;
                } else if (lj == lj1) {
                    if (gatos[j].getEdad() < gatos[j + 1].getEdad()) {
                        cambiar = true;
                    } else if (gatos[j].getEdad() == gatos[j + 1].getEdad()) {
                        if (gatos[j].getNombre().compareTo(gatos[j + 1].getNombre()) > 0) {
                            cambiar = true;
                        }
                    }
                }
                if (cambiar) {
                    Gato aux = gatos[j];
                    gatos[j] = gatos[j + 1];
                    gatos[j + 1] = aux;
                }
            }
        }
        System.out.println("Gatos ordenados:");
        for (int i = 0; i < cantGatos; i++) {
            gatos[i].mostrar();
            System.out.println();
        }
    }

    public void verificarMismoDueño() {
        int total = cantPerros + cantGatos;
        Animal[] todos = new Animal[total];
        for (int i = 0; i < cantPerros; i++) todos[i] = perros[i];
        for (int i = 0; i < cantGatos; i++) todos[cantPerros + i] = gatos[i];

        boolean[] visto = new boolean[total];
        boolean hay = false;

        for (int i = 0; i < total; i++) {
            if (visto[i]) continue;
            String dueño = todos[i].getNombreDueño();
            int cant = 0;
            for (int j = 0; j < total; j++) {
                if (todos[j].getNombreDueño().equalsIgnoreCase(dueño)) {
                    cant++;
                    visto[j] = true;
                }
            }
            if (cant > 1) {
                System.out.println("El dueño " + dueño + " tiene " + cant + " animales");
                hay = true;
            }
        }
        if (!hay) {
            System.out.println("No hay animales del mismo dueño");
        }
    }
}

public class Ejercicio5 {
    public static void main(String[] args) {
        CentroVeterinario cv1 = new CentroVeterinario("VetCentral");
        CentroVeterinario cv2 = new CentroVeterinario("VetNorte");

        cv1.agregarPerro(new Perro("Rex", 5, "Juan", true, true));
        cv1.agregarPerro(new Perro("Toby", 3, "Maria", false, false));
        cv1.agregarPerro(new Perro("Max", 5, "Juan", true, true));
        cv1.agregarPerro(new Perro("Rocky", 3, "Ana", false, true));

        cv1.agregarGato(new Gato("Michi", 4, "Juan", true, true));
        cv1.agregarGato(new Gato("Luna", 6, "Pedro", false, false));
        cv1.agregarGato(new Gato("Nala", 6, "Carla", true, true));
        cv1.agregarGato(new Gato("Simba", 2, "Maria", false, true));

        cv2.agregarPerro(new Perro("Bolt", 1, "Carlos", false, false));
        cv2.agregarPerro(new Perro("Coco", 4, "Rosa", true, false));

        cv2.agregarGato(new Gato("Felix", 3, "Carlos", false, true));
        cv2.agregarGato(new Gato("Kitty", 3, "Luis", true, false));

        System.out.println("--- Datos cv1 ---");
        cv1.mostrar();
        System.out.println("--- Datos cv2 ---");
        cv2.mostrar();

        System.out.println("--- Ordenar perros cv1 ---");
        cv1.ordenarPerros();

        System.out.println("--- Ordenar gatos cv1 ---");
        cv1.ordenarGatos();

        System.out.println("--- Mismo dueño cv1 ---");
        cv1.verificarMismoDueño();

        System.out.println("--- Mismo dueño cv2 ---");
        cv2.verificarMismoDueño();
    }
}
