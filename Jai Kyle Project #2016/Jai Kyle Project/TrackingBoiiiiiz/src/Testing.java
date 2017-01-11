 import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Testing {

	@Test
	public void testCustomer() {
		Customer c1 = new Customer("John", "Hamm", "A100001", "07554556998", "123, Privet Drive");
		assertEquals("John", c1.getFirstName());
		assertEquals("Hamm", c1.getLastName());
		assertEquals("A100001", c1.getID());
		assertEquals("07554556998", c1.getPhoneNumber());
		assertEquals("123, Privet Drive", c1.getAddress());
	}
	

	@Test
	public void testCustomerOrder() {
		Tools t1 = new Tools("T10001", 500, 100, "Hammerfun 5000", "Claw Hammer", "T-A-0", "Hammer", false);
		ArrayList<Product> p1 = new ArrayList<Product>();
		p1.add(t1);
		CustomerOrder co1 = new CustomerOrder("CO1121123", "24/12/01", Status.PENDING, "A100001", p1, "123, Privet Drive", 600.55, false);
		assertEquals("CO1121123", co1.getOrderID());
		assertEquals("24/12/01", co1.getDate());
		assertEquals("A100001", co1.getCustomerID());
		assertEquals("T10001", p1.get(0).getId());
		assertEquals("123, Privet Drive", co1.getShippingAddress());
		assertEquals(600.55, co1.getTotalCost(), 0);
		assertEquals(false, co1.getRequiresPW()); 
		
	}
	
	@Test
	public void testEntertainment() {
		Entertainment e1 = new Entertainment("E10001", 500, 100, "SuperSexyGnome5000", "Large Gnome", "E-A-0", "Gnome", "Ceramic", false);
		assertEquals("E10001", e1.getId());
		assertEquals(500, e1.getQuantityOwned());
		assertEquals(100, e1.getWeight());
		assertEquals("SuperSexyGnome5000", e1.getProductName());
		assertEquals("Large Gnome", e1.getProductType());
		assertEquals("Gnome", e1.getEntertainmentType());
		assertEquals("Ceramic", e1.getMaterial());
		assertEquals(false, e1.getRequiresElectricity());
	}
	
	@Test
	public void testFurniture() {
		Furniture f1 = new Furniture("F10001", 500, 100, "SuperBench5000", "BigBench", "F-A-0", 4, 500, "Seating", "Wood");
		assertEquals("F10001", f1.getId());
		assertEquals(500, f1.getQuantityOwned());
		assertEquals(100, f1.getWeight());
		assertEquals("SuperBench5000", f1.getProductName());
		assertEquals("BigBench", f1.getProductType());
		assertEquals(4, f1.getSeatingCapacity());
		assertEquals(500, f1.getWidth());
		assertEquals("Seating", f1.getFurnitureType());
		assertEquals("Wood", f1.getMaterial());
		
		
	}
	
	@Test
	public void testGooey() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInventory() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testLetsaGo() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void testPrintDatInfo() {
		Furniture f1 = new Furniture("F10001", 500, 100, "SuperBench5000", "BigBench", "F-A-0", 4, 500, "Seating", "Wood");
		f1.printItFam();
	}

	
	@Test
	public void testPurchaseOrder() {
		Tools t1 = new Tools("T10001", 500, 100, "Hammerfun 5000", "Claw Hammer", "T-A-0", "Hammer", false);
		ArrayList<Product> p1 = new ArrayList<Product>();
		p1.add(t1);
		PurchaseOrder po1 = new PurchaseOrder("PO100001", "24/04/1992", Status.PENDING, 6999.99, p1);
		
		assertEquals("PO100001", po1.getOrderID());
		assertEquals("24/04/1992", po1.getDate());
		assertEquals(6999.99, po1.getCost(), 0);
		assertEquals(p1, po1.getProductID());
	}
	
	@Test
	public void testTools() {
		Tools t1 = new Tools("T10001", 500, 100, "Hammerfun 5000", "Claw Hammer", "T-A-0", "Hammer", false);
		assertEquals("T10001", t1.getId());
		assertEquals(500, t1.getQuantityOwned());
		assertEquals(100, t1.getWeight());
		assertEquals("Hammerfun 5000", t1.getProductName());
		assertEquals("Claw Hammer", t1.getProductType());
		assertEquals("Hammer", t1.getToolType());
		assertEquals(false, t1.getPowerTools());
	}
	 
	@Test
	public void testUpdateStock(){
		Inventory i = new Inventory();
		Furniture f1 = new Furniture("F10001", 500, 100, "SuperBench5000", "BigBench", "F-A-0", 4, 500, "Seating", "Wood");
		//product, and new stock quantity
		i.updateStock(f1, 6000);
		assertEquals(6000, f1.getQuantityOwned());
		
	}
	
	@Test
	public void testLoadStock(){
		Inventory i = new Inventory();
		i.loadStock();
		assertNotNull(i.products);
	}
	
	@Test
	public void testCheckOutOrder(){
		Tools t1 = new Tools("T10001", 500, 100, "Hammerfun 5000", "Claw Hammer", "T-A-0", "Hammer", false);
		ArrayList<Product> p1 = new ArrayList<Product>();
		p1.add(t1);
		PurchaseOrder po1 = new PurchaseOrder("PO100001", "24/04/1992", Status.PENDING, 6999.99, p1);
		Inventory i = new Inventory();
		Warehouse w = new Warehouse(i);
		CustomerOrder co1 = new CustomerOrder("CO1121123", "24/12/01", Status.PENDING, "A100001", p1, "123, Privet Drive", 600.55, false);
		w.checkOutOrder(co1, Status.PROCESSING);
		assertEquals(Status.PROCESSING, co1.getEy());
		
	}
	
	@Test
	public void testPrepareOrder(){
		Tools t1 = new Tools("T10001", 500, 100, "Hammerfun 5000", "Claw Hammer", "T-A-0", "Hammer", false);
		ArrayList<Product> p1 = new ArrayList<Product>();
		Inventory i = new Inventory();
		Warehouse w = new Warehouse(i);
		p1.add(t1);
		prepareOrder(p1);
		assertEquals("t10001, t20002, t30003", w.getQuickestPath());
	}
	
	@Test
	public void testListOrders(){
		Tools t1 = new Tools("T10001", 500, 100, "Hammerfun 5000", "Claw Hammer", "T-A-0", "Hammer", false);
		Inventory i = new Inventory();
		Warehouse w = new Warehouse(i);
		ArrayList<Product> p1 = new ArrayList<Product>();
		p1.add(t1);
		CustomerOrder co1 = new CustomerOrder("CO1121123", "24/12/01", Status.PENDING, "A100001", p1, "123, Privet Drive", 600.55, false);
		w.listOrders(Status.PENDING);
		assertTrue(co1.getProductID().get(0).getProductName().equals(t1.getProductName()));
		
	}
	
	@Test
	public void updateAccounts(){
		Tools t1 = new Tools("T10001", 500, 100, "Hammerfun 5000", "Claw Hammer", "T-A-0", "Hammer", false);
		Inventory i = new Inventory();
		Warehouse w = new Warehouse(i);
		ArrayList<Product> p1 = new ArrayList<Product>();
		p1.add(t1);
		CustomerOrder co1 = new CustomerOrder("CO1121123", "24/12/01", Status.PENDING, "A100001", p1, "123, Privet Drive", 600.55, false);
		w.updateAccounts(co1, Status.DELIVERED);
		assertSame(co1.getEy(), Status.DELIVERED);
		PurchaseOrder po1 = new PurchaseOrder("PO100001", "24/04/1992", Status.PENDING, 6999.99, p1);
		w.updateAccounts(po1);
		assertEquals(Status.PROCESSING, po1.getEy());
	}
	
	
}
