package application.service;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	private static final Logger log = Logger.getLogger(ServiceController.class.getName());

	@GetMapping("/REST/Services")
	public ArrayList<Service> GetAllServices() {
		return ServiceFileOperator.GetAllServices();
	}

	@GetMapping("/REST/Services/{ServiceID}")
	public Service GetService(@PathVariable("ServiceID") String ServiceID) {
		return ServiceFileOperator.GetService(ServiceID);
	}

	@RequestMapping(value = "/REST/Services/{ServiceID}", method = RequestMethod.PUT)
	public @ResponseBody String PutKIM(@PathVariable("ServiceID") String ServiceID, @RequestBody Service service) {
		ServiceFileOperator.WriteServiceToFile(service);
		log.info("Service " + ServiceID + " saved");
		return "ok";
	}

}
