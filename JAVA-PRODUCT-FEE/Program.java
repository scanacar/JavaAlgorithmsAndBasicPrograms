import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Program {
	
	public static void Program (String[] priceArray,String[] shoppingArray) {
		
		String[] splitLine; // split edilmis satirlarin tutuldugu array
		String type; // typeofmembershipin gecici olarak tutuldugu variable
		String date; // tarihin gecici olarak tutuldugu variable
		
		for (String line : priceArray) {  // priceListin okunup splitlenip productlarin olusturuldugu for dongusu
			splitLine = line.split("\t");
			Main.products.add(new Product(splitLine[0],splitLine[1],Program.dateConverter(splitLine[2]),Program.dateConverter(splitLine[3]),splitLine[4]));
		}
		
		for (String line : shoppingArray) {  // shoppingListin okunup splitlenip bill ve customer olusturuldugu for dongusu
			splitLine = line.split("\t");
			type = splitLine[1];
			date = splitLine[2];
			int counter = 3;
			while (counter<splitLine.length) {
				Main.bills = Program.findProduct(type,date,splitLine[counter],splitLine[counter+1]);
				counter += 2;
			}
			
			Main.customers.add(new Customer(splitLine[0],Main.bills));
			Main.bills = new ArrayList<>();
		}
		for (Customer customer : Main.customers) {  // customerlarin bastirildigi print
			Program.printCustomer(customer);

		}	
	}
	
	
	
	public static ArrayList<Bill> findProduct(String type,String date,String name,String amount){ 
		
		Date shoppingDate = dateConverter(date);
		
		for (Product product : Main.products) {  
			if(type.equals(product.getTypeOfMembership()) && name.equals(product.getName()) && 
			shoppingDate.before(product.getEndDate()) && shoppingDate.after(product.getStartDate())) { //typeOfMembership&&productName&&startDate&&endDate checking
				float price = Float.parseFloat(product.getPrice()); // fiyati floata cevirme
				int amountParsed = Integer.parseInt(amount); // miktari integera cevirme
				
				Main.bills.add(new Bill(product.getName(),price,amountParsed,(float) price*amountParsed)); // yeni faturalar olusturma
			}
		}
		return Main.bills;
	}
	
	public static void printCustomer(Customer customer) {  // customer ve productlarin bastirildigi fonksiyon
		float total = 0;
		System.out.println("---"+customer.getName()+"---");
		
		for (Bill bill : customer.getBills()) {  // faturalarin bastirildigi for
			System.out.println(bill.getProductName()+"\t"+bill.getUnitPrice()+"\t"+bill.getQuantity()+"\t"+(Math.round(bill.getTotal()*10)/10.0));
			total += bill.getTotal();
		}
		System.out.println("Total"+"\t"+total);
	}
	
	public static Date dateConverter(String date) {  // string olarak txtden alinan tarihin date formuna donusturulmesi
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			return sdf.parse(date);
		}
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
