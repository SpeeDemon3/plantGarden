package plantGarden.plant.plantClasses;

import plantGarden.enums.Species;
import plantGarden.plant.RootPlant;

public class Carrot extends RootPlant {

	public Carrot(String name) {
		super(name, 10, 3, 25);
		specie = Species.ZANAHORIA;
		incompatible.add(Species.PEREJIL);
		incompatible.add(Species.HINOJO);
		compatible.add(Species.TOMATE);
		compatible.add(Species.LECHUGA);
	}

}
