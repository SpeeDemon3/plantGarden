package plantGarden.plant.plantClasses;

import plantGarden.enums.Species;
import plantGarden.plant.LeafPlant;

public class Lettuce extends LeafPlant {

	public Lettuce(String name) {
		super(name, 12, 22);
		specie = Species.LECHUGA;
		compatible.add(Species.TOMATE);
		compatible.add(Species.ZANAHORIA);
	}

}
