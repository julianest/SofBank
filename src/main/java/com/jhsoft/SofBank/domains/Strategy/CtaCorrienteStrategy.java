package com.jhsoft.SofBank.domains.Strategy;

import com.jhsoft.SofBank.domains.Strategy.Interfaces.ICalculoInteresStrategy;

public class CtaCorrienteStrategy implements ICalculoInteresStrategy {

    @Override
    public double calcularInteres(double saldo, double tasaInteres) {
        if(saldo<=499){
            return saldo * tasaInteres * 0.05; //Se genera penalidad por saldo Bajo.
        }
        return saldo * tasaInteres;
    }
}
