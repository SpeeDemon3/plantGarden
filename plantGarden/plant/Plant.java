package plantGarden.plant;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import plantGarden.IPlant;
import plantGarden.IPot;
import plantGarden.enums.Family;
import plantGarden.enums.Species;

public class Plant implements IPlant {
	
	// Atributos
	protected Species specie; /* Especie a la que pertenece la planta */
	protected Family family; /* Familia a la que pertenece la planta */
	protected Set<Species> incompatible; /* conjunto de especies incompatibles */
	protected Set<Species> compatible; /* Conjunto de especies compatibles */

	private String name; /* Nombre */
	private int requiredSurface; /* Superficie requerida en cm2 que hay que reservar para cada planta */
	private int requiredVolume; /* Volumen requerida en cm3 de sustrato que reservaremos para la planta */
	protected Date plantingDate; /* Fecha en la que se siembra la semilla */
	protected IPot pot; /* Maceta en la que a sido plantada la planta */
	
	// Constructor
	protected Plant(String name, int distance, int liters) {
		
		this.name = name;
		this.requiredSurface = distance^2;
		this.requiredVolume = liters * 1000;
		incompatible = new HashSet<>(); // Inicializamos
		compatible = new HashSet<>(); // Inicializamos
		
	}

	
	// Metodos
	
	public void setRequiredSurface(int requiredSurface) {
		this.requiredSurface = requiredSurface;
	}
	
	public int getRequiredSurface() {
		return requiredSurface;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void setRequiredVolume(int volume) {
		this.requiredVolume = volume;
	}

	@Override
	public int getRequiredVolume() {
		return requiredVolume;
	}
	
	public void setFamily(Family family) {
		this.family = family;
	}

	@Override
	public Family getFamily() {
		return family;
	}

	public void setSpecie(Species specie) {
		this.specie = specie;
	}
	
	@Override
	public Species getSpecie() {
		return specie;
	}
	
	@Override
	public void plantAPlant(IPot pot) {

		plantingDate = new Date();
		this.pot = pot;
		
	}
	
	@Override
	public String toString() {
		
		return "Planta " + name + " [especie= " + specie + ", familia= " + family
				+ ", superficieRequerida= " + requiredSurface + ", volumenRequerido= "
				+ requiredVolume + ", incompatibles= " + incompatible 
				+ ", fechaSiembra= " + plantingDate 
				+ (pot != null ? ", maceta= " + pot.getName() : "");
		
	}

	/**
	 * Verifica si la planta actual es compatible con otra planta especifica.
	 *
	 * @param plant La planta con la que se verifica la compatibilidad.
	 * @return True si la planta actual es compatible con la planta dada, False si no.
	 */
	@Override
	public boolean itsCompatible(IPlant plant) {

		boolean isCompatible = true;
		
	    // Verificar si las especies son diferentes
		if (!specie.equals(plant.getSpecie())) {
	        // Si la especie de la planta actual no está en la lista de compatibles de la planta dada
			if (!this.compatible.contains(plant.getSpecie())) {
				
	            // Verificar si las familias son diferentes
				isCompatible &= !family.equals(plant.getFamily());

				// Verificar si la especie de la planta dada está en la lista de incompatibles de la actual
				isCompatible &= !incompatible.contains(plant.getSpecie());
				
			}
			
		}
		
		return isCompatible;
	}

	/**
	 * Verifica si la maceta tiene suficiente espacio para albergar la planta actual.
	 *
	 * @param pot La maceta en la que se verifica el espacio.
	 * @return True si la maceta tiene suficiente espacio, False si no.
	 */
	@Override
	public boolean haveSpace(IPot pot) {
	    // Verificar si la superficie disponible en la maceta es suficiente para la planta actual
		boolean surfaceOk = pot.availableSurface() > getRequiredSurface();
		
	    // Si la superficie no es suficiente, mostrar mensaje de advertencia
		if (!surfaceOk) {
			System.out.println("--- Superficie insuficiente para " + getName() + " en " + pot.getName());
		}
		
	    // Verificar si el volumen disponible en la maceta es suficiente para la planta actual
		boolean volumeOk = pot.availableVolume() > getRequiredVolume();
		
	    // Si el volumen no es suficiente, mostrar mensaje de advertencia
		if (!volumeOk) {
			System.out.println("--- Volumen insuficiente pera " + getName() + " en " + pot.getName());
		}
		
	    // Retornar True si tanto la superficie como el volumen son suficientes, False si no lo son
		return surfaceOk && volumeOk;
	}

	
	
}
