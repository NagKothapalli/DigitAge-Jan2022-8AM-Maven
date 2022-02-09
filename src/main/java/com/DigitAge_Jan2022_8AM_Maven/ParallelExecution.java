package com.DigitAge_Jan2022_8AM_Maven;

public class ParallelExecution
{
	public static void main(String[] args)
	{
		//Task1 : Educational Documents
		PrinterOne p1 = new PrinterOne("Education",20);
		//Task2 : Job Documents
		PrinterOne p2 = new PrinterOne("Job",15);
		//Task3 : Medical Documents
		PrinterOne p3 = new PrinterOne("Medical",25);
		//Task4 : Property Documents
		PrinterOne p4 = new PrinterOne("Property",10);
		Thread t1 = new Thread(p1); 
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		t1.start(); t2.start(); t3.start();t4.start();
	}
}


class PrinterOne extends Thread
{
	int count;
	String category;
	PrinterOne(String category , int docCount)
	{
		count = docCount;
		this.category = category;
	}
	@Override
	public void run()
	{
		for(int i=1;i<=count;i++)
		{
			System.out.println("Print Document Type : " + category + "  , Count : " + i);
		}
	}
}