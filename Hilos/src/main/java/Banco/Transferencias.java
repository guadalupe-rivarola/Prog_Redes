package Banco;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transferencias extends Thread{
	private Banco banco;
	private int cuentaOrigen;
	private int monto;
	Random rand;
	private boolean vivo = true;
	
	public Transferencias(Banco banco, int cuentaOrigen, int monto) {
		this.banco = banco;
		this.cuentaOrigen = cuentaOrigen;
		this.monto = monto;
		
		rand = new Random(System.currentTimeMillis());
	}//constructor
	
	@Override
	public void run() {
		try {
			while(vivo) {
				int cuentaDestino =  rand.nextInt(100);
				while(cuentaDestino == cuentaOrigen) {
					cuentaDestino = rand.nextInt(100);
				}//while
			
				banco.transferir(cuentaOrigen, cuentaDestino, this.monto);
				Thread.sleep(rand.nextInt(100));
				this.matar();
			}
		}catch(InterruptedException ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,null,ex);
		}//catch
		
	}//run
	
	
	public void matar() {
		this.vivo = false;
	}
	
}//class
