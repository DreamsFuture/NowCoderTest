package Stack;

import java.util.Stack;

/*
	������ջ����1��2��3��4��5��������еĳ�ջ���к��������ܹ��ж����ܳ�ջ���бȽϼ򵥣�catalan����
	���еĳ�ջ���У�����ÿһ����Ҫ��ջ�������Զ����������������ջ����ջ���ɴ����Ǻ������뵽�ݹ顣
	�������ʹ�õݹ�������е����С�

	��Ҫ˼·���ǣ�����ÿһ�εݹ鶼�������ֿ��ܣ���ջ����ջ;
	��ջ��Ҫ�ж��Ƿ����е����ֶ��Ѿ���ջ�ˣ���ջ��Ҫ�жϵ�ǰջ�Ƿ�Ϊ�գ������е������Ѿ������ջ�ˣ�
	��ô��ӡ��ջ���У��м��ջ����ʹ���м����outSer��¼�����ĳ�ջ���о���outSer+ջ�е�����

*/

public class AllPopOrderFromStack {
	public static int number = 0;
	static Stack<Integer> stack = new Stack<>();//����Ҫ��ȫ  Stack<Integer>()
	static int[] arr = new int[10];
	
	//i��ʾ��i��ʼ��n֮�������������ջ
	public static void stackSequence(int i, int n){
		int top;
		
		//�жϵݹ������־,�����е����ݶ���ջ�ˣ���ʼ��ӡ����
		if(i == n + 1){
			//number��ʾ�ܹ��ж����ֳ�ջ����
			++number;
			
			//���δ�ӡ��arr[j]�е�Ԫ��
			for(int j = 0; j < n - stack.size(); ++j){
				System.out.print(arr[j] + "-");
			}
			
			for(int k = stack.size() - 1; k >= 0; k--){
				System.out.print(stack.get(k));
			}
			System.out.println();
		}
		
		//�����ǰ�����ݲ�û��ȫ����ѹ��ջ�У���ʼ��ջ���߳�ջ����
		else{
			
			//��ջ����
			stack.push(i);
			stackSequence(i+1, n);
			stack.pop();
			
			//�����ǰջ��û�п� ,���ջ     
			if(!stack.empty()){
				top = stack.peek();
				arr[i - stack.size() - 1] = top;
				stack.pop();
				stackSequence(i, n);
				stack.push(top);
			}
		}
	}
}
