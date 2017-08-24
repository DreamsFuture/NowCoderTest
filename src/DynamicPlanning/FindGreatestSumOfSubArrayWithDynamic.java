package DynamicPlanning;

public class FindGreatestSumOfSubArrayWithDynamic {
	
	
	
	public static int find(int[] arr){
		int max = Integer.MIN_VALUE;
		//本题的思想其实就是动态规划问题，而且也用到了，因为sum就是前一个的内容，但是用数组来表示会更显动态规划
		
		//为什么sum数组的长度要比arr大1，就是要判断当前i加上去的内容，索引0也是一个初始化的数据，后面才是一步一步算的
		int[] sum = new int[arr.length + 1];
		sum[0] = arr[0];
		
		for(int i = 0;i<arr.length;i++){
			//判断一个子序列的开始就是从sum的和为0开始
			
			//如果sum的和小于等于0，表示前面的数字加起来都不大于0，这意味着可以不用前面的数字，直接从本i数字开始
			if(sum[i] <= 0){
				sum[i+1] = arr[i];
			}
			
			//如果sum的和大于0，表示前面的数字有用，保留，然后继续加上本i数字
			else{
				sum[i+1] =sum[i] + arr[i];
			}
			
			System.out.print(sum[i+1]);
			System.out.print(" ");
		}
		System.out.println('\n');
		return getMax(sum);
	}
	
	public static int getMax(int[] arr) {  
		  
	    int max = arr[0];  
	  
	    for (int x = 1; x < arr.length; x++) {  
	        if (arr[x] > max)  
	            max = arr[x];  
	  
	    }  
	    return max;  
	  
	} 
	
	public static void main(String[] args) {
		int[] arr = {2,4,-5,4,2,-2,4};
		
		System.out.println(find(arr));
	}
	

}

/*输出的结果：

4 8 3 7 9 7 11 

11
*/
