package application;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import com.fasterxml.jackson.databind.ObjectMapper;
import application.kim.KIM;

public class KIMCreator {

	private static final int KIMCount = 100000;
	private static final String KimsLocation = "datasource/KIMs/";
	private static final String FileEnding = ".json";

	public static void main(String[] args) {

		for (int i = 1; i <= KIMCount; i++) {
			String kimValue = String.format("%09d",
					Integer.parseInt((new Integer((int) (Math.random() * 1E9))).toString()));
			// zufällige 9-stellige Ziffer
			KIM kim = CreateRandomKIM(kimValue);
			ObjectMapper om = new ObjectMapper();
			try {
				om.writeValue(new File(KimsLocation + kimValue + FileEnding), kim);
			} catch (Exception e) {
			}
		}
	}
	
	private static KIM CreateRandomKIM(String kimValue) {
		KIM kim = new KIM(kimValue);
		final String[] LastNames = {"Maier", "Müller", "Schmidt", "Schulze", "Brand", "Braun"};
		final String[] FirstNames = {"Matthias", "Björn", "Harald", "Patricia", "Kerstin", "Sandra"};
		final String[] Companies = {"0400", "0401", "1111", "2222", "3333"};
		kim.setNachname(LastNames[ThreadLocalRandom.current().nextInt(0,LastNames.length)]);
		kim.setVorname(FirstNames[ThreadLocalRandom.current().nextInt(0,FirstNames.length)]);
		kim.setCompany(Companies[ThreadLocalRandom.current().nextInt(0,Companies.length)]);
		kim.setEmail(kim.InitEmail());
		kim.setUserId(kim.InitUserId());
		//kim.setGeburtstag(new Date());
		return kim;
	}
	
/*	private static Date GetRandomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc.getTime();
	}
	
    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }*/
}
