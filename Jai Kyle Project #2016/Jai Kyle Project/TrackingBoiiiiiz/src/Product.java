
public abstract class Product {
	private int quantityOwned, weight;
	private String id, productName, productType, warehouseLocation;
	
	
	public Product(String id, int quantityOwned, int weight, String productName,
			String productType, String warehouseLocation) {
		this.id = id;
		this.quantityOwned = quantityOwned;
		this.weight = weight;
		this.productName = productName;
		this.productType = productType;
		this.warehouseLocation = warehouseLocation;
	}


	public String getWarehouseLocation() {
		return warehouseLocation;
	}


	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getQuantityOwned() {
		return quantityOwned;
	}


	public void setQuantityOwned(int quantityOwned) {
		this.quantityOwned = quantityOwned;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}
