package Leetcode_Solution;

public  class MaxValueWater {
	
	public int maxArea(int[] height){
		
		if (height == null || height.length < 2){
			
			return 0;
			
		}
		
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		
		while(left < right){
			
			max = Math.max(max, (right - left)*Math.min(height[left], height[right]));
			
			if (height[left] < height[right]){
				left++;
			}
			else{
				
				right--;
				
			}
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {
		
		int[] height = {1,5,5,2,5,4,4,4,};
		
		MaxValueWater maxValue = new MaxValueWater();
		
		int max = maxValue.maxArea(height);
		
		System.out.println(max);
	}
	
	
	
	

}
