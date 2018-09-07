package application;

import application.kim.KIM;
import csvStuff.KIMDataFileReader;

public class Playground2 {

	public static void main(String[] args) {
		KIM kim = new KIM("998899");
		kim.setVorname("Max");
		kim.setNachname("Müller");
		KIMDataFileReader.PutKimIntoFile(kim);
	}

}
