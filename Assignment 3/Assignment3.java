import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;


/**
 *This program pings a host given by a URL or an IP address and calculates the median time taken
 *to ping the host over a number of ping processes. The user is asked for the number of pings to 
 *be performed and the ping command is run on the ping service provided by the system by creating a 
 *process. From the data obtained using the ping, the time for the same at each instance is found 
 *out using a regular expression. Once the time for each ping is obtained, the median value for the 
 *collection of values is found by sorting the list in ascending order and finding the middle values

@author Shashwat Mishra 
*/
public class Assignment3{


	public static void main(String[] args){


		Assignment3 A1 = new Assignment3();
		Pingprocess URL1 = new Pingprocess(A1.getpings());


		URL1.makecommandlist();
		URL1.pinging();
		URL1.regex();
		URL1.displaymedian();

		

	}


/**
 *Asks the user for the number of probes of data to be sent as an integer input and then returns
 *the value 
 *
 *@return pingnos   integer that indicates the number of probes to be performed 
*/

	public int getpings(){
		Scanner in = new Scanner(System.in);
                System.out.println("Enter the number of pings to be performed");
		int pingnos = in.nextInt();
		return pingnos;
	}
		
}	



/**
 *Contains all methods for making a list of commands to be performed, using the list to 
 *build a process and then use the output from the process to manipulate and extract 
 *the time taken per probe and finally calculate the median of the probe times and print it

@author Shashwat Mishra
*/


class Pingprocess{

	

 	
	private int number_of_pings;
	private String[] ping_results;
	private ArrayList<String> commandList = new ArrayList<>();
	private float[] times;


	Pingprocess(int num){
		
		number_of_pings = num;
		ping_results = new String[number_of_pings];
		times = new float[number_of_pings];

	}



	

/**
 *makes a command list that is used to build a ProcessBuilder process and start the ping process in 
 *the machine service. Asks the user to enter the host name and appends ping to the name so as to 
 *directly start the ping process
*/

	public void makecommandlist(){


		commandList.add("ping");

                Scanner in = new Scanner(System.in);
                System.out.println("Enter IP address or URL of host");
                commandList.add(in.next());
		

	}


/**
 *Uses ProcessBuilder objects to start the command specified in the command list and ping the required host
 *results are captured in a string array 
 *
 *@exception ex   prints the location and the exception that occured while accessing and starting the process
*/

	public void pinging(){
		
		try{

		
                	ProcessBuilder builder = new ProcessBuilder(commandList);
                	Process pro = builder.start();

                	BufferedReader input = new BufferedReader(new InputStreamReader(pro.getInputStream()));
             
                	for (int loopvar=0; loopvar<number_of_pings;loopvar++)
                	{
                	    	ping_results[loopvar]=input.readLine();
                	    	
                	}
		
			
		}

		catch (Exception ex){
                	ex.printStackTrace();
            	}	
	}


/**
 *Looks into the results obtained and stored by the ping process to locate and extract the time taken
 *for the ping request. The time taken is located using a regular expression that matches the pattern of 
 *results generally returned by a ping request. regular expression is compiled using a Pattern and Matcher 
 *objects
*/


	public void regex(){

                String theregex = "[0-9]+\\.+[0-9](?= ms) ";

                Pattern checkRegex = Pattern.compile(theregex);

		for(int loopvar=1; loopvar<number_of_pings; loopvar++) {

                    	Matcher regexMatcher = checkRegex.matcher(ping_results[loopvar]);

                    	while (regexMatcher.find()) {
                        	if (regexMatcher.group().length() != 0) {
                            		times[loopvar] = Float.valueOf(regexMatcher.group().trim());


                        	}
                    	}
                } 

	}        

/**
 *finds and prints the median of the obtained probe times. When the number of times obtained is odd, the median is 
 *the middle value of the times. However when the number is even, the median is the average of the middle two times.
 *prints the values formatted accordingly
*/


	public void displaymedian(){

		Arrays.sort(times);

                    if(number_of_pings%2==0){
                        System.out.println("The median time to ping is "+times[(number_of_pings/2)]+ " ms");
                    }
                    else {
                        System.out.println("The median time to ping is "+ (times[(number_of_pings+1)/2]+times[(number_of_pings-1)/2])/2+ " ms");
                    }
	}

}


	



		
		
