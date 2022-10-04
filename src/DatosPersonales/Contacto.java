package DatosPersonales;

import java.util.ArrayList;
import java.util.HashMap;

public class Contacto {
    private HashMap<String,Persona> listaCorreo; //Lista de correos, asociado a una Persona.
    private ArrayList<Integer> listaTelefonoFijos;
    private ArrayList<Integer> listaTelefonoMovil;

    public Contacto()
    {
        this.listaCorreo=new HashMap();
        this.listaTelefonoFijos=new ArrayList();
        this.listaTelefonoMovil=new ArrayList();
    }

    public Contacto(HashMap<String,Persona> listaCorreo, ArrayList<Integer> listaTelefonoFijos, ArrayList<Integer> listaTelefonoMovil) {
        this.listaCorreo = listaCorreo;
        this.listaTelefonoFijos = listaTelefonoFijos;
        this.listaTelefonoMovil = listaTelefonoMovil;
    }

    public HashMap<String,Persona> getListaCorreo() {
        return listaCorreo;
    }

    public void setListaCorreo(HashMap<String,Persona> listaCorreo) {
        this.listaCorreo = listaCorreo;
    }

    public ArrayList<Integer> getListaTelefonoFijos() {
        return listaTelefonoFijos;
    }

    public void setListaTelefonoFijos(ArrayList<Integer> listaTelefonoFijos) {
        this.listaTelefonoFijos = listaTelefonoFijos;
    }

    public ArrayList<Integer> getListaTelefonoMovil() {
        return listaTelefonoMovil;
    }

    public void setListaTelefonoMovil(ArrayList<Integer> listaTelefonoMovil) {
        this.listaTelefonoMovil = listaTelefonoMovil;
    }
}
