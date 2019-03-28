package application.kim;

import java.io.File;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KimJsonFileOperator {

	private static final String KimsLocation = "datasource/KIMs/";
	private static final String FileEnding = ".json";

	public static KIM GetKimFromFile(String kim) {
		File f = new File(KimsLocation + kim + FileEnding);
		// File[] files = folder.listFiles();
		KIM kimObj = new KIM();
		ObjectMapper om = new ObjectMapper();
		try {
			kimObj = om.readValue(f, KIM.class);
		} catch (Exception e) {
		}
		/*
		 * for (int i = 0; i < files.length; i++) { if (!files[i].isDirectory()) {
		 * ObjectMapper om = new ObjectMapper(); try { KIM k = om.readValue(files[i],
		 * KIM.class); if(k.getKIM().equals(kim)){ kimObj = k; } } catch (Exception e) {
		 * } } }
		 */
		return kimObj;
	}

	public static ArrayList<String> GetAllKims() {
		File folder = new File(KimsLocation);
		File[] files = folder.listFiles();
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < files.length; i++) {
			if (!files[i].isDirectory()) {
				String filename = files[i].getName();
				al.add(filename.substring(0, filename.length() - FileEnding.length()));
			}
		}
		return al;
	}
}
