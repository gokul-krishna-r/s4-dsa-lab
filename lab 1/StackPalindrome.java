import java.util.*;
import java.io.*;


class Ostack{

	private int top;
	private int max;
	private char arr[];
	
	
	public Ostack(int n){
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

class StackPalindrome{
	public static void main(String args[]){
		String text;
		String palindrome="";
		int n;
		int flag=0;
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Enter string: ");
		text=scn.nextLine().toLowerCase();
		n=text.length();
		Ostack stck=new Ostack(n);
		
		for(int i=0;i<n;i++){
			if(!stck.isFull()){
				stck.push(text.charAt(i));
			}
		}
		while(!stck.isEmpty()){
			palindrome=palindrome+stck.pop();
		}
	
		if(palindrome.equals(text)){
			System.out.println("The sequence is palindrome");
		}else{
			System.out.println("The sequence is not palindrome");
	}

}
}


