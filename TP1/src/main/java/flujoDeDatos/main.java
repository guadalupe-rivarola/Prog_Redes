package flujoDeDatos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream ps = new PrintStream(System.out);
	public static void main(String[] args) {

		int[] vector1 = {1, 4, 0, 0, 6};
		int[] vector2 = new int[5];
	    try {
	    	for (int i = 0; i < 5; i++) {
	    		ps.printf("Ingrese numero %d del vector: %n", i + 1);
	            vector2[i] = Integer.parseInt(br.readLine());
	    	}
	        } catch (IOException e) {
	            ps.println("Se produjo un error de entrada/salida: " + e.getMessage());
	        } catch (NumberFormatException e) {
	            ps.println("Debe ingresar un número válido: " + e.getMessage());
	        }

	        
	        String archivo = "Datos.txt";
	        try (FileWriter escribir = new FileWriter(archivo)) {
	            for (int i = 0; i < vector1.length; i++) {
	                escribir.write(vector1[i] + "\n");
	            }
	            for (int i = 0; i < vector2.length; i++) {
	                escribir.write(vector2[i] + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        

	        // Leer los datos y generar archivos de resultados y errores

	        String resultadosDiviciones = "resultados.txt";
	        String errores = "error.txt";
	        
	        try (FileWriter resultadosWriter = new FileWriter(resultadosDiviciones);
	             FileWriter erroresWriter = new FileWriter(errores)) {
	            for (int i = 0; i < vector1.length - 1; i++) {
	                int numero1 = vector1[i];
	                int numero2 = vector1[i + 1] - 3;

	                try {
	                    if (numero2 == 0) {
	                        throw new ArithmeticException("División por cero");
	                    }
	                    double resultado = (double) numero1 / numero2;
	                    resultadosWriter.write(numero1 + " / " + numero2 + " = " + resultado + "\n");
	                } catch (ArithmeticException e) {
	                    erroresWriter.write(numero1 + " / " + numero2 + " = error (" + e.getMessage() + ")\n");
	                }
	            }
	            
	            for (int i = 0; i < vector2.length - 1; i++) {
	                int numero1 = vector2[i];
	                int numero2 = vector2[i + 1] - 3;

	                try {
	                    if (numero2 == 0) {
	                        throw new ArithmeticException("División por cero");
	                    }
	                    double resultado = (double) numero1 / numero2;
	                    resultadosWriter.write(numero1 + " / " + numero2 + " = " + resultado + "\n");
	                } catch (ArithmeticException e) {
	                    erroresWriter.write(numero1 + " / " + numero2 + " = error (" + e.getMessage() + ")\n");
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            }
	}
}

