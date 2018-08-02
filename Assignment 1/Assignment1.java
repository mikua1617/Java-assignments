//package Assignment1;


import java.io.*;
import java.util.regex.*;
import java.util.Scanner;

/**
 *The objective of this program is to search for all the files in 
 *the system's home directory that match a particular regular expression
 *Regular expressions are entered by the user 
 *@author Shashwat Mishra

*/

public class Assignment1{

/**
 *Asks the user whether they want to keep entering regular expressions to test further or not
 *Stops the moment user enters n.  
 *
 *@param args Used whenever compilation is done on a command line interface
 *             It is of type String[] as it has to accept arguments in string format that accompany the 
 *             execution statement of the program

*/

	public static void main(String args[]) {

		String choice="y";		
		while(choice.equals("y")){

			Matching Regularex = new Matching();

			Regularex.getregex();
			Regularex.matchregex();
			Regularex.getmatchedfiles();
			
			System.out.println("Do you want to enter more? (y/n)");
			Scanner reader = new Scanner(System.in);
			
			choice = reader.next();

			}
		}
	}


/**
 *Contains methods for working with the file system and file handling. The user's home directory is obtained
 *using the getProperty method of the System class. The filenames present in the home directory are obtained 
 *via a File class
 *@author Shashwat Mishra
*/

class Files{

	private String[] Filenames;
	private String Homedir;

/**
 *Used to get the homedirectory of the user via the system method getProperty.
 *
 *@return the home directory as a String
*/	
	public String getHomedir(){
		
		Homedir = System.getProperty("user.home");
		return Homedir;
		}

/**
 *Used to get all the files present in the home directory using an object of the File class. The file names are 
 *stored in an array of Strings 
 
 *@return An array of filenames present in the home directory

*/	
	public String[] getFilenames(){
		
		File file = null;
        	file = new File(getHomedir());
        	Filenames = file.list();
		
		return Filenames;
		
		}
	}

/**
 *Used for all the matching functions required for matching the regular expression with the file names and 
 *then displaying the filenames in the required format 
 *
 *@author Shashwat Mishra 
*/
class Matching {

	private String regex;
	private Pattern regexcheck;
	private String[] matchedfiles= new String[500];
	

		
/**
 *Asks the user to enter a regular expression to search for in the filelist. 
 *The .next() method suffices in this case instead of the nextLine() method because
 *regular expressions don't include spaces
*/		
	public void getregex(){

		System.out.println("Enter the regular expression");
		Scanner reader = new Scanner(System.in);
		regex = reader.next();
		}


/**
 *Performs matching of different patterns with the filenames using Pattern objects
 *Matched filenames are indicated by a true value in an object of the Matched class
 *The matched filenames are added to a dedicated array storing the full path of the matched files
 *by appending the home directory of the user from the files class that was inherited
*/
	public void matchregex(){
		
		Files file1 = new Files();
		
		String[] Filenames = file1.getFilenames();
		int counter = 0;

		
		regexcheck = Pattern.compile(regex);
		for (int i = 0; i < Filenames.length; i++){ 
			
            		Matcher matched = regexcheck.matcher(Filenames[i]);
		
			if(matched.find()==true){
				matchedfiles[counter]=(file1.getHomedir())+"/"+Filenames[i];
				counter++;
				
				}				
			}
		
		}


/**
 *Displays a list of the full paths of all the files matched to the regular expression
 *goes not to the end of the array but until the matchedfiles array contains something
*/
	public void getmatchedfiles(){

		int i=0;
		while(matchedfiles[i]!=null){
				
			System.out.println(matchedfiles[i]);
			i++;
		}		

	}
		
}
				
		
