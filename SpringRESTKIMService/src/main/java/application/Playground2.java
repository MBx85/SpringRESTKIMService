package application;

import java.util.concurrent.ThreadLocalRandom;

public class Playground2 {

	public static void main(String[] args) {
		for (int i=1;i<=40;i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1,5);
				System.out.println( randomNum);
		}}
	}


