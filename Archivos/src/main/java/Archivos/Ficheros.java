package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ficheros {
	
	//objeto que represente un archivo del sistema operativo
	
	private File archivo;
	private PrintStream ps;
	public Ficheros(){
		String ruta = ""; // "c:\\User\\"
		String nombre = "mario";
		String extension =".txt";
		archivo = new File(ruta.concat(nombre.concat(extension))); 
	}
	
	public void createFilePrintStream(File a) {
		//salida archivo
		//entrada consola
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(archivo);
			ps = new PrintStream(fos,true); //modo de sobreescritura append true no sobreescribe
			ps.println("Hola lauta");
			ps.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
