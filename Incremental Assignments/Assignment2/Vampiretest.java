import java.io.*;
import java.util.*;
import java.lang.Object;

public class Vampiretest{

	public static void main(String[] args){

		System.out.println("Enter the number of vampire nos needed");
		Scanner reading = new Scanner(System.in);
		int count = reading.nextInt();

		Vampires V = new Vampires(count);
		V.printvampires(V);
	}
		
}




class Vampires{

	private int numcount;

	public Vampires(int c){
		numcount = c;
	} 

	public Vampires(){}

	public ArrayList<Integer> logic(){

		int number = 1;
		ArrayList<Integer> vampires = new ArrayList<Integer>();
	
		Operations operations = new Operations();
		
		int digits, x=0, n=0;

		while(vampires.size()<numcount){

			number++;
		
		
			digits = operations.digitcount(number);
		
			

			if(digits%2 == 0){

				for(int i=2; i<=number; i++){

					if(number%i==0 && operations.digitcount(number/i)==(operations.digitcount(number)/2) && operations.digitcount(i)==digits/2){
						if(i%10 == 0 && number/i%10 ==0){

							continue;

						}
						


						else{
							
							
							ArrayList<Integer> factordigits = new ArrayList<Integer>();
		
							factordigits.addAll(operations.getdigits(i));
							factordigits.addAll(operations.getdigits(number/i));
							

							ArrayList<Integer> numberdigits = new ArrayList<Integer>();
			
							numberdigits = operations.getdigits(number);

                                                        if(operations.comparedigits(factordigits, numberdigits)){
																
								n++;								
								vampires.add(number);						
								break;
								
							}
						}

							
			
	
					}
				}
			}

			else {

			continue;
			}

		
		}
	return vampires;

	}


	public void printvampires(Vampires V){

		ArrayList<Integer> vampires = new ArrayList<Integer>();
		System.out.println("Please Wait. Calculating");
		vampires = V.logic();
		

		for (Integer a: vampires){

			System.out.println(a);
		}
	}
}


class Operations{



	public int digitcount(int num){
		
		int count=0;		
		
		while(num!=0){
		
			num /= 10;
			count++;
		}
		
	return count;
	}			

	

	public ArrayList<Integer> getdigits(int num){

		ArrayList<Integer> digits = new ArrayList<Integer>();

		while(num!=0){

			digits.add(num%10);
			num /= 10;
		}
	
	return digits;

	}
	
		

	public boolean comparedigits(ArrayList<Integer> factor, ArrayList<Integer> num){

		Collections.sort(factor);
		Collections.sort(num);

		return factor.equals(num);
	}

	
}
