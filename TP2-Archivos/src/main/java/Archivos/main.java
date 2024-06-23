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
		boolean continuar = true;
		
		while(continuar) {
			ps.println("\n Menú: ");
			ps.println("1. Agregar producto.");
			ps.println("2. Mostrar productos");
			ps.println("3. Salir");
			String texto = Ejercicios.leerDatos();
			int opcion = Integer.parseInt(texto);
			switch(opcion) {
			case 1:
				ejercicio.escribirArchivo(archivo);
				break;
			case 2:
				ejercicio.leerArchivo(archivo);
				break;
			case 3:
				continuar = false;
				break;
			default:
				ps.print("Opción no válida. Por favor, intente nuevamente");
			}
		}
	}
}