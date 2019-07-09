package classtest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTest {

	public static void main(String[] args) {
		
		Date today = new Date();
		System.out.println(today);
		
		
		SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd. hh:mm");
		String dateStr = date.format(today);
		System.out.println(dateStr);
		
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
		String timeStr = time.format(today);
		System.out.println(timeStr);
	
	}
	

}
