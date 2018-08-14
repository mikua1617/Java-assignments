public class Part5{

	public static void main(String[] args){

		Second S1 = new Second();
		Second.Secondinner S2 = S1.new Secondinner();
		S2.printer();

	}

}

class First{
		

	class Firstinner{

		Firstinner(int var1){
			
			int var2 = 100;

			var1 = 790;
			System.out.println(var1);

		}
	}
}


class Second{

	class Secondinner extends F1.Firstinner{

		void printer(){

			//System.out.println(var2);
		}
	}
}
