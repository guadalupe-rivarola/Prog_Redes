package Archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ejercicios {
	static PrintStream ps = new PrintStream(System.out);
	
	static String leerDatos() {
			String cadena = "";
			try {
				int Byte = -1;
				while((Byte = System.in.read()) != '\n') 
				{
					if(Byte != 13)
					cadena += (char)Byte;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return cadena;
	}
	/*	
	static String Ejercicio1() {
		ps.println("Ingrese el texto: ");
		String texto = leerDatos();	
		return texto;
	}
	
	static String  verificarFloat(){
	 ps.println("Ingrese el texto a verificar: ");
	 String texto = leerDatos();
	 String numeros = "";
		    for (int i = 0; i < texto.length(); i++) {
		        char caracter = texto.charAt(i);
		        if (caracter >= '0' && caracter <= '9') {
		            numeros += caracter;
		        }
		    }

		    if (texto.contains(".")) {
		        float numComa = Float.parseFloat(numeros);
		        return "Número con coma encontrado: " + numComa;
		    } else {
		        int numero = 0;
		        try {
		            numero = Integer.parseInt(numeros);
		        } catch (NumberFormatException e) {
		            ps.println("El texto no contiene numeros.");
		        }
		        return "Número entero encontrado: " + numero;
		    }
		}
 

	
	static String verificarFloat() {
	    ps.println("Ingrese el texto a verificar: ");
	    String texto = leerDatos();
	    String numeros = "";
	    boolean puntoEncontrado = false; // Bandera para verificar si ya se encontró un punto decimal

	    for (int i = 0; i < texto.length(); i++) {
	        char caracter = texto.charAt(i);
	        if (caracter >= '0' && caracter <= '9') {
	            numeros += caracter;
	        } else if (caracter == '.' && !puntoEncontrado) { // Si encontramos un punto y no se ha encontrado previamente
	            numeros += caracter;
	            puntoEncontrado = true; // Marcamos que se ha encontrado un punto
	        }
	    }

	    if (!numeros.isEmpty()) { // Verificar si se ha encontrado algún número
	        if (numeros.contains(".")) {
	            float numComa = Float.parseFloat(numeros);
	            return "Número con coma encontrado: " + numComa;
	        } else {
	            int numero = Integer.parseInt(numeros);
	            return "Número entero encontrado: " + numero;
	        }
	    } else {
	        return "El texto no contiene números.";
	    }
	}
*/
	
	public void crearArchivo(String ruta, String nombre, String extension ) {
		File archivo = new File(ruta.concat(nombre.concat(extension))); 
		if(!archivo.exists()) {
			try {
				archivo.createNewFile();
			}catch(IOException e) {
				Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,e);
			}
		}
	}
	
	public void escribirArchivo(File archivo) {
		//datos para escribir en el texto plano
	    ps.println("Ingrese el nombre del producto: ");
	    String nombreProd = leerDatos();
	    ps.println("Ingrese el precio de compra:");
	    String texto = leerDatos();
	    double precioComp = Double.parseDouble(texto);
	    ps.println("Ingrese el precio de venta: ");
	    String texto2 = leerDatos();
	    double precioVenta = Double.parseDouble(texto2);
	    ps.println("Ingrese el stock del producto: ");
	    String texto3 = leerDatos();
	    int stock = Integer.parseInt(texto3); 

		//escribir en el texto
	    FileWriter fw  = null;
	    PrintWriter pw = null;
		try {			
			fw = new FileWriter(archivo, true);
			pw = new PrintWriter(fw);
				 
			pw.print(nombreProd);
			pw.print(";");
			pw.print(precioComp);
			pw.print(";");
			pw.print(precioVenta);
			pw.print(";");
			pw.println(stock);
			pw.flush();
		} catch (IOException e) {
			Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,e);
		}finally {
			try {
				if(pw != null)
					pw.close();
				if(fw != null)
					fw.close();
			}catch(IOException e) {
				Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,e);
				}
			}
		}
	
	 
	public void leerArchivo(File archivo) {
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			PrintStream ps = new PrintStream(System.out);
			String aux;
			ps.println("\nDatos del archivo:");
            ps.println("Nombre del producto\tPrecio de compra\tPrecio de venta\t   Stock");
			while((aux = br.readLine()) != null) {
				String[] datos = aux.split(";");
				ps.printf( Utils.ANSI_GREEN + "%-20s\t" + Utils.ANSI_PURPLE + "%-20s\t" + Utils.ANSI_BLUE_BRIGHT + "%-15s\t    " + Utils.ANSI_RED_BRIGHT + "%-5s\n", datos[0],datos[1],datos[2],datos[3]);
			}
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,e);
		} catch (IOException e) {
			Logger.getLogger(Ejercicios.class.getName()).log(Level.WARNING,null,e);
		}
	}
	
}

