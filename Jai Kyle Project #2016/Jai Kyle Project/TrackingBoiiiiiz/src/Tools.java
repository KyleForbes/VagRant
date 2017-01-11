
public class Tools extends Product{
	private String toolType;
	private Boolean powerTools;
	
	public Tools(String id, int quantityOwned, int weight, String productName,
			String productType, String warehouseLocation, String toolType, Boolean powerTools) {
		super(id, quantityOwned, weight, productName, productType, warehouseLocation);
		this.toolType = toolType;
		this.powerTools = powerTools;
		
		
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public Boolean getPowerTools() {
		return powerTools;
	}

	public void setPowerTools(Boolean powerTools) {
		this.powerTools = powerTools;
	}
	
	

}
