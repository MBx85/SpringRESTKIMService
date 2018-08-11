package application;

import java.io.BufferedReader;
import java.io.FileReader;

public class Playground {

	public static void main(String[] args) {
		final String filepath = "C:\\Testing\\Kimdata.csv";
		final String csvDivider = ";";

		try {
			FileReader fileReader = new FileReader(filepath);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = null;
			int linecounter = 0;

			while (((line = bufferedReader.readLine()) != null)) {
				if (linecounter != 0) // because header line should not be read
				{
					String[] values = line.split(csvDivider);

					/*
					 * for (String s : values) { System.out.println(linecounter + " " + s); }
					 */
					System.out.println("Vorname " + values[CSVSupporter.GetAttributeCSVArrayPos("vorname")]);
				}
				linecounter++;
			}

			// Always close files.
			bufferedReader.close();

		} catch (Exception e) {
			System.out.println("EXCEPTION CAUGHT" + e.getMessage());
		}
	}

}
