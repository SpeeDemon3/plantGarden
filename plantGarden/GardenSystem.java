package plantGarden;

import java.util.ArrayList;
import java.util.List;

import plantGarden.plant.plantClasses.Carrot;
import plantGarden.plant.plantClasses.CherryTomato;
import plantGarden.plant.plantClasses.Fennel;
import plantGarden.plant.plantClasses.Lettuce;
import plantGarden.plant.plantClasses.Tomato;
import plantGarden.plant.plantClasses.Parsley;
import plantGarden.pot.RectangularPot;
import plantGarden.pot.TubularPot;

/**
 * @author Antonio Ruiz Benito -> SpeedDemoN
 */
public class GardenSystem {

	public static void main(String[] args) {

		// Creo el huerto
		IGarden garden = new VegetablePatch("huerto");
		
		// Creo 3 macetas
		IPot pot1 = new RectangularPot("Maceta R1", 21, 21, 21);
		IPot pot2 = new TubularPot("maceta T2", 25, 16);
		IPot pot3 = new TubularPot("Maceta T2", 40, 40);
		
		// Añado las macetas al huerto
		garden.addPots(pot1);
		garden.addPots(pot2);
		garden.addPots(pot3);
		
		System.out.println("Prueba-> " + garden);
		
		// Creo plantas
		IPlant plantTest = new Tomato("Test");
		IPlant cherry = new CherryTomato("Tomate cherry");
		IPlant chard = new Lettuce("Acelga");
		IPlant carrot = new Carrot("Zanahoria");
		IPlant parsley = new Parsley("Perejil");
		IPlant fennel = new Fennel("Hinojo");
		List<Carrot> carrots = new ArrayList<>();
		
		for (int i = 0; i <= 10; i++) {
			Carrot c = new Carrot("Zanahoria española" + (i + 1));
			carrots.add(c);
		}
		
		// Planto las plantas
		garden.plantPlants(plantTest);
		
		IPot cherryPot = garden.plantPlants(cherry);
		paintResultsPlanting(cherry, cherryPot);
		
		
		IPot chardPot = garden.plantPlants(chard);
		paintResultsPlanting(chard, chardPot);
		
		IPot carrotPot = garden.plantPlants(carrot);
		paintResultsPlanting(carrot, carrotPot);
		
		IPot parsleyPot = garden.plantPlants(parsley);
		paintResultsPlanting(parsley, parsleyPot);
		
		IPot fennelPot = garden.plantPlants(fennel);
		paintResultsPlanting(fennel, fennelPot);
		
		for (Carrot c : carrots) {
			IPot carrotsPot = garden.plantPlants(c);
			paintResultsPlanting(c, carrotsPot);
		}
		
		
		System.out.println("Huerto Prueba con todas las plantas :\n" + garden);
		
	}

	public static void paintResultsPlanting(IPlant plant, IPot pot) {
		if (pot != null) {
			System.out.println("He plantado " + plant.getName() + " en " + pot.getName());
		} else {
			System.out.println("No he podido plantar " + plant.getName());
		}
	}
	
}
