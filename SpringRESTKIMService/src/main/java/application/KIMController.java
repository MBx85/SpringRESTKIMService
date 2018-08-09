package application;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KIMController {

	@RequestMapping("/KIM/{kim}")
	public KIM kim(@PathVariable("kim") String kim) {
		return new KIM(kim);
	}
}
