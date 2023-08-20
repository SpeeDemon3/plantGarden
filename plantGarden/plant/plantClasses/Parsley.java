package plantGarden.plant.plantClasses;

import plantGarden.enums.Species;
import plantGarden.plant.AromaticPlant;

public class Parsley extends AromaticPlant {

	protected Parsley(String name, int distance, int liters) {
		super(name, 8, 5);
		specie = Species.PEREJIL;
		incompatible.add(Species.LECHUGA);
		incompatible.add(Species.ZANAHORIA);
		compatible.add(Species.TOMATE);
	}
	
}
