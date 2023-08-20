package plantGarden.plant;

import plantGarden.IPot;
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
	
	@Override
	public boolean haveSpace(IPot pot) {
		// Variable que verifica si hay profundidad suficiente
		boolean depthOk = pot.getDepth() > requiredDepth;
		
		// Si no hay profundidad suficiente
		if (!depthOk) {
			System.out.println("--- Profundidad insuficiente para " + getName() + " en " + pot.getName());
		}
		// Retornamos true solo si recibimos 2 true, en caso contrario false
		return super.haveSpace(pot) && depthOk;
	}
}
