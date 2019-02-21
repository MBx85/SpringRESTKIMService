package application.interfaces;

import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalSystemController {
	
	@GetMapping("/RefreshFromPS") 
	public void RefreshFromPS(@RequestParam(value = "date", required = true) String inputDate) {
		String pattern = "yyyy-MM-dd'T'HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try{
			PersonalSystemGetters.GetRefreshedKimsContent(sdf.parse(inputDate));
		}
		catch(Exception e) {}
		
	}
}
