public class part3{

	public static void main(){

		inheritor obj1 = new inheritor();

	}
}

interface iface1{

	void method1();
	void method2();
}

interface iface2{

	void method3();
	void method4();
}

interface iface3{

	void method5();
	void method6();
}


interface inherited extends iface1, iface2, iface3{

	void method7();
}


class concrete{

}

class inheritor extends concrete implements inherited{

	void method8(iface1 first){

	}

	void method9(iface2 second){
	
	}

  	void method10(iface3 third){
	
	}

	void method11(inherited fourth){
	
	}
} 





















