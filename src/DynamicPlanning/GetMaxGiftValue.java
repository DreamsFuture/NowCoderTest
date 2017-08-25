package DynamicPlanning;

public class GetMaxGiftValue {
	
	public static int getMaxValue(int[][] arr){
		
		int cols = arr[0].length;
		int rows = arr.length;
/*		System.out.println("cols:"+cols);  //可以直接把int类型与字符相加改变数据类型
		System.out.println("rows:"+rows+"\n");*/
		int[][] max = new int[rows][cols];
		max[0][0] = arr[0][0];
		
		
		//初始化数据
		for(int i = 1 ;i < rows;i++){
			max[i][0] = max[i-1][0] + arr[i][0];
		}
		for(int i = 1;i < cols;i++){
			max[0][i] = max[0][i-1]+ arr[0][i];
		}
		for(int i = 1; i < rows; i++){
			for(int j = 1; j < cols; j++){
				
				if(max[i-1][j] >= max[i][j-1]){
					max[i][j] = max[i-1][j] + arr[i][j];
				}
				else{
					max[i][j] = max[i][j-1] + arr[i][j];
				}
				
			}
		}
		
		
		for(int i = 0 ; i<rows;i++){
			for(int j = 0;j<cols;j++){
				System.out.print(max[i][j]);
				System.out.print(' ');
				if(j==cols-1){
					System.out.println();
				}
			}
		}
		return max[rows-1][cols-1];
		
	}
	
	public static void main(String[] args) {
		int[][] arr = {{2,3,4,5},{54,6,4,3},{5,8,3,0}}; //Java中的数组都是花括号
	/*  2  3 4 5 
		54 6 4 3
		5  8 3 0 */
		System.out.println(getMaxValue(arr));
		int[][] arr1 = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
		
/*		1 10 3 8
		12 2 9 6 
		5 7 4 11
		3 7 16 5
		*/
		System.out.println(getMaxValue(arr1));
	}
	
	

}
