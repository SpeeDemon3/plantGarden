package plantGarden.plant;

import plantGarden.enums.Family;

public class RootPlant extends Plant {
	
	private int requiredDepth; /* Profundidad minima requerida para que crezca la planta */ 

	protected RootPlant(String name, int distance, int liters, int requiredDepth) {
		super(name, distance, liters);
		this.requiredDepth = requiredDepth;
		this.family = Family.RAIZ;
	}

	public int getRequiredDepth() {
		return requiredDepth;
	}

	public void setRequiredDepth(int requiredDepth) {
		this.requiredDepth = requiredDepth;
	}
	
}
