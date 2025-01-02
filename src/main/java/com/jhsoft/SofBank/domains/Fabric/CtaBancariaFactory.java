package com.jhsoft.SofBank.domains.Fabric;


import com.jhsoft.SofBank.domains.models.CuentaBancaria;
import com.jhsoft.SofBank.domains.models.TipoCuenta;

public abstract class CtaBancariaFactory {
    public abstract CuentaBancaria crearCuenta(String numeroCuenta, double saldo, double tasaInteres, TipoCuenta tipoCuenta);
}
