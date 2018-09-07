package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import application.interfaces.PersonalSystemGetters;

public class Playground {

	public static void main(String[] args) {
		String pattern = "dd.MM.yyyy";// yyyy-MM-dd HH:mm:ss";
		String dateString = "22.08.2018";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			date = sdf.parse(dateString);
		} catch (Exception e) {
		}
		PersonalSystemGetters.GetRefreshedKimsContent(date);

	}
}