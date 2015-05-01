package winPack;


import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
 
public class GetCurrentDateTime {
	int i;
	static int j;
	public static void staticMethod(){
		
		System.out.println("accessing static");
	}
	
	public void nonStatic(){
		System.out.println("non Static");
		System.out.println(j);
	}
	
  public static void main(String[] args) {
	  staticMethod();
	  GetCurrentDateTime a = new GetCurrentDateTime();
	  
	  j=100;
	  a.i=5;
	  a.nonStatic();
	  
	  
 
	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");
	   //get current date time with Date()
	   Date date = new Date();
	   System.out.println(dateFormat.format(date));
 
	   //get current date time with Calendar()
	   Calendar cal = Calendar.getInstance();
	   System.out.println(dateFormat.format(cal.getTime()));
	   
	   System.out.println("time:"+cal.get(Calendar.DAY_OF_YEAR)+cal.get(Calendar.DAY_OF_MONTH)+cal.get(Calendar.DAY_OF_WEEK)+cal.get(Calendar.MONTH));
	   
	   System.out.println("time:"+LocalDateTime.now());
	   System.out.println("time:"+System.currentTimeMillis());
 
  }
}
