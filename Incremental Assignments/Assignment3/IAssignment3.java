public class IAssignment3{

	public static void main(String[] args){

		Rodent[] rodents = new Rodent[10];

		rodents[0] = new Mouse("Miku");
		rodents[1] = new Gerbil("Gogo");
		rodents[2] = new Hamster("Hamlet");
	

		System.out.println(rodents[1].run());
	}
}







abstract class Rodent{

	int distance = 0;
	String name;

	Rodent(){
		
		System.out.println("Inside rodent constructor");

	}

	public abstract int run();



}

class Mouse extends Rodent{

	Mouse(String name){
		this.name = name;
		System.out.println("Inside Mouse constructor");

	}

	public int run(){
		this.distance += 20;
		return this.distance;

	}

}

class Gerbil extends Rodent{

	Gerbil(String name){
		this.name = name;
		System.out.println("Inside Gerbil constructor");

	}

	public int run(){
		this.distance += 30;
		return this.distance;
	}

}

class Hamster extends Rodent{

	Hamster(String name){
		this.name = name;
		System.out.println("Inside Hamster constructor");

	}

	public int run(){
		this.distance += 40;
		return this.distance;

	}


}


