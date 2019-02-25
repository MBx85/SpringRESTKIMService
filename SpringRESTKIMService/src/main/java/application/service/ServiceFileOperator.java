package application.service;

import java.io.File;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceFileOperator {

	private static String ServicesLocation = "datasource/Services/";
	private static String FileEnding = ".json";

	static ArrayList<Service> GetAllServices() {
		File folder = new File(ServicesLocation);
		File[] files = folder.listFiles();
		ArrayList<Service> al = new ArrayList<Service>();

		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				ObjectMapper om = new ObjectMapper();
				try {
					Service s = om.readValue(files[i], Service.class);
					al.add(s);
				} catch (Exception e) {
				}
			}
		}
		return al;
	}

	static void WriteServiceToFile(Service s) {
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(new File(ServicesLocation + s.getId() + FileEnding), s);
		} catch (Exception e) {
		}
	}

}
