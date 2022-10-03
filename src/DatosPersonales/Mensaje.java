package DatosPersonales;

import java.util.ArrayList;
import java.util.Date;

public class Mensaje {
    private String mailFrom;
    private String mailTo;
    private ArrayList<String> cc;
    private Date fechaEnvio;
    private String asunto;
    private String cuerpo;

    public Mensaje(String mailFrom, String mailTo, ArrayList<String> cc, Date fechaEnvio, String asunto, String cuerpo) {
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.cc = cc;
        this.fechaEnvio = fechaEnvio;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public ArrayList<String> getCc() {
        return cc;
    }

    public void setCc(ArrayList<String> cc) {
        this.cc = cc;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
