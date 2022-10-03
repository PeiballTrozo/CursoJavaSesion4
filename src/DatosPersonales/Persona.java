package DatosPersonales;

import DatosPersonales.OperacionesCorreo.OperacionesEnvio;
import DatosPersonales.OperacionesCorreo.OperacionesRecepcion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class Persona implements OperacionesEnvio, OperacionesRecepcion {
    protected String DNI;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected Direccion direccion;
    protected Contacto contacto;

    protected Stack<Mensaje> bandejaRecibidos;
    protected Stack<Mensaje> bandejaEnviados;

    protected String correo;

    public Persona(String DNI, String nombre, String apellido1, String apellido2, Direccion direccion, Contacto contacto, String correo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.contacto = contacto;
        this.correo=correo;
        this.bandejaRecibidos = new Stack();
        this.bandejaEnviados = new Stack();
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Stack<Mensaje> getBandejaRecibidos() {return bandejaRecibidos;}

    public void setBandejaRecibidos(Stack<Mensaje> bandejaRecibidos) {this.bandejaRecibidos = bandejaRecibidos;}

    public Stack<Mensaje> getBandejaEnviados() {return bandejaEnviados;}

    public void setBandejaEnviados(Stack<Mensaje> bandejaEnviados) {this.bandejaEnviados = bandejaEnviados;}

    public String getCorreo() {return correo;}

    public void setCorreo(String correo) {this.correo = correo;}

    @Override
    public void enviarCorreo(String to, ArrayList<String> copia, String asunto, String cuerpo) {
        if(contacto.getListaCorreo().containsKey(to)){
            Persona destinatario=contacto.getListaCorreo().get(to);//Se busca el destinatario
            Mensaje mensaje=new Mensaje(this.correo,to,copia,new Date(),asunto,cuerpo);//Se forma el correo
            destinatario.recibirCorreo(mensaje);//Se envia el correo
            this.guardarCorreo(mensaje); //Se guarda el correo
            if(copia!=null){
                for (String mail: copia) {
                    if(contacto.getListaCorreo().containsKey(mail)){
                        contacto.getListaCorreo().get(mail).recibirCorreo(mensaje);//Se envia una copia a todas las personas indicadas
                    }
                }
            }
        }else{
            throw new IllegalArgumentException("No existe ese contacto");
        }
    }

    @Override
    public void guardarCorreo(Mensaje mensaje) {
        this.bandejaEnviados.push(mensaje);
    }

    @Override
    public void eliminarCorreo(Mensaje mensaje) {
        if(bandejaRecibidos.contains(mensaje)){
            bandejaRecibidos.remove(mensaje);
        } else if (bandejaEnviados.contains(mensaje)) {
            bandejaEnviados.remove(mensaje);
        }else{
            throw new IllegalArgumentException("No existe ese correo");
        }
    }

    @Override
    public void recibirCorreo(Mensaje mensaje) {
        this.bandejaRecibidos.push(mensaje);
        System.out.println("Asunto: "+mensaje.getAsunto()+"\n Cuerpo: "+mensaje.getCuerpo());
    }
}