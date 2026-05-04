public class Edificio {
    String nombre;
    double superficie;
    int cantDep;
    Departamento[] deps;
    Parqueo parqueo;

    public Edificio(String nombre, double superficie) {
        this.nombre = nombre;
        this.superficie = superficie;
        this.cantDep = 0;
        this.deps = new Departamento[100];
    }

    public void agregarDepartamento(Departamento d) {
        if (cantDep < 100) {
            deps[cantDep] = d;
            cantDep++;
        }
    }

    public void setParqueo(Parqueo p) {
        this.parqueo = p;
    }
}
