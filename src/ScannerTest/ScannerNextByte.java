package ScannerTest;

import java.util.*;
import java.util.regex.Pattern;

public class ScannerNextByte {

	public static void main(String[] args) {

		String s = "18  12 11 56 00 64 65  333 -16 33 o W \\ or ld! 3 127 128 255 256 + 3 . 0 / - + @ # ^ * ( ) ! g = 6  true";

		// create a new scanner with the specified String Object
		Scanner scanner = new Scanner(s);
		Locale locale = Locale.US;
		// set the locale to the scanner object
		scanner.useLocale(locale);
		// find the next Byte token and print it
		// loop for the whole scanner
		while (scanner.hasNext()) {
			/*
			// if the next is byte, print found and the byte
			if (scanner.hasNextByte()) {
				System.out.println("Found                 :" + scanner.nextByte());
			}
			*/
			/*
			if (scanner.hasNext(Pattern.compile("\\w+")) ){
				
				System.out.println("Found words     :    "+ scanner.next(Pattern.compile("\\w+")));
			}
			*/
			if(scanner.hasNext(Pattern.compile("[0-9]"))){
				String string =  scanner.next(Pattern.compile("\\w+"));
				System.out.println("Found words     :    "+ string);
				int number = Integer.parseInt(string);
				System.out.println("number is :" + number);
			}
			else if(scanner.hasNextInt(10)){
				int string = scanner.nextInt(2);
				System.out.println("16进制数据：             "+string);
				//System.out.println("对应的10进制数据为：      "+Integer.parseUnsignedInt(string, 16));
				
				
			}
			
			else{
				scanner.next();
			}
			// if a Byte is not found, print "Not Found" and the token
			//System.out.println("Not Found :" + scanner.next());
		}

		// close the scanner
		scanner.close();
	}
}