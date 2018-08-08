package application;

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KIMController {

    private static final String testString = "This is the KIM REST Service";

    @RequestMapping("/KIM")
    public KIM kim() {
    	return new KIM(testString);
    }
}
