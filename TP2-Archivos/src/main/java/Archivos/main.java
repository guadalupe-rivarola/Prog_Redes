package Archivos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class main {
	static PrintStream ps = new PrintStream(System.out);
	static boolean continuar = true; 
	
	public static void main(String[] args) {
		while (continuar) {
			ps.println("Ingrese la opcion a ejecutar:");
			ps.println("1- Ejercicio 1");
			ps.println("2- Ejercicio 2");
			ps.println("0- Salir");

			int opcion = main.leerOpcion();

			switch (opcion) {
			case 1:
					ps.println("Ejecutando Ejercicio 1");
					ps.println(Ejercicios.Ejercicio1());
				break;
			case 2:
				ps.println("Ejecutando Ejercicio 2");
				ps.println(Ejercicios.verificarFloat());
			break;
			case 0: 
					ps.println("Fin del menú");
					continuar = false;
					break;
			default: 
					ps.println("Opcion invalida, ingrese un numero valido: ");
					break;
		
			}
		}

	}



	static int leerOpcion() {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    int opcion = 0;
	    boolean entradaValida = false;
	
	    while (!entradaValida) {
	        ps.println("Ingrese la opcion:");
	
	            String input;
				try {
					input = reader.readLine();
					opcion = Integer.parseInt(input);
					
					if (opcion >= 0) {
		                entradaValida = true; 
		            } else {
		                ps.println("Error: Por favor, ingrese un numero entero positivo.");
		            }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	    }
	
	    return opcion;
		}
	}