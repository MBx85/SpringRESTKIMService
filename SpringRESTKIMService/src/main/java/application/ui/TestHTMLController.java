package application.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestHTMLController {

	@GetMapping("/testhtml")
	public String getTestHTML(Model model) {
		model.addAttribute("fragment", "/fragments/testfragment");
		model.addAttribute("fragmentElement", "testfragment");
		return "TestHTML";
	}
}