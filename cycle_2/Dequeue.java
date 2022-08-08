import java.io.*;
import java.util.*;


class Link{
	public Link next;
	public Link prev;
	public int data;
	
	public Link(int s){
		data=s;
	}
	public void displayLink(){
		System.out.println(data);	
	}

}

class DoublyLinkedList{
	Link first;
	Link last;
	
	public DoublyLinkedList(){
		first=last=null;
	}
	public boolean isEmpty(){
		return first==null || last==null;
	}
	
	public void insertFirst(int s){
		Link nl=new Link(s);
		if(isEmpty()){
			first=last=nl;
		}else{
			nl.next=first;
			first.prev=nl;
			first=nl;
		}
	}
	
	public void insertLast(int s){
		Link nl=new Link(s);
		if(isEmpty()){
			first=last=nl;
			
		}else{
			nl.prev=last;
			last.next=nl;
			last=nl;	
		}
	}
	public int deleteFirst(){
		int value;
		if(isEmpty()){
			System.out.println("Empty");
		}else if(first==last){
			value=last.data;
			last=first=null;
			return value;

		}else{
			value=first.data;
			first=first.next;
			first.prev=null;
			return value;

		}
		return -1;
	}
	public int deleteLast(){
		int value;
		if(isEmpty()){
			System.out.println("Empty");
		}else if(first==last){
			value=last.data;
			last=first=null;
			return value;

		}else{
			value=last.data;
			last=last.prev;
			last.next=null;
			return value; 
		}
		return -1;
	}
	public void displayForward(){
		Link current=first;
		while(current!=null){
			current.displayLink();
			if(current.next==null){
				break;
			}else{
				current=current.next;
			}
		}
		if(current==null){
			System.out.println("Queue is Empty");
		}
	} 
	public void displayBackward(){
		Link current=last;
		while(current!=null){
			current.displayLink();
			if(current.prev==null){
				break;
			}else{
				current=current.prev;
			}
		}
		
		if(current==null){
			System.out.println("Queue is Empty");
		}
	}

}

class DeQueueStruct{
	DoublyLinkedList dl=new DoublyLinkedList();
	
	public void insertFront(int s){
		dl.insertFirst(s);
	}
	public void insertRear(int s){
		dl.insertLast(s);
	}
	public int deleteFront(){
		return dl.deleteFirst();
	}
	public int deleteRear(){
		return dl.deleteLast();
	}
	public void displayQueue(){
		System.out.println("The Queue is: ");
		dl.displayForward();
	}



}
class Dequeue{
	public static void main(String args[]){
		int choice=0;
		DeQueueStruct dq=new DeQueueStruct();
		int d;
		do{
			System.out.println("--------Menu--------");
			System.out.println("\n1. Insert Front\n2. Insert Rear\n3. Delete Front\n4. Delete Rear\n5. Display Queue\n6. Exit");
			System.out.println("Enter choice: ");
			
			Scanner scn=new Scanner(System.in);
			choice=scn.nextInt();
		
			switch(choice){
				case 1:
					System.out.println("Enter value to insert: ");
					d=scn.nextInt();
					dq.insertFront(d);
					break;
				case 2:
					System.out.println("Enter value to insert: ");
					d=scn.nextInt();
					dq.insertRear(d);
					break;
				case 3:
					d=dq.deleteFront();
					if(d==-1){
						
					}else{
						System.out.println("The deleted item is "+d);
					}

					break;
				case 4:
					d=dq.deleteRear();
					if(d==-1){
					
					}else{
						System.out.println("The deleted item is "+d);
					}


					break;
				case 5:
					System.out.println("The Entered Queue is: ");
					dq.displayQueue();
					break;
				case 6:
					break;
				default:
					System.out.println("Something went wrong");
			
			}
		
		}while(choice!=6);
}
}
