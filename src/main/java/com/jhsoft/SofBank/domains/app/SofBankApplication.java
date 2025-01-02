package com.jhsoft.SofBank.domains.app;

import com.jhsoft.SofBank.Infraestructure.logging.TransactionLogger;
import com.jhsoft.SofBank.domains.Fabric.CtaAhorroFactory;
import com.jhsoft.SofBank.domains.Fabric.CtaCorrienteFactory;
import com.jhsoft.SofBank.domains.Fabric.Interfaces.ICtaBancariaFactory;
import com.jhsoft.SofBank.domains.models.TipoCuenta;
import com.jhsoft.SofBank.domains.models.interfaces.ICuentaBancaria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SofBankApplication {

	public static void main(String[] args) {

		SpringApplication.run(SofBankApplication.class, args);


		ICtaBancariaFactory ctaAhorroFactory = new CtaAhorroFactory(); //Factory
		ICtaBancariaFactory ctaCorrienteFactory = new CtaCorrienteFactory(); //Factory

		ICuentaBancaria cuentaAhorro = ctaAhorroFactory.crearCuenta("111111111", 1000, 0.087, TipoCuenta.AHORRO);

		cuentaAhorro.depositar(700.0);
		cuentaAhorro.retirar(200);
		cuentaAhorro.depositar(300);
		//cuentaAhorro.mostrarEstadoCuenta();

		ICuentaBancaria cuentaCorriente = ctaCorrienteFactory.crearCuenta("222222222", 500, 0.087, TipoCuenta.CORRIENTE);
		cuentaCorriente.retirar(200);
		cuentaCorriente.depositar(50);
		//cuentaCorriente.mostrarEstadoCuenta();

		System.out.println("\n-----------------------\nTransacciones registradas:\n");
		//TransactionLogger.getInstance().getTransacciones().forEach(System.out::println);
	}

}
