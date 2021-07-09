
public class Officer {
	
	private String name;
	private String regNo;
	private int yearOfStart;
	private int hourOfWork;
	private double baseSalary;
	private double ssBenefits;
	private double severancePay;
	private double workSalary;
	private double totalSalary;
	private String position = "OFFICER";
	
	public Officer(String name, String regNo, int yearOfStart, int hourOfWork, double baseSalary, double ssBenefits,
			double severancePay, double workSalary, double totalSalary) {
		this.name = name;
		this.regNo = regNo;
		this.yearOfStart = yearOfStart;
		this.hourOfWork = hourOfWork;
		this.baseSalary = baseSalary;
		this.ssBenefits = ssBenefits;
		this.severancePay = severancePay;
		this.workSalary = workSalary;
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

	public int getHourOfWork() {
		return hourOfWork;
	}

	public void setHourOfWork(int hourOfWork) {
		this.hourOfWork = hourOfWork;
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

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public double getSsBenefits() {
		return ssBenefits;
	}

	public void setSsBenefits(double ssBenefits) {
		this.ssBenefits = ssBenefits;
	}

	public double getSeverancePay() {
		return severancePay;
	}

	public void setSeverancePay(double severancePay) {
		this.severancePay = severancePay;
	}

	public double getWorkSalary() {
		return workSalary;
	}

	public void setWorkSalary(double workSalary) {
		this.workSalary = workSalary;
	}
}
