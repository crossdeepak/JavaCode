import java.util.ArrayList;
import java.util.Collections;

public class MainClass {

	public static void main(String[] args) {
	ArrayList<String> strList=new ArrayList<>();
	strList.add("Hi");
	strList.add("Cross");
	strList.add("Fire");
	iterateOnList(strList);
	
	ArrayList<Integer> intList=new ArrayList<>();
	intList.add(40);
	intList.add(80);
	intList.add(100);
	iterateOnList(intList);
	
	}
	private static void iterateOnList(ArrayList<?>elements){
		for (Object object : elements) {
			System.out.println(object);
		}
	}
}

	
	/*		ListClassesDemo.arrayListClassWork(args);
	ArrayList<Customer> customerList=new ArrayList<>();
	customerList.add(new Customer(111, "Deepak", "Muraree"));
	customerList.add(new Customer(116, "Rahul", "Muraree"));
	customerList.add(new Customer(115, "Cross", "CS"));
	customerList.add(new Customer(113, "Fallen", "CS"));
	customerList.add(new Customer(118, "Coldzera", "CS"));
	
	Collections.sort(customerList);
	for (Customer customer : customerList) {
	//	System.out.println(customer);
	}
	
	Collections.sort(customerList,new CustomerComparator());
	for (Customer customer : customerList) {
		System.out.println(customer);
	}
	
	}
*/