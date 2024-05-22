package Archivos;

public class main {

	public static void main(String[] args) {
		//arhivo de texto plano: tiene solo texto (sin formato
		//volcado de memoria: escribir datos binario)
		Ficheros archivo = new Ficheros();
		archivo.createFilePrintStream(archivo.getArchivo()); 
		archivo.createFilePrinter(archivo.getArchivo());
	}

}
