public class Main {

    static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Mueble silla   = new Mueble("Silla",   "Madera");
        Mueble mesa    = new Mueble("Mesa",    "Metal");
        Mueble sofa    = new Mueble("Sofa",    "Tela");
        Mueble cama    = new Mueble("Cama",    "Madera");
        Mueble armario = new Mueble("Armario", "MDF");

        Habitacion h101a = new Habitacion("Sala 101", 20.0);
        h101a.agregarMueble(silla); h101a.agregarMueble(mesa); h101a.agregarMueble(sofa);

        Habitacion h101b = new Habitacion("Dormitorio 101", 15.0);
        h101b.agregarMueble(cama);

        Habitacion h101c = new Habitacion("Cocina 101", 10.0);
        h101c.agregarMueble(mesa); h101c.agregarMueble(silla);

        Departamento d101 = new Departamento(101, 1);
        d101.agregarHabitacion(h101a);
        d101.agregarHabitacion(h101b);
        d101.agregarHabitacion(h101c);

        Habitacion h102a = new Habitacion("Sala 102", 22.0);
        h102a.agregarMueble(sofa); h102a.agregarMueble(mesa);

        Habitacion h102b = new Habitacion("Dormitorio 102", 16.0);
        h102b.agregarMueble(cama); h102b.agregarMueble(armario);

        Habitacion h102c = new Habitacion("Estudio 102", 12.0);
        h102c.agregarMueble(mesa); h102c.agregarMueble(silla); h102c.agregarMueble(armario);

        Habitacion h102d = new Habitacion("Bano 102", 8.0);

        Departamento d102 = new Departamento(102, 1);
        d102.agregarHabitacion(h102a);
        d102.agregarHabitacion(h102b);
        d102.agregarHabitacion(h102c);
        d102.agregarHabitacion(h102d);

        Habitacion h201a = new Habitacion("Sala 201", 18.0);
        h201a.agregarMueble(sofa); h201a.agregarMueble(mesa); h201a.agregarMueble(silla);

        Habitacion h201b = new Habitacion("Terraza 201", 30.0);

        Departamento d201 = new Departamento(201, 2);
        d201.agregarHabitacion(h201a);
        d201.agregarHabitacion(h201b);

        Habitacion h202a = new Habitacion("Sala 202", 25.0);
        h202a.agregarMueble(sofa); h202a.agregarMueble(mesa);

        Departamento d202 = new Departamento(202, 2);
        d202.agregarHabitacion(h202a);
        d202.agregarHabitacion(new Habitacion("Cuarto A 202", 12.0));
        d202.agregarHabitacion(new Habitacion("Cuarto B 202", 10.0));
        d202.agregarHabitacion(new Habitacion("Cuarto C 202",  9.0));
        d202.agregarHabitacion(new Habitacion("Cuarto D 202", 11.0));
        d202.agregarHabitacion(new Habitacion("Cuarto E 202", 13.0));

        Departamento d301 = new Departamento(301, 3);
        d301.agregarHabitacion(new Habitacion("Sala 301",    20.0));
        d301.agregarHabitacion(new Habitacion("Cuarto 301",  15.0));
        d301.agregarHabitacion(new Habitacion("Cocina 301",  10.0));
        d301.agregarHabitacion(new Habitacion("Bano 301",     8.0));
        d301.agregarHabitacion(new Habitacion("Estudio 301", 12.0));

        Habitacion h302a = new Habitacion("Sala 302", 22.0);
        h302a.agregarMueble(sofa); h302a.agregarMueble(mesa); h302a.agregarMueble(silla);

        Habitacion h302b = new Habitacion("Cuarto 302", 16.0);
        h302b.agregarMueble(cama); h302b.agregarMueble(armario);
        h302b.agregarMueble(silla); h302b.agregarMueble(mesa);

        Habitacion h302c = new Habitacion("Cocina 302", 11.0);
        h302c.agregarMueble(mesa);

        Departamento d302 = new Departamento(302, 3);
        d302.agregarHabitacion(h302a);
        d302.agregarHabitacion(h302b);
        d302.agregarHabitacion(h302c);

        Edificio edificio = new Edificio("Torre Central", 1500.0);
        Parqueo parqueo = new Parqueo(3, 5.0);
        edificio.setParqueo(parqueo);

        edificio.agregarDepartamento(d101);
        edificio.agregarDepartamento(d102);
        edificio.agregarDepartamento(d201);
        edificio.agregarDepartamento(d202);
        edificio.agregarDepartamento(d301);
        edificio.agregarDepartamento(d302);

        System.out.println("=== a) Edificio creado: " + edificio.nombre + " ===");
        System.out.println("    Superficie: " + edificio.superficie + " m2");
        System.out.println("    Departamentos: " + edificio.cantDep);
        System.out.println("    Parqueo capacidad: " + edificio.parqueo.capacidad + " autos");
        System.out.println();

        int pisoY = 2;
        System.out.println("=== b) Depto con mas habitaciones en piso " + pisoY + " ===");
        int maxHab = -1;
        for (int i = 0; i < edificio.cantDep; i++) {
            if (edificio.deps[i].nroPiso == pisoY && edificio.deps[i].nroHab > maxHab) {
                maxHab = edificio.deps[i].nroHab;
            }
        }
        for (int i = 0; i < edificio.cantDep; i++) {
            if (edificio.deps[i].nroPiso == pisoY && edificio.deps[i].nroHab == maxHab) {
                System.out.println("    Puerta: " + edificio.deps[i].nroPuerta
                        + "  Piso: " + edificio.deps[i].nroPiso
                        + "  Habitaciones: " + edificio.deps[i].nroHab);
            }
        }
        System.out.println();

        int pisoX  = 1;
        int puertaZ = 102;
        System.out.println("=== c) Agregando mueble al depto " + puertaZ + " del piso " + pisoX + " ===");
        Mueble lampara = new Mueble("Lampara", "Vidrio");
        boolean encontrado = false;
        for (int i = 0; i < edificio.cantDep; i++) {
            if (edificio.deps[i].nroPiso == pisoX && edificio.deps[i].nroPuerta == puertaZ) {
                edificio.deps[i].agregarMueble(lampara, 0);
                System.out.println("    Mueble '" + lampara.tipo + "' agregado a la 1ra habitacion del depto " + puertaZ);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("    No se encontro el departamento.");
        }
        System.out.println();

        System.out.println("=== d) Depto(s) con mas muebles en total ===");
        int maxMuebles = -1;
        for (int i = 0; i < edificio.cantDep; i++) {
            int total = edificio.deps[i].totalMuebles();
            if (total > maxMuebles) {
                maxMuebles = total;
            }
        }
        for (int i = 0; i < edificio.cantDep; i++) {
            if (edificio.deps[i].totalMuebles() == maxMuebles) {
                System.out.println("    Puerta: " + edificio.deps[i].nroPuerta
                        + "  Piso: " + edificio.deps[i].nroPiso
                        + "  Total muebles: " + maxMuebles);
            }
        }
        System.out.println();

        int pisoZ = 3;
        System.out.println("=== e) Habitacion con mas muebles en piso " + pisoZ + " ===");
        int maxMueblesHab = -1;
        String nombreHabMax = "Ninguna";
        for (int i = 0; i < edificio.cantDep; i++) {
            if (edificio.deps[i].nroPiso == pisoZ) {
                for (int j = 0; j < edificio.deps[i].nroHab; j++) {
                    if (edificio.deps[i].hab[j].cantMuebles > maxMueblesHab) {
                        maxMueblesHab = edificio.deps[i].hab[j].cantMuebles;
                        nombreHabMax  = edificio.deps[i].hab[j].nombre;
                    }
                }
            }
        }
        System.out.println("    Habitacion: " + nombreHabMax + "  Muebles: " + maxMueblesHab);
        System.out.println();

        System.out.println("=== f) Eliminando deptos con cant prima de habitaciones ===");
        int idx = 0;
        while (idx < edificio.cantDep) {
            if (esPrimo(edificio.deps[idx].nroHab)) {
                System.out.println("    Eliminando depto puerta " + edificio.deps[idx].nroPuerta
                        + "  (hab=" + edificio.deps[idx].nroHab + " es primo)");
                for (int j = idx; j < edificio.cantDep - 1; j++) {
                    edificio.deps[j] = edificio.deps[j + 1];
                }
                edificio.deps[edificio.cantDep - 1] = null;
                edificio.cantDep--;
            } else {
                idx++;
            }
        }
        System.out.println("    Deptos restantes: " + edificio.cantDep);
        for (int k = 0; k < edificio.cantDep; k++) {
            System.out.println("    -> Puerta " + edificio.deps[k].nroPuerta
                    + "  Piso " + edificio.deps[k].nroPiso
                    + "  (" + edificio.deps[k].nroHab + " hab)");
        }
        System.out.println();

        System.out.println("=== g) Agregando autos al parqueo (capacidad: " + edificio.parqueo.capacidad + ") ===");
        edificio.parqueo.agregarAuto("1234-ABC");
        edificio.parqueo.agregarAuto("5678-DEF");
        edificio.parqueo.agregarAuto("9012-GHI");
        edificio.parqueo.agregarAuto("3456-JKL");
    }
}
