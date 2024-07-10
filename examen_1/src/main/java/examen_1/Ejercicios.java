package examen_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicios {

	static File archivo = new File("datos.dat");
	static File copia = new File("tuti_fruti.csv");
	
	static PrintStream ps = new PrintStream(System.out);
	
	static void Modificar() {
		    
			FileReader Fr = null;
			BufferedReader Br = null;
			FileWriter Fw = null;
			PrintWriter Pw = null;
			
			try {
				
			  Fr = new FileReader(archivo);
			  Br = new BufferedReader(Fr);
			  
			  if(!copia.exists()) {
				  Fw = new FileWriter(copia);
				  Pw = new PrintWriter(Fw);
				  String aux;
				  while((aux=Br.readLine()) != null){		
					  String datos = aux.substring(1, 2).toUpperCase() + aux.replace(".", ";");
						Pw.println(datos);
						Pw.flush();
				  }	
				  Pw.close();
				  Fw.close();
			  }
			  Br.close();
			  Fr.close();	  
			  if(archivo.exists())
				  archivo.delete();
			}catch(FileNotFoundException ex){
				Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,ex);
				
			}catch(IOException ex){
				Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,ex);	
		}
			}
			
	    static void menu() {
	    	ps.print("aca va el menu");
	    }
		static void confirmarArchivo() {
			if(!archivo.exists()) {
				 menu();
			}else if(archivo.exists()) {
				Modificar();
			}
		}
		
	}
		
	

