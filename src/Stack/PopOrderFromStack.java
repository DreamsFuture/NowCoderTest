package Stack;

import java.util.Stack;


/*
	����������f(4), ���Ǹ�4��Ԫ�ر��Ϊa,b,c,d, ��ô���ǣ�Ԫ��aֻ���ܳ�����1��λ�ã�2��λ�ã�3��λ�ú�4��λ��(��������⣬һ����4��λ�ã�����abcd,Ԫ��a����1��λ��)�� 
		1) ���Ԫ��a��1��λ�ã���ôֻ����a��ջ�����ϳ�ջ����ʱ��ʣԪ��b��c��d�ȴ�����������������f(3) 
		2) ���Ԫ��a��2��λ�ã���ôһ����һ��Ԫ�ر�a�ȳ�ջ������f(1)�ֿ���˳��ֻ����b������ʣc��d����f(2) 
		3) ���Ԫ��a��3��λ�ã���ôһ��������Ԫ�ر�1�ȳ�ջ������f(2)�ֿ���˳��ֻ����b��c������ʣd����f(1) 
		4) ���Ԫ��a��4��λ�ã���ôһ����a�Ƚ�ջ������ջ����ôԪ��b��c��d�ĳ�ջ˳���Ǵ�С����Ľ⣬�� f(3)

	��������������f(4) = f(3) + f(2) * f(1) + f(1) * f(2) + f(3) 
	Ϊ�˹����������Ƕ���f(0) = 1������f(4)��������дΪ�� 
	f(4) = f(0) * f(3) + f(1) * f(2) + f(2) * f(1) + f(3) * f(0) 
	Ȼ�������ƹ㵽n���ƹ�˼·��n=4ʱ��ȫһ�����������ǿ��Եõ��� 
	f(n) = f(0)*f(n-1) + f(1)*f(n-2) + �� + f(n-1)*f(0) 

*/
public class PopOrderFromStack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����о����г�ջ˳��
		Stack<String> stack = new Stack<String>();
		orderList(stack, "", "1234");
	}

	public static void orderList(Stack<String> stack, String result, String input) {
		// ���ö����¡�ķ������Ȱ�ջ�����������������Ӱ������
		Stack<String> temp = (Stack<String>) stack.clone();
		
		//public String substring(int beginIndex,int endIndex) Returns a string that is a substring of this string. 
		String subStr = input.substring(0, 1);  // "12"
		
		//public String substring(int beginIndex) Returns a string that is a substring of this string. 
		input = input.substring(1);  // "34"
		
		
		temp.push(subStr);
		
		// �ж���ֹ����
		if (input.length() == 0) {
			while (!temp.isEmpty()) {
				result += temp.pop().toString();
			}
			System.out.println(result);
		} 
		else {
			orderList(temp, result, input);
			while (!temp.isEmpty()) {
				result += temp.pop();
				orderList(temp, result, input);
			}
		}
	}
}
/*
��������

4321
3421
3241
3214
2431
2341
2314
2143
2134
1432
1342
1324
1243
1234

*/