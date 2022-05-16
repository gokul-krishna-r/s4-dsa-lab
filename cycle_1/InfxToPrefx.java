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
	
	public char peek(){
		return arr[top];
		}

}

class InfxToPrefx{

	static int precedence(char ch){
	switch(ch){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
	}
	}
	static String reverseStr(String str){
	String rvr="";
	for(int i=0,j=str.length()-1;i<str.length();i++,j--){
		if(str.charAt(j)=='('){
			rvr+=')';
		}else if(str.charAt(j)==')'){
			rvr+='(';
		}else{
			rvr+=str.charAt(j);
		}

	}
	System.out.println("Reverse String is "+rvr);
	return rvr;
	
	}
	public static void main(String args[]){
		String infix,postfix="";
		int n;
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Expression: ");
		infix=scn.nextLine();
		n=infix.length();
		Ostack stck=new Ostack(n);
		char opThis,opTop;
		
		infix=reverseStr(infix);
		if(!stck.isEmpty()){
			opTop = stck.peek();
		}else{
			opTop=' ';
		}
		
		int i=0;
		while(i!=infix.length()){
			opThis=infix.charAt(i);
			if(Character.isLetterOrDigit(opThis)){
				System.out.println("Charcter Detected "+opThis);
				postfix+=opThis;
				System.out.println("The postfix expression is "+postfix);
			}else if(opThis==')'){
				while(!stck.isEmpty()){
					opTop=stck.peek();
					if(opTop=='('){
						stck.pop();

						break;
					}else{
						postfix+=stck.pop();

						System.out.println("The postfix expression is "+postfix);
					}
				
				}
				
			}else if(opThis=='+'||opThis=='-'||opThis=='*'||opThis=='/'||opThis=='^'||opThis==')'||opThis=='('){
				System.out.println("Operator Detected "+opThis);
				if(opThis=='('){
					stck.push(opThis);
					
				}else{
						char item=' ';
						while(!stck.isEmpty()){
							item=stck.peek();
							if(precedence(item)<=precedence(opThis)){
								break;
							}else if(precedence(item)>precedence(opThis)){
								postfix+=stck.pop();
								System.out.println("The postfix expression is "+postfix);
							}else if(precedence(item)<precedence(opThis) || item=='('){
								break;
							}
						}
						stck.push(opThis);
						System.out.println("stack is "+stck.peek());
						

						

				}

				
				
			}else{
				System.out.println("Syntax Error");
				break;
			}
			i++;	
		}
		while(!stck.isEmpty()){
			postfix+=stck.pop();
		}
		System.out.println("The postfix expression is "+postfix);
		System.out.println("The prefix expression is "+reverseStr(postfix));


		

}
}


