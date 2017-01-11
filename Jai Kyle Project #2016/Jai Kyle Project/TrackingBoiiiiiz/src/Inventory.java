import java.util.ArrayList;

public class Inventory {
	private ArrayList<Product> products = new ArrayList<Product>();

	
	public Inventory() {

	}
	
	//Pass any product to update and a new stock quantity
	public void updateStock(Product p, int newQuant) {
		String id = p.getId();
		for(int i = 0; i < products.size(); i++){
			if (id.equals(products.get(i).getId()));
			products.get(i).setQuantityOwned(newQuant);
		}
	}

	public void loadStock() {
		Tools t1 = new Tools("T10001", 500, 2, "Hammerfun 5000", "Claw Hammer", "T-1-0", "Hammer", false);
		Tools t2 = new Tools("T10008", 200, 20, "Megaton Hammer", "Sledgehammer", "T-1-6", "Hammer", false);
		Tools t3 = new Tools("T10024", 20, 10, "MegaChainer 5000", "Chainsaw", "T-2-8", "Saw", true);
		Tools t4 = new Tools("T10423", 650, 1, "SuperSpade 5000", "Spade", "T-3-2", "Spade", false);
		Tools t5 = new Tools("T10555", 300, 1, "Philips Screwdriver 250", "Screwdriver", "T-1-3", "Screwdriver", false);
		Furniture f1 = new Furniture("F10001", 50, 20, "SuperBench 5000", "BigBench", "F-1-0", 4, 1, "Seating", "Wood");
		Furniture f2 = new Furniture("F10023", 20, 100, "SuperBubbleBlaster 5000", "Jacuzzi", "F-6-3", 2, 4, "Seating", "Wood");
		Furniture f3 = new Furniture("F10423", 80, 10, "Mini-Table 500", "Table", "F-2-1", 0, 1, "Surface", "Dragon Bone");
		Furniture f4 = new Furniture("F15154", 1, 1000, "Mega Santa Lap 5000", "Bench", "F-3-9", 100, 200, "Seating", "Marble");
		Furniture f5 = new Furniture("F19423", 90, 5, "WaterBlock 5000", "Parasol", "F-3-6", 2, 4, "Protection", "Metal");
		Entertainment e1 = new Entertainment("E12121", 44, 12, "SuperSexyGG 5000",  "E-3-7", "Sensual Gnome", "Fun-In-The-Sun", "Ceramic", false);
		Entertainment e2 = new Entertainment("E26162", 123, 73, "SUPERFANCYLIGHT 5000",  "E-2-4", "Light", "Pretty lights", "", true);
		Entertainment e3 = new Entertainment("E85629", 53, 53, "MegaLoud 5000", "E-4-7", "Audio", "Speaker", "Plastic", true);
		Entertainment e4 = new Entertainment("E19472", 26, 18, "SuperLamp 5000", "E-1-4", "Light", "Runway light", "Metal", true);
		Entertainment e5 = new Entertainment("E73012", 79, 16, "test", "E-5-7","test", "test", "gwent", false);
		products.add(t1);
		products.add(t2);
		products.add(t3);
		products.add(t4);
		products.add(t5);
		products.add(f1);
		products.add(f2);
		products.add(f3);
		products.add(f4);
		products.add(f5);
		products.add(e1);
		products.add(e2);
		products.add(e3);
		products.add(e4);
		products.add(e5);
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}
