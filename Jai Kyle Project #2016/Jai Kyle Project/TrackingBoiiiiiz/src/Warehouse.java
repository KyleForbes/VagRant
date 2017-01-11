import java.util.ArrayList;

public class Warehouse {
	// store incoming customer orders
	private ArrayList<CustomerOrder> orderList = new ArrayList<CustomerOrder>();
	// order of item pickup
	private String quickestPath;
	// Store the items ordered by a customer
	private String orderP = "";
	// create testing customer orders
	int counter;
	// store incoming purchased stock
	private ArrayList<PurchaseOrder> poList = new ArrayList<PurchaseOrder>();

	public ArrayList<CustomerOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<CustomerOrder> orderList) {
		this.orderList = orderList;
	}

	public Warehouse(Inventory i) {

	}

	public void loadOrders(){
		Tools t3 = new Tools("T10024", 20, 10, "MegaChainer 5000", "Chainsaw", "T-2-8", "Saw", true);
		Tools t4 = new Tools("T10423", 650, 1, "SuperSpade 5000", "Spade", "T-3-2", "Spade", false);
		Furniture f2 = new Furniture("F10023", 20, 100, "SuperBubbleBlaster 5000", "Jacuzzi", "F-6-3", 2, 4, "Seating", "Wood");
		Furniture f3 = new Furniture("F10423", 80, 10, "Mini-Table 500", "Table", "F-2-1", 0, 1, "Surface", "Dragon Bone");
		Entertainment e1 = new Entertainment("E12121", 44, 12, "SuperSexyGG 5000", "Sensual Gnome", "E-3-7", "Fun-In-The-Sun", "Ceramic", false);
		Entertainment e2 = new Entertainment("E26162", 123, 73, "SUPERFANCYLIGHT 5000", "Light", "E-2-4", "Pretty lights", "", true);
		orderP = t3.getId() + " " + t4.getId() + " " + f2.getId() + " " + f3.getId() + " " + e1.getId() + " " + e2.getId();
		CustomerOrder o1 = new CustomerOrder("C10001", "19/03/55", Status.PENDING, "1125643", orderP, "123 privet drive", 699.99, false);
		orderList.add(o1);
		System.out.println(orderP);
		Tools t1 = new Tools("T10001", 500, 2, "Hammerfun 5000", "Claw Hammer", "T-1-0", "Hammer", false);
		Tools t2 = new Tools("T10008", 200, 20, "Megaton Hammer", "Sledgehammer", "T-3-6", "Hammer", false);
		Furniture f4 = new Furniture("F15154", 1, 1000, "Mega Santa Lap 5000", "Bench", "F-2-9", 100, 200, "Seating", "Marble");
		Furniture f5 = new Furniture("F19423", 90, 5, "WaterBlock 5000", "Parasol", "F-1-6", 2, 4, "Protection", "Metal");
		Entertainment e4 = new Entertainment("E19472", 26, 18, "SuperLamp 5000", "Light", "E-4-4", "Runway light", "Metal", true);
		Entertainment e5 = new Entertainment("E73012", 79, 16, "test", "test", "E-5-7", "test", "gwent", false);
		orderP = t1.getId() + " " + t2.getId() + " " + f4.getId() + " " + f5.getId() + " " + e4.getId() + " " + e5.getId();
		CustomerOrder o2 = new CustomerOrder("C10015", "12/11/52", Status.DISPATCHED, "3213197", orderP, "221 Beaconsfield Road", 422.11, false);
		orderList.add(o2);
		System.out.println(orderP);
		
	}

	public void checkOutOrder(Order o, Status newStatus) {
		for (int i = 0; i < orderList.size(); i++) {
			if (o.getOrderID().equals(orderList.get(i).getOrderID())) {
				orderList.get(i).setEy(newStatus);
			}
		}
	}

	public void prepareOrder(ArrayList<Product> p1) {

	}

	// Orders not yet checked out
	public void listOrders(Status currentStatus) {
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getEy() == currentStatus) {
				System.out.println(orderList.get(i).getOrderID());
			}
		}
	}

	// inform accounts that the order has been fulfilled
	public void updateAccounts(PurchaseOrder py) {
		for (int i = 0; i < poList.size(); i++) {
			if (poList.get(i).getOrderID().equals(py.getOrderID())) {
				poList.get(i).setEy(Status.DELIVERED);
			}
		}

	}

	public void updateAccounts(CustomerOrder c) {
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderID().equals(c.getOrderID())) {
				orderList.get(i).setEy(Status.DELIVERED);
			}
		}
	}

}
