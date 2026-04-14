public class Estudiante extends Persona {
    private int    matricula;
    private String carrera;

    public Estudiante(String nombre, int carnet, int edad, int matricula, String carrera) {
        super(nombre, carnet, edad);
        this.matricula = matricula;
        this.carrera   = carrera;
    }

    public int    getMatricula() { return matricula; }
    public String getCarrera()   { return carrera;   }

    public void setMatricula(int matricula)  { this.matricula = matricula; }
    public void setCarrera(String carrera)   { this.carrera   = carrera;   }

    @Override
    public void mostrar() {
        System.out.println("========== ESTUDIANTE ==========");
        System.out.println("Nombre    : " + nombre);
        System.out.println("Carnet    : " + carnet);
        System.out.println("Edad      : " + edad);
        System.out.println("Matricula : " + matricula);
        System.out.println("Carrera   : " + carrera);
        System.out.println("================================");
    }
}
