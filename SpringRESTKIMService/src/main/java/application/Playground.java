package application;

import java.io.File;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import application.service.Service;

public class Playground {
	private static String ServicesLocation = "datasource/Services/";
	// private static String FileEnding = ".json";

	public static void main(String[] args) {

		File folder = new File(ServicesLocation);
		File[] files = folder.listFiles();
		ArrayList<Service> al = new ArrayList<Service>();

		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getPath() + " " + files[i].isDirectory());
			if (!files[i].isDirectory()) {
				ObjectMapper om = new ObjectMapper();
				try {
					Service s = om.readValue(files[i], Service.class);
					al.add(s);
				} catch (Exception e) {
				}
			}
		}
		
		for (Service ss : al) {
			System.out.println(ss.getId());
		}

	}

}
