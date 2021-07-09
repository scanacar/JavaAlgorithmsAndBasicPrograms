
public class PartTimeEmployee {
	
	private String name;
	private String regNo;
	private int yearOfStart;
	private int hourOfWork;
	private double severancePay;
	private double overWorkSalary;
	private double totalSalary;
	private String position = "PARTTIME_EMPLOYEE";
	
	public PartTimeEmployee(String name, String regNo, int yearOfStart, int hourOfWork, double severancePay,
			double overWorkSalary, double totalSalary) {
		this.name = name;
		this.regNo = regNo;
		this.yearOfStart = yearOfStart;
		this.hourOfWork = hourOfWork;
		this.severancePay = severancePay;
		this.overWorkSalary = overWorkSalary;
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

	public double getOverWorkSalary() {
		return overWorkSalary;
	}

	public void setOverWorkSalary(double overWorkSalary) {
		this.overWorkSalary = overWorkSalary;
	}
}
