import java.io.*;


class ReadName{
	public static void main(String args[]) throws IOException{
	int i;
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader bp=new BufferedReader(isr);
	System.out.println("Enter number 1");
	String temp=bp.readLine();
	i=Integer.parseInt(temp);
	
	int j;
	System.out.println("Enter number 1");
	temp=bp.readLine();
	j=Integer.parseInt(temp);
	
	System.out.println("Sum of the two numbers are : "+(i+j));
	
	}

}
