package csvStuff;

import application.kim2dept.KimToDept;

public class KimToDeptDataFileReader extends GeneralDataFileReader {
	private static final String FilePathProperty = "k2d.datasource";

	public static KimToDept GetDeptFromFile(String kim) {
		KimToDept k2d = new KimToDept();
		try {
			filepath = SetFilePathFromProperty(FilePathProperty);
			FileReaderSupporter frs = new FileReaderSupporter(filepath);

			while (((frs.line = frs.bufferedReader.readLine()) != null)) {
				if (!frs.IsHeaderLine) // because header line should not be read
				{
					String[] values = frs.line.split(csvDivider);
					if (values[0].equals(kim)) {
						doMappingFromArray(k2d, values);
					}
				} else
					frs.IsHeaderLine = false; // set during first iteration
			}

			frs.bufferedReader.close();
		} catch (Exception e) {
		}
		return k2d;
	}

	private static void doMappingFromArray(KimToDept k2d, String[] arr) {
		k2d.setKim(arr[0]);
		k2d.setDeptid(arr[1]);
	}
}
