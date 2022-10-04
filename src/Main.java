import DatosPersonales.Contacto;
import DatosPersonales.Direccion;
import DatosPersonales.Persona;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Persona p1= new Persona("DNI1","nombre1", "ap1","ap2",new Direccion(),new Contacto(),"correodeP1@gmail.com");
        Persona p2= new Persona("DNI2","nombre2", "ap3","ap4",new Direccion(),new Contacto(),"CORREODEP2@gmail.com");

        p1.addContactoCorreo("CORREODEP2@gmail.com",p2);
        p2.addContactoCorreo("correodeP1@gmail.com",p1);

        p1.enviarCorreo("CORREODEP2@gmail.com",null,"Asunto1", "El cuerpo del 1er mensaje" );
        p1.enviarCorreo("CORREODEP2@gmail.com",null,"Asunto2", "El cuerpo del 2º mensaje" );
        p1.enviarCorreo("CORREODEP2@gmail.com",null,"Asunto3", "El cuerpo del 3er mensaje" );
        p1.enviarCorreo("CORREODEP2@gmail.com",null,"Asunto4", "El cuerpo del 4º mensaje" );
        p1.enviarCorreo("CORREODEP2@gmail.com",null,"Asunto5", "El cuerpo del 5º mensaje" );
        p1.enviarCorreo("CORREODEP2@gmail.com",null,"Asunto6", "El cuerpo del 6º mensaje" );

        p2.procesarBuzonRecibidosTexto();
        p2.procesarBuzonRecibidosBinarioTexto();
        p2.procesarBuzonRecibidosBinarioDatos();

        //leerFicheros();
        //borrarFicheros();
    }

    private static void borrarFicheros() throws IOException {
        System.out.println("Borrando Ficheros");

    }

    private static void leerFicheros() {
        System.out.println("Leyendo el fichero de texto");
        try {
            BufferedReader br= new BufferedReader(new FileReader("src\\DatosPersonales\\Ficheros\\BuzonProcesado.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}