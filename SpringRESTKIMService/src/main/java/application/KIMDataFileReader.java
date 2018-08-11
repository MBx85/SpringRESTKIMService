package application;

import java.io.BufferedReader;
import java.io.FileReader;

public class KIMDataFileReader {
	private static final String filepath = "C:\\Testing\\Kimdata.csv"; // in Properties File auslagern?
	private static final String csvDivider = ";";

	static KIM GetKimFromFile(String kim) {
		KIM kimObject = new KIM();
		try {
			FileReader fileReader = new FileReader(filepath);
			BufferedReader bufferedReader = new BufferedReader(fileReader); // Always wrap FileReader in BufferedReader.
			String line = null;
			boolean IsHeaderLine = true;

			while (((line = bufferedReader.readLine()) != null)) {
				if (!IsHeaderLine) // because header line should not be read
				{
					String[] values = line.split(csvDivider);
					String tempKim = values[CSVSupporter.GetAttributeCSVArrayPos("kim")];
					if(tempKim.equals(kim)) {
						kimObject.setKim(tempKim);
						kimObject.setVorname(values[CSVSupporter.GetAttributeCSVArrayPos("vorname")]);
						kimObject.setNachname(values[CSVSupporter.GetAttributeCSVArrayPos("nachname")]);
					}
				}
				else IsHeaderLine = false; //set during first iteration
			}

			bufferedReader.close();
		} catch (Exception e) {
		}
		return kimObject;
	}
/*
	private String GetAttributeValue(String attribute) {

		return "";
	}
	*/
}
