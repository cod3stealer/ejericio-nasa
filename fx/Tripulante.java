package fx;

public class Tripulante {
    //Atributos
    private String nombre;
    private String rol;
    private int nivel;

    //Constructor
    public Tripulante(){}
    public Tripulante(String nombre, String rol, int nivel) {
        this.nombre = nombre;
        this.rol = rol;
        this.nivel = nivel;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
