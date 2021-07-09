
public class Bill {
	
	// Attributes
	private String productName;
	private float unitPrice;
	private int quantity;
	private float total;
	//Constructor
	public Bill(String productName, float unitPrice, int quantity, float total) {
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.total = total;
	}
	//Getter Setters
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
