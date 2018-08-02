import java.util.Scanner;
import java.util.regex.*;



public class IAssignment5{

	public static void main(String[] args){

		IAssignment5 A1 = new IAssignment5();

		System.out.println("Enter the line");
        	Scanner reading = new Scanner(System.in);
        	String line = reading.nextLine();
		
		System.out.println(A1.regexchecker(line));
		

	}

	public boolean regexchecker(String line){
	
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
		if (x==1)
			return true;

		else 
			return false;

		


	}
                     
                

		
}
