package winPack;

import java.io.Console;
import java.util.Scanner;

public class NonStaticVariable{
	  int noOfInstances;
	  
	  NonStaticVariable(){
		  
	  this.noOfInstances = noOfInstances+1;
	  noOfInstances++;
	  
	  
	  } 
	  
	  
	  public static void main(String[] args){
		  
		  int a,b;
		  Scanner sc = new Scanner(System.in);
		  a= sc.nextInt();
		  b= sc.nextInt();
		  b=a+b;
		  a=b-a;
		  b=b-a;
		  System.out.println("a:"+a+"b:"+b);
		  sc.close();

	  NonStaticVariable st1 = new NonStaticVariable();
	  System.out.println("No. of instances  for st1  : " 
	  + st1.noOfInstances);

	  NonStaticVariable st2 = new NonStaticVariable();
	  System.out.println("No. of instances  for st1  : " 
	  + st1.noOfInstances);
	  System.out.println("No. of instances  for st2  : " 
	  + st2.noOfInstances);

	  NonStaticVariable st3 = new NonStaticVariable();
	  System.out.println("No. of instances  for st1  : " 
	  + st1.noOfInstances);
	  System.out.println("No. of instances  for st2  : " 
	   + st2.noOfInstances);
	  System.out.println("No. of instances  for st3  : " 
	  + st3.noOfInstances);

	  }
	}