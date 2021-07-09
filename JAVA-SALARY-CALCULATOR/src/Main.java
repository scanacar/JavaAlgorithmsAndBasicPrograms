import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
	
	//Arraylists for objects (facultyMember,officer e.g)
	static ArrayList<FacultyMember> facultyMembers = new ArrayList<>();
	static ArrayList<ResearchAssistant> researchAssistants = new ArrayList<>();
	static ArrayList<Officer> officers = new ArrayList<>();
	static ArrayList<PartTimeEmployee> partTimeEmployees = new ArrayList<>();
	static ArrayList<Worker> workers = new ArrayList<>();
	static ArrayList<Chief> chiefs = new ArrayList<>();
	static ArrayList<Security> securities = new ArrayList<>();
	
	public static void main (String[] args) throws FileNotFoundException {
		
		// Reading file
		String[] personnelArray =  ReadFromFile.readFile(args[0]);
		String[] monitorArray = ReadFromFile.readFile(args[1]);
		//Calling program function
		Program.Program(personnelArray,monitorArray,facultyMembers,researchAssistants,officers,partTimeEmployees,
				workers,chiefs,securities);
		//Calling print functions
		Program.printFM(facultyMembers);
		Program.printRA(researchAssistants);
		Program.printOF(officers);
		Program.printW(workers);
		Program.printC(chiefs);
		Program.printPTE(partTimeEmployees);
		Program.printS(securities);
		
		
	}
	

}
