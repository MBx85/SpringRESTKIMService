package application.kim;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import csvStuff.KIMDataFileReader;

@RestController
public class KIMController {

	private static final Logger log = Logger.getLogger( KIMController.class.getName() );
	
	//BELOW IS FOR HTTP GET
	@RequestMapping(value = "/KIM/{kim}", method = RequestMethod.GET)
	public KIM kim(@PathVariable("kim") String kim) {
		log.info("KIM " + kim + " requested");
		return KIMDataFileReader.GetKimFromFile(kim);
	}
	
	
	//BELOW IS FOR HTTP PUT
	@RequestMapping(value = "/KIM/{kim}", method = RequestMethod.PUT)
		public void PutKIM(@PathVariable("kim") String kim) {
		/* Get KIM From File; if it is there --> overwrite; if not --> create*/
		/*KIM FileKIM = new KIM(kim);
		if(FileKIM.getKIM() == null) {
			// Append to file
		}
		else {
			// overwrite
		}*/
		log.info("Modified KIM " + kim);
	}
}
