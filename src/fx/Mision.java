package fx;

import java.util.ArrayList;

public class Mision {
    //Atributos
    private String nombre;
    private boolean nigger;
    private String fecha;
    private String obj;
    private Nave nave;
    private ArrayList<Tripulante> tripulantes;

    //Constructor por defecto y parametrizado
    public Mision(){}
    public Mision(String nombre, String fecha, String obj, Nave nave, ArrayList<Tripulante> tripulantes) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.obj = obj;
        this.nave = nave;
        this.tripulantes = tripulantes;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getObj() {
        return obj;
    }
    public void setObj(String obj) {
        this.obj = obj;
    }
    public Nave getNave() {
        return nave;
    }
    public void setNave(Nave nave) {
        this.nave = nave;
    }
    public ArrayList<Tripulante> getTripulantes() {
        return tripulantes;
    }
    public void setTripulantes(ArrayList<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }
}
