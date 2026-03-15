public class Aula {
    String nombreAula;
    int piso;
    String[] alumnos;
    int[] notas;

    public Aula(String nom, int p, String[] chicos, int[] calif) {
        this.nombreAula = nom;
        this.piso = p;
        this.alumnos = chicos;
        this.notas = calif;
    }

    public void mostrarDatos() {
        System.out.println("Aula: " + this.nombreAula);
        System.out.println("Piso: " + this.piso);
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println(alumnos[i] + " - " + notas[i]);
        }
    }

    public void mostrarDatos(boolean verEstado) {
        if (verEstado) {
            for (int i = 0; i < alumnos.length; i++) {
                String estado = "REPROBADO";
                if (notas[i] >= 51) {
                    estado = "APROBADO";
                }
                System.out.println(alumnos[i] + " - " + estado);
            }
        }
    }
}