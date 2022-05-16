import java.util.*;
import java.io.*;


class Ostack{

	private int top;
	private int max;
	private String arr[];
	
	
	public Ostack(int n){
		max=n;
		top=-1;
		arr=new String[max];
	}
	public void push(String c){
		top++;
		arr[top]=c;
	}
	public String pop(){
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
	
	public String peek(){
		return arr[top];
		}

}

class PrefxToPostfx{


	static String reverseStr(String str){
	String rvr="";
	for(int i=0,j=str.length()-1;i<str.length();i++,j--){
			rvr+=str.charAt(j);
	}
	System.out.println("Reverse String is "+rvr);
	return rvr;
	
	}
	public static void main(String args[]){
		String prefix,postfix="";
		int n;
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Expression: ");
		prefix=scn.nextLine();
		n=prefix.length();
		Ostack stck=new Ostack(n);
		String opThis;
		String opTop;
		
		prefix=reverseStr(prefix);
		if(!stck.isEmpty()){
			opTop = stck.peek();
		}else{
			opTop="";
		}
		
		int i=0;
		while(i!=prefix.length()){
			opThis=String.valueOf(prefix.charAt(i));
			System.out.println("Postfx is "+opThis);
			if(Character.isLetterOrDigit(opThis.charAt(0))){
				System.out.println("Charcter Detected "+opThis);
				stck.push(opThis);
			}else if(opThis.equals("+")||opThis.equals("-")||opThis.equals("*")||opThis.equals("/")|| opThis.equals("^")){
				System.out.println("Operator Detected "+opThis);
				
				String operand1=stck.pop();
				String operand2=stck.pop();
				String temp=opThis+operand2+operand1;
				stck.push(temp);
				
			}else{
				System.out.println("Syntax Error");
				break;
			}
			i++;	
		}
		while(!stck.isEmpty()){
			postfix+=stck.pop();
		}
		System.out.println("The postfix expression is "+reverseStr(postfix));


}
}


