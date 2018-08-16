package csvStuff;

import application.kim.KIM;

public class KIMDataFileReader extends GeneralDataFileReader {
	private static final String FilePathProperty = "kim.datasource";
	
	public static KIM GetKimFromFile(String kim) {
		KIM kimObject = new KIM();
		try {
			filepath = SetFilePathFromProperty(FilePathProperty);
			FileReaderSupporter frs = new FileReaderSupporter(filepath);

			while (((frs.line = frs.bufferedReader.readLine()) != null)) {
				if (!frs.IsHeaderLine) // because header line should not be read
				{
					String[] values = frs.line.split(csvDivider);
					String tempKim = values[CSVSupporter.GetAttributeCSVArrayPos("kim")];
					if (tempKim.equals(kim)) {
						kimObject.setKim(tempKim);
						kimObject.setVorname(values[CSVSupporter.GetAttributeCSVArrayPos("vorname")]);
						kimObject.setNachname(values[CSVSupporter.GetAttributeCSVArrayPos("nachname")]);
					}
				} else
					frs.IsHeaderLine = false; // set during first iteration
			}

			frs.bufferedReader.close();
		} catch (Exception e) {
		}
		return kimObject;
	}
}
