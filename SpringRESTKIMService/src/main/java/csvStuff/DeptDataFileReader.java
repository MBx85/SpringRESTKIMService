package csvStuff;

import application.department.Department;

public class DeptDataFileReader extends GeneralDataFileReader {
	private static final String FilePathProperty = "dept.datasource";

	public static Department GetDeptFromFile(String deptid) {
		Department dept = new Department();
		try {
			filepath = SetFilePathFromProperty(FilePathProperty);
			FileReaderSupporter frs = new FileReaderSupporter(filepath);

			while (((frs.line = frs.bufferedReader.readLine()) != null)) {
				if (!frs.IsHeaderLine) // because header line should not be read
				{
					String[] values = frs.line.split(csvDivider);
					if (values[0].equals(deptid)) {
							doMappingFromArray(dept, values);
					}
				} else
					frs.IsHeaderLine = false; // set during first iteration
			}

			frs.bufferedReader.close();
		} catch (Exception e) {
		}
		return dept;
	}
	
	private static void doMappingFromArray(Department dept, String[] arr){
		dept.setDeptID(arr[0]);
		dept.setSkz(arr[1]);
		dept.setKurzbez(arr[2]);
	} 
}
