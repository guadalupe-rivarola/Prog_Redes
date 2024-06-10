package guia1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ClaseEjercicios {
	
	static PrintStream ps = new PrintStream(System.out);
	
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);
	
	public static String entradaDeDatos1() {	
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
		String datoHoras = entradaDeDatos1();
		int hora = Integer.parseInt(datoHoras);
		
		ps.println("Ingrese el valor por hora: ");
		String datoHora = entradaDeDatos1();
		double cantH = Double.parseDouble(datoHora);
		
		double sueldoBruto = hora * cantH;
		return "El sueldo bruto es: " + sueldoBruto;
	
	}
	
	public static String Ejercicio1B() {
		
		ps.println("Ingrese el valor del primer angulo interior del triangulo: ");
		String dato1 = entradaDeDatos1();
		double angulo1 = Double.parseDouble(dato1);
		
		ps.println("Ingrese el valor del segundo angulo interior del triangulo: ");
		String dato2 = entradaDeDatos1();
		double angulo2 = Double.parseDouble(dato2);
		
		double angulo3 = 180 - (angulo1 + angulo2) ;
		
		return "El valor del tercer angulo interior del tringulo es: " + angulo3;
	}

	public static String Ejercicio1C() {
		ps.println("Ingrese la superficie del cuadrado (en m²): ");
		String dato = entradaDeDatos1();
		double superficie = Double.parseDouble(dato);
		
		double lado = Math.sqrt(superficie) ;
		double perimetro = 4 * lado;
		return "El perimetro del cuadrado es de " + perimetro + "metros.";
	}
	
	public static String Ejercicio1D() {
		
		ps.println("Ingrese la temperatura Fahrenheit: ");
		String dato = entradaDeDatos1();
		double temF = Double.parseDouble(dato);
		
		double temC = (5.0 / 9.0) * (temF - 32);
		return "La temperatura en grados Centigrados es: " + temC +"°";
	}
	
	public static String Ejercicio1E() {
		
		ps.println("Ingrese el tiempo en segundos: ");
		String dato = entradaDeDatos1();
		int segundos = Integer.parseInt(dato);
		
		int dias = segundos / (24 * 3600);
		segundos = segundos % (24*3600);
		
		int horas = segundos / 3600;
		segundos = segundos %= 3600;
		
		int minutos = segundos / 60;
		segundos = segundos %= 60;
		
		return "Dias: " + dias + "  Horas: " + horas + "  Minutos: " + minutos + "  Segundos: " + segundos;
	}

	public static String Ejercicio1F() {
		
		try {
			ps.println("Ingrese el precio del articulo: ");
			String dato = entradaDeDatos1();
			double precio = Double.parseDouble(dato);
			
			//plan 1
			double plan1 = precio * 0.10;
			double descuento = precio - plan1;
			
			//plan 2 
			double precioIncrementado = precio * 1.10;
			double precioContado = precioIncrementado * 0.50;
			double precioResto = precioIncrementado - precioContado;
			double dosCuotas = precioResto / 2;
			
			//plan 3
			double precioIncrementado2 = precio * 1.15;
			double precioContado2 = precioIncrementado2 * 0.25;
			double precioResto2 = precioIncrementado2 - precioContado2;
			double cincoCuotas = precioResto2 / 5;		
		
			//plan 4
			double precioIncrementado3 = precio * 1.25;
			
			double priParte = precioIncrementado3 * 0.60;
			double segParte = precioIncrementado3 - priParte;
			
			double primerasCuotas = priParte / 4;
			double ultimasCuotas = segParte / 4;
			
			return  String.format("Plan 1: 100%% al contado: %.2f $\n", descuento) +
					String.format("Plan 2: 50%% al contado: %.2f $ y el resto en 2 cuotas iguales de: %.2f $\n", precioContado, dosCuotas)+
					String.format("Plan 3: 25%% al contado: %.2f $ y el resto en 5 cuotas iguales de: %.2f $\n", precioContado2, cincoCuotas)+
					String.format("Plan 4: 8 cuotas. 60%% repartido en 4 cuotas iguales de:  %.2f $ y el resto en 4 cuotas iguales de: %.2f $\n", primerasCuotas, ultimasCuotas)
					; 
		}catch(NumberFormatException e) {
			return "Error: Ingrese un valor numero valido para el precio.";
		}
	}

	public static String Ejercicio1G() {
		
		ps.println("Ingrese su signo zodiacal: ");
		String signo = entradaDeDatos1().toUpperCase();
		
		switch(signo) {
		case "ACUARIO":
			return "Enero o Febrero";
		
		case "PISCIS":
		return "Febrero o Marzo";

		case "ARIES":
		return "Marzo o Abril";

		case "TAURO":
		return "Abril o Mayo";

		case "GEMINIS":
		return "Mayo o Junio";

		case "CANCER":
		return "Junio o Julio";

		case "LEO":
		return "Julio o Agosto";
		
		case "VIRGO":
		return "Agosto o Septiembre";

		case "LIBRA":
		return "Septiembre u Octubre";
		
		case "ESCORPIO":
		return "Octubre o Noviembre";
			
		case "SAGITARIO":
		return "Noviembre o Diciembre";
		
		case "CAPRICORNIO":
		return "Diciembre o Enero";
		
		default:
			return "No existe ese signo zodiacal";
				}
		
	}

	public static String entradaDeDatos2() {
		
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String Ejercicio2A() {
		
		ps.println("Ingrese el primer apellido: ");
		String apellido1 = entradaDeDatos2();
		ps.println("Ingrese el segundo apellido: ");
		String apellido2 = entradaDeDatos2();
		ps.println("Ingrese el tercer apellido: ");
		String apellido3 = entradaDeDatos2();
		
		return apellido1;
	}
	
	public static String Ejercicio2B() {
		
		
		
		return "";
	}

	public static String Ejercicio2C() {
		ps.println("Ingrese el numero: ");
		String dato = entradaDeDatos2();
		int num = Integer.parseInt(dato);
		
		if(num % 2 == 0) {
			return "El numero es par";
		}else {
			return "El numero es impar";
		}
	}

	public static String Ejercicio2D() {
		
		ps.println("Ingrese el primer numero: ");
		String dato1 = entradaDeDatos2();
		int num1 = Integer.parseInt(dato1);
		ps.println("Ingrese el segundo numero: ");
		String dato2 = entradaDeDatos2();
		int num2 = Integer.parseInt(dato2);
		
		if(num1 % num2 ==0) {
			return num1 + " es divisible por " + num2;
		}else {
			return num1 + " no es divisible por " + num2;
		}
	}


}
