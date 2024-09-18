package Banco;

import java.io.PrintStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa un hilo encargado de realizar transferencias entre cuentas del banco.
 * Hereda de la clase {@code Thread} para ejecutar las transferencias en un hilo separado.
 */
public class Transferencias extends Thread {

    private Banco banco;
    private int cuentaOrigen;
    private int monto;
    private Random rand;
    private boolean vivo = true;
    private int cuentaDestino;
    private Long tiempoActual;
    
    private PrintStream ps = new PrintStream(System.out);

    /**
     * Constructor para inicializar el objeto Transferencias.
     *
     * @param banco       Instancia del banco donde se realizar�n las transferencias.
     * @param cuentaOrigen N�mero de la cuenta de origen de las transferencias.
     * @param monto       Monto a transferir en cada operaci�n.
     * @param time        Tiempo actual utilizado para la inicializaci�n del generador de n�meros aleatorios.
     */
    public Transferencias(Banco banco, int cuentaOrigen, int monto, Long time) {
        this.banco = banco;
        this.cuentaOrigen = cuentaOrigen;
        this.monto = monto;
        this.tiempoActual = time;

        rand = new Random(System.currentTimeMillis());
    } // Constructor

    @Override
    public void run() {
        try {
            ps.printf("\n" + Utils.ANSI_BLUE_BACKGROUND + "\t\t\t" + Utils.ANSI_GREEN + "Inicio de Transferencia \t\t" + Utils.ANSI_RESET);
            ps.printf("\n" + Utils.ANSI_BLUE_BACKGROUND + "\t\t\t" + Utils.ANSI_GREEN + "Hilo: %s Banco:%s \t\t" + Utils.ANSI_RESET, this.currentThread().getName(), this.getName());

            while (vivo) {
                // Genera un n�mero de cuenta destino diferente a la cuenta de origen
                cuentaDestino = rand.nextInt(100);
                while (cuentaOrigen == cuentaDestino) {
                    cuentaDestino = rand.nextInt(100);
                }

                ps.printf("\n" + Utils.ANSI_BLUE_BACKGROUND + "\t\t\t" + Utils.ANSI_GREEN + "C.C:%d a C.C:Cuenta-%d  Monto:%d$ \t\t\n" + Utils.ANSI_RESET, this.cuentaOrigen, this.cuentaDestino, this.monto);

                // Realiza la transferencia
                banco.transferir(cuentaOrigen, cuentaDestino, this.monto);
                
                // Duerme el hilo por un tiempo aleatorio
                Thread.sleep(rand.nextInt(100));
                
                // Termina el ciclo de transferencia
                this.matar();
            } // while
            
            ps.printf("\n" + Utils.ANSI_BLUE_BACKGROUND + "\t\t\t" + Utils.ANSI_GREEN + "TRANSFERENCIA: %s" + Utils.ANSI_RED + " FINALIZADA \t\t\n\n" + Utils.ANSI_RESET, this.currentThread().getName());

        } catch (InterruptedException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    } // run

    /**
     * Detiene el hilo de transferencia estableciendo la bandera {@code vivo} a {@code false}.
     */
    public void matar() {
        this.vivo = false;
    }

} // class