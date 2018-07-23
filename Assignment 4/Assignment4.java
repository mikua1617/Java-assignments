import java.util.*;
import java.io.*;
import java.lang.Character;
import java.text.SimpleDateFormat;  

public class Assignment4{
	
	public static void main(String[] args){

		
		
		KYCDates D1 = new KYCDates();
		D1.makecalendar(D1.getdates()); 
		D1.finddaterange();
		D1.printvaliddates();
		
	}

	public int getinputnos(){
		
		System.out.println("Enter the number of dates to be entered");
        	Scanner reading = new Scanner(System.in);
        	int number_of_dates = reading.nextInt();
		
		return number_of_dates;
	}
}

		
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




	public String[] getdates(){
		

		System.out.println("Enter the dates");
		String[] dateinputs = new String[number_of_dates];

		Scanner reading2 = new Scanner(System.in);
		
		for(int i=0; i<number_of_dates; i++)
			dateinputs[i] = reading2.nextLine();

		return dateinputs;		
			  

	}





	public void makecalendar(String[] dateinputs){

		
		for(int i=0; i<number_of_dates; i++){
		
			
			joining_dates[i] = new GregorianCalendar(Integer.parseInt(dateinputs[i].substring(6,10)), Integer.parseInt(dateinputs[i].substring(3,5))-1, Integer.parseInt(dateinputs[i].substring(0,2)));
			

			current_dates[i] = new GregorianCalendar(Integer.parseInt(dateinputs[i].substring(17)), Integer.parseInt(dateinputs[i].substring(14,16))-1, Integer.parseInt(dateinputs[i].substring(11,13)));


		}
	}




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
