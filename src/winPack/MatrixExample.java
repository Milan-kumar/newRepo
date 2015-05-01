package winPack;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;

class MatrixExample{
	  public static void main(String[] args)  {
	  int array[][]= {{1,3,5},{2,4,6}};
	  DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY HH:mm:ss:SSS");
	  Date date = new Date();
	  System.out.println("time:"+dateFormat.format(date));
	  Calendar cal= Calendar.getInstance();
	  System.out.println("time:"+dateFormat.format(cal.getTime()));
	  System.out.println("time:"+LocalDateTime.now());
	  System.out.println("Row size= " + array.length);
	  System.out.println("Column size = " + array[1].length);
	  outputArray(array);
	  }
	  
	  
	  
	 public static void outputArray(int[][] array) {
	 int rowSize = array.length;
	 int columnSize = array[0].length;
	 for(int i = 0; i <= 1; i++) {
	 System.out.print("[");
	 for(int j = 0; j <= 2; j++) {
	 System.out.print(" " + array[i][j]);
	 }
	 System.out.println(" ]");
	 }
	 System.out.println();
	 }
	}