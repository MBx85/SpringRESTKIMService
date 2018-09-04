package csvStuff;

import application.company.Company;

public class CompanyDataFileReader extends GeneralDataFileReader {
	private static final String FilePathProperty = "company.datasource";

	public static Company GetCompanyFromFile(String companyKey) {
		Company c = new Company();
		try {
			filepath = SetFilePathFromProperty(FilePathProperty);
			FileReaderSupporter frs = new FileReaderSupporter(filepath);

			while (((frs.line = frs.bufferedReader.readLine()) != null)) {
				if (!frs.IsHeaderLine) // because header line should not be read
				{
					String[] values = frs.line.split(csvDivider);
					if (values[0].equals(companyKey)) {
						doMappingFromArray(c, values);
					}
				} else
					frs.IsHeaderLine = false; // set during first iteration
			}

			frs.bufferedReader.close();
		} catch (Exception e) {
		}
		return c;
	}

	private static void doMappingFromArray(Company c, String[] arr) {
		c.setKey(arr[0]);
		c.setLabel(arr[1]);
	}
}
