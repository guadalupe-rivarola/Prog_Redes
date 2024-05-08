package Readers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Colecciones {

		//colecciones: variables donde se pueden guardar más de 1 dato a la vez
	//vector
	int[] vector = new int[5];
	
	//list interfaz (se crea un objeto de la interfaz y le meto una clase del objeto arraylist)
	//arraylist clase (va ser un objeto y le meto adentro una clase del objeto de arraylist)
	
	//agrerar: minima eficiencia
	//lectura: muy eficiente
	ArrayList<String> frutas = new ArrayList<>();
	ArrayList verduras = new ArrayList<>();

	List nombre = new ArrayList<>(); //List padre y puede meter adentro todos. 
	List<String> apellido = new ArrayList<>();
	
	//son iguales a los list
	//agrerar maxima eficiencia
	//lectura cero eficiente
	LinkedList<String> componentesPc = new LinkedList<>();

	LinkedHashMap<String, String> listaEspañolIngles = new LinkedHashMap<>();
	Map<Integer,Integer> valores = new LinkedHashMap<>();

	LinkedHashSet<Integer> listaEspañol = new LinkedHashSet<>();
	Set<Integer> valores2 = new LinkedHashSet<>();

	//			k ,	v
	HashMap<String, String> españolRAE = new HashMap<>();

	Map<String,Integer> españolIngles = new HashMap();

	HashSet<String> claves = new HashSet<>();
	Set<Integer> DNI = new HashSet<>();
	
	public void Array() {
		frutas.add(""); //agrega
		verduras.add(5); 
		verduras.add("s");
		
		frutas.clear(); // vacia por completo
		
		//elimina uno en especifico
		frutas.remove(4); //borra loo que este en la pocicion 5
		frutas.remove("manzana"); // busca y borra ese dato especifico
		
		verduras.contains("tomate"); //devuleve true/folse si contiene o no el dato
		verduras.containsAll(new ArrayList<>()); //verifica que esten todos  
		
		frutas.get(5); //devuelve lo que esta en la posicion 5
		frutas.indexOf("banana"); // busca banana y devuelve la posicion
		
		verduras.isEmpty();//verifica si la lista esta vacia
		verduras.size(); //verifica la cantidad de elementos que tiene la lista
		
		Object[] ver = verduras.toArray();
		
		//si tenemos un Map/HashMAp podemos transformarlo en un arraylist
		Collection<String> valores = españolRAE.values();
	} 
	
	public void Recorridos() {
		// FOR normal
		for (int i = 0; i <= frutas.size(); i++) {
			frutas.get(i);
		}

		// FOR EACH
		for (String item : frutas) {
			System.out.println(item);
		}
		
		//while
		Iterator it = frutas.iterator();
		while (it.hasNext()) {
			it.remove();
			it.next();
		}

		////// MAP's &      SET's
		// MAP(k,v)         SET(k)
		for(String traduccion : españolRAE.keySet()) {}
		
		for(String traduccion : españolRAE.values()) {}
		
		Iterator it2 = españolRAE.keySet().iterator();
		while (it2.hasNext()) {
			Object key = it2.next(); // k
			españolRAE.get(key);     // v
		}
		
		for(Map.Entry<String, String> e : españolRAE.entrySet()){
			e.getKey();
			e.getValue();
		} 
		
		//opcion 1 para ordenar la clase que quiero ordenar
		//ordena por orden de numero y orden alfabetico
		//Collections.sort(verduras);
		
		//opcion 2
		Collections.sort(verduras , Collections.reverseOrder() );
		
	}
}
