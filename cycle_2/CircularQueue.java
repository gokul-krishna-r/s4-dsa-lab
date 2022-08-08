import java.util.*;
import java.io.*;


class Link{
	public int data;
	public Link next;
	public Link(int d){
		data=d;
	}
	public void displayLink(){
		System.out.println(data);
	}
}

class Queue{
	private Link front;
	private Link rear;


	public Queue(){
		front=null;
		rear=null; 
	}
	public boolean isEmpty(){
		return rear==null;
	}

	public void insertLast(int d){
		Link temp;
		Link nl=new Link(d);
		if(isEmpty()){
			front=nl;
			rear=nl;
		}else{
			rear.next=nl;	
			
		}
		nl.next=front;
		rear=nl;
	}
	public Link deleteFirst(){

		Link temp=null;
		if(isEmpty()){
			System.out.println("Empty");
		}else{
			if(front==rear){
				rear=null;
				front=null;
				System.out.println("Emptied");
			}else{
				temp=front;
				front=front.next;
				rear.next=front;
		}		
	}
	return temp;
	}
	
		
	

	public void displayList(){
		Link current=front;
		while(current!=null){
			current.displayLink();
			if(current.next==front){
				break;
			}else{
			current=current.next;
			}
		}
		if(current==null){
		System.out.println("Queue is Empty");
		
		}

			
	}
	public int getLength(){
	Link current=front;
	int count=0;
	while(current!=null){
		count++;	
		current=current.next;
	}
		return count;
	}
	
	
}


class CircularQueue{


	public static void main(String args[]){
		Queue q=new Queue();
		
		int choice=0;
		int d;
		do{
		System.out.println("--------Menu--------");
		System.out.println("\n1. Insert Item\n2. Delete Item\n3. Display queue\n4. Exit");
		System.out.println("Enter choice: ");
		
		Scanner scn=new Scanner(System.in);
		choice=scn.nextInt();
		
		switch(choice){
			case 1:
				System.out.println("Enter value to insert: ");
				d=scn.nextInt();
				q.insertLast(d);
				break;
			case 2:
				q.deleteFirst();
				break;
			case 3:
				System.out.println("The Entered Queue is: ");
				q.displayList();
				break;
			case 4:
				break;
			default:
				System.out.println("Something went wrong");
		
		}
		
		
		
		}while(choice!=4);

		
	
	}


}
