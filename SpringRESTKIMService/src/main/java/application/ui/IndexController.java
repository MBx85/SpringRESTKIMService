package application.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import application.kim.KIM;
import csvStuff.KIMDataFileReader;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index(Model model) {
		/*
		 * model.addAttribute("fragment", "/fragments/main");
		 * model.addAttribute("fragmentElement", "main");
		 */
		return "index";
	}

	@GetMapping("/mitarbeiter")
	public String mitarbeiter(Model model) {
		/*
		 * model.addAttribute("fragment", "fragments/mitarbeiterAnzeigen");
		 * model.addAttribute("fragmentElement", "mitarbeiterAnzeigen");
		 */
		return "mitarbeiterAnzeigen";
	}

	@GetMapping("/RefreshKIMs")
	public String refreshKIMs(Model model) {
		/*
		 * model.addAttribute("fragment", "fragments/kimAktualisieren");
		 * model.addAttribute("fragmentElement", "kimAktualisieren");
		 */
		return "kimAktualisieren";
	}

	@GetMapping("/MaDetails/{kim}")
	public String MaDetails(Model model, @PathVariable("kim") String kim) {
		KIM kimObj = KIMDataFileReader.GetKimFromFile(kim);
		model.addAttribute("nachname", kimObj.getNachname());
		model.addAttribute("vorname", kimObj.getVorname());
		model.addAttribute("email", kimObj.getEmail());
		model.addAttribute("userId", kimObj.getUserId());
		return "MaDetails";
	}
}