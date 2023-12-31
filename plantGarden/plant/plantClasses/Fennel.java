package plantGarden.plant.plantClasses;

import plantGarden.enums.Species;
import plantGarden.plant.AromaticPlant;

public class Fennel extends AromaticPlant {

	public Fennel(String name) {
		super(name, 10, 8); // Distancia 10cm - Volumen 8L
		specie = Species.HINOJO;
		incompatible.add(Species.TOMATE);
		incompatible.add(Species.ZANAHORIA);
		compatible.add(Species.LECHUGA);
	}
	
}
