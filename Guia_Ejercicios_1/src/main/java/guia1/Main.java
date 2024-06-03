package guia1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
	static boolean continuar = true;
	static PrintStream ps = new PrintStream(System.out);
			
	public static void main(String[] args) {
				while (continuar) {
					ps.println("Ingrese la opcion a ejecutar:");
					ps.println("1- Ejercicio 1 A");
					ps.println("2- Ejercicio 1 B");
					ps.println("3- Ejercicio 1 C");
					ps.println("0- Salir");

					int opcion = Main.leerOpcion();

					switch (opcion) {
					case 1:
							ps.println("Ejecutando Ejercicio 1 A");
							ps.println(ClaseEjercicios.Ejercicio1A());
						break;
					case 2:
						ps.println("Ejecutando Ejercicio 1 B");
						ps.println(ClaseEjercicios.Ejercicio1B());
						break;
					case 3:
						ps.println("Ejecutando Ejercicio 2");
						// L�gica del ejercicio 2
						break;
					case 0:
						ps.println("Saliendo del men�...");
						continuar = false;
						break;
					default:
						ps.println("Opci�n inv�lida. Por favor, ingrese una opci�n v�lida.");
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
		            try {
		                String input = reader.readLine(); 
		                opcion = Integer.parseInt(input); 

		                
		                if (opcion >= 0) {
		                    entradaValida = true; 
		                } else {
		                    ps.println("Error: Por favor, ingrese un numero entero positivo.");
		                }
		            } catch (NumberFormatException | IOException e) {
		                ps.println("Error: Por favor, ingrese un numero entero valido.");
		            }
		        }

		        return opcion;
		
	}

}
