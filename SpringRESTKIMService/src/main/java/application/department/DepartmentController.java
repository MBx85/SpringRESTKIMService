package application.department;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import csvStuff.DeptDataFileReader;

@RestController
public class DepartmentController {
	
	@GetMapping("/Dept/{deptid}")
	public Department kimtodept(@PathVariable("deptid") String deptid) {
		return DeptDataFileReader.GetDeptFromFile(deptid);
	}
}
