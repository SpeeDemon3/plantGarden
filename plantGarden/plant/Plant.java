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

	@Override
	public boolean itsCompatible(IPlant plant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean haveSpace(IPot pot) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
