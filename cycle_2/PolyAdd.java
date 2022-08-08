
import java.util.*;
import java.io.*;

class Link{
	public int coeff;
	public int exp;
	public Link next;
	public Link(int coeff,int exp){
		this.exp=exp;
		this.coeff=coeff;
	}
	public void displayLink(){
		if(exp!=0){
			System.out.print(String.valueOf(coeff)+"x^"+String.valueOf(exp));
		}else{
			System.out.print(String.valueOf(coeff));
		}		

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
	public void insertFirst(int x,int e){
		Link nl=new Link(x,e);
		if(isEmpty()){
			first=nl;
		}else{
			nl.next=first;
			first=nl;
		}
		
	}
	public void insertLast(int x,int e){
		Link nl=new Link(x,e);
		Link cur=first;
		if(isEmpty()){
			first=nl;
		}else{
			while(cur.next!=null){
				cur=cur.next;
			}
			if(cur.next==null){
				cur.next=nl;
			}

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
			if(current.next !=null && current.next.coeff>0){
				System.out.print("+");
			} 
			current=current.next;
		}
		System.out.println("\n");
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
	public LinkedList readString(String poly){
		String x="",p="";
		int flag=0,sign=0,insertCoeff=0,insertExp=0;
		char c;
		int i=-1;
		while(i!=poly.length()){

			for(i=i+1;i<poly.length();i++){
				c=poly.charAt(i);
				
				if(c == 'x'){
					continue;
				}else if(c=='^'){
					flag=1;
					continue;
				
				}else if(c=='+' || c=='-'){
					flag=0;
					break;
				}

			
				if(c !='x' && flag==0){
					if(i!=0 && poly.charAt(i-1)=='-'){
						x+='-';
					}
					x+=c;
					System.out.println("x: "+x);
				}
				else if(c != '^' && flag==1 &&( c !='+' ||  c !='-')){
					 p+=c;
					 System.out.println("p: "+p);
				}
			}
		
				if(x!="" && p!=""){
					
					 	insertLast(Integer.parseInt(x),Integer.parseInt(p));
					 	x="";
					 	p="";
					}
					
				}
			
			return this;
		}
			
			
			

	 
	public LinkedList addPoly(LinkedList l2){
		LinkedList result = new LinkedList();
		Link node1=this.first;
		Link node2=l2.first;
		Link res=new Link(0,0);
		int count=0;
		
		while(node1!=null || node2 != null){
			if(node1 == null){
				res.coeff=node2.coeff;
				res.exp=node2.exp;
				node2=node2.next;
			}else if(node2 == null){
				res.coeff=node1.coeff;
				res.exp=node1.exp;
				node1=node1.next;
			}else if(node1.exp==node2.exp){
				res.coeff=node1.coeff+node2.coeff;
				res.exp=node1.exp;
				node1=node1.next;
				node2=node2.next;
			}else if(node1.exp<node2.exp){
				res.coeff=node2.coeff;
				res.exp=node2.exp;
				node2=node2.next;
			}else if(node1.exp>node2.exp){
				res.coeff=node1.coeff;
				res.exp=node1.exp;
				node1=node1.next;
			}
			result.insertLast(res.coeff,res.exp);	
		
		}
		return result;
	}
	
	
	
	
	
}
public class PolyAdd{

	
	public static void main(String args[]){
		int pos1=0,pos2=0;
		int choice=0;
		String x="";
		String p="";
		String poly1,poly2;
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter First Polynomial: ");
		poly1=scn.nextLine();
		
		System.out.println("Enter Second Polynomial: ");
		poly2=scn.nextLine();

		LinkedList l1=new LinkedList();
		LinkedList l2=new LinkedList();
		l1=l1.readString(poly1);
		l2=l2.readString(poly2);
		
		System.out.println("The polynomial 1: ");
		l1.displayList();
		System.out.println("The polynomial 2: ");
		l2.displayList();
		LinkedList result=l1.addPoly(l2);
		
		System.out.println("The polynomial After Addition is: ");
		result.displayList();
		
	}
//		Output
//		Enter First Polynomial: 
//		13x^5-9x^3+8x^2+17x^0
//		Enter Second Polynomial: 
//		1x^4+6x^3-3x^2+7x^1-10x^0

}
