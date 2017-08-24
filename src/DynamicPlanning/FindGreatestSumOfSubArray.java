package DynamicPlanning;

public class FindGreatestSumOfSubArray {
	
	public static int find(int[] arr){
		int max = Integer.MIN_VALUE;
		//�����˼����ʵ���Ƕ�̬�滮���⣬����Ҳ�õ��ˣ���Ϊsum����ǰһ�������ݣ���������������ʾ����Զ�̬�滮
		int sum = 0;
		for(int i = 0;i<arr.length;i++){
			//�ж�һ�������еĿ�ʼ���Ǵ�sum�ĺ�Ϊ0��ʼ
			
			//���sum�ĺ�С�ڵ���0����ʾǰ������ּ�������������0������ζ�ſ��Բ���ǰ������֣�ֱ�Ӵӱ�i���ֿ�ʼ
			if(sum <= 0){
				sum = arr[i];
			}
			
			//���sum�ĺʹ���0����ʾǰ����������ã�������Ȼ��������ϱ�i����
			else{
				sum += arr[i];
			}
			
			//�Ƚϵ�ǰ�ĺ���max�����maxС������Ը������ֵ��
			if(sum > max){
				max = sum;
			}
			//Ȼ�����ѭ�������sumС��0����ʾ��i��ֵ̫С�˶�������ǰ���ֵ����ȥ��
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {2,4,-5,4,2,-2,4};
		System.out.println(find(arr));
	}
	

}
