package application.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private static final String testString = "This is the KIM REST Service";

	@RequestMapping("/test")
	public String getTestMessage() {
		return testString;
	}
}
