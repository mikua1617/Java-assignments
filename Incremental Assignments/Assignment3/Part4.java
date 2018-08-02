import java.util.Scanner;

public class Part4{

	public static void main(String[] args){

		Cyclefactory cyclefactory = new Cyclefactory();

		Cycle cycle = null;

		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter the type of cycle? (u / b / t)");

	  
       		if (userInput.hasNextLine()){
             
            		String typeOfCycle = userInput.nextLine();
           	 	cycle = Cyclefactory.makenewcycle(typeOfCycle);
            		if(cycle == null){
                		System.out.println("Unsupported input. Please enter u, b or t next time");
            		} 
			
		}

	}

	
}

interface Cycle{

	public void getvalues();

}

class Unicycle implements Cycle{

	public Unicycle(){
		this.getvalues();
		
	}

	public void getvalues(){
		System.out.println("Speed of this cycle is 100");
		System.out.println("This cycle has 1 wheel");
	}
		
}

class Bicycle implements Cycle{

	public Bicycle(){
		this.getvalues();
		
	}

	public void getvalues(){
		System.out.println("Speed of this cycle is 80");
		System.out.println("This cycle has 2 wheels");
	}
}



class Tricycle implements Cycle{

	public Tricycle(){
		this.getvalues();
		
	}

	public void getvalues(){
		System.out.println("Speed of this cycle is 60");
		System.out.println("This cycle has 3 wheels");
	}
}

class Cyclefactory{	

	public static Cycle makenewcycle(String cycletype){

		if(cycletype.equals("u")){

			return new Unicycle();
		}

		else 
		if(cycletype.equals("b")){

			return new Bicycle();
		}

		else
		if(cycletype.equals("t")){

			return new Tricycle();
		}
		else return null;
	}

}













