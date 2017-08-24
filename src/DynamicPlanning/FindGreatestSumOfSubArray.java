package DynamicPlanning;

public class FindGreatestSumOfSubArray {
	
	public static int find(int[] arr){
		int max = Integer.MIN_VALUE;
		//本题的思想其实就是动态规划问题，而且也用到了，因为sum就是前一个的内容，但是用数组来表示会更显动态规划
		int sum = 0;
		for(int i = 0;i<arr.length;i++){
			//判断一个子序列的开始就是从sum的和为0开始
			
			//如果sum的和小于等于0，表示前面的数字加起来都不大于0，这意味着可以不用前面的数字，直接从本i数字开始
			if(sum <= 0){
				sum = arr[i];
			}
			
			//如果sum的和大于0，表示前面的数字有用，保留，然后继续加上本i数字
			else{
				sum += arr[i];
			}
			
			//比较当前的和与max，如果max小，则可以覆盖最大值，
			if(sum > max){
				max = sum;
			}
			//然后继续循环，如果sum小于0，表示本i的值太小了额，这样会把前面的值都减去了
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,4,-5,4,2,-2,4};
		System.out.println(find(arr));
	}
	

}
