package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class main {
	static PrintStream ps = new PrintStream(System.out);
	
	
	public static void main(String[] args) {

		Ejercicios ejercicio = new Ejercicios();
		String ruta = "";
		String nombre = "Inventario";
		String extension = ".dat";
		File archivo = new File(ruta.concat(nombre).concat(extension));
		ejercicio.crearArchivo(ruta,nombre,extension);
		//ejercicio.escribirArchivo(archivo);
		ejercicio.leerArchivo(archivo);
	}
}