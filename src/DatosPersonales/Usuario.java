package DatosPersonales;

import Abstract.Cuentas.Cuenta;

import java.util.ArrayList;

public class Usuario extends Persona{

    private float saldoTotal;
    private String mail;

    private ArrayList<Cuenta> listaCuentas;

    public Usuario(String DNI, String nombre, String apellido1, String apellido2, Direccion direccion, Contacto contacto, String mail) {
        super(DNI, nombre, apellido1, apellido2, direccion, contacto);
        listaCuentas= new ArrayList<Cuenta>();
        this.saldoTotal = calcularSaldo();
        this.mail = mail;
    }

    public float getSaldoTotal() {
        saldoTotal=calcularSaldo();
        return saldoTotal;
    }

    //public void setSaldoTotal(float saldoTotal) {this.saldoTotal = saldoTotal;}

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
     private float calcularSaldo()
     {
         int saldo=0;
         for(Cuenta cuenta: listaCuentas){
            saldo+=cuenta.visualizarSaldo();
         }
         return saldo;
     }


}
