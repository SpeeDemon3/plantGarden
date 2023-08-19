package plantGarden.pot;

import plantGarden.enums.PotShape;

public class RectangularPot extends Pot {

	// Atributos
	private int width; /* Ancho de la maceta */
	private int potLength; /* Largo de la maceta */

	// Constructor
	public RectangularPot(String name, int tall, int width, int length) {
		super(name, tall);
		this.width = width;
		this.potLength = length;

	}
	
	@Override
	public int getSurface() {
		return width * potLength; 
	}
	
	@Override
	public PotShape getShape() {
		return PotShape.RECTANGULAR;
	}
	
}
