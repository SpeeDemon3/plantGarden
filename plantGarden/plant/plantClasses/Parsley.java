package plantGarden.plant.plantClasses;

import plantGarden.enums.Species;
import plantGarden.plant.AromaticPlant;

public class Parsley extends AromaticPlant {

	public Parsley(String name) {
		super(name, 8, 5);
		specie = Species.PEREJIL;
		incompatible.add(Species.LECHUGA);
		incompatible.add(Species.ZANAHORIA);
		compatible.add(Species.TOMATE);
	}
	
}
