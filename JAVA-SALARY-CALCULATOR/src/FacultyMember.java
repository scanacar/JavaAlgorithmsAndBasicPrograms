
public class FacultyMember extends Academician {
	
	public FacultyMember(String name, String regNo, int yearOfStart, int hourOfWork, double baseSalary,
			double ssBenefits, double severancePay, double totalSalary) {
		super(name, regNo, yearOfStart, hourOfWork, baseSalary, ssBenefits, severancePay, totalSalary);
		// TODO Auto-generated constructor stub
	}
	
	private String position = "FACULTY_MEMBER";
	private double addCourseFee;

	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getAddCourseFee() {
		return addCourseFee;
	}

	public void setAddCourseFee(double addCourseFee) {
		this.addCourseFee = addCourseFee;
	}
}
