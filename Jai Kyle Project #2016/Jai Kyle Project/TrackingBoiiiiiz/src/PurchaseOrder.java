import java.util.ArrayList;
public class PurchaseOrder extends Order{
	private double cost;
	private String productID;
	
	
	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public String getProductID() {
		return productID;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public PurchaseOrder(String orderID, String date, Status ey, double cost,
			String productID) {
		super(orderID, date, ey);
		this.cost = cost;
		this.productID = productID;
	}
	
}
