package plantGarden.plant;

import plantGarden.enums.Family;

public abstract class LeafPlant extends Plant {

	protected LeafPlant(String name, int distance, int liters) {
		super(name, distance, liters);
		family = Family.HOJA;
	}

}
