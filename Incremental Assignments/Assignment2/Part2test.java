public class Part2test{
	
	public static void main(String[] args){

		Part2 obj = new Part2(2);
	}

}



class Part2{

	Part2(int var1){
		this("abcd");

		System.out.println("First Constructor with int parameter");
		

	}

	Part2(String var2){

		System.out.println("Second Constructor with String parameter");

	}
}
