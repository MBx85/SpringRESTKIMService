package application;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import application.service.Service;

public class Playground2 {

	public static void main(String[] args) {
		String id = "RestS1";
		Service s = new Service();
		s.setId(id);

		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(new File("datasource/"+id+".json"), s);
		} catch (Exception e) {
		}
	}

}
