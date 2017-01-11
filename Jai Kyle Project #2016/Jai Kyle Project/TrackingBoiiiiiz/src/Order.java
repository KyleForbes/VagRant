
public abstract class Order {
private String orderID, date;
Status ey;

public Order(String orderID, String date, Status ey) {
	this.orderID = orderID;
	this.date = date;
	this.ey = ey;
}

public String getOrderID() {
	return orderID;
}

public void setOrderID(String orderID) {
	this.orderID = orderID;
}

public String getDate() {
	return date;
}

public Status getEy() {
	return ey;
}

public void setEy(Status ey) {
	this.ey = ey;
}

public void setDate(String date) {
	this.date = date;
}


}
