
public class Security {
	
	private String name;
	private String regNo;
	private int yearOfStart;
	private int hourOfWork;
	private double severancePay;
	private int transMoney = 5;
	private int foodMoney = 10;
	private double totalSalary;
	private double salary;
	private String position = "SECURITY";
	
	public Security(String name, String regNo, int yearOfStart, int hourOfWork, double severancePay, double totalSalary) {
		this.name = name;
		this.regNo = regNo;
		this.yearOfStart = yearOfStart;
		this.hourOfWork = hourOfWork;
		this.severancePay = severancePay;
		this.totalSalary = totalSalary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public int getYearOfStart() {
		return yearOfStart;
	}

	public void setYearOfStart(int yearOfStart) {
		this.yearOfStart = yearOfStart;
	}

	public int getHourOfWork() {
		return hourOfWork;
	}

	public void setHourOfWork(int hourOfWork) {
		this.hourOfWork = hourOfWork;
	}

	public double getSeverancePay() {
		return severancePay;
	}

	public void setSeverancePay(double severancePay) {
		this.severancePay = severancePay;
	}

	public int getTransMoney() {
		return transMoney;
	}

	public void setTransMoney(int transMoney) {
		this.transMoney = transMoney;
	}

	public int getFoodMoney() {
		return foodMoney;
	}

	public void setFoodMoney(int foodMoney) {
		this.foodMoney = foodMoney;
	}
}
