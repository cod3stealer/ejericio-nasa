package fx;

public class crearNave {
    public static Nave crearNave(String nombre, String tipo, Tripulante tripulante) {
        Nave nave = new Nave();
        nave.setNombre(nombre);
        nave.setTipo(tipo);
        nave.setTripulantes(tripulante);
        return nave;
    }
}
