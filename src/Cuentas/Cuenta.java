package Cuentas;

public abstract class Cuenta {
    protected String DNI;
    protected String numeroDeCuenta;
    protected float saldo;

    public Cuenta(String DNI, String numeroDeCuenta) {
        this.DNI = DNI;
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldo = 0;
    }

    public float visualizarSaldo()
    {
        return saldo;
    }
    public abstract void realizarIngreso(float cantidad);
    public abstract void realizarTransferencia(float cantidad, Cuenta destino);
    public abstract void realizarTransferenciaComision(float cantidad, float comision, Cuenta destino);


}
