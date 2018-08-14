import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.lang.Character;

public class Assignment7test{

	public static void main(String[] args) throws Exception{

		try{

		Map<Character, Integer>  counter = new HashMap<>();

		Counting obj1 = new Counting();
		Writing obj2 = new Writing();
		counter = obj1.mapping(counter, args);
		

		obj2.writing(counter);
		}		
		catch(Exception ex){
			ex.printStackTrace();
		}

	
	}
}

class Reading{


	public String reader(String[] args){		
		try {
 		Scanner scanner = new Scanner( new File(args[0]) );
 		

		String text = scanner.useDelimiter("\\A").next();
		text = text.replaceAll("\\s+","");
		
		return text;
		}
		catch(FileNotFoundException ex){
			System.out.println("File Doesn't exist. Please give a valid filename next time");
			return "";
		}
		

			

	}
}


class Counting{

	public Map<Character, Integer> mapping(Map<Character, Integer> counter, String[] args){

		Reading R1 = new Reading();		
		String text = R1.reader(args); 

		
		

		for(int i=0; i<text.length(); i++){	

			int count = counter.containsKey(Character.valueOf(text.charAt(i))) ? counter.get(Character.valueOf(text.charAt(i))) : 0;
			counter.put(Character.valueOf(text.charAt(i)), count + 1);
			
		}
		return counter;

	}
}


class Writing{

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

		
