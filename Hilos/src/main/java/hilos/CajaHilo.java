package hilos;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;

public class CajaHilo extends Thread{
	
	private int numCaja;
	private String nombreCajero;
	private long tiempoInicial;
	private ArrayList<Persona> filaClientes;
	private boolean matar = false;
	
	public CajaHilo(int nro, String nom, long ti, ArrayList<Persona> listaClientes) {
		this.numCaja =nro;
		this.nombreCajero = nom;
		this.tiempoInicial = ti;
		this.filaClientes = listaClientes;
	}
	
	///////////////////////////////
	//tarea a ejecutar por el hilo
	@Override
	public void run() { 
		while(!matar) {
		for(Persona p : filaClientes) {
			ps.print(this.getNombreCajero());
			procesarCompra(p.getChanguito());
			p.getChanguito().remove(p.getChanguito());
		}
		this.matarHilo();
		}
	}
	
	///////////////////////////////
	
	PrintStream ps = new PrintStream(System.out);
	
	public void procesarCompra(Map<String, Integer> changuito) {
		//ps.printf("Cleinte: %s - (%d) \n", p.getNombre(), p.getDni());
		for(Map.Entry<String, Integer> c: changuito.entrySet()) {
			ps.printf("Caja No. %d - (%s)\n", this.getNumCaja(), this.getNombreCajero());

			ps.printf("\t Producto: %s  ---- Cant: %d --  \n", c.getKey());
			cobrarProducto(c.getValue());
		}
	}
	public void matarHilo() {
		this.matar = true;
	}
	public void cobrarProducto(int cant) {
		try {
			Thread.sleep(cant * 300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int getNumCaja() {
		return numCaja;
	}

	public void setNumCaja(int numCaja) {
		this.numCaja = numCaja;
	}

	public String getNombreCajero() {
		return nombreCajero;
	}

	public void setNombreCajero(String nombreCajero) {
		this.nombreCajero = nombreCajero;
	}

	public long getTiempoInicial() {
		return tiempoInicial;
	}

	public void setTiempoInicial(long tiempoInicial) {
		this.tiempoInicial = tiempoInicial;
	}

	public ArrayList<Persona> getFilaCleintes() {
		return filaClientes;
	}

	public void setFilaCleintes(ArrayList<Persona> filaCleintes) {
		this.filaClientes = filaCleintes;
	}
	
	
}
