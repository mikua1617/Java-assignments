import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.lang.Character;

public class IAssignment7{

	public static void main(String[] args) throws Exception{

		Map<Character, Integer>  counter = new HashMap<>();

		IAssignment7 A1 = new IAssignment7();

		counter = A1.mapping(counter, args);

		A1.writing(counter);

	}


	public String reader(String[] args) throws Exception{		

 		Scanner scanner = new Scanner( new File(args[0]) );
 		

		String text = scanner.useDelimiter("\\A").next();
		text = text.replaceAll("\\s+","");
		return text;
	}



	public Map<Character, Integer> mapping(Map<Character, Integer> counter, String[] args) throws Exception{

		IAssignment7 A2 = new IAssignment7();		
		String text = A2.reader(args); 
		

		for(int i=0; i<text.length(); i++){	

			int count = counter.containsKey(Character.valueOf(text.charAt(i))) ? counter.get(Character.valueOf(text.charAt(i))) : 0;
			counter.put(Character.valueOf(text.charAt(i)), count + 1);
			
		}
		return counter;

	}



	public void writing(Map<Character, Integer> counter) throws Exception{
		
		File fileTwo=new File("output.txt");
    		FileOutputStream fos=new FileOutputStream(fileTwo);
        	PrintWriter pw=new PrintWriter(fos);

		for(Map.Entry<Character, Integer> m :counter.entrySet()){
            		pw.println(m.getKey()+"="+m.getValue());
       	 	}

		pw.flush();
        	pw.close();
        	fos.close();
	}


	
}

		
