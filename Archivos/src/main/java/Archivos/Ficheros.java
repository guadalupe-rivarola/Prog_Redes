package Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ficheros {
	
	//objeto que represente un archivo del sistema operativo
	
	private File archivo;
	private PrintStream ps;
	public Ficheros(){
		String ruta = ""; // "c:\\User\\"
		String nombre = "mario";
		String extension =".txt";
		
		try {
		System.setErr(new PrintStream (
						new FileOutputStream(
								new File("Errores.log")),true));
		} catch (IOException e) {
			
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING,null,e);
		}
		archivo = new File(ruta.concat(nombre.concat(extension))); 
	}
	
	public File getArchivo() {
		return this.archivo;
	}
	
	public void createFilePrintStream(File a) {
		//salida archivo
		//entrada consola
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(archivo);
			ps = new PrintStream(fos, true); //modo de sobreescritura append true no sobreescribe
			ps.println("Hola lauuuta");
			ps.flush();
			
		} catch (FileNotFoundException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING,null,e);
		}finally {
			if(fos != null)
			try {
				fos.close();
				
			} catch (IOException e) {
				Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING,null,e);
			}		
		}
	}

	public void createFilePrinter(File a) {
		
		FileWriter fw = null;
		PrintWriter pw = null; //escribe en archivos
	
		try {
			
			if( !a.exists() ) {
				a.createNewFile();
			}
			
			fw = new FileWriter(a , true);
			pw = new PrintWriter(fw);
			
			pw.println("Todo bien?");
			
		}catch(FileNotFoundException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING,null,e);
			
		} catch (IOException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING,null,e);
			
		}finally {
			
			try {
				if(pw != null)
					pw.close();
				
				if(fw != null)
					fw.close();
				
			} catch (IOException e) {
				Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING,null,e);
			}
		}
		
	}

	public void createFileBuffe(File a) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(a,true);
			bw = new BufferedWriter(fw);
			
			bw.write("Hellooo");
			bw.newLine();
			bw.write("Byeee");
			
			bw.flush();
			
		} catch (IOException e) {
			Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING,null,e);
		}finally {
			try {
				
				if(fw != null)
				fw.close();
				
				if(bw != null)
				bw.close();
				
			} catch (IOException e) {
				
				Logger.getLogger(Ficheros.class.getName()).log(Level.WARNING,null,e);
			}
			
		}
	}
}	