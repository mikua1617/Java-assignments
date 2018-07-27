package Shashwat.assignment.singleton;

public class IAssignment1singleton{
	
	private String str1;

	public static IAssignment1singleton initialization(String str1){

		IAssignment1singleton obj1 = new IAssignment1singleton();
		obj1.str1 = str1;
		
		return obj1;

	}

	public void printer(){
		
		System.out.println(str1);
	}

}
		
