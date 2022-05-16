import java.util.*;
import java.io.*;



class Ostack{

	private int top;
	private int max;
	private float arr[];
	
	
	public Ostack(int n){
		max=n;
		top=-1;
		arr=new float[max];
	}
	public void push(float c){
		top++;
		arr[top]=c;
	}
	public float pop(){
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
	
	public float peek(){
		return arr[top];
		}

}

class PostfxEval{


	public static float evalOperator(String op,float operand1,float operand2){
		switch(op){
			case "+":
				return operand1+operand2;
			case "-":
				return operand1-operand2;
			case "/":
				return operand1/operand2;
			case "*":
				return  operand1*operand2;
			case "%":
				return operand1%operand2;
			case "^":
				return (float)Math.pow(operand1,operand2);
			default:
				return -1;
		}
	}
	public static void main(String args[]){
		String postfix="";
		int n;
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Expression: ");
		postfix=scn.nextLine();
		n=postfix.length();
		Ostack stck=new Ostack(n);
		String opThis;
		
		int result=0;
		int i=0;
		while(i!=postfix.length()){
			opThis=String.valueOf(postfix.charAt(i));
			if(Character.isLetterOrDigit(opThis.charAt(0))){
				stck.push(Float.parseFloat(opThis));
			}else if(opThis.equals("+")||opThis.equals("%")||opThis.equals("-")||opThis.equals("*")||opThis.equals("/")|| opThis.equals("^")){
				float operand2=stck.pop();
				float operand1=stck.pop();
				result=(int)evalOperator(opThis,operand1,operand2);
				stck.push(result);
				System.out.println(result+"\n");
				
			}else{
				System.out.println("Syntax Error");
				break;
			}
			i++;	
		}
		while(!stck.isEmpty()){
			result=(int)stck.pop();
		}
		System.out.println("The Result of the Postfix Expression is: "+result);


}
}


