package csvStuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import application.kim.KIM;

/** reads KIM Objects from and writes them into files
 * 
 * @author Markus
 *
 */

public class KIMDataFileReader extends GeneralDataFileReader {
	private static final String FilePathProperty = "kim.datasource";
	private static final String BufferFilePathProperty = "kimbuffer.datasource";

	public static KIM GetKimFromFile(String kim) {
		KIM kimObject = new KIM();
		try {
			filepath = SetFilePathFromProperty(FilePathProperty);
			FileReaderSupporter frs = new FileReaderSupporter(filepath);

			while (((frs.line = frs.bufferedReader.readLine()) != null)) {
				if (!frs.IsHeaderLine) // because header line should not be read
				{
					String[] values = frs.line.split(csvDivider);
					
					if (values[0].equals(kim)) {
						doMappingFromArray(kimObject, values);
					}
				} else
					frs.IsHeaderLine = false; // set during first iteration
			}

			frs.bufferedReader.close();
		} catch (Exception e) {
		}
		return kimObject;
	}

	public static void PutKimIntoFile(KIM kimObj) {
		try {
			filepath = SetFilePathFromProperty(FilePathProperty);
			final String bufferFilePath = SetFilePathFromProperty(BufferFilePathProperty);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
			String line = null, kim = kimObj.getKIM();
			boolean IsHeaderLine = true, KimInserted = false;
			FileWriter bufferWriter = new FileWriter(bufferFilePath);

			while (((line = bufferedReader.readLine()) != null)) {
				if (!IsHeaderLine) // because header line should not be read
				{
					String[] values = line.split(csvDivider);
					if (values[0].equals(kim)) {// Kim ist die erste Spalte
						/* überschreibe die Zeile im CSV */
						bufferWriter.write(WriteCSVLine(kimObj) + "\r\n");
						KimInserted = true;
					} else {
						bufferWriter.write(line + "\r\n");
						/* schreibe die Zeile ins File, da InputKIM!=csvKIM */
					}
				} else {
					bufferWriter.write(line + "\r\n");
					IsHeaderLine = false; // set during first iteration
				}
			}

			if (!KimInserted) {
				/* Append InputKIM to CSV */
				bufferWriter.write(WriteCSVLine(kimObj) + "\r\n");
			}
			bufferedReader.close();
			bufferWriter.close();
			RenameAndCleanUpFiles(filepath, bufferFilePath);
		} catch (Exception e) {
		}
	}

	private static void RenameAndCleanUpFiles(String PathDataFile, String PathBufferFile) {
		File bufferFile = new File(PathBufferFile);
		File dataFile = new File(PathDataFile);
		dataFile.delete();
		bufferFile.renameTo(dataFile);
	}

	private static String WriteCSVLine(KIM kimObj) {
		StringBuffer sb = new StringBuffer();
		sb.append(kimObj.getKIM());
		sb.append(csvDivider);
		sb.append(kimObj.getVorname());
		sb.append(csvDivider);
		sb.append(kimObj.getNachname());
		sb.append(csvDivider);
		//sb.append(Application.DateOnlyFormatter.format(kimObj.getGeburtstag()));
		sb.append(csvDivider);
		//sb.append(Application.DateTimeFormatter.format(new Date())); // saveDate
		sb.append(csvDivider);
		sb.append(kimObj.InitEmail());
		sb.append(csvDivider);
		sb.append(kimObj.InitUserId());
		sb.append(csvDivider);
		sb.append(kimObj.getCompany());
		return sb.toString();
	}
	
	private static void doMappingFromArray(KIM k, String[] arr) {
		k.setKim(arr[0]);
		k.setVorname(arr[1]);
		k.setNachname(arr[2]);
		k.setEmail(arr[5]);
		k.setUserId(arr[6]);
	}
}
