package Banco;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(System.currentTimeMillis());
		Banco nacion = new Banco(100 , 5000);
		
		for(int nroCuenta=0; nroCuenta<100 ;nroCuenta++) {
			int monto ]= rand.nextInt(500, 5000);
			Transferencias transfEnCurso = new Transferencias(nacion,nroCuenta,monto);
			transfEnCurso.setName("Cuenta-" + nroCuenta);
			
			transfEnCurso.start();
		}
		

	}

}
