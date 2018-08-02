import java.io.*;
import java.util.*;
import java.lang.Object;


public class Vampirenos{

	public static void main(String args[]) {

		int number = 1;
		ArrayList<Integer> vampires = new ArrayList<Integer>();
	
		Vampirenos vampirenos = new Vampirenos();
		
		int digits, x=0, n=0;

		while(vampires.size()<100){

			number++;
		
		
			digits = vampirenos.digitcount(number);
		
			

			if(digits%2 == 0){

				for(int i=2; i<=number; i++){

					if(number%i==0 && vampirenos.digitcount(number/i)==(vampirenos.digitcount(number)/2) && vampirenos.digitcount(i)==digits/2){
						if(i%10 == 0 && number/i%10 ==0){

							continue;

						}
						


						else{
							
							
							ArrayList<Integer> factordigits = new ArrayList<Integer>();
		
							factordigits.addAll(vampirenos.getdigits(i));
							factordigits.addAll(vampirenos.getdigits(number/i));
							

							ArrayList<Integer> numberdigits = new ArrayList<Integer>();
			
							numberdigits = vampirenos.getdigits(number);

                                                        if(vampirenos.comparedigits(factordigits, numberdigits)){
								
									

								System.out.println(number);								
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
							
	
	}


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

