package DynamicPlanning;

public class FindGreatestSumOfSubArrayWithDynamic {
	
	
	
	public static int find(int[] arr){
		int max = Integer.MIN_VALUE;
		//�����˼����ʵ���Ƕ�̬�滮���⣬����Ҳ�õ��ˣ���Ϊsum����ǰһ�������ݣ���������������ʾ����Զ�̬�滮
		
		//Ϊʲôsum����ĳ���Ҫ��arr��1������Ҫ�жϵ�ǰi����ȥ�����ݣ�����0Ҳ��һ����ʼ�������ݣ��������һ��һ�����
		int[] sum = new int[arr.length + 1];
		sum[0] = arr[0];
		
		for(int i = 0;i<arr.length;i++){
			//�ж�һ�������еĿ�ʼ���Ǵ�sum�ĺ�Ϊ0��ʼ
			
			//���sum�ĺ�С�ڵ���0����ʾǰ������ּ�������������0������ζ�ſ��Բ���ǰ������֣�ֱ�Ӵӱ�i���ֿ�ʼ
			if(sum[i] <= 0){
				sum[i+1] = arr[i];
			}
			
			//���sum�ĺʹ���0����ʾǰ����������ã�������Ȼ��������ϱ�i����
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

/*����Ľ����

4 8 3 7 9 7 11 

11
*/
