package BitOperation;
/*
	1. 给一个数组，如果其中只有一个数是单一存在的，其的都是两个，则通过数组中每一个数组进行异或得到一个最后一个单独的数字
	
	例如：{1,2,3,4,3,2,1}  输出结果： 1^2^3^4^3^2^1 = 4
	
	2. 异或原理：	001^010 = 011 = 3
	
				011 ^ 011 = 000
				
				0000 ^ 1000 = 1000
				
				1000 ^ 011 = 1011
				
				1011 ^ 10 = 1001
				
				1001 ^ 01 = 1000		
						
*/
public class FindTheOnlyNonRepetitedNumber {
	public static void main(String[] args) {
		int[] arr = {1,2,5,5,6,4,6,4,6,1,3,3};
		int a = FindTheOnlyOnceNumber(arr);
		System.out.println(a);
	}
	public static int  FindTheOnlyOnceNumber(int[] arr){
		if(arr.length<2){
			return arr[0];
		}
		int result = 0;
		for(int i = 0; i<arr.length; ++i){
			result ^= arr[i];	
		}
		return result;
	}
}
