package hilos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
	    //Obtenemos la marca de tiempo nical del S.O para
        //generar comparacione en las tareas.
		long tiempoInicial = System.currentTimeMillis();
			
		//--- Aca despues vamos a aplicar Patrones de Diseño FACTORY ---
		Persona cli1 = new Persona( "nombre",45678952, new HashMap<String, Integer>( Map.of("Arroz",10, "Coca-Cola",5, "Vela Cumple",2, "Globos",3)));
		Persona cli2 = new Persona("Juan", 36589741, new  HashMap<String, Integer>( Map.of( "Taza",1, "Cuchara", 1,"Cafe",1)) );
		Persona cli3 = new Persona("Enrique", 69874521, new  HashMap<String, Integer>( Map.of( "Pan",2, "Manteca",1, "Cuchillo de Untar",1 )) );
		Persona cli4 = new Persona("Maria", 45534578,  new  HashMap<String, Integer>( Map.of( "Vodka",2, "Fernet",2, "Speed",8, "Jugo de Naranja",5, "Coca-Cola",4  )));
		Persona cli5 = new Persona("Sofia", 63642158,	new  HashMap<String, Integer>( Map.of( "Pritty-Limon",3, "Esponja",2, "Guante",2, "Detergente",1 )));
		Persona cli6 = new Persona("Hector", 25632568, new  HashMap<String, Integer>( Map.of( "Mandioca",3, "Papayas",2, "Biscochitos",2  )));
		Persona cli7 = new Persona("Maxi", 68574125, new  HashMap<String, Integer>( Map.of( "yerba",2, "Azucar",1, "Edulcurante",2, "Yuyos varios",3  )));
		Persona cli8 = new Persona("Laura", 25632568, new  HashMap<String, Integer>( Map.of( "Tomates",3, "Budin",2, "Nesquik", 1,"Leche",3  )) );
		Persona cli9 = new Persona("Matias", 12458524, new  HashMap<String, Integer>( Map.of( "Medialuna",12, "Pepino",3, "Bagio",2  )) );
		Persona cli10 = new Persona("Renzo", 25632568,	new  HashMap<String, Integer>( Map.of( "Test Embarazo",1, "Lubricante",3, "Hojas A4",2, "Pa�ales",3  )));
		
		
		
		//Crear un Array con Datos iniciales
		//Crear un Map con datos iniciales
		//new ArrayList<>(  List.of(     Map.of( k1,v2 ,k2,v2 ...)   ) ) 
		//new HashMap<String, Integer>( Map.of( k1,v2 ,k2Persona ) )
		
		ArrayList<Persona> colaCaja1 = new ArrayList<>();
		colaCaja1.add(cli10);
		colaCaja1.add(cli9);
		//forma1
		//esta clase heradaba de Thread, asi que es un Hilo y tiene actividades para hacer.
		CajaHilo caja1 = new CajaHilo(007, "Raul", tiempoInicial, colaCaja1);
		caja1.setName("Caja_1");
		caja1.start();
		
		ArrayList<Persona> colaCaja2 = new ArrayList<>();
		colaCaja2.add(cli1);
		colaCaja2.add(cli2);
		
		Thread Caja2 = new Thread(new CajaHilo(8, "Roberto", tiempoInicial, colaCaja2));
		caja1.setName("Caja_1");
		Caja2.start();
		
		//forma2 
		//esta clase implementa Runnable asi que no es un hilo, es solo una tarea a realizar
		Seguridad tareasDeSeguridad = new Seguridad();
		Thread guardia1 = new Thread(tareasDeSeguridad, "Guardia1");
		guardia1.setPriority(Thread.MAX_PRIORITY);
		guardia1.start();
		
		//forma3
		//cuando la tarea es muy cortita para realizar conviene marnar el hilo directo sin crear Class nueva
		Thread empleado = new Thread(
				new Runnable() {
					
					@Override
					public void run() {	
					}
				});
		empleado.setName("Empleado1");
		empleado.setPriority(Thread.MIN_PRIORITY);
		empleado.start();
	}
	
	public void metodosHilo(long tiempoInicial) {
		//  Ciclo de vida:  NEW
			Thread caja_1 = new Thread();
			caja_1.getName();// muestra el nombre del hilo
			caja_1.setName("Caja_1"); //le pone nombre al hilo
			caja_1.getPriority(); //le da prioridad al hilo 0-10
			caja_1.setPriority(Thread.MAX_PRIORITY); //prioridad maxima
			caja_1.getState(); // en que parte del CICLO DE VIDA esta
			caja_1.getThreadGroup(); //agregar tareas que son similares y que se ejecuten
			caja_1.isAlive();  //si el hilo esta vivo o muerto
			caja_1.isInterrupted(); //si el hilo esta pausado o no  deuvuelve un boolean
			
			try {
			caja_1.interrupted();
			caja_1.interrupt();
			caja_1.sleep(tiempoInicial);
			caja_1.join();
			caja_1.wait(tiempoInicial);
			caja_1.suspend();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			caja_1.resume();//reactiva la tarea de un Thread
			caja_1.notify(); //reanuda un hilo pausado
			caja_1.notifyAll();
			caja_1.start(); //prende el hilo y ejecuta la tarea
			caja_1.stop(); //mata al hilo
		
			caja_1.currentThread(); //devuelve en que hilo se esta trabajando ahora
	}
}
