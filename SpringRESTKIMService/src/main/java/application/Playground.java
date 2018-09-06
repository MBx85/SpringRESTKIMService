package application;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Playground {

	public static void main(String[] args) {
		String dateString = "1985-08-26T22:06:33";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		
		try {Date date = sdf.parse(dateString);
		System.out.println(date);
		}
		catch(Exception e) {
			
		}
		}
	
	}


