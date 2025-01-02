package com.jhsoft.SofBank.domains.Fabric.Interfaces;


import com.jhsoft.SofBank.domains.models.TipoCuenta;
import com.jhsoft.SofBank.domains.models.interfaces.ICuentaBancaria;

public interface ICtaBancariaFactory {
    ICuentaBancaria crearCuenta(String numeroCuenta, double saldo, double tasaInteres, TipoCuenta tipoCuenta);
}
