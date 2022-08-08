import java.util.*;

class Node{
	public int data;
	public Node next;
	public Node(int d){
		data=d;
	}
	public void displayNode(){
		System.out.println(data);
	}
}

class PriorityQueueStruct{
	private Node front;
	public PriorityQueueStruct(){
		front=null;
	}
	public boolean isEmpty(){
		return front==null;
	}
	public void enQueue(int d){
		Node nl=new Node(d);
		Node current=front;
		Node previous=front;
		if(isEmpty()){
			front=nl;
		}else{
		while(current!=null){
			if(current==front  && current.data>nl.data){
				nl.next=current;
				front=nl;
				break;
			}else if(current.data>nl.data){
				previous.next=nl;
				nl.next=current;
				break;
			}else if(current.next==null && current.data<nl.data){
				current.next=nl;
			}else{
				previous=current;
				current=current.next;
			}
	}
	}
		
	}
	public Node deleteFirst(){
		Node temp=front;
		front=front.next;
		return front;
	}
	
	public int deQueue(){
		Node current=front;
		Node previous=front;
		while(current!=null){
			if(current.next==null){
				break;
			}else{
				previous=current;
				current=current.next;
			}
		}
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return -1;
		}
		else if(current.next==null){

			if(current==front){
				front=null;
			}
			else{
			previous.next=null;
			}
		}
		
		return current.data;

	}
	public void displayQueue(){
		Node current=front;
		while(current!=null){
			current.displayNode();
			if(current.next==null){
				break;
			}else{
				current=current.next;
			}
		}
		
		if(isEmpty()){
			System.out.println("Empty");
		}

			
	}
}


class PriorityQueue{

	public static void main(String args[]){
		PriorityQueueStruct q=new PriorityQueueStruct();
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
				q.enQueue(d);
				break;
			case 2:
				System.out.println("The deleted item is :"+q.deQueue());
				break;
			case 3:
				System.out.println("The Entered Queue is: ");
				q.displayQueue();
				break;
			case 4:
				break;
			default:
				System.out.println("Something went wrong");
		
		}
		}while(choice!=4);
	
	}
}
