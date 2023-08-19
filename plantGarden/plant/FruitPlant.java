package plantGarden.plant;

import plantGarden.enums.Family;

public abstract class FruitPlant extends Plant {

	protected FruitPlant(String name, int distance, int liters) {
		super(name, distance, liters);
		family = Family.FRUTO;
	}

}
