import java.util.Comparator;

public class CustomerComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getFirstName().compareTo(c2.getFirstName());
	}

}
