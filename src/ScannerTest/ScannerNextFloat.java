package ScannerTest;

import java.util.*;

public class ScannerNextFloat {
	public static void main(String[] args) {
		String s = "Hello World! 3 + 3.0 = 6.0 true ";
		Float f = 1.2385f;
		s = s + f;
		// create a new scanner with the specified String Object
		Scanner scanner = new Scanner(s);
		// use US locale to be able to identify floats in the string
		scanner.useLocale(Locale.US);
		// find the next float token and print it
		// loop for the whole scanner
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
			// if the next is a float, print found and the float
			if (scanner.hasNextFloat()) {
				System.out.println("Found :" + scanner.nextFloat());
			}
		}
		// close the scanner
		scanner.close();
	}
}
