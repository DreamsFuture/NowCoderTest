package Leetcode_Solution;

import java.util.HashMap;

public class TwoSum {
	
	public TwoSum(){
		
	}
	
	public int[] twoSum(int[] numbers, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		
		int[] result = new int[2];
		
		for (int i = 0; i < numbers.length; i++){
			
			if (map.containsKey(numbers[i])){
				
				int index = map.get(numbers[i]);
				
				result[0] = index + 1;
				
				result[1] = i + 1;
				
				break;
				
			}
			else{
				
				map.put(target - numbers[i], i);
				
			}			
		}
		
		
		return result;
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		TwoSum twoSum = new TwoSum();
		
		int[] numbers =new int[] {1,11,54,256,45,123,74};
		
		int target = 99;
				
		int[] returnResult = twoSum.twoSum(numbers, target);
		
		for (int i:returnResult){
			System.out.println(i);
		}
				
	}
	
	

}
