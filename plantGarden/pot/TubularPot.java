package plantGarden.pot;

import plantGarden.enums.PotShape;

public class TubularPot extends Pot{
	
	// Atributos
	private int diameter; // Diametro de la maceta 

	// Constructor
	public TubularPot(String name, int tall, int diameter) {
		super(name, tall);
		this.diameter= diameter;
	}
	
	@Override
	public int getSurface() {
		return (int) (Math.PI * (diameter / 2) * (diameter / 2));
	}
	
	@Override
	public PotShape getShape() {
		return PotShape.TUBULAR;
	}

}
