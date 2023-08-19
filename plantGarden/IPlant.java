package plantGarden;

import plantGarden.enums.Family;
import plantGarden.enums.Species;

public interface IPlant {

	String getName();
	int getRequiredSurface(); /* Superficie requerida */
	int getRequiredVolume(); /* Volumen requerido */

	Family getFamily(); /* Familia a la que pertenece */
	Species getSpecie(); /* Especie a la que pertenece una planta */
	
	boolean itsCompatible(IPlant plant); /* Metodo para saber si una planta es compatible con otra */
	boolean haveSpace(IPot pot); /* Metodo para saber si la planta tiene espacio en la maceta */
	void plantAPlant(IPot pot); /* Metodo para plantar la planta en una maceta */
	
}
