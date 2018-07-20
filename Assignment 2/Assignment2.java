import java.util.*;
import java.io.*;
import java.lang.Character;


/**
 *This program checks whether a string taken as input from the user contains all the alphabets 
 *in english. The alphabets are not case sensitive so a and A both count as an occurence of the 
 *letter a. A map of alphabets is created mapped to a default value and as soon as a letter in the 
 *passed line is found, the associated value is reduced. Thus any key not associated to the default 
 *value is essentially found in the string entered.
 *
 *@author Shashwat Mishra
*/

public class Assignment2{
	
	public static void main(String[] args){
		
		System.out.println("Enter the string");
        	Scanner reading = new Scanner(System.in);
        	String line = reading.nextLine();

		String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Map<String, Integer>  dictionary = new HashMap<>();
		Checkalphabets line1 = new Checkalphabets();

		dictionary = line1.makedictionary(letters, dictionary);

	
		dictionary = line1.checkstring(line, dictionary);
		
		
		if(line1.checkdictionary(dictionary) == 1)
			System.out.println("All characters of the alphabet are not present");
		else
			System.out.println("All characters of the alphabet are present");

		
 
		



	}
}

/**
 *Contains all methods needed to check for occurence of letters in a line. Makes the appropriate mappings
 *and reduces mappings accordingly when a valid character is found. 
 *
 *@author Shashwat Mishra
*/


class Checkalphabets{


/**
 *Makes a hashmap by extracting the characters from a string containing all uppercase and lowercase letters
 *and linking all letters to a default value of 0. 
 *
 *@param dictionary   A hashmap that is initially empty (with no links)
 *@param letters      A String that contains all the uppercase and lowercase letters of the alphabet,used
 *                    to generate the dictionary by fragmenting into chars
 *
 *
 *
 *@return dictionary  A hashmap that contains all the letters of the alphabet both uppercase and lowercase 
 *                    initialized to a default value of 0
*/


	public Map<String, Integer> makedictionary(String letters, Map<String, Integer> dictionary){
			
		
		for (int letter_pos=0; letter_pos<letters.length(); letter_pos++){
			dictionary.put(String.valueOf(letters.charAt(letter_pos)), 0);
        	}
			
		return dictionary;
	}


/**
 *Parses through the passed line input string and whenever a letter is found, reduces the corresponding 
 *mapped value by 1 by calling the appropriate functions. Makes sure that a valid character of the alphabet
 *is found before doing decrement
 *
 *@param line           The user entered sentence or string that needs to be checked for occurence of all the
 *                      letters of the alphabet
 *@param dictionary     Hashmap containing all the alphabets mapped to 0, to be reduced
 *
 *
 *@return dictionary    Manipulated hashmap with all alphabets linked to negative values if found in line and 
 *                      0 value if not found
*/

	public Map<String, Integer> checkstring(String line, Map<String, Integer> dictionary){

		for (int loopcounter=0; loopcounter<line.length(); loopcounter++){
			if (Character.isLowerCase(line.charAt(loopcounter))){
				dictionary = manipulateupper(line, dictionary, loopcounter);
			}
				

			else if (Character.isUpperCase(line.charAt(loopcounter))){
				dictionary = manipulatelower(line, dictionary, loopcounter);
			}

			else 
				continue;
			
		}
			
		

		return dictionary;
	}


/**
 *Used to reduce the linked mapping for the appropriate key. When the letter found in the entered line is of the lowercase
 *this method is called and reduces the mapping for the letter found as well as the mapping for the uppercase of the letter
 *found. Thus ensures that case insensitivity is maintained and a is considered the same as A.
 *
 *@param line          The string entered by the user to check for occurence of alphabets
 *@param dictionary    mapping being manipulated according to the letter found
 *@param loopcounter   the loopcounter used in the method that calls this method so as to retain the position of the letter at 
 *                     which to reduce the mapping 
 *                     
 *
 *@return dictionary   Manipulated hashmap with lowercase letters and corresponding uppercase letter mappings reduced
*/


	private Map<String, Integer> manipulateupper(String line, Map<String, Integer> dictionary, int loopcounter){

		dictionary.put(String.valueOf(line.charAt(loopcounter)).toUpperCase(), dictionary.get(String.valueOf(line.charAt(loopcounter)).toUpperCase()) - 1);
        dictionary.put(String.valueOf(line.charAt(loopcounter)), dictionary.get(String.valueOf(line.charAt(loopcounter))) - 1);

		return dictionary;
	}


/**
 *Used to reduce the linked mapping for the appropriate key. When the letter found in the entered line is of the uppercase
 *this method is called and reduces the mapping for the letter found as well as the mapping for the lowercase of the letter
 *found. Thus ensures that case insensitivity is maintained and a is considered the same as A.
 *
 *@param line          The string entered by the user to check for occurence of alphabets
 *@param dictionary    mapping being manipulated according to the letter found
 *@param loopcounter   the loopcounter used in the method that calls this method so as to retain the position of the letter at 
 *                     which to reduce the mapping 
 *                     
 *
 *@return dictionary   Manipulated hashmap with lowercase letters and corresponding uppercase letter mappings reduced
*/

	private Map<String, Integer> manipulatelower (String line, Map<String, Integer> dictionary, int loopcounter){

		dictionary.put(String.valueOf(line.charAt(loopcounter)), dictionary.get(String.valueOf(line.charAt(loopcounter))) - 1);
        dictionary.put(String.valueOf(line.charAt(loopcounter)).toLowerCase(), dictionary.get(String.valueOf(line.charAt(loopcounter)).toLowerCase()) - 1);

		return dictionary;
	}

		
/**
 *Checks the dictionary sequentially as to whether any key has been mapped to 0. Any letter mapped to 0 implies that it 
 *did not occur in the line entered and hence kept its default value. If any letter didn't occur flag is set to 1 and returns
 *to main
 *
 *@param dictionary   The manipulated hashmap that links each letter to the corresponding integer according to their occurence in 
 *                    the string entered
 *
 *
 *@return flag        Flag which checks whether all letters are present or not. If present returns 0 else returns 1
*/

	
	

	public int checkdictionary(Map<String, Integer> dictionary){
		int flag=0;
		for (Map.Entry<String,Integer> entry : dictionary.entrySet())
			if(entry.getValue()==0){
                flag=1;
                break;
			}
		return flag;
               
		
	}
}
		
				

		

