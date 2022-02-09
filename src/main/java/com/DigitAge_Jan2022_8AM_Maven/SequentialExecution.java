package com.DigitAge_Jan2022_8AM_Maven;

public class SequentialExecution
{
	public static void main(String[] args)
	{
		//Task1 : Educational Documents
		Printer p1 = new Printer("Education",20);
		//Task2 : Job Documents
		Printer p2 = new Printer("Job",15);
		//Task3 : Medical Documents
		Printer p3 = new Printer("Medical",25);
		//Task4 : Property Documents
		Printer p4 = new Printer("Property",10);
		p1.printDocuments();
		p2.printDocuments();
		p3.printDocuments();
		p4.printDocuments();
	}
}



class Printer
{
	int count;
	String category;
	Printer(String category , int docCount)
	{
		count = docCount;
		this.category = category;
	}
	
	public void printDocuments() //Explicit Function
	{
		for(int i=1;i<=count;i++)
		{
			System.out.println("Print Document Type : " + category + "  , Count : " + i);
		}
	}
}
