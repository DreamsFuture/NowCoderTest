package DynamicPlanning;

/*面试题14：剪绳子

一条长度为n的绳子，剪成任意整数段，求各段乘积最大值？
*/

public class MaxValueAfterCuttingThread {
	
	public static int MaxValue(int length){
		
		if(length < 2) return 0;
		if(length == 2) return 1;
		if(length == 3) return 2;
		
		int[] res = new int[length + 1];
		res[0] = 0;
		res[1] = 1;
		res[2] = 2;
		res[3] = 3;
		
		int max = 0;
		
		//数组res是求得每一个长度为i的最大值，小于最大值的值不存储，在比较大小的时候就省略了
		for(int i = 4; i <= length; ++i){
			//max在这里进行初始化，目的就是为了让长度为i的绳子剪成j段都比较一遍
			max = 0;
			for(int j = 1; j<=i>>1; ++j){
				
				int result = res[j] * res[i - j];
				System.out.printf("result = %d",result);
				System.out.println();
				if(max < result) max = result;
				res[i] = max;
				
				System.out.printf("res[%d] = %d, res[%d - %d] = %d",i,res[i],i,j,res[i - j]);
				System.out.println();
			}
			
		}
		
		for(int i = 0; i<length+1; i++){
			
			System.out.print(res[i]);
			System.out.print(' ');
		}
		
		
		
		max = res[length];
		
		System.out.println();
		return max;		
	}
	
	public static void main(String[] args) {
		int length = 8;
		
		System.out.println(MaxValue(length));;
		
		
	}
	
	

}

/*输出结果：
 * 
result = 3
res[4] = 3, res[4 - 1] = 3
result = 4
res[4] = 4, res[4 - 2] = 2


result = 4
res[5] = 4, res[5 - 1] = 4    res[1]*res[4]=4
result = 6
res[5] = 6, res[5 - 2] = 3    res[2]*res[3]=6

result = 6
res[6] = 6, res[6 - 1] = 6    
result = 8
res[6] = 8, res[6 - 2] = 4
result = 9
res[6] = 9, res[6 - 3] = 3

result = 9
res[7] = 9, res[7 - 1] = 9
result = 12
res[7] = 12, res[7 - 2] = 6
result = 12
res[7] = 12, res[7 - 3] = 4

result = 12
res[8] = 12, res[8 - 1] = 12
result = 18
res[8] = 18, res[8 - 2] = 9
result = 18
res[8] = 18, res[8 - 3] = 6
result = 16
res[8] = 18, res[8 - 4] = 4
0 1 2 3 4 6 9 12 18 
18
*/

