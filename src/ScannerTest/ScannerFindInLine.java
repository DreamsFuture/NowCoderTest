package ScannerTest;

import java.util.*;
import java.util.regex.Pattern;

public class ScannerFindInLine {

	public static void main(String[] args) {

		String s = "Hello World! 3+3.0=6";

		// create a new scanner with the specified String Object
		Scanner scanner = new Scanner(s);

		// find a pattern of any letter plus "ello"
		System.out.println("" + scanner.findInLine(Pattern.compile(".ello")));
		System.out.println("" + scanner.findInLine(Pattern.compile(".\\+")));
		// print the next line of the string
		System.out.println("" + scanner.nextLine());

		// close the scanner
		scanner.close();
	}
}