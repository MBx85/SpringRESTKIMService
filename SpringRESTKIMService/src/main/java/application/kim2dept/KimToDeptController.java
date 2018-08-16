package application.kim2dept;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KimToDeptController {

	@GetMapping("/KimToDept/{kim}")
	public KimToDept kimtodept(@PathVariable("kim") String kim) {
		return new KimToDept();
	}
}
