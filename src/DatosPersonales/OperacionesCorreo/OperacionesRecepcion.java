package DatosPersonales.OperacionesCorreo;

import DatosPersonales.Mensaje;

public interface OperacionesRecepcion {

    void eliminarCorreo(Mensaje men);
    void recibirCorreo(Mensaje men);

    void  procesarBuzonRecibidosTexto();
    void  procesarBuzonRecibidosBinarioTexto();
    void  procesarBuzonRecibidosBinarioDatos();
}
