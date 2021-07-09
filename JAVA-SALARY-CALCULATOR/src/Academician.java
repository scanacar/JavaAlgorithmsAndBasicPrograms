
public class Academician {
	
	private String name;
	private String regNo;
	private int yearOfStart;
	private int hourOfWork;
	private double baseSalary;
	private double ssBenefits;
	private double severancePay;
	private double totalSalary;
	public Academician(String name, String regNo, int yearOfStart, int hourOfWork, double baseSalary, double ssBenefits,
			double severancePay, double totalSalary) {
		this.name = name;
		this.regNo = regNo;
		this.yearOfStart = yearOfStart;
		this.hourOfWork = hourOfWork;
		this.baseSalary = baseSalary;
		this.ssBenefits = ssBenefits;
		this.severancePay = severancePay;
		this.totalSalary = totalSalary;
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
	
	
	
}
