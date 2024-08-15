package Banco;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	private Map<Integer,Integer> cuentas;
	private PrintStream ps = new PrintStream(System.out);
	private Lock cierreDeBanco = new ReentrantLock(); //permite bloquear 
	private Condition saldoSuficiente; //se necesita una condicion para bloquear
	
	public Banco( int cantCuentas, int montoInicial) {
		cuentas = new HashMap<>();
		saldoSuficiente = cierreDeBanco.newCondition(); //vinculando un bloqueador con una condicion.
		
		
		for(int nro=0; nro<cantCuentas;nro++) {
			cuentas.put(nro, montoInicial);
		}//for
		
	}//constructor

	public void transferir(int cuentaOrigen, int cuentaDestino, int monto) {
		// TODO Auto-generated method stub
		
		
	}//transferir

}
