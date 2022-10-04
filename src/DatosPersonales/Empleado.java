package DatosPersonales;

public class Empleado extends Persona{

    private String usuario;
    private String password;

    public Empleado(String DNI, String nombre, String apellido1, String apellido2, Direccion direccion, Contacto contacto, String usuario, String password, String correo) {
        super(DNI, nombre, apellido1, apellido2, direccion, contacto, correo);
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
