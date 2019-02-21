package application.interfaces;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import application.kim.KIM;
import csvStuff.KIMDataFileReader;

public class PersonalSystemGetters {
	private static String PsEndpointProp = "ps.endpoint"; 
	private static String dateTimePattern = "yyyy-MM-dd'T'HH:mm:ss";
	
	public static void GetKimFromPSAndPutIntoFile(String kim) {
		KIMDataFileReader.PutKimIntoFile(GetKimFromPS(kim));
	}
	
	public static KIM GetKimFromPS(String kim) {
		String endp = SetEndpointFromProperty(PsEndpointProp)+kim;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(endp, KIM.class);
	}
	
	private static String SetEndpointFromProperty(String property) {
		Properties properties = new Properties();
		try {
			BufferedInputStream stream = new BufferedInputStream(
					new FileInputStream("src\\main\\resources\\filesEndpoints.properties"));
			properties.load(stream);
			stream.close();
		} catch (Exception e) {
		}
		return properties.getProperty(property);
	}
	
	public static List<String> GetRefreshedKimsFromPs(Date inputDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateTimePattern);
		String endp = SetEndpointFromProperty(PsEndpointProp)+"ChangedKims?date=" + sdf.format(inputDate);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String[]> rEnt = restTemplate.getForEntity(endp, String[].class);
		List<String> kimList = Arrays.asList(rEnt.getBody());
		return kimList;
	}
	
	public static void GetRefreshedKimsContent(Date inputDate) {
		List<String> StringList = PersonalSystemGetters.GetRefreshedKimsFromPs(inputDate);
		for (String kim : StringList) {
			GetKimFromPSAndPutIntoFile(kim);
		}
	}
}