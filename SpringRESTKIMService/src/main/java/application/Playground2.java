package application;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import java.util.Properties;

public class Playground2 {

	public static void main(String[] args) {
		System.out.println("START");
		Properties properties = new Properties();
		try {
			BufferedInputStream stream = new BufferedInputStream(
					new FileInputStream("src\\main\\resources\\filesEndpoints.properties"));

			properties.load(stream);
			stream.close();
			System.out.println(properties.getProperty("k2d.datasource"));
		}

		catch (Exception e) {
			System.out.println("EX CAUGHT");
			System.out.println(e.getMessage());
		}
	}

}
