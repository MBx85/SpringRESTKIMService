package application;

import java.lang.reflect.Field;

public class Playground2 {

	public static void main(String[] args) {

KIM kim = new KIM("111");
Field fieldarr[] = kim.getClass().getFields();
System.out.println(fieldarr.length);

for(Field field : kim.getClass().getFields()) {
	System.out.println(field.getName());
}
	}

}

