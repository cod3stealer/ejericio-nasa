package fx;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/*
* Esta clase almacena los metodos que luego serán usados por los botones de la interfaz gráfica
*  */
public class gestorMision {
    //Atributos
    private ArrayList<Nave> naves = new ArrayList<>();
    private ArrayList<Tripulante> tripulantes = new ArrayList<>();
    private ArrayList<Mision> misiones = new ArrayList<>();
    private String nombre;

    //Constructor sin parametros que inicializa los arrays con ejemplos
    public gestorMision() {
        /*
        Tripulante t1 = new Tripulante("Santi", "Limpia pasillos", 2);
        naves.add(crearNave.crearNave("SantiNave", "Floffy", t1));
        tripulantes.add(crearTripulacion.crearTripulacion("Santi", 5, "Nose"));
        */

    }

    //Metodos
    public void crearMision(String nombre, String fecha, String obj, Nave nave, ArrayList<Tripulante> tripulantes) {
        try {
            this.nombre = nombre;
            BufferedWriter w = new BufferedWriter(new FileWriter(nombre+".txt"));
            w.write("Nombre de misión: "+nombre+"\nFecha de lanzamiento: "+fecha+"\n" +
                    "Objetivos: "+obj+"\n");
            w.close();
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }

    public String[] getMision(){
        String[] misionesGuardadasEnTxt = new String[0];
        if (nombre != null) {
            try {
                BufferedReader r = new BufferedReader(new FileReader(nombre + ".txt"));
                String linea;
                while ((linea = r.readLine()) != null) {
                    if (linea.startsWith("Nombre de la mision: ")) {
                        misionesGuardadasEnTxt = new String[]{linea.substring("Nombre de la mision: ".length())};
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null,"crea una misión","error",JOptionPane.ERROR_MESSAGE);
        }
        return misionesGuardadasEnTxt;
    }

    public String getMisionRegistrada(){
        return nombre;
    }

    public Nave getNave(String nombre) {
        for (Nave nave : naves) {
            if (nave.getNombre().equals(nombre)) {
                return nave;
            }
        }
        return null;
    }
    public String[] getNombreNaves() {
        String[] nNaves = new String[naves.size()];
        for (int i = 0; i < naves.size(); i++) {
            nNaves[i] = naves.get(i).getNombre();
        }
        return nNaves;
    }

    public void asignNaveMision(String nMision, Nave nave) {
        for (Mision mision : misiones) {
            if (mision.getNombre().equals(nMision)) {
                mision.setNave(nave);
                break;
            }
        }
    }
    public String[] getNombresTripulantes() {
        String[] nombresTripulantes = new String[tripulantes.size()];
        for (int i = 0; i < tripulantes.size(); i++) {
            nombresTripulantes[i] = tripulantes.get(i).getNombre();
        }
        return nombresTripulantes;
    }
    public Tripulante getTripulantePorNombre(String nTripulante) {
        for (Tripulante tripulante : tripulantes) {
            if (tripulante.getNombre().equals(nTripulante)) {
                return tripulante;
            }
        }
        return null;
    }
    public void asignTripAMision(String nombreMision, Tripulante tripulante) {
        for (Mision mision : misiones) {
            if (mision.getNombre().equals(nombreMision)) {
                mision.getTripulantes().add(tripulante);
                break;
            }
        }
    }
}
