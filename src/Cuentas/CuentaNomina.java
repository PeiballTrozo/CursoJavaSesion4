package Cuentas;

public class CuentaNomina extends Cuenta {

    private final float COMISION_TRANSFERENCIA=0.05f;
    private final float INTERES_INGRESO=1.01f;
    public CuentaNomina(String DNI, String numeroDeCuenta) {
        super(DNI, numeroDeCuenta);
    }

    public void realizarIngreso(float cantidad)
    {
        if(cantidad>1500){
            saldo+=cantidad*INTERES_INGRESO;
        }else{
            saldo+=cantidad;
        }
    }

    public void realizarTransferencia(float cantidad, Cuenta destino)
    {
        this.realizarTransferenciaComision(cantidad,COMISION_TRANSFERENCIA,destino);
    }


    public void realizarTransferenciaComision(float cantidad, float comision, Cuenta destino) {
        if(comision <0&& comision>1){
            throw  new IllegalArgumentException("La comision debe ser un numero entre 0 y 1");
        }
        this.saldo-=cantidad+(cantidad*comision);
        destino.realizarIngreso(cantidad);
    }
}
