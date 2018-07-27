public class Part2{

	public static void main(String[] args){

		Unicycle U1 = new Unicycle();
		Bicycle B1 = new Bicycle();
		Tricycle T1 = new Tricycle();
		
		Cycle[] C1 = new Cycle[10];

		C1[0] = (Cycle) U1;
		C1[1] = (Cycle) B1;
		C1[2] = (Cycle) T1;

		C1[0].balance();
		C1[1].balance();
		C1[2].balance();

		Unicycle U2 = (Unicycle) C1[0];
		Bicycle B2 = (Bicycle) C1[1];
		Tricycle T2 = (Tricycle) C1[2];
				
		U2.balance();
		B2.balance();
		T2.balance();

	}
}

class Cycle{

	public void balance(){

		System.out.println("balancing a cycle");
	}
}

class Unicycle extends Cycle{

	public void balance(){

		System.out.println("balancing a Unicycle");
	}
}


class Bicycle extends Cycle{

	public void balance(){

		System.out.println("balancing a Bicycle");
	}
}


class Tricycle extends Cycle{

	
	
}
