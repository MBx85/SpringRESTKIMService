package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Playground {

	public static void main(String[] args) {
		final String filepath = "C:\\Testing\\Kimdata.csv";
		final String filepath2 = "C:\\Testing\\Kimdata2.csv";
		final String csvDivider = ";";
		File file2Read = new File(filepath);
		File file2Write = new File(filepath2);
		
		
		try {
			FileReader fileReader = new FileReader(filepath);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter fw = new FileWriter(filepath2);
						
			String line = null;
			int linecounter = 0;
			while (((line = bufferedReader.readLine()) != null)) {
				fw.write(line+ "\r\n");
				if (linecounter != 0) // because header line should not be read
				{
					String[] values = line.split(csvDivider);
					System.out.println("Vorname " + values[CSVSupporter.GetAttributeCSVArrayPos("vorname")]);
				}
				linecounter++;
			}
			fw.close();
			// Always close files.
			bufferedReader.close();
			file2Write.renameTo(file2Read);
			FileWriter CleanUpper = new FileWriter(filepath2);
			CleanUpper.write("");
			CleanUpper.close();
			
		} catch (Exception e) {
			System.out.println("EXCEPTION CAUGHT" + e.getMessage());
		}
	}

}
