package guia1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ClaseEjercicios {
	
	static PrintStream ps = new PrintStream(System.out);
	
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
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	
	public static void Ejercicio2A() {
		
		ps.println("Ingrese el primer apellido: ");
		String apellido1 = entradaDeDatos2();
		ps.println("Ingrese el segundo apellido: ");
		String apellido2 = entradaDeDatos2();
		ps.println("Ingrese el tercer apellido: ");
		String apellido3 = entradaDeDatos2();
		
		String[] apellidos = {apellido1, apellido2, apellido3};	
		Arrays.sort(apellidos);
		
		ps.println("Apellidos ordenados alfábeticamente: ");
		for(String a : apellidos) {
			ps.println(a);
		}
	}
	
	public static void Ejercicio2B() {
		ps.println("Ingrese el primer número: ");
		String dato1 = entradaDeDatos2();
		double num1 = Double.parseDouble(dato1);
		ps.println("Ingrese el segundo número real: ");
		String dato2 = entradaDeDatos2();
		double num2 = Double.parseDouble(dato2);
		ps.println("Ingrese el tercer número real: ");
		String dato3 = entradaDeDatos2();
		double num3 = Double.parseDouble(dato3);
		ps.println("Ingrese el cuarto número real: ");
		String dato4 = entradaDeDatos2();
		double num4 = Double.parseDouble(dato4);		
		
		double[] numeros = {num1,num2,num3,num4};	
		double menor = numeros[0];
		
		for(int i=0; i<numeros.length; i++) {
			if(numeros[i]<menor) {
				menor = numeros[i];
			}
		}
		ps.println("De los 4 números reales, el menor es: " + menor);
	}

	public static String Ejercicio2C() {
		ps.println("Ingrese el numero: ");
		String dato = entradaDeDatos2();
		int num = Integer.parseInt(dato);
		
		if(num % 2 == 0) {
			return "El numero " + num + " es par";
		}else {
			return "El numero " + num + " es impar";
		}
	}

	public static String Ejercicio2D() {
		ps.println("Ingrese el primer numero: ");
		String dato1 = entradaDeDatos2();
		int num1 = Integer.parseInt(dato1);
		ps.println("Ingrese el segundo numero: ");
		String dato2 = entradaDeDatos2();
		int num2 = Integer.parseInt(dato2);
		
		if(num1 % num2 == 0) {
			return num1 + " es divisible por " + num2;
		}else {
			return num1 + " no es divisible por " + num2;
		}
	}

	public static String Ejercicio2E() {
		ps.println("Ingrese su fecha de nacimiento en este formato dd/mm/aa : ");
		String fecha = entradaDeDatos2();
		String[] partes = fecha.split("/");
		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		
		switch(mes) {
		case 1:
			if(dia <= 19) {
				return "Capricornio";
			}else {
				return "Acuario";
			}
		case 2:
			if(dia <= 18) {
				return "Acuario";
			}else {
				return "Piscis";
			}
		case 3:
			if(dia <= 20) {
				return "Piscis";
			}else {
				return "Aries";
			}
		case 4:
			if(dia <= 19) {
				return "Aries";
			}else {
				return "Tauro";
			}
		case 5:
			if(dia <= 20) {
				return "Tauro";
			}else {
				return "Géminis";
			}
		case 6:
			if(dia <= 20) {
				return "Géminis";
			}else {
				return "Cáncer";
			}
		case 7:
			if(dia <= 22) {
				return "Cáncer";
			}else {
				return "Leo";
			}
		case 8:
			if(dia <= 22) {
				return "Leo";
			}else {
				return "Virgo";
			}
		case 9:
			if(dia <= 22) {
				return "Virgo";
			}else {
				return "Libra";
			}
		case 10:
			if(dia <= 22) {
				return "Libra";
			}else {
				return "Escorpio";
			}
		case 11:
			if(dia <= 21) {
				return "Escorpio";
			}else {
				return "Sagitario";
			}
		case 12:
			if(dia <= 21) {
				return "Sagitario";
			}else {
				return "Capricornio";
			}
		default: 
			return "Fecha inválida.";
		}
	}
	
	public static String Ejercicio2F() {
		ps.println("Ingrese el nombre y el apellido de la primera persona: ");
		String persona1 = entradaDeDatos2();
		ps.println("Ingrese el nombre y el apellido de la segunda persona: ");
		String persona2 = entradaDeDatos2();
		
		if(persona1.length() > persona2.length()) {
			return "La persona con el nombre y apellido más largo es: " + persona1;
		}else if(persona2.length() > persona1.length()){
			return "La persona con el nombre y apellido más largo es: " + persona2;
		}else {
			return "Las dos personas tienen la misma longitud en sus nombres y apellidos.";
		}
	}
	
	public static void Ejercicio2G() {
		ps.println("Ingrese un número entero: ");
		String dato = entradaDeDatos2();
		int num = Integer.parseInt(dato);
		
		for(int i=1 ; i<=10 ; i++) {
			int resultado = num * i;
			ps.println(num + " x " + i + " = " + resultado);
		}
		
	}
	
	public static void Ejercicio2H() {
		ps.println("Ingrese un número natural: ");
		String dato = entradaDeDatos2();
		int num = Integer.parseInt(dato);
		
		boolean numPrimo = true;
		if(num < 2) {
			numPrimo = false;
		}else {
			for(int i=2 ; i<= num / 2 ; i++) {
				if(num % i == 0) {
					numPrimo = false;
					break;
				}
			}
		}
		
		if(numPrimo) {
			ps.println(num + " es un número primo");
		}else {
			ps.println(num + " no es un número primo.");
		}
	}

	public static void Ejercicio3A() {
		File archivo = new File("Ejercicio3A.txt");
		ps.println("Ingrese 5 datos separados por ',': ");
		String dato = entradaDeDatos2();
		String[] datos = dato.split(",");
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
			try {
				fw = new FileWriter(archivo, true);
				pw = new PrintWriter(fw);
				pw.print("El último dato ingresado es:");
				pw.println(datos[4]);
				pw.flush();
			} catch (IOException e) {
				Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
			}finally {
				try {
					if(pw != null)
						pw.close();
					if(fw != null) 
						fw.close();
					} catch (IOException e) {
						Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
					}
			}	
	}
	
	public static void Ejercicio3B() {
		File archivo = new File("Ejercicio3B.txt");
		ps.println("Cuál es la cantidad de valores que va a ingresar: ");
		String dato = entradaDeDatos2();
		int cant = Integer.parseInt(dato);
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
			try {
				fw = new FileWriter(archivo, false);
				pw = new PrintWriter(fw);
				for (int i = 0; i < cant; i++) {
					ps.println("Ingrese el dato: ");
					String valor = entradaDeDatos2();
				    if (valor.matches(".*\\d.*") ) { //dato investigado en internet
				    	pw.println(valor);  
				    	pw.flush();
				    }    
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(pw != null)
						pw.close();
					if(fw != null) 
						fw.close();
				} catch (IOException e) {
						Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
				}
			}
		}

	public static void Ejercicio3C() {
		File archivo = new File("C:/Users/guada/OneDrive/Documentos/GitHub/Prog_Redes/archivos/números.txt");
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(archivo, false);
			pw = new PrintWriter(fw);
			
			for(int i=0; i<=1000;i++) {
				if(i % 2 == 0) {
					pw.println(i);
				}
					
			}
		} catch (IOException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		}finally {
			try {
				if(pw != null)
					pw.close();
				if(fw != null) 
					fw.close();
			} catch (IOException e) {
				Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
			}
		}
	}

	public static void Ejercicio3D() {
		File archivo = new File("C:/Users/guada/OneDrive/Documentos/GitHub/Prog_Redes/archivos/números.txt");
		FileReader fr = null;
		BufferedReader br = null;
		try {
			 fr = new FileReader(archivo);
			 br = new BufferedReader(fr);
			String aux;
			
			ps.println("Datos del archivo: ");
			while ((aux = br.readLine()) != null) {
				ps.println(aux);
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr != null)
					fr.close();
				if(br != null) 
					br.close();
			} catch (IOException e) {
				Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
			}
		}
	}

	public static void Ejercicio3E() {
		File original = new File("C:/Users/guada/OneDrive/Documentos/GitHub/Prog_Redes/archivos/números.txt");
		File copia = new File("C:/Users/guada/OneDrive/Documentos/GitHub/Prog_Redes/archivos/copia.tmp");
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			 fr = new FileReader(original);
			 br = new BufferedReader(fr);

			if(!copia.exists()) {
				fw = new FileWriter(copia);
				pw = new PrintWriter(fw);
				String aux = "";
				while ((aux = br.readLine()) != null) {
					int num = Integer.parseInt(aux);
					if(num % 3 != 0) {
						pw.println(aux);
				}
				}
			}
			if(original.exists())
				original.delete();
			if(copia.exists())
				copia.renameTo(original);
		} catch (FileNotFoundException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		} catch (IOException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		}finally {
            try {
                if (pw != null)
                    pw.close();
                if (fw != null)
                    fw.close();
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING, null, e);
            }
         }
	}

	public static void Ejercicio3F() {
		File archivo = new File("C:/Users/guada/OneDrive/Documentos/GitHub/Prog_Redes/archivos/números.txt");
		File archivo2 = new File("C:/Users/guada/OneDrive/Documentos/GitHub/Prog_Redes/primos.dat");
		
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			fw = new FileWriter(archivo2);
			pw = new PrintWriter(fw);
			String aux;
		
			while((aux = br.readLine()) != null) {
				int num = Integer.parseInt(aux);
				boolean numPrimo = true;
				
				if(num < 2) {
					numPrimo = false;
				}else {
					for(int i=2; i <= num / 2; i++) {
						if(num % i == 0) {
							numPrimo = false;
							break;
						}
					}
				}
				if(numPrimo) {
					pw.println(num);
				}
			}
		}catch(IOException e){
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING, null, e);
		}finally {
			try {
				if(fr != null)
					fr.close();
				if(br != null) 
					br.close();
				if(fw != null)
					fw.close();
				if(pw != null) 
					pw.close();
			} catch (IOException e) {
				Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
			}

		}
	}


	public static void Ejercicio3G() {
		File original = new File("C:/Users/guada/OneDrive/Documentos/GitHub/Prog_Redes/archivos/caracteres.dat");
		File copia = new File("C:/Users/guada/OneDrive/Documentos/GitHub/Prog_Redes/archivos/copia.tmp");
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		PrintWriter pw = null;
		//ingresar palabras
		try {
			fw = new FileWriter(original, false);
			pw = new PrintWriter(fw);
			for(int i=0;i<=10;i++) {
				ps.println("Ingrese una palabra que contenga 'ñ': ");
				String dato = entradaDeDatos2();
				pw.println(dato);					
				pw.flush();
			}
		 } catch (FileNotFoundException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		} catch (IOException e) {		
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		}finally {
            try {
                if (fw != null)
                    fw.close();
                if (pw != null)
                    pw.close();
            } catch (IOException e) {
                Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING, null, e);
            }
		}
		
		//mostrar palabras
		try {
			fr = new FileReader(original);
			br = new BufferedReader(fr);
			String aux;
			ps.println("Fichero original: ");
			while((aux=br.readLine()) != null) {
				ps.println(aux);
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		} catch (IOException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		}finally {
            try {
                if (fr != null)
                    fr.close();
                if (br != null)
                    br.close();
            } catch (IOException e) {
                Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING, null, e);
            }
        }
		
		//reemplazar palabras
		try {
			fw = new FileWriter(copia, false);
			pw = new PrintWriter(fw);
			fr = new FileReader(original);
			br = new BufferedReader(fr);
			String aux;
			while((aux=br.readLine()) != null){
				String datos = aux.replace("ñ", "nie-nio");
				pw.println(datos);
				pw.flush();
			}
		} catch (IOException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		}finally {
            try {
                if (pw != null)
                    pw.close();
                if (fw != null)
                    fw.close();
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING, null, e);
            }
		}
		if(original.exists())
			original.delete();
		if(copia.exists())
			copia.renameTo(original);
		
		//mostrar palabras nuevas
		try {
			fr = new FileReader(original);
			br = new BufferedReader(fr);
			String aux;
			ps.println("Fichero arreglado: ");
			while((aux=br.readLine()) != null) {
				ps.println(aux);
			}
		} catch (FileNotFoundException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		} catch (IOException e) {
			Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING,null,e);
		}finally {
            try {
                if (fr != null)
                    fr.close();
                if (br != null)
                    br.close();
            } catch (IOException e) {
                Logger.getLogger(ClaseEjercicios.class.getName()).log(Level.WARNING, null, e);
            }
		}
	}

	public static void Ejercicio4A() {
	
	}
	
	public static void Ejercicio4B() {
		
	}
	
	public static void Ejercicio4C() {
		
	}
	
	public static void Ejercicio4D() {
		
	}
	
	public static void Ejercicio4E() {
		
	}
	
	public static void Ejercicio4F() {
		
	}
	
	public static void Ejercicio4G() {
		
	}
}
