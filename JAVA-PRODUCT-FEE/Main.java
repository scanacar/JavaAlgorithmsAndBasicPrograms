import java.util.ArrayList;

public class Main {
	
	// Product, Customer ve Bill ArrayLists
	static ArrayList<Product> products = new ArrayList<>();
	static ArrayList<Customer> customers = new ArrayList<>();
	static ArrayList<Bill> bills = new ArrayList<>();
	
	public static void main(String[] args) {

		//Dosya okunduktan sonra verilerin eklendigi arrayler
		String[] shoppingArray = ReadFromFile.readFile(args[0]);
		String[] priceArray = ReadFromFile.readFile(args[1]);
		Program.Program(priceArray,shoppingArray); // program adli fonksiyonun cagirilmasi
	}
}
