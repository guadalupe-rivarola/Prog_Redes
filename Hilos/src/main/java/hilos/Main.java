package hilos;

public class Main {

	public static void main(String[] args) {
	    //Obtenemos la marca de tiempo nical del S.O para
        //generar comparacione en las tareas.
		long tiempoInicial = System.currentTimeMillis();
			
		//--- Aca despues vamos a aplicar Patrones de Diseño FACTORY ---
		Persona cli1  = new Persona("Javi",25632568,
				new String[] {"Arroz","Coca-Cola","Vela Cumple", "Globos"},
				new int[]    { 10    ,     5     ,     2       ,    3   });
		Persona cli2  = new Persona("Juan",36589741,
				new String[] {"Taza", "Cuchara", "Cafe"},
				new int[]    { 1    ,    1     ,   1});
		Persona cli3  = new Persona("Enrique",69874521,
				new String[] {"Pan", "Manteca" , "Cuchillo de Untar"},
				new int[]    {  2  ,     1     ,         1      });
		Persona cli4  = new Persona("Maria",45534578,
				new String[] {"Vodka", "Fernet" , "Speed", "Jugo de Naranja", "Coca-Cola"},
				new int[]    {   2   ,    2     ,    8   ,      5          ,   4   });
		Persona cli5  = new Persona("Sofia",63642158,
				new String[] {"Pritty-Limon" , "Esponja" , "Guante" , "Detergente"},
				new int[]    {      3       ,     2     ,     2       ,    1   });
		Persona cli6  = new Persona("Hector",25632568,
				new String[] {"Mandioca","Papayas","Biscochitos"},
				new int[]    {   3    ,     2     ,     2       });
		Persona cli7  = new Persona("Maxi",68574125,
				new String[] {"yerba","Azucar","Edulcurante", "Yuyos varios"},
				new int[]    {   2    ,   1     ,     2       ,    3   });
		Persona cli8  = new Persona("Laura",25632568,
				new String[] {"Tomates","Budin","Nesquik", "Leche"},
				new int[]    { 3       ,   2   ,     1   ,    3   });
		Persona cli9  = new Persona("Matias",12458524,
				new String[] {"Medialuna","Pepino","Bagio"},
				new int[]    {     12     ,  3     ,  2    });
		Persona cli10 = new Persona("Renzo",25632568,
				new String[] {"Test Embarazo", "Lubricante", "Hoas A4" , "Pañales"},
				new int[]    {    1          ,    3        ,     2     ,    3   });	
		
		//forma1
		//esta clase heradaba de Thread, asi que es un Hilo y tiene actividades para hacer.
		CajaHilo caja1 = new CajaHilo();
		caja1.start();
		
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
