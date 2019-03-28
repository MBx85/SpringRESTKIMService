package application.kim;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import csvStuff.KIMDataFileReader;

@RestController
public class KIMController {

	private static final Logger log = Logger.getLogger(KIMController.class.getName());

	// BELOW IS FOR HTTP GET
	@RequestMapping(value = "/KIMFromCSV/{kim}", method = RequestMethod.GET)
	public KIM kimFromCsv(@PathVariable("kim") String kim) {
		log.info("KIM " + kim + " requested from CSV");
		return KIMDataFileReader.GetKimFromFile(kim);
	}

	@RequestMapping(value = "/KIMs", method = RequestMethod.GET)
	public ArrayList<String> AllKims() {
		log.info("All KIMs requested");
		Date startDate = new Date();
		ArrayList<String> al = KimJsonFileOperator.GetAllKims();
		Date endDate = new Date();
		long diff = endDate.getTime() - startDate.getTime();
		log.info(al.size() +" KIMs returned, Duration " + diff + " ms");
		return al;
		
	}

	@RequestMapping(value = "/KIMs/{kim}", method = RequestMethod.GET)
	public KIM kim(@PathVariable("kim") String kim) {
		log.info("KIM " + kim + " requested");
		return KimJsonFileOperator.GetKimFromFile(kim);
	}

	/*
	 * //BELOW IS FOR HTTP PUT
	 * 
	 * @RequestMapping(value = "/KIM/{kim}", method = RequestMethod.PUT) public void
	 * PutKIM(@PathVariable("kim") String kim) { /* Get KIM From File; if it is
	 * there --> overwrite; if not --> create
	 */
	/*
	 * KIM FileKIM = new KIM(kim); if(FileKIM.getKIM() == null) { // Append to file
	 * } else { // overwrite } log.info("Modified KIM " + kim); }
	 */
}
