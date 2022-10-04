import DatosPersonales.Contacto;
import DatosPersonales.Direccion;
import DatosPersonales.Persona;

import java.io.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws IOException {

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

        leerFicheros();
        //borrarFicheros();
    }

    /**
     * Borra los ficheros eliminandolos y creandolos de nuevo vacios
     * @throws IOException
     */
    private static void borrarFicheros() throws IOException {
        System.out.println("Borrando Ficheros");
        File text= new File("src\\DatosPersonales\\Ficheros\\BuzonProcesado.txt");
        System.out.println( text.delete());
        System.out.println(text.createNewFile());

        File binarioTexto= new File("src\\DatosPersonales\\Ficheros\\BuzonProcesadoBinarioTexto.dat");
        binarioTexto.delete();
        binarioTexto.createNewFile();

        File binarioDatos= new File("src\\DatosPersonales\\Ficheros\\BuzonProcesadoBinarioDatos.dat");
        binarioDatos.delete();
        binarioDatos.createNewFile();

    }

    /**
     * Lee los ficheros y los imprime por pantalla
     */
    private static void leerFicheros() throws IOException {
        System.out.println("-----------------------Leyendo el fichero de texto");
        try {
            BufferedReader br= new BufferedReader(new FileReader("src\\DatosPersonales\\Ficheros\\BuzonProcesado.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("----------------------Leyendo el fichero binario de texto");

        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("src\\DatosPersonales\\Ficheros\\BuzonProcesadoBinarioTexto.dat")));

            int ch;
            while((ch = bis.read()) != -1) {
                System.out.print((char)ch);
            }
            bis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("----------------------Leyendo el fichero binario de datos");

        int contador=1;
        DataInputStream dis=null;
        try {
            dis= new DataInputStream(new FileInputStream("src\\DatosPersonales\\Ficheros\\BuzonProcesadoBinarioDatos.dat"));

            while (true){
                String correo= dis.readUTF();//Hago una primera lectura aqui para que no se imprima otro "Correo N:" antes de que se compruebe que se haya terminado
                System.out.println("Correo "+(contador)+":");
                System.out.println("\tFrom: "+correo);
                System.out.println("\tAsunto: "+ dis.readUTF());
                System.out.println("\tCuerpo:\n\t\t"+dis.readUTF());
                contador++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException endException){
            System.out.println("Se acabo el fichero binario de datos");
            dis.close();
        }
    }
}