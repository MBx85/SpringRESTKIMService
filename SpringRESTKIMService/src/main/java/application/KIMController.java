package application;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KIMController {

	private static final Logger log = Logger.getLogger( KIMController.class.getName() );
	
	@CrossOrigin(origins = "http://localhost:8092")
	@RequestMapping(value = "/KIM/{kim}", method = RequestMethod.GET)
	public KIM kim(@PathVariable("kim") String kim) {
		log.info("KIM " + kim + " requested");
		return new KIM(kim);
	}
	
	@RequestMapping(value = "/KIM/{kim}", method = RequestMethod.PUT)
		public void doNothing(@PathVariable("kim") String kim) {
		log.info("Modified KIM " + kim);
	}
}
