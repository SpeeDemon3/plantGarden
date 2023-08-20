package plantGarden;

import java.util.HashSet;
import java.util.Set;

public class VegetablePatch implements IGarden {
	
	// Atributos
	private String name;
	private Set<IPot> pots;
	
	// Constructor
	public VegetablePatch(String name) {
		this.name = name;
		pots = new HashSet<>();
	}

	@Override
	public void addPots(IPot pot) {
		pots.add(pot);
	}

	@Override
	public IPot plantPlants(IPlant plant) {
		// Recorremos todas las macetas
		for (IPot pot : pots) {
			
			if (pot.plantPlant(plant)) { // Si se puede plantar la planta
				
				return pot; // Devolvemos la maceta
			}
			
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Huerto: " + name + "\n");
		// Recorremos todas las macetas
		for (IPot pot : pots) {
			// Añadimos cada maceta
			sb.append("\t" + pot + "\n");
		}
		
		return sb.toString();
	}

}
