package ScannerTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	
	public static void main(String[] args) {
		Matcher m = Pattern.compile("\\w+").matcher("_ 5414 aewa * % @ dfasdfa");
		while(m.find()){
			System.out.println(m.group(0));
			System.out.println("start: "+m.start());
			System.out.println("end:   "+m.end());
		}
		
	}
	
	

}
