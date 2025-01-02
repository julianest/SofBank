package com.jhsoft.SofBank.Infraestructure.logging;

import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private static TransactionLogger instance;
    private final List<String> transacciones;

    private TransactionLogger() {
        transacciones = new ArrayList<>();
    }

    public static synchronized TransactionLogger getInstance(){
        if(instance == null){
            instance = new TransactionLogger();
        }
        return instance;
    }

    public void log(String transaccion){
        transacciones.add(transaccion);
        //System.out.println("Transacción registrada: "+ transaccion);
    }

    public List<String> getTransacciones(){
        return new ArrayList<>(transacciones);
    }
}
