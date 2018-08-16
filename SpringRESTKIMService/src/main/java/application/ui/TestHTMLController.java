package application.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestHTMLController {

	@GetMapping("/testhtml")
	public String refreshKIMs() {
		return "TestHTML";
	}
}
