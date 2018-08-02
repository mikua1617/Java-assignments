import java.util.*;
import java.io.*;
import java.lang.Character;
import java.text.SimpleDateFormat;  


/**
 *This program asks the user to enter a predetermined number of pairs of dates in the format
 *dd-mm-yyyy dd-mm-yyyy and then finds the range of dates over which the user may backdate his/her KYC
 *form. The KYC form needs to be filled every year by customers of Gruber Healthcare. According to government
 *regulations, the KYC form may only be filled within 30 days before or after the sign up anniversary of the 
 *customer. If the current date is beyond the range of stipulated dates for KYC filing, the customer must backdate 
 *the KYC form to a date in the range of valid dates. The joining anniversary occurs every year consequent to 
 *a customer signing up for Gruber healthcare. This program prints the allowable date range possible for a
 *given pair of sign up and current dates. If the current date is within a year of the sign up date, there is 
 *no valid date acceptable and hence the program prints an error message 
 *
 *@author    Shashwat Mishra
*/



public class Assignment4{
	
	public static void main(String[] args){

		
		
		KYCDates D1 = new KYCDates();
		D1.makecalendar(D1.getdates()); 
		D1.finddaterange();
		D1.printvaliddates();
		
	}



/**
 *Asks the user for the number of date pairs to be entered and then returns the same. Used in the constructor 
 *of class KYCDates in order to initialize the size of Calendar arrays with the number of values to be entered
 *by the user 

 *@return  number_of_dates        The number of pairs of dates to be entered and checked for by the program
*/



	public int getinputnos(){
		
		System.out.println("Enter the number of dates to be entered");
        	Scanner reading = new Scanner(System.in);
        	int number_of_dates = reading.nextInt();
		
		return number_of_dates;
	}
}

/**
 *Contains methods and variables needed to ask the user for input of the necessary dates, find the date range of KYC form 
 *filling and then print out the range of dates accordingly if possible.
 *
 *@author Shashwat Mishra
*/



	
class KYCDates{

	private int number_of_dates;
 	private Calendar[] joining_dates;
	private Calendar[] current_dates;
	private Calendar[] begin_dates;
	private Calendar[] end_dates;
	


	KYCDates(){
		
		Assignment4 A1 = new Assignment4();
		number_of_dates = A1.getinputnos();
		joining_dates = new Calendar[number_of_dates];
		current_dates = new Calendar[number_of_dates];
		begin_dates = new Calendar[number_of_dates];
		end_dates = new Calendar[number_of_dates];
	}


/**
 *Asks the user to enter the enter the pairs of dates as required in the format dd-mm-yyyy dd-mm-yyyy and accepts 
 *input into a string array. Returns the array of strings with each string storing one pair of dates as accepted 
 *in input.
 *
 *@return dateinputs    array of strings that stored each entered pair of dates in a separate string with the date
 *                      of joining and the current date respectively separated by a space 
*/


	public String[] getdates(){
		

		System.out.println("Enter the dates");
		String[] dateinputs = new String[number_of_dates];

		Scanner reading2 = new Scanner(System.in);
		
		for(int i=0; i<number_of_dates; i++)
			dateinputs[i] = reading2.nextLine();

		return dateinputs;		
			  

	}


/**
 *Converts the string input into object of Calendar type by reading through the string and extracting substrings
 *for each of the days, months and years as necessary. upcasts the data in a GregorianCalendar format to an object
 *of Calendar class. 
 *
 *@param dateinputs     Array of strings that contains dates in the dd-mm-yyyy dd-mm-yyyy format with the first date 
 *                      bring the signing up date and the second date, separated by a space being the current date. 
*/




	public void makecalendar(String[] dateinputs){

		
		for(int i=0; i<number_of_dates; i++){
		
			
			joining_dates[i] = new GregorianCalendar(Integer.parseInt(dateinputs[i].substring(6,10)), Integer.parseInt(dateinputs[i].substring(3,5))-1, Integer.parseInt(dateinputs[i].substring(0,2)));
			

			current_dates[i] = new GregorianCalendar(Integer.parseInt(dateinputs[i].substring(17)), Integer.parseInt(dateinputs[i].substring(14,16))-1, Integer.parseInt(dateinputs[i].substring(11,13)));


		}
	}



/**
 *Computes the range of dates wherein the KYC form may be filled by a customer given the date of joining and the 
 *current date. The range of dates is given by an upper limit and a lower limit. The upper limit varies according to
 *whether the current date falls within the range of valid dates for KYC. Also makes sure that the lower limit is set according
 *to whether the KYC range is even possible or not.
*/



	public void finddaterange(){

		int current_year;

		for(int i=0; i<number_of_dates; i++){
			
				
			current_year = current_dates[i].get(Calendar.YEAR);
			
			if (current_dates[i].get(Calendar.YEAR) == joining_dates[i].get(Calendar.YEAR)){
				begin_dates[i] = null;
			}			


			else{
				
				begin_dates[i] = (Calendar) joining_dates[i].clone();

				begin_dates[i].add(Calendar.DAY_OF_YEAR, -30);
				begin_dates[i].add(Calendar.YEAR, (current_year - joining_dates[i].get(Calendar.YEAR))); 

			}
			
			Date date1 = current_dates[i].getTime();
			Date date2 = joining_dates[i].getTime();
			

			long difference =  (date1.getTime()-date2.getTime())/86400000;
			
			if(difference<335)
				begin_dates[i]=null;
		

			joining_dates[i].add(Calendar.DAY_OF_YEAR, 31);
			joining_dates[i].add(Calendar.YEAR, (current_year - joining_dates[i].get(Calendar.YEAR))); 
			

			if (current_dates[i].compareTo(joining_dates[i])<0){

				end_dates[i] = (Calendar) current_dates[i].clone();
				

			}

			else {

				end_dates[i] = (Calendar) joining_dates[i].clone();
			}
				

		}
	}


/**
 *Prints out the starting and the ending dates for the range of values of permissible KYC dates as found out in the 
 *finddaterange method. Formats the dates in the required format (dd-mm-yyyy dd-mm-yyyy) using the java.text.SimpleDateFormat 
 *class. Makes sure that the range of dates exists before printing out.
*/



	public void printvaliddates(){	


		for(int i=0; i<number_of_dates; i++){

			if(begin_dates[i]==null){
				System.out.println("No dates possible");
			}

			else{
			
			Date date1 = begin_dates[i].getTime();
			Date date2 = end_dates[i].getTime();	

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println(formatter.format(date1) + " " + formatter.format(date2));
			}  

		}

	}

			





}
