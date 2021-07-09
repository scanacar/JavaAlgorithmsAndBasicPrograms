import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Program {
	//Program function - it splits arrays and creates objects
	public static void Program (String[] personnelArray, String[] monitorArray,ArrayList<FacultyMember> facultyMembers,
			ArrayList<ResearchAssistant> researchAssistants, ArrayList<Officer> officers, ArrayList<PartTimeEmployee> partTimeEmployees,
			ArrayList<Worker> workers, ArrayList<Chief> chiefs,ArrayList<Security> securities) {
		
		String[] splitLine;
		
		for (String line : personnelArray) {
			splitLine = line.split("\t");
			
			if (splitLine[2].equals("FACULTY_MEMBER")) {
				Main.facultyMembers.add(new FacultyMember(splitLine[0],splitLine[1],Integer.parseInt(splitLine[3]),0,0,0,0,0));
			}
			else if (splitLine[2].equals("RESEARCH_ASSISTANT")) {
				Main.researchAssistants.add(new ResearchAssistant(splitLine[0],splitLine[1],Integer.parseInt(splitLine[3]),0,0,0,0,0));
			}
			else if (splitLine[2].equals("OFFICER")) {
				Main.officers.add(new Officer(splitLine[0],splitLine[1],Integer.parseInt(splitLine[3]),0,0,0,0,0,0));
			}
			else if (splitLine[2].equals("PARTTIME_EMPLOYEE")) {
				Main.partTimeEmployees.add(new PartTimeEmployee(splitLine[0],splitLine[1],Integer.parseInt(splitLine[3]),0,0,0,0));
			}
			else if (splitLine[2].equals("WORKER")) {
				Main.workers.add(new Worker(splitLine[0],splitLine[1],Integer.parseInt(splitLine[3]),0,0,0,0));
			}
			else if (splitLine[2].equals("CHIEF")) {
				Main.chiefs.add(new Chief(splitLine[0],splitLine[1],Integer.parseInt(splitLine[3]),0,0,0,0));
			}
			else if (splitLine[2].equals("SECURITY")) {
				Main.securities.add(new Security(splitLine[0],splitLine[1],Integer.parseInt(splitLine[3]),0,0,0));
			}
		}
		
		for (String line : monitorArray) {
			splitLine = line.split("\t");
			//Setting information of facultymember to attributes
			for (FacultyMember fm : Main.facultyMembers) {
				if (fm.getRegNo().equals(splitLine[0])) {
					fm.setHourOfWork(Integer.parseInt(splitLine[1])+Integer.parseInt(splitLine[2])+Integer.parseInt(splitLine[3])+
							Integer.parseInt(splitLine[4]));
					fm.setBaseSalary(2600);
					fm.setSsBenefits(fm.getBaseSalary()*1.35);
					fm.setSeverancePay((2020-fm.getYearOfStart())*16);
					
					for (int i = 1;i<5;i++) {
						fm.setAddCourseFee(fm.getAddCourseFee()+
								((Integer.parseInt(splitLine[i]) - 40)/ 8 >= 1 ? 160 : (Integer.parseInt(splitLine[i])-40)*20));
					}
					fm.setTotalSalary(fm.getBaseSalary()+fm.getSsBenefits()+fm.getSeverancePay()+fm.getAddCourseFee());
				}
			}
			//Setting information of researchassistant to attributes
			for (ResearchAssistant ra : Main.researchAssistants) {
				if (ra.getRegNo().equals(splitLine[0])) {
					ra.setHourOfWork(Integer.parseInt(splitLine[1])+Integer.parseInt(splitLine[2])+Integer.parseInt(splitLine[3])+
							Integer.parseInt(splitLine[4]));
					ra.setBaseSalary(2600);
					ra.setSsBenefits(ra.getBaseSalary()*1.05);
					ra.setSeverancePay((2020-ra.getYearOfStart())*16);
					ra.setTotalSalary(ra.getBaseSalary()+ra.getSsBenefits()+ra.getSeverancePay());
				}
			}
			//Setting information of officer to attributes
			for (Officer of : Main.officers) {
				if (of.getRegNo().equals(splitLine[0])) {
					of.setHourOfWork(Integer.parseInt(splitLine[1])+Integer.parseInt(splitLine[2])+Integer.parseInt(splitLine[3])+
							Integer.parseInt(splitLine[4]));
					of.setBaseSalary(2600);
					of.setSsBenefits(of.getBaseSalary()*0.65);
					of.setSeverancePay((2020-of.getYearOfStart())*16);
					
					for (int i = 1;i<5;i++) {
						of.setWorkSalary(of.getWorkSalary()+
								((Integer.parseInt(splitLine[i]) - 40)/10 >= 1 ? 200 : (Integer.parseInt(splitLine[i])-40)*20));
					}
					of.setTotalSalary(of.getBaseSalary()+of.getSsBenefits()+of.getSeverancePay()+of.getWorkSalary());
				}
			}
			//Setting information of parttimeemployee to attributes
			for (PartTimeEmployee pte : Main.partTimeEmployees) {
				if (pte.getRegNo().equals(splitLine[0])) {
					pte.setHourOfWork(Integer.parseInt(splitLine[1])+Integer.parseInt(splitLine[2])+Integer.parseInt(splitLine[3])+
							Integer.parseInt(splitLine[4]));
					pte.setSeverancePay((2020-pte.getYearOfStart())*16);
					
					if (Integer.parseInt(splitLine[1])>= 10 && Integer.parseInt(splitLine[1]) <= 20) {
						pte.setOverWorkSalary(pte.getOverWorkSalary()+(Integer.parseInt(splitLine[1]))*18);
					}
					if (Integer.parseInt(splitLine[2])>= 10 && Integer.parseInt(splitLine[2]) <= 20) {
						pte.setOverWorkSalary(pte.getOverWorkSalary()+(Integer.parseInt(splitLine[2]))*18);
					}
					if (Integer.parseInt(splitLine[3])>= 10 && Integer.parseInt(splitLine[3]) <= 20) {
						pte.setOverWorkSalary(pte.getOverWorkSalary()+(Integer.parseInt(splitLine[3]))*18);
					}
					if (Integer.parseInt(splitLine[4])>= 10 && Integer.parseInt(splitLine[4]) <= 20) {
						pte.setOverWorkSalary(pte.getOverWorkSalary()+(Integer.parseInt(splitLine[4]))*18);
					}
					pte.setTotalSalary(pte.getSeverancePay()+pte.getOverWorkSalary());
				}
			}
			//Setting information of worker to attributes
			for (Worker w : Main.workers) {
				if (w.getRegNo().equals(splitLine[0])) {
					w.setHourOfWork(Integer.parseInt(splitLine[1])+Integer.parseInt(splitLine[2])+Integer.parseInt(splitLine[3])+
							Integer.parseInt(splitLine[4]));
					
					w.setSeverancePay((2020-w.getYearOfStart())*16);
					for (int i = 1;i<5;i++) {
						w.setOverWorkSalary((w.getOverWorkSalary()+
								((Integer.parseInt(splitLine[i]) - 40)/10 >= 1 ? 110 : (Integer.parseInt(splitLine[i])-40)*11)));
					}
					w.setTotalSalary(w.getSeverancePay()+w.getSalaryOfDay()*20+ w.getOverWorkSalary());
				}
			}
			//Setting information of chief to attributes
			for (Chief c : Main.chiefs) {
				if (c.getRegNo().equals(splitLine[0])) {
					c.setHourOfWork(Integer.parseInt(splitLine[1])+Integer.parseInt(splitLine[2])+Integer.parseInt(splitLine[3])+
							Integer.parseInt(splitLine[4]));
					c.setSeverancePay((2020-c.getYearOfStart())*16);
					for (int i = 1;i<5;i++) {
						c.setOverWorkSalary((c.getOverWorkSalary()+
								((Integer.parseInt(splitLine[i]) - 40)/8 >= 1 ? 120 : (Integer.parseInt(splitLine[i])-40)*15)));
					}
					c.setTotalSalary(c.getSeverancePay()+c.getOverWorkSalary()+c.getSalaryOfDay()*20);
				}
			}
			//Setting information of security to attributes
			for (Security s : Main.securities) {
				if (s.getRegNo().equals(splitLine[0])){
					s.setHourOfWork(Integer.parseInt(splitLine[1])+Integer.parseInt(splitLine[2])+Integer.parseInt(splitLine[3])+
							Integer.parseInt(splitLine[4]));
					s.setSeverancePay((2020-s.getYearOfStart())*16);
					if (Integer.parseInt(splitLine[1]) >= 30 && Integer.parseInt(splitLine[1]) <= 54) {
						s.setTotalSalary(s.getTotalSalary()+s.getFoodMoney()*6+s.getTransMoney()*6);
					}
					if (Integer.parseInt(splitLine[2]) >= 30 && Integer.parseInt(splitLine[2]) <= 54) {
						s.setTotalSalary(s.getTotalSalary()+s.getFoodMoney()*6+s.getTransMoney()*6);
					}
					if (Integer.parseInt(splitLine[3]) >= 30 && Integer.parseInt(splitLine[3]) <= 54) {
						s.setTotalSalary(s.getTotalSalary()+s.getFoodMoney()*6+s.getTransMoney()*6);
					}
					if (Integer.parseInt(splitLine[4]) >= 30 && Integer.parseInt(splitLine[4]) <= 54) {
						s.setTotalSalary(s.getTotalSalary()+s.getFoodMoney()*6+s.getTransMoney()*6);
					}
					s.setTotalSalary(s.getTotalSalary()+s.getSeverancePay()+s.getHourOfWork()*10);
				
				}
			}
		}
	}
	//PRINT FUNCTIONS
	public static void printFM(ArrayList<FacultyMember> facultyMembers) throws FileNotFoundException {
		//(Math.round(bill.getTotal()*10)/10.0)
		for (FacultyMember fm : Main.facultyMembers) {
			String[] splitName;
			String regFM = fm.getRegNo();
			splitName = fm.getName().split(" ");
			PrintStream facultyMember = new PrintStream(new File(regFM+".txt"));
			System.setOut(facultyMember);
			System.out.printf("Name : "+splitName[0]+"\n"+"Surname : "+splitName[1]+"\n"+"Registration Number : "+fm.getRegNo()+"\n"+
			"Position : "+fm.getPosition()+"\n"+"Year of Start : "+fm.getYearOfStart()+"\n"+"Total Salary : "+"%.2f"+" TL",
			(fm.getTotalSalary()));
		}
	}
	public static void printRA(ArrayList<ResearchAssistant> researchAssistants) throws FileNotFoundException {
		for (ResearchAssistant ra : Main.researchAssistants) {
			String[] splitName;
			String regRA = ra.getRegNo();
			splitName = ra.getName().split(" ");
			PrintStream researchAssistant = new PrintStream(new File(regRA+".txt"));
			System.setOut(researchAssistant);
			System.out.printf("Name : "+splitName[0]+"\n"+"Surname : "+splitName[1]+"\n"+"Registration Number : "+ra.getRegNo()+"\n"+
			"Position : "+ra.getPosition()+"\n"+"Year of Start : "+ra.getYearOfStart()+"\n"+"Total Salary : "+"%.2f"+" TL",ra.getTotalSalary());
		}
	}
	public static void printOF(ArrayList<Officer> officers) throws FileNotFoundException {
		for (Officer of : Main.officers) {
			String[] splitName;
			String regOF = of.getRegNo();
			splitName = of.getName().split(" ");
			PrintStream officer = new PrintStream(new File(regOF+".txt"));
			System.setOut(officer);
			System.out.printf("Name : "+splitName[0]+"\n"+"Surname : "+splitName[1]+"\n"+"Registration Number : "+of.getRegNo()+"\n"+
			"Position : "+of.getPosition()+"\n"+"Year of Start : "+of.getYearOfStart()+"\n"+"Total Salary : "+"%.2f"+" TL",of.getTotalSalary());
			
		}
	}
	public static void printPTE(ArrayList<PartTimeEmployee> partTimeEmployees) throws FileNotFoundException {
		for (PartTimeEmployee pte : Main.partTimeEmployees) {
			String[] splitName;
			String regPTE = pte.getRegNo();
			splitName = pte.getName().split(" ");
			PrintStream partTimeEmployee = new PrintStream(new File(regPTE+".txt"));
			System.setOut(partTimeEmployee);
			System.out.printf("Name : "+splitName[0]+"\n"+"Surname : "+splitName[1]+"\n"+"Registration Number : "+pte.getRegNo()+"\n"+
			"Position : "+pte.getPosition()+"\n"+"Year of Start : "+pte.getYearOfStart()+"\n"+"Total Salary : "+"%.2f"+" TL",pte.getTotalSalary());
			
		}
	}
	public static void printW(ArrayList<Worker> workers) throws FileNotFoundException {
		for (Worker w : Main.workers) {
			String[] splitName;
			String regW = w.getRegNo();
			splitName = w.getName().split(" ");
			PrintStream worker = new PrintStream(new File(regW+".txt"));
			System.setOut(worker);
			System.out.printf("Name : "+splitName[0]+"\n"+"Surname : "+splitName[1]+"\n"+"Registration Number : "+w.getRegNo()+"\n"+
			"Position : "+w.getPosition()+"\n"+"Year of Start : "+w.getYearOfStart()+"\n"+"Total Salary : "+"%.2f"+" TL",w.getTotalSalary());
			
		}
	}
	public static void printC(ArrayList<Chief> chiefs) throws FileNotFoundException {
		for (Chief c : Main.chiefs) {
			String[] splitName;
			String regC = c.getRegNo();
			splitName = c.getName().split(" ");
			PrintStream chief = new PrintStream(new File(regC+".txt"));
			System.setOut(chief);
			System.out.printf("Name : "+splitName[0]+"\n"+"Surname : "+splitName[1]+"\n"+"Registration Number : "+c.getRegNo()+"\n"+
			"Position : "+c.getPosition()+"\n"+"Year of Start : "+c.getYearOfStart()+"\n"+"Total Salary : "+"%.2f"+" TL",c.getTotalSalary());
			
		}
	}
	public static void printS(ArrayList<Security> securities) throws FileNotFoundException {
		for (Security s : Main.securities) {
			String[] splitName;
			String regS = s.getRegNo();
			splitName = s.getName().split(" ");
			PrintStream security = new PrintStream(new File(regS+".txt"));
			System.setOut(security);
			System.out.printf("Name : "+splitName[0]+"\n"+"Surname : "+splitName[1]+"\n"+"Registration Number : "+s.getRegNo()+"\n"+
			"Position : "+s.getPosition()+"\n"+"Year of Start : "+s.getYearOfStart()+"\n"+"Total Salary : "+"%.2f"+" TL",s.getTotalSalary());
			
		}
	}
}
