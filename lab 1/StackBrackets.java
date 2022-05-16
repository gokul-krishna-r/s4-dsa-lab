import java.util.*;
import java.io.*;


class Bstack{

	private int top;
	private int max;
	private char arr[];
	
	
	public Bstack(int n){
		max=n;
		top=-1;
		arr=new char[max];
	}
	public void push(char c){
		top++;
		arr[top]=c;
	}
	public char pop(){
		return arr[top--];
	}
	public char peek(){
		return arr[top];
	}
	public boolean isFull(){
		if(top==max-1){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isEmpty(){
		if(top==-1){
			return true;
		}else{
			return false;
		}
	
	}

}

class StackBrackets{
	public static void main(String args[]){
		String text;
		int n;
		int flag=0;
		int count=0;
		char curr;
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter expression: ");
		text=scn.nextLine();
		
		n=text.length();
		
		scn.close();
		Bstack stck=new Bstack(n);
		
		for(int i=0;i<n;i++){
			if(!stck.isFull()){
				flag=0;
				curr=text.charAt(i);
				
				if(curr=='{' || curr=='('|| curr=='['){
					stck.push(curr);
				}
				
				if(curr=='}'||curr==')' || curr==']'){
					
					if(stck.isEmpty()){
						flag=0;
						break;		
					}
					char open=stck.pop();
					if((open=='{' && curr=='}') || (open=='(' && curr==')') || (open=='[' && curr==']')){
						flag=1;
						count++;
						
					}
					else{
					flag=0;
						break;
					}
				
				}
			}
		}
	/*int pop_flag=0;
	if(!stck.isEmpty()){
		stck.pop();
		pop_flag=1;
	}*/
	if(stck.isEmpty()){

		if(flag==1){		
			System.out.println("Expression is matched:\nNo. of valid brackets: "+count);
		}else{
			System.out.println("Expression is not matched:\nMaximum no. of valid brackets: "+count);
			
			
		}
	
	}else{
			System.out.println("Expression is not matched:\nMaximum no. of valid brackets: "+count);
		}
		
	
	

}
}



