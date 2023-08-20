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
	public int availableVolume() {
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
		return getSurface() - occupiedSurface();
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

	/**
	 * Intenta plantar una planta en la maceta actual.
	 *
	 * @param plant La planta que se intenta plantar.
	 * @return True si la planta se pudo plantar exitosamente, False si no.
	 */
	@Override
	public boolean plantPlant(IPlant plant) {
		
		System.out.println("--- PLANTANDO " + plant.getName() + " EN " + this.getName());
	    // Variable para verificar si todas las plantas existentes son compatibles
		boolean compatiblesOk = true;
		
	    // Iterar a traves de las plantas existentes en la maceta para verificar compatibilidad
		for (IPlant p : plants) {
	        // Verificar si la planta actual es compatible con la planta a plantar
			boolean compatibleOk = plant.itsCompatible(p);
	        // Si no son compatibles, mostrar un mensaje informativo
			if (!compatibleOk) {
				System.out.println("--- " + p.getName() + " no es compatible con" 
						+ plant.getName());
			}
	        // Actualizar la variable de compatibilidad general
			compatiblesOk &= compatibleOk;
		}
		
		// Variable para comprobar si la planta entra en la maceta o no
		boolean fitPlant = false;
	    // Si todas las plantas son compatibles, verificar si la planta puede caber en la maceta
		if (compatiblesOk) {
			// Comprobamos si tiene espacio en esta maceta indicandolo con this
			fitPlant = plant.haveSpace(this);
		}
		
	    // Si la planta puede caber en la maceta, agregarla a la colección de plantas y plantarla
		if (fitPlant) {
			// Añadimos la planta a la coleccion de plantas
			plants.add(plant);
			// Añadimos la planta a la maceta
			plant.plantAPlant(this);
		}
	    // Retornar true si la planta fue plantada exitosamente, o false si no cabe o no es compatible
		return fitPlant;
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
				+ availableVolume() + "cm3");
		
		return sb.toString();
		
	}
	

}
