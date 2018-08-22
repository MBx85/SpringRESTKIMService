package application.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index(Model model) {
		/*model.addAttribute("fragment", "/fragments/main");
		model.addAttribute("fragmentElement", "main");*/
		return "index";
	}

	@GetMapping("/mitarbeiter")
	public String mitarbeiter(Model model) {
		/*model.addAttribute("fragment", "fragments/mitarbeiterAnzeigen");
		model.addAttribute("fragmentElement", "mitarbeiterAnzeigen");*/
		return "mitarbeiterAnzeigen";
	}
	
	@GetMapping("/RefreshKIMs")
	public String refreshKIMs(Model model) {
		/*model.addAttribute("fragment", "fragments/kimAktualisieren");
		model.addAttribute("fragmentElement", "kimAktualisieren");*/
		return "kimAktualisieren";
		
	}
}