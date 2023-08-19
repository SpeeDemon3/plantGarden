package plantGarden.pot;

import java.util.HashSet;
import java.util.Set;

import plantGarden.IPlant;
import plantGarden.IPot;
import plantGarden.enums.PotShape;
import plantGarden.plant.Plant;

public abstract class Pot implements IPot {
	
	// Atributos
	private String name; /* Nombre */
	private int tall; /* Alto */
	private Set<IPlant> plants; /* Plantas que tendra la maceta */
	
	// Constructor
	public Pot (String name, int tall) {
		
		this.name = name;
		this.tall = tall;
		plants = new HashSet<>();
		
	}
	
	// Metodos

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getVolume() {
		return tall * getSurface();
	}

	@Override
	public int AvailableVolume() {
		return getVolume() - volumeOccupied();
	}
	
	private int volumeOccupied() {
		int result = 0;
		for (IPlant p : plants) {
			result += p.getRequiredSurface();
		}
		return result;
	}
	
	@Override
	public int getSurface() {
		return 0;
	}

	@Override
	public int availableSurface() {
		return getSurface() - availableSurface();
	}
	
	private int occupiedSurface() {
		int result = 0;
		for (IPlant p : plants) {
			result += p.getRequiredSurface();
		}
		
		return result;
	}

	@Override
	public int getDepth() {
		return tall;
	}

	@Override
	public PotShape getShape() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean plantPlant(IPlant plant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<IPlant> getPlants() {
		return plants;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Maceta: " + name + " [" + getShape() + 
				"] (sup " + getSurface() + "cm2 - vol " + getVolume() + "cm3).\n");
		
		if (plants.isEmpty()) {
			sb.append("\t\tvacía\n");
		}
		
		for (IPlant p : plants) {			
			sb.append("\t\t" + p + "\n");
		}
		
		sb.append("\t\t>> Disponible sup " + availableSurface() + "cm2 - vol "
				+ AvailableVolume() + "cm3");
		
		return sb.toString();
		
	}
	

}
