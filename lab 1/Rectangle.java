import java.io.*;


class Rectangle{
	public static void main(String args[]) throws IOException{
	int length,breadth;
	
	InputStreamReader isr=new InputStreamReader(System.in);
	BufferedReader bp=new BufferedReader(isr);
	
	System.out.println("Enter length of the Rectangle");
	String temp=bp.readLine();
	length=Integer.parseInt(temp);
	
	System.out.println("Enter breadth of the Rectangle");
	temp=bp.readLine();
	breadth=Integer.parseInt(temp);
	
	System.out.println("Area of the Rectangle is : "+(length*breadth));
	
	}

}
