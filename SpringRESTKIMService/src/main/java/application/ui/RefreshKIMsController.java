package application.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RefreshKIMsController {
	@GetMapping("/RefreshKIMs")
	public String refreshKIMs() {
		return "RefreshKIMs";
	}
}
