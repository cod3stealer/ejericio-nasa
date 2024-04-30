package fx;

public class crearTripulacion {
    public static Tripulante crearTripulacion (String nombre, int nivel, String rol) {
        Tripulante t = new Tripulante();
        t.setNombre(nombre);
        t.setNivel(nivel);
        t.setRol(rol);
        return t;
    }
}
