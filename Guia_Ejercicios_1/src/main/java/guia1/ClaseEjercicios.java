package guia1;
import java.io.IOException;
import java.io.PrintStream;

public class ClaseEjercicios {
	public double entradaDeDatos() {
		PrintStream ps;
		String h = "";
		Double horas = 0.0;
		
		ps.println("Ingrese la cantidad de horas trabajadas: ");
		
		//lee los bytes
		try {
			int Byte = -1;
			//String cadena = "";
			while( (Byte = System.in.read()) != '\n' ) {
				if ((Byte != 13))
					h += (char)Byte;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 horas = Double.parseDouble( h );
		//return cadena;
		
		
		
		ps.println("Ingrese el valor por hora : ");
		
		String v = "";
		Double valor = 0.0;
	
		try {
			int Byte = -1;
		
			while( (Byte = System.in.read()) != '\n' ) {
				if ((Byte != 13))
					v += (char)Byte;
			}
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		 valor = Double.parseDouble( v );
		
		 Double sueldoF = horas*valor;
		
		 ps.printf("El valor final es %s",sueldoF);
	}

}
