package application;


import java.util.Date;
import application.kim.KIM;
import csvStuff.KIMDataFileReader;

public class Playground {

	public static void main(String[] args) {
		KIM kim = new KIM("111111");
		kim.setVorname("Vor");
		kim.setNachname("Nach");
		Date date = new Date();
		kim.setGeburtstag(date);
		KIMDataFileReader.PutKimIntoFile(kim);
	}
}