package Shashwat.assignment.singleton;

public class IAssignment1singleton{
	
	private String str1;
	private IAssignment1singleton obj1 = null;

	public static IAssignment1singleton initialization(String str){

		
		
		if(obj==null)
			obj = new IAssignment1singleton();

		str1 = str;
		
		return obj;
		
		

	}

	public void printer(){
		
		System.out.println(str1);
	}

}
		
