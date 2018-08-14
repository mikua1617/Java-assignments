import java.util.Scanner;
import java.util.regex.*;



public class Assignment5test{

	public static void main(String[] args){

		Regexcheck obj1 = new Regexcheck();

		String s1 = "That is a building.";
		String s2 = "there is my home";
		String s3 = "there lives a rabbit.";
		String s4 = "Who survived?";
		String s5 = "Yesss!.";
		obj1.regexchecker(s1);
		obj1.regexchecker(s2);
		obj1.regexchecker(s3);
		obj1.regexchecker(s4);
		obj1.regexchecker(s5);
		

	}
}

class Input_output{


	public String getinput(){

		System.out.println("Enter the line");
        	Scanner reading = new Scanner(System.in);
		String line = reading.nextLine();
		return line;
	}

	public void print_results(int x){
			
		if (x==1)
			System.out.println("Yes the line starts with a capital letter and ends with a period");

		else 
			System.out.println("No the line does not start with a capital letter and end with a period");

	}	

}

class Regexcheck{

	public void regexchecker(String line){

		String theregex = "^[A-Z].*\\.$";
		int x=0;

                Pattern checkRegex = Pattern.compile(theregex);

		Matcher regexMatcher = checkRegex.matcher(line);

                while (regexMatcher.find()) {
                    	if (regexMatcher.group().length() != 0) {
                            	x=1;
				break;
			}
			else{
				break;
			}
		}

		Input_output obj = new Input_output();
		obj.print_results(x);
	
	}
		
}
