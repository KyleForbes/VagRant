
public class Furniture extends Product implements PrintDatInfo{
	private int seatingCapacity, width;
	private String furnitureType, material;
	
	
	public Furniture(String id, int quantityOwned, int weight, String productName,
			String productType, String warehouseLocation, int seatingCapacity, int width,
			String furnitureType, String material) {
		super(id, quantityOwned, weight, productName, productType, warehouseLocation);
		this.seatingCapacity = seatingCapacity;
		this.width = width;
		this.furnitureType = furnitureType;
		this.material = material;
	}


	public int getSeatingCapacity() {
		return seatingCapacity;
	}


	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public String getFurnitureType() {
		return furnitureType;
	}


	public void setFurnitureType(String furnitureType) {
		this.furnitureType = furnitureType;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void printItFam(){
		System.out.println("Product Name: " + getProductName());
		System.out.println("Product Type" + getProductType());
		System.out.println("Furniture Type" + furnitureType);
	}
	

}
