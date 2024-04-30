package fx;

public class Nave {
    //Atributos
    private String nombre;
    private String tipo;
    private Tripulante tripulantes;

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Tripulante getTripulantes() {
        return tripulantes;
    }
    public void setTripulantes(Tripulante tripulantes) {
        this.tripulantes = tripulantes;
    }
}
