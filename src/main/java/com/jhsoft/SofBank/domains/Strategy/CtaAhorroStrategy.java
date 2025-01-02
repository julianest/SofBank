package com.jhsoft.SofBank.domains.Strategy;


import com.jhsoft.SofBank.domains.Strategy.Interfaces.ICalculoInteresStrategy;

public class CtaAhorroStrategy implements ICalculoInteresStrategy {

    @Override
    public double calcularInteres(double saldo, double tasaInteres) {
        return saldo * tasaInteres;
    }
}
