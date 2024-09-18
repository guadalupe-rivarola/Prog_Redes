package Banco;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Clase que representa un banco que gestiona cuentas y operaciones de transferencia.
 * Utiliza mecanismos de bloqueo para asegurar la consistencia en las operaciones.
 */
public class Banco {

    private String nombreBanco;
    private int sucursal;
    private Map<Integer, Integer> cuentas;
    private PrintStream ps = new PrintStream(System.out);
    
    /**
     * Objeto Lock utilizado para manejar la sincronizaci�n en las operaciones del banco.
     * Se utiliza para asegurar que solo un hilo pueda realizar operaciones cr�ticas a la vez.
     */
    private Lock cierreDeBanco = new ReentrantLock();
    
    /**
     * Objeto Condition asociado al Lock {@code cierreDeBanco}.
     * Se utiliza para esperar y notificar condiciones espec�ficas relacionadas con las operaciones de transferencia.
     */
    private Condition saldoSuficiente;
    
    /**
     * Constructor para inicializar el objeto Banco.
     * 
     * @param cantCuentas N�mero de cuentas a crear en el banco.
     * @param montoInicial Monto inicial de cada cuenta.
     * @param nombre Nombre del banco.
     */
    public Banco(int cantCuentas, int montoInicial, String nombre) {
        ps.printf("\n" + Utils.ANSI_WHITE_BACKGROUND + "\t\t\t" + Utils.ANSI_BLACK + "BANCO CREADO \t\t\t\n" + Utils.ANSI_RESET);

        cuentas = new HashMap<>();
        
        // Inicializa el objeto Condition asociado al Lock cierreDeBanco.
        // Esto permite que los hilos puedan esperar en una condici�n espec�fica y ser notificados cuando se cumpla.
        saldoSuficiente = cierreDeBanco.newCondition();
        
        this.nombreBanco = nombre;
        
        // Inicializa las cuentas con el monto inicial proporcionado
        for (int nro = 0; nro < cantCuentas; nro++) {
            cuentas.put(nro, montoInicial);
        }
    }

    /**
     * Realiza una transferencia entre dos cuentas del banco.
     * Este m�todo deber�a ser implementado para manejar la l�gica de transferencia
     * y la sincronizaci�n necesaria para asegurar la consistencia de las cuentas.
     * 
     * @param cuentaOrigen N�mero de la cuenta de origen.
     * @param cuentaDestino N�mero de la cuenta destino.
     * @param monto Monto a transferir.
     */
    public void transferir(int cuentaOrigen, int cuentaDestino, int monto) {
        // Implementar l�gica de transferencia aqu�
    }

    /**
     * Obtiene el nombre del banco.
     * 
     * @return El nombre del banco.
     */
    public String getName() {
        return this.nombreBanco;
    }

}