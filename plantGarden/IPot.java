package plantGarden;

import java.util.Set;

import plantGarden.enums.PotShape;

public interface IPot {
	
	String getName(); /* Nombre de la maceta */
	int getVolume(); /* Volumen total */
	int availableVolume(); /* Volumen disponible en la maceta */
	int getSurface(); /* Superficie total */
	int availableSurface(); /* Superficie disponible en la maceta */
	int getDepth();/* Profundidad disponible */
	
	PotShape getShape(); /* Forma de la maceta */
	boolean plantPlant(IPlant plant); /* Plantar planta en la maceta */
	Set<IPlant> getPlants();/* Conjunto de plantas que tenemos */
	
}
