package DatosPersonales.OperacionesCorreo;

import DatosPersonales.Mensaje;

import java.util.ArrayList;

public interface OperacionesEnvio {


    /**
     * Enviar el correo
     * @param to Correo del destinatario
     * @param copia Correos de los destinatarios de las copias. null si no se hara copias
     * @param asunto Asunto del correo
     * @param cuerpo Mensaje del correo
     */
    void enviarCorreo(String to,  ArrayList<String> copia, String asunto, String cuerpo);

    /**
     * Guarda el correo en la bandeja de enviados.
     * @param mensaje
     */
    void guardarCorreo(Mensaje mensaje);
}
