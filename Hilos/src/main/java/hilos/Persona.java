package hilos;

import java.util.Map;

public class Persona {

	private int dni;
	private String nombre;
	private Map<String,Integer> changuito;
	

	public Persona(String nom, int dni, Map<String,Integer> chan ) {
		this.nombre = nom;
		this.dni = dni;
		this.changuito = chan;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Map<String, Integer> getChanguito() {
		return changuito;
	}


	public void setChanguito(Map<String, Integer> changuito) {
		this.changuito = changuito;
	}
	
}

