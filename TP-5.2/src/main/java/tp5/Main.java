package tp5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class Main {
	private static final Logger log = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		
		Arbitro arbitro = new Arbitro();
		ArrayList<Equipo> equipo = new ArrayList<Equipo>();
		
		for(int i = 1; i<=4; i++) {
			equipo.add(new Equipo("Equipo: " + i, arbitro));
		}

		arbitro.iniciarCarrera();
	
		for(Equipo e : equipo) {
			e.empezarCarrera();
		}
	
		for(Equipo e : equipo) {
			for(Atleta a : e.getAtletas()) {
				try {
					a.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		arbitro.terminarCarrera(equipo);
		
	}
}
