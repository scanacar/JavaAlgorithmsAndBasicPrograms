
public class Worker extends FullTimeEmployee {
	
	public Worker(String name, String regNo, int yearOfStart, int hourOfWork, double severancePay,
			double overWorkSalary, double totalSalary) {
		super(name, regNo, yearOfStart, hourOfWork, severancePay, overWorkSalary, totalSalary);
		// TODO Auto-generated constructor stub
	}

	private double salaryOfDay = 105;
	private String position = "WORKER";
	

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalaryOfDay() {
		return salaryOfDay;
	}

	public void setSalaryOfDay(double salaryOfDay) {
		this.salaryOfDay = salaryOfDay;
	}
}
