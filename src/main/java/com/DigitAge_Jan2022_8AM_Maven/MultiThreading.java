package com.DigitAge_Jan2022_8AM_Maven;

public class MultiThreading
{
	
	public static void main(String[] args)
	{
		PrintOne p1 = new PrintOne("ThreadOne");
		PrintTwo p2 = new PrintTwo("ThreadTwo");
		PrintOne p3 = new PrintOne("ThreadThree");
		PrintTwo p4 = new PrintTwo("ThreadFour");
		System.out.println("Start Parallel Processing");
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(p4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}

class PrintOne extends Thread
{
	String threadName;
	public PrintOne(String thread)
	{
		threadName = thread;
	}
	@Override
	public void run()
	{
		for(int i=0;i<=10;i++)
		{
			System.out.println("PrinterOne Document :" + i + " by " + threadName );
		}
	}
}

class PrintTwo extends Thread
{
	String threadName;
	public PrintTwo(String thread)
	{
		threadName = thread;
	}
	@Override
	public void run()
	{
		for(int i=0;i<=10;i++)
		{
			System.out.println("PrinterTwo Document :" + i + " by " + threadName );
		}
	}
}
