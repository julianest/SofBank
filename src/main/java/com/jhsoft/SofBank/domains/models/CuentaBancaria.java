package com.jhsoft.SofBank.domains.models;


import com.jhsoft.SofBank.Infraestructure.logging.TransactionLogger;
import com.jhsoft.SofBank.domains.models.interfaces.ICuentaBancaria;


public class CuentaBancaria implements ICuentaBancaria {

    private String numeroCuenta;
    private double saldo;
    private double interesAcumulado = 0.0;
    private TipoCuenta tipo;

    public CuentaBancaria(String numeroCuenta, double saldoInicial, TipoCuenta tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
        this.tipo = tipoCuenta;


    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            TransactionLogger.getInstance().log("- Depósito de $" + monto + " en la cuenta "+ numeroCuenta);
            //System.out.println(" Depósito exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println(" El monto a depositar debe ser positivo.");
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }
    public double obtenerSaldoSinInteres() {
        return saldo - interesAcumulado;
    }
    public double obtenerInteresAcumulado() {return interesAcumulado;}

    @Override
    public double retirar(double monto){
        if(monto <= this.saldo){
            this.saldo -= monto;
            TransactionLogger.getInstance().log("- Retiro   de $" + monto + " en la cuenta "+ numeroCuenta);
            //System.out.println("Retiro exitoso: $" + monto +" Saldo actual: $" + saldo);
            return monto;
        }else {
            System.out.println("Imposible retirar. el monto supera el saldo en cuenta: $" + saldo );
            return 0.0;
        }
    }

    @Override
    public void mostrarEstadoCuenta(){
        String mensaje =
                String.format(
                        "|----------------------------------|\n" +
                        " - Cuenta:              N° %s\n" +
                        " - Tipo:                %s\n" +
                        " - Saldo Sin intereses: $%.2f\n" +
                        " - Interés Acumulado:   $%.2f\n" +
                        " - Total total:         $%.2f\n" +
                        "|----------------------------------| ",
                        numeroCuenta, tipo.name(), obtenerSaldoSinInteres(), obtenerInteresAcumulado(), obtenerSaldo());
        System.out.println(mensaje);
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getInteresAcumulado() {
        return interesAcumulado;
    }
    public void setInteresAcumulado(double interesAcumulado) {
        this.interesAcumulado = interesAcumulado;
    }
    public TipoCuenta getTipo() {return tipo;}
}
