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

class LinkedList{
	private Link first;
	public LinkedList(){
		first=null;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void insertFirst(int d){
		Link nl=new Link(d);
		if(isEmpty()){
			first=nl;
		}else{
			nl.next=first;
			first=nl;
		}
		
	}
	public Link deleteFirst(){
		Link temp=first;
		first=first.next;
		return first;
	}
	
	public Link deleteLast(){
		Link current=first;
		Link previous=first;
		while(current.next!=null){
			previous=current;
			current=current.next;
		}
		if(current.next==null){

			if(previous==first){
				first=null;
			}
			else{
			previous.next=null;
			}
		}
		
		return current;

	}
	public void displayList(){
		Link current=first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}

			
	}
	public int getLength(){
	Link current=first;
	int count=0;
	while(current!=null){
		count++;	
		current=current.next;
	}
		return count;
	}
	public float avg(){
	int pos;
	Link current=first;
	int count=0;
	float result=0;
	if(getLength()%2==0){
		pos=getLength()/2;
	}else{
		pos=(getLength()+1)/2;
	}	
	while(current!=null){
		count++;
		if(count==pos){
			if(getLength()%2==0){
				result=((float)(current.data+current.next.data))/2;
			}else{
				result=current.data;
			}
		
			break;
			
		}	
		current=current.next;
		}
	
	return result;
	}
	public void swapPos(int pos1,int pos2){
	Link n1=first;
	Link n2=first;
	int count=0;
	while(n1.next!=null){
		if(count==pos1){
			break;
		}
		count++;
		n1=n1.next;
		
	}
	count=0;
	while(n2.next!=null){
		if(count==pos2){
			break;
		}
		count++;
		n2=n2.next;
		
	}
	
	int temp;
	temp=n1.data;
	n1.data=n2.data;
	n2.data=temp;
	
	
	}
	
}
public class SinglyLinkedList{
	public static void main(String args[]){
		int pos1=0,pos2=0;
		int choice=0;
		Scanner scn=new Scanner(System.in);
		LinkedList l=new LinkedList();
		do{
		
			System.out.println("\n------Menu------");
			System.out.println("1. Insert Element\n2. Delete Last\n3. Calculate Avg\n4. Swap\n5. Display\n6. Exit");
			System.out.println("Enter Choice: ");
			choice=scn.nextInt();
			
			switch(choice){
				case 1:
					System.out.println("Enter element: ");
					l.insertFirst(scn.nextInt());
					break;
				case 2:
					System.out.println("\nDeleted Last item: "+l.deleteLast().data);
					break;
				case 3:
					System.out.println("The avg of List is: "+l.avg());
					break;
				case 4:
					if(l.getLength()>=2){
						System.out.println("Enter postions to swap the list:");
						pos1=scn.nextInt();
						pos2=scn.nextInt();
					
						System.out.println("\nBefore Swapping:");
						l.displayList(); 
						l.swapPos(pos1,pos2);
						System.out.println("After Swapping: ");
						l.displayList();
					}else{
						System.out.println("Not enough Elements");
					}
					break;
				case 5:
					System.out.println("The List is");
					l.displayList();
					break;
				case 6:
					break;
				default:
					System.out.println("Some Error Occurred");
					break;
			
			}
		
			//System.out.println("Enter elements :");

			//l.insertFirst(scn.nextInt());
		
			//System.out.println("List is: ");
			//l.displayList();
		
			//System.out.println("The avg of List is: "+l.avg());	
			//System.out.println("\nDeleted Last item: "+l.deleteLast().data);
			//l.displayList();
			//System.out.println("\nThe avg of List is: "+l.avg());
		
			//System.out.println("Enter postions to swap the list:");
			//pos1=scn.nextInt();
			//pos2=scn.nextInt();
		
			//System.out.println("\nBefore Swapping:");
			//l.displayList(); 
			//l.swapPos(pos1,pos2);
			//System.out.println("After Swapping: ");
			//l.displayList();
		}while(choice!=6);
	}
	

}
