package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
	public Ficheros(String rut, String name, String ext){
		String ruta = rut;//""; // "c:\\User\\"
		String nombre = name;//"mario"; // = name "LoL"
		String extension = ext; //".txt"; // = ext ".exe"
		
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
	
	//funcionalidades del archivo
	public void datosArchivo() {
		try {
			ps = new PrintStream(System.out);
			ps.println("Name: "+ archivo.getName());   //nombre del archivo
			ps.println("Path: " + archivo.getPath());
			ps.println("PathAbs" + archivo.getAbsolutePath());
			ps.println("PathCannon: " + archivo.getCanonicalPath());
			ps.println("Contenedor del archivo" + archivo.getParentFile()); //donde esta ese archivo
			ps.println("Parent: " + archivo.getParent());
			ps.println("Tamaño: " + archivo.getTotalSpace());
			ps.println("Ejecutable?" + archivo.canExecute());
			ps.println("Acceso de lectura: " + archivo.canRead());
			ps.println("Acceso de escritura: " + archivo.canWrite());
			ps.println("Esta oxulto?" + archivo.isHidden());
			//"Borra" + archivo.delete();
			//"Elimina, cuando se cierra el programa: " + archivo.deleteOnExit();
			ps.println("Existe?" + archivo.exists());
			ps.println("Es un archivo?: " + archivo.isFile());
			ps.println("Es una carpeta?:" + archivo.isDirectory());
			//"Crea archivo" + archivo.createNewFile();
			//"Crea archivo" + archivo.mkdir();
			//"Renombrar" + archivo.renameTo("NuevoNombre.txt");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//formas de crear archivo
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

	//forma de leer los archivos 
	public String leerCharChar(File a) {

		FileReader fr = null;
		String texto = "";
		try {
			fr = new FileReader(a);
			int letra;
			
			while ( (letra =  fr.read()) != -1 ) {
				texto += (char)letra;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return texto;
	}

	public String leerConReader(File a) {
		FileReader fr = null;
		BufferedReader br = null;
		String texto="";
		
		try {
			 fr = new FileReader(a);
			 br = new BufferedReader(fr);
			 
			 String linea = "";
			 
			 while((linea = br.readLine()) != null) {
				 texto += linea.concat("\n");
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return texto;
	}
}	