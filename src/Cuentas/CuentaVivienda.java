package Cuentas;

public class CuentaVivienda extends Cuenta {

    private float valorPendiente;
    public CuentaVivienda(String DNI, String numeroDeCuenta, float valorPendiente) {
        super(DNI, numeroDeCuenta);
        this.valorPendiente = valorPendiente;
    }

    public void realizarIngreso(float cantidad)
    {
        this.saldo+=cantidad;
    }

    public void realizarTransferencia(float cantidad, Cuenta destino)
    {
        this.saldo-=cantidad;
        destino.realizarIngreso(cantidad);
    }
    public void realizarTransferenciaComision(float cantidad, float comision, Cuenta destino)
    {
        this.realizarTransferencia(cantidad,destino); //No hay comision, se envia directamente al metodo de comision
    }

    public void cancelarImporteHipoteca(float pagado)
    {
        valorPendiente-=pagado;
    }
    public float verRestoHipoteca()
    {
        return valorPendiente;
    }
    @Override
    public float visualizarSaldo()
    {
        return saldo-valorPendiente;
    }
}
