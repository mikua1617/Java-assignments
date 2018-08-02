import java.util.*;

public class IAssignment4{

	public static void main(String[] args){

		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the age of army candidate");		
		int age = reader.nextInt();
		
		Exceptiontest candidate = new Exceptiontest();

		try{

			candidate.handler(age);		
		
		}
		catch(TooYoung | TooOld | NegativeAge ex){

			System.out.println(ex);

		}

		finally{
			System.out.println("finally statement");
		}

					
	}
}



class TooYoung extends Exception{

	TooYoung(String s){
		super(s);
	}
}

class TooOld extends Exception{

	TooOld(String s){
		super(s);
	}
}

class NegativeAge extends Exception{

	NegativeAge(String s){
		super(s);
	}
}

class Exceptiontest{

	public void handler(int age) throws TooYoung, TooOld, NegativeAge{

		if(age < 18 && age > 0){
		
			throw new TooYoung("Person too young");
		}
	
		else
		if(age > 80){

			throw new TooOld("Person too old");
		}

		else 
		if(age < 0){

			throw new NegativeAge("Invalid age for person");

		}
		else{

			System.out.println("Welcome to the Indian army!!");

		}

	}
}

















