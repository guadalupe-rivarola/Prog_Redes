package Archivos;

import java.io.PrintStream;

public class main {

	public static void main(String[] args) {
		//arhivo de texto plano: tiene solo texto (sin formato
		//volcado de memoria: escribir datos binario)
		PrintStream ps = new PrintStream(System.out);
		Ficheros archivo = new Ficheros("","Mario", ".txt");
		//Ficheros archivo = new Ficheros();
		//archivo.createFilePrintStream(archivo.getArchivo()); 
		archivo.createFilePrinter(archivo.getArchivo());
		//archivo.datosArchivo();
		//forma1
		ps.println( archivo.leerCharChar(archivo.getArchivo() ) );
		//forma
		ps.println(Utils.ANSI_YELLOW + archivo.leerConReader(archivo.getArchivo()) + Utils.ANSI_RESET);
		ps.println("Color normal");
		ps.println(Utils.ANSI_PURPLE + "\t\t colores mas lindos");
		ps.println(Utils.ANSI_MAGENTA + "\t\t lau" + Utils.ANSI_RESET);
	}

}
