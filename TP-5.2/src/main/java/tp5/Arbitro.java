package tp5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintStream;

public class Arbitro {
	
	private static final Logger log = Logger.getLogger(Arbitro.class.getName());
	private long tiempoInicio;
	PrintStream ps = new PrintStream( System.out );
	public Arbitro() {
		log.setLevel(Level.INFO);
	}
	
	
	
	public void iniciarCarrera() {
		tiempoInicio = System.currentTimeMillis();
		log.info("EMPIEZA LA CARRERA DE POSTAS \n");
	}
	
    public void registrarAvance(Equipo equipo, Atleta atleta, int tiempoEtapa) {
        long tiempoActual = System.currentTimeMillis() - tiempoInicio;
        long min = TimeUnit.MILLISECONDS.toMinutes(tiempoActual);
        long seg = TimeUnit.MILLISECONDS.toSeconds(tiempoActual) % 60;

        log.info(String.format("Equipo: %s | Atleta: %s | Actividad: %s | Tiempo acumulado: %02d:%02d minutos\n", 
                                  equipo.getNombreEquipo(), atleta.getName(), equipo.getActividadActual(), min, seg));
    }
	
    public void terminarCarrera(ArrayList<Equipo> equipo) {
    	long tiempoFin = System.currentTimeMillis();
        long tiempoTotalCarrera = tiempoFin - tiempoInicio;
        long minutosCarrera = TimeUnit.MILLISECONDS.toMinutes(tiempoTotalCarrera);
        long segundosCarrera = TimeUnit.MILLISECONDS.toSeconds(tiempoTotalCarrera) % 60;
	
		ArrayList<Equipo> podio = new ArrayList<Equipo>(equipo);
		Collections.sort(podio, new Comparator<Equipo>(){
			public int compare(Equipo e1, Equipo e2) {
				return Long.compare(e1.getTiempoTotal(), e2.getTiempoTotal());
			}
		});
	
		
	    log.info("\n--- Resultados Finales ---");
	    int posicion = 1;
	    long ultimoTiempo = -1;
	    for (int i = 0; i < podio.size(); i++) {
	        Equipo equi = podio.get(i);
	        if (equi.getTiempoTotal() != ultimoTiempo) {
	            posicion = i + 1;
	        }
	        long minutos = TimeUnit.MILLISECONDS.toMinutes(equi.getTiempoTotal());
	        long segundos = TimeUnit.MILLISECONDS.toSeconds(equi.getTiempoTotal()) % 60;
	
	        ps.printf("Posición %d: %s - Tiempo: %02d:%02d minutos\n", posicion, equi.getNombreEquipo(), minutos, segundos);
	        ultimoTiempo = equi.getTiempoTotal();
	    }
	    
	
	 
	    log.info(String.format("Carrera completada en %02d:%02d minutos.\n", minutosCarrera, segundosCarrera));

    }
}
