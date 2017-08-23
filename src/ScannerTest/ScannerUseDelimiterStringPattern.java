package ScannerTest;


import java.util.*;
import java.util.regex.Pattern;

public class ScannerUseDelimiterStringPattern {

   public static void main(String[] args) {

   String s = "Hello World! 3 + ` \\[]{} ! @ #  $ % ^ & *(  ) _ + - = / | 30 = 60 true? ";

   // create a new scanner with the specified String Object
   Scanner scanner = new Scanner(s);
   ArrayList arraylist1 = new ArrayList();
   
   // print a line of the scanner
   //System.out.println("" + scanner.nextLine());

   // change the delimiter of this scanner
   //scanner.useDelimiter("Wor");
   while(scanner.hasNext()){
		//System.out.println(scanner.next(Pattern.compile("^[0-9]*$")));
	    //arraylist1.add((String)scanner.findInLine(Pattern.compile("[0-9]+")));
		System.out.println(scanner.findInLine(Pattern.compile("[0-9]+")));
		scanner.next();
	}
   //System.out.println("" + scanner.nextLine());
   // display the new delimiter
   System.out.println("" + scanner.delimiter());
   /*
    * 
   for(String s1 : arraylist1){
	   System.out.println(s1.toString());
   }
   // close the scanner
    * 
    */
   System.out.println(Pattern.compile("[0-9]+").pattern());
   scanner.close();
   }
}