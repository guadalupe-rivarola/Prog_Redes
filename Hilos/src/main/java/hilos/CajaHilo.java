package hilos;

import java.util.ArrayList;

public class CajaHilo extends Thread{
	
	private int numCaja;
	private String nombreCajero;
	private long tiempoInicial;
	private ArrayList<Persona> filaCleintes;
	
	public CajaHilo(int nro, String nom, long ti, ArrayList<Persona> listaClientes) {
		this.numCaja =nro;
		this.nombreCajero = nom;
		this.tiempoInicial = ti;
		this.filaCleintes = listaClientes;
	}
	
	///////////////////////////////
	
	@Override
	public void run() {
		
	}
	
	///////////////////////////////

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
		return filaCleintes;
	}

	public void setFilaCleintes(ArrayList<Persona> filaCleintes) {
		this.filaCleintes = filaCleintes;
	}
	
	
}
