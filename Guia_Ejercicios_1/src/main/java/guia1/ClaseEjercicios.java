package guia1;
import java.io.IOException;
import java.io.PrintStream;

public class ClaseEjercicios {
	
	static PrintStream ps = new PrintStream(System.out);
	
	public static String entradaDeDatos() {	
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
	
	public static String Ejercicio1A(){
				
		ps.println("Ingrese la cantidad de horas trabajadas: ");
		String datoHoras = entradaDeDatos();
		int hora = Integer.parseInt(datoHoras);
		
		ps.println("Ingrese el valor por hora: ");
		String datoHora = entradaDeDatos();
		double cantH = Double.parseDouble(datoHora);
		
		double sueldoBruto = hora * cantH;
		return "El sueldo bruto es: " + sueldoBruto;
	
	}
	
	public static String Ejercicio1B() {
		
		ps.println("Ingrese el valor del primer angulo interior del triangulo: ");
		String dato1 = entradaDeDatos();
		double angulo1 = Double.parseDouble(dato1);
		
		ps.println("Ingrese el valor del segundo angulo interior del triangulo: ");
		String dato2 = entradaDeDatos();
		double angulo2 = Double.parseDouble(dato2);
		
		double angulo3 = 180 - (angulo1 + angulo2) ;
		
		return "El valor del tercer angulo interior del tringulo es: " + angulo3;
	}

	public static String Ejercicio1C() {
		ps.println("Ingrese la superficie del cuadrado (en m²): ");
		String dato = entradaDeDatos();
		double superficie = Double.parseDouble(dato);
		
		double lado = Math.sqrt(superficie) ;
		double perimetro = 4 * lado;
		return "El perimetro del cuadrado es de " + perimetro + "metros.";
	}
	
	public static String Ejercicio1D() {
		
		ps.println("Ingrese la temperatura Fahrenheit: ");
		String dato = entradaDeDatos();
		double temF = Double.parseDouble(dato);
		
		double temC = (5.0 / 9.0) * (temF - 32);
		return "La temperatura en grados Centigrados es: " + temC +"°";
	}
}
