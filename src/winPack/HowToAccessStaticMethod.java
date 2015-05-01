package winPack;

public class HowToAccessStaticMethod{
	  int i;
	  static int j;
	  public static void staticMethod(){
	  System.out.println("you can access a static method this way");
	
	  }
	  public void nonStaticMethod(){
	  i=100;
	  j=1000;
	  System.out.println("Don't try to access a non static method");
	  }
	  public static void main(String[] args) {
	  //i=100;
		  HowToAccessStaticMethod ns = new HowToAccessStaticMethod();
	    
	   j=1000;
//	  nonStaticMethod();
		  j=100;
		  ns.i=5;
		  ns.nonStaticMethod();
	  
	  ns.nonStaticMethod();
	  staticMethod();
	  }
	}
