package application.kim2dept;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import application.kim.KIMController;
import csvStuff.KimToDeptDataFileReader;

@RestController
public class KimToDeptController {
	
	private static final Logger log = Logger.getLogger( KIMController.class.getName() );

	@GetMapping("/KimToDept/{kim}")
	public KimToDept kimtodept(@PathVariable("kim") String kim) {
		log.info("KimToDept requested for KIM " + kim);
		return KimToDeptDataFileReader.GetDeptFromFile(kim);
	}
}
