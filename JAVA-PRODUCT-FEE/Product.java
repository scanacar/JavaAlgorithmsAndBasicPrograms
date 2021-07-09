import java.util.Date;

public class Product {
	//Attributes
	private String name;
	private String typeOfMembership;
	private Date startDate;
	private Date endDate;
	private String price;
	//Constructor
	public Product(String name, String typeOfMembership, Date startDate, Date endDate, String price) {
		this.name = name;
		this.typeOfMembership = typeOfMembership;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}
	//Getter Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeOfMembership() {
		return typeOfMembership;
	}

	public void setTypeOfMembership(String typeOfMembership) {
		this.typeOfMembership = typeOfMembership;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
