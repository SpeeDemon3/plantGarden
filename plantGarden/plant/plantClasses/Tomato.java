package plantGarden.plant.plantClasses;

import plantGarden.enums.Species;
import plantGarden.plant.FruitPlant;

public class Tomato extends FruitPlant {
	// Constructor para crear nuevos tomates
	public Tomato(String name) {
		this(name, 30, 18); // Utilizando this llamamos al constructor protegido que hace todo el trabajo
	}
	
	// Constructor para ser llamado por la clase hija
	protected Tomato(String name, int distance, int liters) {
		super(name, distance, liters);
		specie = Species.TOMATE;
		incompatible.add(Species.HINOJO);
		compatible.add(Species.LECHUGA);
		compatible.add(Species.PEREJIL);
		compatible.add(Species.ZANAHORIA);
	}

}
