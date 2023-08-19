package plantGarden;

public interface IGarden {
	
	

	/* Añadir macetas */
	void addPots(IPot pot);
	/* Plantar plantas */
	IPot plantPlants(IPlant plant);
}
