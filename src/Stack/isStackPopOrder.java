package Stack;

import java.util.Stack;

/*
ջ��ѹ�롢��������

��Ŀ�����������������У���һ�����б�ʾջ��ѹ��˳�����ж϶��������Ƿ�Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ���������־�����ȡ�
����˼·��

�����������ֱ�۵��뷨���ǽ���һ������ջ��������ĵ�һ�������е���������ѹ��ø���ջ�������յڶ������е�˳�����δӸ�ջ�е������֡�

�ж�һ�������ǲ���ջ�ĵ������еĹ��ɣ������һ�����������ָպ���ջ�����֣���ôֱ�ӵ�����
�����һ�����������ֲ���ջ�������ǰ�ѹջ�����л�û����ջ������ѹ�븨��ջ��ֱ������һ����Ҫ����������ѹ��ջ��Ϊֹ��
������е����ֶ�ѹ��ջ����Ȼû���ҵ���һ�����������֣���ô�����в�������һ���������С�
*/
public class isStackPopOrder {
	 /**
     * ���������������У���һ�����б�ʾջ��ѹ��˳�����ж϶��������Ƿ�Ϊ��ջ�ĵ���˳��
     * ����ѹ��ջ���������־�����ȡ���������1 ��2��3 ��4��5 ��ĳջѹջ���У�
     * ����4��5��3��2��1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
     * ��4��3��5��1��2�Ͳ������Ǹ�ѹ�����еĵ������С�
     * �����鱾�ĵķ�����ͬ��
     *
     * @param push ��ջ����
     * @param pop  ��ջ����
	 * @return 
     * @return true����ջ��������ջ���е�һ������˳��
     */
	public static boolean isPopOrder(int[] push, int[] pop){
		if(push == null || pop == null || pop.length == 0 || push.length == 0){
			return false;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int pushIndex = 0;
		int popIndex = 0;

		while( popIndex < pop.length ){
			while(pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])){
				stack.push(push[pushIndex]);
				++pushIndex;	
			}
			if(stack.peek() == pop[popIndex]){
				stack.pop();
				++popIndex;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {3, 5, 4, 2, 1};
        int[] pop3 = {4, 3, 5, 1, 2};
        int[] pop4 = {3, 5, 4, 1, 2};
        System.out.println("true: " + isPopOrder(push, pop1));
        System.out.println("true: " + isPopOrder(push, pop2));
        System.out.println("false: " + isPopOrder(push, pop3));
        System.out.println("false: " + isPopOrder(push, pop4));
        int[] push5 = {1};
        int[] pop5 = {2};
        System.out.println("false: " + isPopOrder(push5, pop5));
        int[] push6 = {1};
        int[] pop6 = {1};
        System.out.println("true: " + isPopOrder(push6, pop6));
        System.out.println("false: " + isPopOrder(null, null));
        // ���Է���2
	}
}
