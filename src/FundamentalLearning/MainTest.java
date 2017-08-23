package FundamentalLearning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainTest {
	
	
	public int test(int[] input){
		if (input == null || input.length>3){
			return -1;
		}
		else if(input[0] == input[1] || input[1] == input[2] || input[2] ==input[0]){
				return -1;
			
		}
		else{
			for(int i =0;i<input.length;i++){
				if (input[i]<0){
					return -1;
				}
			}
		}
		int a = 0;
		//ArrayList<Integer> arraylist = new ArrayList<Integer>();
		int[] input1 = new int[5];
		for(int i = 0;i < input.length; i++){
			input1[i] = input[i];
			if (input[i] == 2){
				input1[3] = 5;
				a++;
			}
			else if (input[i] == 5){
				input1[3] = 2;
				a++;
			}
			
			else if(input[i] == 6){
				input1[3] = 9;
				a++;
			}
			else if(input[i] == 9){
				input1[3] = 6;
				a++;
			}
		}
		
		int[] four = new int[4];
		int[] five = new int[5];
		if(a==0){
			Arrays.sort(input);
			ArrayList<Integer> arraylist = new ArrayList<Integer>();
			for(int i=0;i<input.length;i++){
				arraylist.add(input[i]);
			}
			for(int i= 1;i<input.length;i++){
				arraylist.add(input[0]*10+input[i]);
			}
			arraylist.add(input[1]*10+input[0]);
			for(int i = 2;i<input.length;i++){
				arraylist.add(input[1]*10+input[i]);
			}
			return (int) arraylist.get(input[2]);
		}
		else if(a==1){
			four = input1;
			Arrays.sort(four);
			ArrayList arraylist = new ArrayList();
			for(int i=0;i<four.length;i++){
				arraylist.add(four[i]);
			}
			for(int i= 1;i<four.length;i++){
				arraylist.add(four[0]*10+four[i]);
			}
			arraylist.add(four[1]*10+four[0]);
			for(int i = 2;i<four.length;i++){
				arraylist.add(four[1]*10+four[i]);
			}
			return (int) arraylist.get(input[2]);
		}
		else if (a==2){
			five = input1;
			return -1;
		}
		else{
			return -1;
		}
		
	}

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String string = input.next();
		String[] str = string.split("\\,");
		int[] intput = new int[str.length];
		for(int i = 0 ;i<intput.length;i++){
			
			intput[i] = Integer.parseInt(str[i]);
			//System.out.println(intput[i]);
			
		}
		
		MainTest test = new MainTest();
		Arrays.sort(intput);
		int output = test.test(intput);
		System.out.println(output);
		input.close();
	}
	
	
	
	
	
	
}
