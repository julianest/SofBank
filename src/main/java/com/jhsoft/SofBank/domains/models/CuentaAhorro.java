package com.jhsoft.SofBank.domains.models;


import com.jhsoft.SofBank.domains.Strategy.CtaAhorroStrategy;
import com.jhsoft.SofBank.domains.Strategy.Interfaces.ICalculoInteresStrategy;

public class CuentaAhorro extends CuentaBancaria {

    private double tasaInteres;
    private ICalculoInteresStrategy estrategiaCalculoInteres;

    public CuentaAhorro(String numeroCuenta, double saldo,  double tasaInteres){
        super(numeroCuenta, saldo, TipoCuenta.AHORRO);
        this.tasaInteres= tasaInteres;
        this.estrategiaCalculoInteres = new CtaAhorroStrategy();
    }

    @Override
    public void depositar(double monto) {
        super.depositar(monto);
        aplicarTasaInteres();
    }

    public void aplicarTasaInteres(){
        double interes = estrategiaCalculoInteres.calcularInteres(getSaldo(),tasaInteres); //getSaldo() * tasaInteres;
        setInteresAcumulado(getInteresAcumulado() + interes) ;
        setSaldo(getSaldo()+interes);
        //System.out.println(" Intereses Aplicados: $"+ interes);
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        if (tasaInteres < 0) {
            throw new IllegalArgumentException("La tasa de interés no puede ser negativa.");
        }
        this.tasaInteres = tasaInteres;
    }

    //Herencia: Por medio de main.java.com.SofBank.bank.domains.models.CuentaAhorro heredamos las caracteristicas y comportamientos de una clase padre main.java.com.SofBank.bank.domains.models.CuentaBancaria.
    //Polimorfismo: La sobreescritura del método depositar en main.java.com.SofBank.bank.domains.models.CuentaAhorro modifica el comportamiento heredado de main.java.com.SofBank.bank.domains.models.CuentaBancaria al agregar la aplicación de una tasa de interés.
}
