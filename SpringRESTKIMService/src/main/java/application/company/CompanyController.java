package application.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import csvStuff.CompanyDataFileReader;

@RestController
public class CompanyController {

	@GetMapping("/Company/{key}")
	public Company company(@PathVariable("key") String key) {
		return CompanyDataFileReader.GetCompanyFromFile(key);

	}
}