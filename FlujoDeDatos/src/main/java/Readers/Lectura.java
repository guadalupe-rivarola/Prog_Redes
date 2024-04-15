package Readers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lectura {
	
	// Stream
	// Stream  IN
	// Stream  OUT
	// Stream  ERR
	PrintStream ps;
	public Lectura()
	{
	//intermediario entre la escritura y el canal
	PrintStream ps = new PrintStream(System.out);

	System.out.println("Byte:");
	//Scanner s = new Scanner(System.in);
	//System.err.println();


	//escribe byte a byte
	// ejemplo: el byte 27 no tiene representacion y se ve un ?
	System.out.write(  104  );  //
	System.out.write(  10  );  // enter
	System.out.write(  5 );
	System.out.write(  97 );

	byte[] array = {78, 64, 119, 97, 19};
	try {
	System.out.write(  array );
	} catch (IOException e) {
	// TODO Auto-generated catch block
	Logger.getLogger(Readers.Lectura.class.getName()).log( Level.SEVERE , null, e);  //mostrar informacion a traves de un canal de comunicacion, es abstracta
	//e.printStackTrace(); logger reemplaza esto
	}

	System.err.println("ERROR");

	System.out.flush(); //asegura que la informacion en el canal de comunicacion salga
	//System.out.println();

	ps.println("holaaa");

	// printf : permite armar el formato
	//%d enteros
	//%b boolean
	//%s text
	//%f numeros con como
	//%.2f solo con 2 decimales

	ps.printf("EL numero elegido es: %b %d y su nombre: %s y en su cuenta tiene: %.2f $ \n", true, 18, "Guada", 9574.34);


	//System.set..() : cambian el canal de comunicacion por defecto.
	//System.setErr(error);
	//System.setOut(error);
	//System.setIn(null);

	File archivo = new File("error.log");

	//crea un canal de comunicaciones de SALIDA, destino:  un ARCHIVO (file)

	FileOutputStream fos = null;
	try {
	fos = new FileOutputStream(archivo , true);
	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	PrintStream error = new PrintStream(fos);

	System.setErr(error);



	System.err.println("Esto es un error critico");

	}

	public String entradaDeDatos() {
	//lee los bytes
	try {

	int Byte = -1;
	String cadena = "";
	while( (Byte = System.in.read()) != '\n'   ) {

	if ((Byte != 13))
	cadena += (char)Byte;

	}

	System.out.print(cadena);

	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return "";



	}

	//int opcion = Integer.parseInt(cadena);
	//double precio = Double.parseDouble( cadena );



	}


