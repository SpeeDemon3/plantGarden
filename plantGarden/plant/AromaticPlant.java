package plantGarden.plant;

import plantGarden.enums.Family;

public abstract class AromaticPlant extends Plant {

	protected AromaticPlant(String name, int distance, int liters) {
		super(name, distance, liters);
		family = Family.AROMATICA;
	}

}
