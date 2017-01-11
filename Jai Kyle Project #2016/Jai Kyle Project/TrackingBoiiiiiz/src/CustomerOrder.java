import java.util.ArrayList;
public class CustomerOrder extends Order {
	private String customerID;
	private String productID;
	private String shippingAddress;
	private double totalCost;
	private Boolean requiresPW;
	
	
	public CustomerOrder(String orderID, String date, Status ey, String customerID,
			String productID, String shippingAddress,
			double totalCost, Boolean requiresPW) {
		super(orderID, date, ey);
		this.customerID = customerID;
		this.productID = productID;
		this.shippingAddress = shippingAddress;
		this.totalCost = totalCost;
		this.requiresPW = requiresPW;
	}


	public String getCustomerID() {
		return customerID;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	public String getProductID() {
		return productID;
	}


	public void setProductID(String productID) {
		this.productID = productID;
	}


	public String getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	public double getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}


	public Boolean getRequiresPW() {
		return requiresPW;
	}


	public void setRequiresPW(Boolean requiresPW) {
		this.requiresPW = requiresPW;
	}

}
