
public class ResearchAssistant extends Academician {

	public ResearchAssistant(String name, String regNo, int yearOfStart, int hourOfWork, double baseSalary,
			double ssBenefits, double severancePay, double totalSalary) {
		super(name, regNo, yearOfStart, hourOfWork, baseSalary, ssBenefits, severancePay, totalSalary);
		// TODO Auto-generated constructor stub
	}
	
	private String position = "RESEARCH_ASSISTANT";

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
