import java.lang.*;
import java.util.*;

public class SList<T> {

	public Node<T> first = null;

	public String toString(){
	
		StringBuilder stringBuilder = new StringBuilder();
		
		Node temp = first;
		

		while(temp.getNext()!=null){
			stringBuilder.append(temp.getValue()+" --> ");
			temp = temp.getNext();
		}

		stringBuilder.append(temp.getValue());

		return stringBuilder.toString();
	}

	
	SListIterator<T> iterator() { 

		return new SListIterator<T>(first); 
	}

		

	
	
	public static void main(String[] args) {
		SList<Integer> L1 = new SList<Integer>();

		SListIterator<Integer> list = L1.iterator();

		Scanner reader = new Scanner(System.in);
		
		int choice=0;

		while (choice!=100){

			System.out.println("Enter your choice. Enter 1 for inserting, 2 for removing, 3 to print and 100 to exit");
			choice = reader.nextInt();

			switch(choice){

				case 1: System.out.println("enter value to be inserted in the list");
					int val = reader.nextInt();
					list.insert(new Node<Integer>(val));
					break;

				case 2: list.remove();
					break;

				case 3: L1.first = list.first;
					System.out.println("The list is - ");
					System.out.println(L1);
					break;
		
				case 100: break;

				default: System.out.println("Ivalid input");
					break;
			}
		}
				
	}

}

class Node<T> {
	private T value;
	private Node<T> next;

	public Node(T value) {
		this.value = value;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getNext() {
		return next;
	}

	public T getValue() {
		return value;
	}
}
	

class SListIterator<T> {

	public Node<T> first = null;

	SListIterator(Node<T> node) {
		first = node;
	}
		
	public void insert(Node<T> node) {
		node.setNext(first);
		first = node;
	}

	public void remove(){
		if(first.getNext()!=null)
			first = first.getNext();
		else first = null;
	}
	
}


			

				

	
	

		   














