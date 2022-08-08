import java.io.*;
import java.util.*;


class Link{
	public Link next;
	public Link prev;
	public char data;
	
	public Link(char s){
		data=s;
	}
	public void displayLink(){
		System.out.print(data);	
	}

}

class DoublyLinkedList{
	Link first;
	Link last;
	
	public DoublyLinkedList(){
		first=last=null;
	}
	public boolean isEmpty(){
		return first==null;
	}
	
	public void insertFirst(char s){
		Link nl=new Link(s);
		if(!isEmpty()){
			nl.next=first;
			first.prev=nl;
			first=nl;
		}else{
			first=last=nl;	
		}
	}
	
	public void insertLast(char s){
		Link nl=new Link(s);
		if(!isEmpty()){
			nl.prev=last;
			last.next=nl;
			last=nl;
		}else{
			first=last=nl;	
		}
	}
	public void deleteFirst(){

		if(isEmpty()){
			System.out.println("Empty");
		}else if(last==first){
			last=first=null;

		}else{
			first=first.next;
			first.prev=null;
		}
	}
	public void deleteLast(){

		if(isEmpty()){
			System.out.println("Empty");
		}else if(last==first){
			last=first=null;
		}else{

			last=last.prev;
			last.next=null;

		}

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
	public void clearList(){
		first=last=null;
	}
	public String displayBackward(){
		String rvr="";
		Link current=last;
		while(current!=null){
			current.displayLink();
			rvr+=current.data;
			if(current.prev==null){
				break;
			}else{
				current=current.prev;
			}
		}
		
		if(current==null){
			System.out.println("Queue is Empty");
		}
		
		return rvr;
	}
	public void reverseList(){
		Link current=last.prev;
		int count=0;
		while(current!=null){
			insertLast(current.data);
			count++;
			if(current.prev==null){
				break;
			}else{
				current=current.prev;
			}
		}
		for(int i=0;i<count;i++){
			deleteFirst();
		}
	
	}
	


}

class StringReversalDoubly{
	public static void main(String args[]){
		int choice=0;
		String str;
		int i=0;
		DoublyLinkedList dq=new DoublyLinkedList();
		do{
			System.out.println("\n--------Menu--------");
			System.out.println("\n1. Enter String\n2. Reverse\n3. Exit");
			System.out.println("Enter choice: ");
			Scanner scn=new Scanner(System.in);
			choice=scn.nextInt();
			scn.nextLine();
		
			switch(choice){
				case 1:
					System.out.println("Enter string: ");
					str=scn.nextLine();
					i=0;
					dq.clearList();
					while(i!=str.length()){
						dq.insertLast(str.charAt(i));
						i++;
					}
					break;
				case 2:
					System.out.println("Reverse String is: ");
					dq.reverseList();
					dq.displayForward();
					break;
				case 3:
					break;
				default:
					System.out.println("Something went wrong");
			
			}
		
		}while(choice!=3);
}
}
