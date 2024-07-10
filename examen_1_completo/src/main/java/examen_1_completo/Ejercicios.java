package examen_1_completo;

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
		       boolean continuar = true;
		while (continuar) {
		ps.println("Ingrese la opción a ejecutar:");
		ps.println("1- Agregar");
		ps.println("2- Mostrar");
		ps.println("3- Eliminar");
		ps.println("0- Salir");
		int opcion = leerOpcion();
		switch (opcion) {
		case 1:
		ps.println("1-Agregar datos al archivo");
		break;

		case 2:
		ps.println("2-Mostrar archivo");
		mostrar();
		break;

		case 3:
		ps.println("3-Eliminar datos del archivo");
		//eliminarDatos();
		break;

		case 0:
		ps.println("SALISTE");
		continuar = false;
		break;

		default:
		ps.println("Opción inválida. Por favor, ingrese una opción válida.");
		break;
		}
		}

		}

		static int leerOpcion() {
		       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		       int opcion = 0;
		       boolean entradaValida = false;
		       while (!entradaValida) {
		           ps.println("Ingrese la opción:");
		           try {
		            String input = reader.readLine();
		               opcion = Integer.parseInt(input);
		               if (opcion >= 0) {
		                   entradaValida = true;
		               } else {
		                   ps.println("Error: Por favor, ingrese un número entero positivo.");
		               }
		           } catch (NumberFormatException | IOException e) {
		               ps.println("Error: Por favor, ingrese un número entero válido.");
		           }
		       }
		       return opcion;
		}

			static void confirmarArchivo() {
				if(!archivo.exists()) {
					menu();
				}else if(archivo.exists()) {
					Modificar();
				}
			}

			public static void mostrar() {
				FileReader fr = null;
				BufferedReader br = null;
				try {
					fr = new FileReader(copia);
					br = new BufferedReader(fr);
					String aux;
			
					ps.println("Datos del archivo: ");
					while ((aux = br.readLine()) != null) {
						String[] datos = aux.split(";");
						ps.printf(Utils.ANSI_MAGENTA + "%-20s\t" + Utils.ANSI_GREEN + "%-20s\t" + Utils.ANSI_PURPLE + "%-20s\t" + Utils.ANSI_BLUE_BRIGHT + "%-15s\t" + Utils.ANSI_RED_BRIGHT + "%-5s\n" + Utils.ANSI_RESET, datos[0], datos[1], datos[2], datos[3], datos[4]);
					}
				} catch (FileNotFoundException e) {
					Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,e);
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						if(fr != null)
							fr.close();
						if(br != null)
							br.close();
				} catch (IOException e) {
					Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,e);
			}
		}
	}
}

