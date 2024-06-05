package Archivos;

import java.io.IOException;
import java.io.PrintStream;

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
	
	static String Ejercicio1() {
		ps.println("Ingrese el texto: ");
		String texto = leerDatos();	
		return texto;
	}
	
/*	static String  verificarFloat(){
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
 
*/
	
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

	}

