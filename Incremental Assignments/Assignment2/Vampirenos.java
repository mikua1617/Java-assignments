import java.io.*;
import java.util.*;
import java.lang.Object;


public class Vampirenos{

	public static void main(String args[]) {

		int number = 1;
		ArrayList<Integer> vampires = new ArrayList<Integer>();
		
		int digits, x=0, n=0;

		while(vampires.size()<100){

			number++;
		
		
			digits = Vampirenos.digitcount(number);
		
			

			if(digits%2 == 0){

				for(int i=2; i<=number; i++){

					if(number%i==0 && Vampirenos.digitcount(number/i)==(Vampirenos.digitcount(number)/2) && Vampirenos.digitcount(i)==digits/2){
						if(i%10 == 0 && number/i%10 ==0){

							continue;

						}
						


						else{
							
							
							ArrayList<Integer> factordigits = new ArrayList<Integer>();
		
							factordigits.addAll(Vampirenos.getdigits(i));
							factordigits.addAll(Vampirenos.getdigits(number/i));
							

							ArrayList<Integer> numberdigits = new ArrayList<Integer>();
			
							numberdigits = Vampirenos.getdigits(number);

                                                        if(Vampirenos.comparedigits(factordigits, numberdigits)){
								
									

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


	public static int digitcount(int num){
		
		int count=0;		
		
		while(num!=0){
		
			num /= 10;
			count++;
		}
		
	return count;
	}			

	

	public static ArrayList<Integer> getdigits(int num){

		ArrayList<Integer> digits = new ArrayList<Integer>();

		while(num!=0){

			digits.add(num%10);
			num /= 10;
		}
	
	return digits;

	}
	
		

	public static boolean comparedigits(ArrayList<Integer> factor, ArrayList<Integer> num){

		Collections.sort(factor);
		Collections.sort(num);

		return factor.equals(num);
	}

		

		





















	


}

