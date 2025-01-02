package com.jhsoft.SofBank.domains.Fabric;


import com.jhsoft.SofBank.domains.Fabric.Interfaces.ICtaBancariaFactory;
import com.jhsoft.SofBank.domains.models.CuentaBancaria;
import com.jhsoft.SofBank.domains.models.CuentaCorriente;
import com.jhsoft.SofBank.domains.models.TipoCuenta;

public class CtaCorrienteFactory extends CtaBancariaFactory implements ICtaBancariaFactory {

    @Override
    public CuentaBancaria crearCuenta(String numeroCuenta, double saldo, double tasaInteres, TipoCuenta tipoCuenta) {
        if(tipoCuenta != TipoCuenta.CORRIENTE){
            throw new IllegalArgumentException("El tipo de cuenta no coincide con esta fábrica.");
        }
        return new CuentaCorriente(numeroCuenta, saldo, tasaInteres);
    }
}
