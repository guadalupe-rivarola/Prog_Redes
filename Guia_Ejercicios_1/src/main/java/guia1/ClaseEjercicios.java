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
		
		ps.println("Ingrese el valor por hora: ");
		String datoHora = entradaDeDatos();
		int hora = Integer.parseInt(datoHora);
		
		ps.println("Ingrese la cantidad de horas trabajadas: ");
		String datoHoras = entradaDeDatos();
		double cantH = Double.parseDouble(datoHoras);
		
		double sueldoBruto = hora * cantH;
		return "El sueldo bruto es: " + sueldoBruto;
	
	}
	

}
