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
					ps.println("4- Ejercicio 1 D");
					ps.println("5- Ejercicio 1 E");
					ps.println("6- Ejercicio 1 F");
					ps.println("7- Ejercicio 1 G");
					ps.println("8- Ejercicio 2 A");
					ps.println("9- Ejercicio 2 B");
					ps.println("10- Ejercicio 2 C");
					ps.println("11- Ejercicio 2 D");
					ps.println("12- Ejercicio 2 E");
					ps.println("13- Ejercicio 2 F");
					ps.println("14- Ejercicio 2 G");
					ps.println("15- Ejercicio 2 H");
					ps.println("16- Ejercicio 3 A");

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
						ps.println("Ejecutando Ejercicio 1 C");
						ps.println(ClaseEjercicios.Ejercicio1C());
						break;
					case 4:
						ps.println("Ejecutando Ejercicio 1 D");
						ps.println(ClaseEjercicios.Ejercicio1D());
						break;
					case 5:
						ps.println("Ejecutando Ejercicio 1 E");
						ps.println(ClaseEjercicios.Ejercicio1E());
						break;
					case 6:
						ps.println("Ejecutando Ejercicio 1 F");
						ps.println(ClaseEjercicios.Ejercicio1F());
						break;
					case 7:
						ps.println("Ejecutando Ejercicio 1 G");
						ps.println(ClaseEjercicios.Ejercicio1G());
						break;
					case 8:
						ps.println("Ejecutando Ejercicio 2 A");
						ClaseEjercicios.Ejercicio2A();
						break;
					case 9:
						ps.println("Ejecutando Ejercicio 2 B");
						ClaseEjercicios.Ejercicio2B();
						break;
					case 10:
						ps.println("Ejecutando Ejercicio 2 C");
						ps.println(ClaseEjercicios.Ejercicio2C());
						break;
					case 11:
						ps.println("Ejecutando Ejercicio 2 D");
						ps.println(ClaseEjercicios.Ejercicio2D());
						break;
					case 12:
						ps.println("Ejecutando Ejercicio 2 E");
						ps.println(ClaseEjercicios.Ejercicio2E());
						break;
					case 13:
						ps.println("Ejecutando Ejercicio 2 F");
						ps.println(ClaseEjercicios.Ejercicio2F());
						break;
					case 14:
						ps.println("Ejecutando Ejercicio 2 G");
						ClaseEjercicios.Ejercicio2G();
						break;
					case 15:
						ps.println("Ejecutando Ejercicio 2 H");
						ClaseEjercicios.Ejercicio2H();
						break;
					case 16:
						ps.println("Ejecutando Ejercicio 3 A");
						//ps.println(ClaseEjercicios.Ejercicio2A());
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
