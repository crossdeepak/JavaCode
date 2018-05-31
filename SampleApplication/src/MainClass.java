import java.util.Scanner;

/*import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int num=200;
		Integer iob=num;
		Integer iob2=500;
		System.out.println(iob);
		int num2=iob2;
		System.out.println(num2);
	}
}*/

	
/*	try{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Number");
		int n1=scanner.nextInt();
		System.out.println("Enter Number");
		int n2=scanner.nextInt();
		System.out.println(n1/n2);
	}
	catch(InputMismatchException e){
		e.printStackTrace();
		System.out.println("Input Mismatch");
	}
	catch(ArithmeticException e){
		e.printStackTrace();
		System.out.println("Arithmatic123");
	}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("Expception");
	}*/


public class MainClass
{
static String s = "";
public static void m0(int a, int b)
{
s +=a;
m2();
m1(b);
}
public static void m1(int i)
{
s += i;
}
public static void m2()
{
throw new NullPointerException("aa");
}
public static void m()
{
m0(1, 2);
m1(3);
}
public static void main(String args[])
{
try
{
m();
}
catch(Exception e){ }
System.out.println(s);
}
}