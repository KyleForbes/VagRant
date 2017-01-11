
public class Entertainment extends Product{
	private String entertainmentType, material;
	private Boolean requiresElectricity;
	
	
	public Entertainment(String id, int quantityOwned, int weight,
			String productName, String warehouseLocation,String productType, String entertainmentType,
			String material, Boolean requiresElectricity) {
		super(id, quantityOwned, weight, productName, productType, warehouseLocation);
		this.entertainmentType = entertainmentType;
		this.material = material;
		this.requiresElectricity = requiresElectricity;
		
		 
	}

	public String getEntertainmentType() {
		return entertainmentType;
	}


	public void setEntertainmentType(String entertainmentType) {
		this.entertainmentType = entertainmentType;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public Boolean getRequiresElectricity() {
		return requiresElectricity;
	}


	public void setRequiresElectricity(Boolean requiresElectricity) {
		this.requiresElectricity = requiresElectricity;
	}
	
	

}
