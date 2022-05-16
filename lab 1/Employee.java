import java.io.*;
import java.util.*;

class Employee{
	public static void main(String args[]){
	int age;
	float salary;
	String name;
	char gender;
	
	Scanner scn=new Scanner(System.in);
	
	System.out.println("Enter Name of the Employee ");
	name=scn.nextLine();
	
	System.out.println("Enter Gender of the Employee ");
	String temp=scn.nextLine();
	gender=temp.charAt(0);
	
	System.out.println("Enter Age of the Employee ");
	age=scn.nextInt();
	
	System.out.println("Enter Salary of the Employee ");
	salary=scn.nextFloat();
	

	
	System.out.println("Name = "+name+"\nGender = "+gender+"\nAge = "+age+"\nSalary = "+salary);
	
	}

}
