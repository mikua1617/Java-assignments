package Shashwat.assignment.main;

import Shashwat.assignment.data.IAssignment1data;
import Shashwat.assignment.singleton.IAssignment1singleton;

public class IAssignment1main{

	public static void main(String[] args){

		IAssignment1data data1 = new IAssignment1data();
		data1.printvars();
		data1.printlocalvars();
		
		IAssignment1singleton S1 = IAssignment1singleton.initialization("Hello World!");
		S1.printer();
		

		
	}
}
