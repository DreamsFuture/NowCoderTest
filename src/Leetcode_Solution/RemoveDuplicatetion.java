package Leetcode_Solution;

public class RemoveDuplicatetion {
	
	
	public int removeDuplicate(int[] Array){
		
		if (Array == null || Array.length == 0){
			
			return 0;
						
		}
		
		int pre = Array[0];
		
		boolean flag = false;
		
		int count = 0;
		
		int o = 0;
		
		for( int i = 1;i < Array.length; i++ ){
			
			
			int current = Array[i];
			
			if (current == pre ){
				
				if (!flag){
					flag = true;
					Array[o++] = current;
					continue;
				}
				else{
					
					count++;
				}
				
			}
			else{
				pre = current;
				Array[o++] = current;
				flag = false;
			}
		}
		
		
		
		return Array.length - count;
	}
	
	
	public static void main(String[] args) {
		
		int[] Array = {2,3,4,4,4,1,5,21,34,44,51,52,52,54,55,61,61,61};
		
		RemoveDuplicatetion removeDuplicates = new RemoveDuplicatetion();
		
		int len = removeDuplicates.removeDuplicate(Array);
		
		System.out.println(Array.length);
		System.out.println(len);
		
	}
	
	
	
	
	
	
	
	

}
