package Leetcode_Solution;

public class AllocateCandy {
	
	public int allocateCandy(int[] ratings){
		
		if (ratings == null || ratings.length == 0){
			
			return 0;
		}
		
		int[] candies = new int[ratings.length];
		
		
		for (int i = 1;i < ratings.length; i++){
			
			if (ratings[i] > ratings[i - 1]){
				
				candies[i] = candies[i - 1] + 1;
				
			}
			
			else{
				
				candies[i] = 1;
				
			}
		}
		
		int result = candies[ratings.length -  1];
		
		for (int i = ratings.length - 2 ;i >= 0; i-- ){
			
			int cur = 1;
			if (ratings[i] > ratings[i + 1]){
				
				cur = candies[i + 1] +1;
				
			}
			
			result += Math.max(cur, candies[i]);
			candies[i] = cur;
			
		}
		
		return result;
	}
	
	// 这个是有问题的
	
	public static void main(String[] args) {
		
		
		int[] ratings = {1,5,6,2,5,4,4,4};
		
		AllocateCandy allocateCandy = new AllocateCandy();
		
		int min = allocateCandy.allocateCandy(ratings);
		
		System.out.println(min);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
