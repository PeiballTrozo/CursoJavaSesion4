package Cuentas;

public class CuentaAhorro extends Cuenta{

    private float comisionesCobradas;
    private final float COMISION_TRANSFERENCIA=0.01f;
    public CuentaAhorro(String DNI, String numeroDeCuenta) {
        super(DNI, numeroDeCuenta);
        this.comisionesCobradas = 0;
    }

    public void realizarIngreso(float cantidad) {
        this.saldo+=cantidad;
    }


    public void realizarTransferencia(float cantidad, Cuenta destino)
    {
        comisionesCobradas+=cantidad*COMISION_TRANSFERENCIA;
        this.realizarTransferenciaComision(cantidad,COMISION_TRANSFERENCIA,destino);
    }

    public void realizarTransferenciaComision(float cantidad, float comision, Cuenta destino) {
        if(comision <0&& comision>1){
            throw  new IllegalArgumentException("La comision debe ser un numero entre 0 y 1");
        }
        this.saldo-=cantidad+(cantidad*comision);
        destino.realizarIngreso(cantidad);
    }

    public float verComisionesCobradas()
    {
        return comisionesCobradas;
    }
}
