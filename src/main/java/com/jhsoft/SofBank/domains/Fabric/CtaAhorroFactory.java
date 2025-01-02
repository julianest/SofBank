package com.jhsoft.SofBank.domains.Fabric;


import com.jhsoft.SofBank.domains.Fabric.Interfaces.ICtaBancariaFactory;
import com.jhsoft.SofBank.domains.models.CuentaAhorro;
import com.jhsoft.SofBank.domains.models.CuentaBancaria;
import com.jhsoft.SofBank.domains.models.TipoCuenta;

public class CtaAhorroFactory extends CtaBancariaFactory implements ICtaBancariaFactory {

    @Override
    public CuentaBancaria crearCuenta(String numeroCuenta, double saldo, double tasaInteres, TipoCuenta tipoCuenta) {
        if(tipoCuenta != TipoCuenta.AHORRO){
            throw new IllegalArgumentException("El tipo de cuenta no coincide con esta fábrica.");
        }
        return new CuentaAhorro(numeroCuenta, saldo,tasaInteres);
    }
}
