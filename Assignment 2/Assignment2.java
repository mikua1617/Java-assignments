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
 *Contains all methods needed to check for occurence of letters in a line. 
 *
 *@author Shashwat Mishra
*/


class Checkalphabets{


/**
 *Makes a hashmap by extracting the characters from a string containing all uppercase and lowercase letters
 *and linking all letters to a default value of 0. 
*/


	public Map<String, Integer> makedictionary(String letters, Map<String, Integer> dictionary){
			
		
		for (int letter_pos=0; letter_pos<letters.length(); letter_pos++){
			dictionary.put(String.valueOf(letters.charAt(letter_pos)), 0);
        }
			
		return dictionary;
	}

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

	private Map<String, Integer> manipulateupper(String line, Map<String, Integer> dictionary, int loopcounter){

		dictionary.put(String.valueOf(line.charAt(loopcounter)).toUpperCase(), dictionary.get(String.valueOf(line.charAt(loopcounter)).toUpperCase()) - 1);
        dictionary.put(String.valueOf(line.charAt(loopcounter)), dictionary.get(String.valueOf(line.charAt(loopcounter))) - 1);

		return dictionary;
	}




	private Map<String, Integer> manipulatelower (String line, Map<String, Integer> dictionary, int loopcounter){

		dictionary.put(String.valueOf(line.charAt(loopcounter)), dictionary.get(String.valueOf(line.charAt(loopcounter))) - 1);
        dictionary.put(String.valueOf(line.charAt(loopcounter)).toLowerCase(), dictionary.get(String.valueOf(line.charAt(loopcounter)).toLowerCase()) - 1);

		return dictionary;
	}

		



	
	

	public int 	checkdictionary(Map<String, Integer> dictionary){
		int flag=0;
		for (Map.Entry<String,Integer> entry : dictionary.entrySet())
			if(entry.getValue()==0){
                flag=1;
                break;
			}
		return flag;
               
		
	}
}
		
				

		

