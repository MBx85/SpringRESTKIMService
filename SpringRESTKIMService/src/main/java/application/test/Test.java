package application.test;

public class Test {
	
	public static String GetBigString() {
		String s = "";
		for (int i = 1;i<25000;i++) {
			s += "A";
		}
		return s;
	}
}
