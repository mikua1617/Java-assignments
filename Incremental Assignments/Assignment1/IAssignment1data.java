package Shashwat.assignment.data;

public class IAssignment1data{
	
	private int var1;
	private char var2;

	public void printvars(){
		System.out.println(var1);
		System.out.println(var2);
	}

	public void printlocalvars(){
		
/*
		int var1;
		char var2;


This part of the code is not valid in Java because local variables are not initialized by default. Only instance variables are initialized by the java compiler as can be seen by the printed out values for the global var1 and var2 (int initialized by 1 and char by '\u0000' that is null in unicode). Thus, attempting to print local variables without initialization gives an error. 

*/
		
		System.out.println(var1);
		System.out.println(var2);
	}
	
}
