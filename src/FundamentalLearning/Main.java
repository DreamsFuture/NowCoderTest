package FundamentalLearning;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public int MainTest(String[] input){
		
		if (input == null || input.length<4){
			
			return 0;
		}
		
		
			
		int awardNum = Integer.parseInt(String.valueOf(input[0]));
			
		String[] awardValue= input[1].split(" ");
			
		String[] awardNumber = input[2].split(" ");
		
		int getLimit = Integer.parseInt(String.valueOf(input[3]));
		
		int[] award_Value = null;
		int[] award_Number = null;
		int total = 0;
		int max = 0;
		
		for (int i= 0;i<awardValue.length;i++){
			
			award_Value[i] = Integer.parseInt(String.valueOf(awardValue[i]))+Integer.parseInt(String.valueOf(awardNumber[i]));
			award_Number[i] = Integer.parseInt(String.valueOf(awardNumber[i]));
			total = total + Integer.parseInt(String.valueOf(awardNumber[i]));
		}
		
		Arrays.sort(award_Value);
		
		int realNumber =0;
		
		while(realNumber)
			
		
		
		
		
		
		
		
		return 0;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		String[] input = null ;
		
		Main mainTest = new Main();
		
		for (int i = 0; i < 4; i++) {
	        input[i] = in.nextLine();
	    }
		
		mainTest.MainTest(input);
		
	}
	
	
	

}
