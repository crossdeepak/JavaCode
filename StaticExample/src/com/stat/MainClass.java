package com.stat;

/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//public class MainClass {

	
	/*	Object [] myObjects = {
				 new Integer(12),
				 new String("foo"),
				 new Integer(5),
				 new Boolean(true)
				 };
				 Arrays.sort(myObjects);
				 for( int i=0; i<myObjects.length; i++) {
				 System.out.print(myObjects[i].toString());
				 System.out.print(" ");
				 }
	*/	
		
		/*public static Iterator reverse(List list) {
			Collections.reverse(list);
			 return list.iterator();
			 }
			 public static void main(String[] args) {
			 List list = new ArrayList();
			 list.add("1"); list.add("2"); list.add("3");
			 for (Object obj: reverse(list))
			 System.out.print(obj + ",");
			 }*/
	/*public static Collection get() {
		 Collection sorted = new LinkedList();
		 sorted.add("B"); sorted.add("C"); sorted.add("A");
		 return sorted;
		 }
		 public static void main(String[] args) {
		 for (Object obj: get()) {
		 System.out.print(obj + ", ");
		 }
		 }*/
	
//	import java.util.*;
//	 public class MainClass {
//	 public static void main(String[] args) {
//		 Set set = new HashSet();
//	 set.add(new Integer(2));
//	 set.add(new Integer(1));
//	System.out.println(set);
//	 }}
	
/*import java.util.*;
 public class MainClass {
 public static void main(String[] args) {
 PriorityQueue<String> pq = new PriorityQueue<String>();
 pq.add("carrot");
 pq.add("apple");
 pq.add("banana");
 System.out.println(pq.poll() +":" + pq.peek());
 }
 }*/


 
/*import java.util.*;
 class KeyMaster {
 public int i;
 public KeyMaster(int i) { this.i = i; }
 public boolean equals(Object o) { return i == ((KeyMaster)o).i; }
 public int hashCode() { return i; }
 }
 public class MainClass {
public static void main(String[] args) {
 Set<KeyMaster> set = new HashSet<KeyMaster>();
 KeyMaster k1 = new KeyMaster(1);
 KeyMaster k2 = new KeyMaster(2);
 set.add(k1); set.add(k1);
 set.add(k2); set.add(k2);
 System.out.print(set.size() + ":");
 k2.i = 1;
System.out.print(set.size() + ":");
 set.remove(k1);
 System.out.print(set.size() + ":");
 set.remove(k2);
System.out.print(set.size());
 }
}*/

class MainClass
{
public void doA(int k) throws Exception { // 0
for(int i=0; i< 10; i++) {
if(i == k) throw new Exception("Index of k is "+i); // 1
}
}
public void doB(boolean f) throws Exception { //2
if(f) {
doA(15); //3
}
else return;
}
public static void main(String[] args) throws Exception { //4
	MainClass a = new MainClass();
	System.out.println(args.length);
a.doB(args.length>0); //5
}
}