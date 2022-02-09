package com.DigitAge_Jan2022_8AM_Maven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        hashMap();
    }
    //@Test
	public void listOfStudents()
	{
		ArrayList<Student> students = new ArrayList<Student>();
		Student s1 = new Student(22,"Ram",550);
		Student s2 = new Student(25,"Ramu",580);
		Student s3 = new Student(28,"Ramesh",590);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s3);
		students.add(new Student(38,"Raj",595)); //Run time object / Ananymous object
		for(int i=0;i<students.size();i++)
		{
			System.out.println("Student Number :" + i);
			System.out.println(students.get(i).number);
			System.out.println(students.get(i).name);
			System.out.println(students.get(i).marks);
		}
	}
	

    public void treeSet()
    {
    	 TreeSet<String> al=new TreeSet<String>();  
    	  al.add("Ravi");  
    	  al.add("Vijay");  
    	  al.add("Ravi");  
    	  al.add("Ajay");  
    	  //Traversing elements  
    	  Iterator<String> itr=al.iterator();  
    	  while(itr.hasNext()){  
    	   System.out.println(itr.next());  
    }  
    }
    
    public static void hashMap()  // no duplicate keys  , put , putAll , putifAbsent , remove - key based , value based , replace
    {
    	HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
    	   map.put(1,"Mango");  //Put elements in Map  
    	   map.put(2,"Apple");    
    	   map.put(3,"Banana");   
    	   map.put(4,"Grapes");   
    	       System.out.println("one : " + map.get(1));
    	   System.out.println("Iterating Hashmap...");  
    	   for(Map.Entry m : map.entrySet()){    
    	    System.out.println(m.getKey()+" "+m.getValue());    
    	   }  
    }
}
class Student
{
	int number;
	String name;
	int marks;
	Student(int num,String myname,int mymarks)
	{
		number = num;
		name = myname;
		marks = mymarks;
	}
}
