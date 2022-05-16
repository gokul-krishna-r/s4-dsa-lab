import java.io.*;
import java.util.*;

class Prgm3{
	public static void main(String args[]){
	int sum=0;
	int i[]=new int[10];
	int n=10;
	float avg;
	Scanner scn=new Scanner(System.in);

	for(int j=0;j<n;j++){
		System.out.println("Enter number "+(j+1));
		i[j]=scn.nextInt();
		sum+=i[j];
	}
	System.out.println("Sum of the numbers are: "+sum);
	avg=(float)sum/n;
	
	System.out.println("Avg of the numbers are: "+avg);


	
	}

}
