package Stack;

import java.util.Stack;

/*
	给定入栈序列1、2、3、4、5，输出所有的出栈序列和总数。总共有多少总出栈序列比较简单，catalan数。
	所有的出栈序列：对于每一个将要入栈的数而言都存在两种情况，出栈和入栈，由此我们很容易想到递归。
	下面就是使用递归输出所有的序列。

	主要思路就是：对于每一次递归都存在两种可能，出栈和入栈;
	入栈需要判断是否所有的数字都已经入栈了，出栈需要判断当前栈是否为空，当所有的数都已经进入过栈了，
	那么打印出栈序列，中间出栈序列使用中间变量outSer记录，最后的出栈序列就是outSer+栈中的序列

*/

public class AllPopOrderFromStack {
	public static int number = 0;
	static Stack<Integer> stack = new Stack<>();//不需要补全  Stack<Integer>()
	static int[] arr = new int[10];
	
	//i表示从i开始到n之间的数字依次入栈
	public static void stackSequence(int i, int n){
		int top;
		
		//判断递归结束标志,当所有的数据都入栈了，则开始打印数据
		if(i == n + 1){
			//number表示总共有多少种出栈序列
			++number;
			
			//依次打印出arr[j]中的元素
			for(int j = 0; j < n - stack.size(); ++j){
				System.out.print(arr[j] + "-");
			}
			
			for(int k = stack.size() - 1; k >= 0; k--){
				System.out.print(stack.get(k));
			}
			System.out.println();
		}
		
		//如果当前的数据并没有全部都压入栈中，则开始入栈或者出栈操作
		else{
			
			//入栈操作
			stack.push(i);
			stackSequence(i+1, n);
			stack.pop();
			
			//如果当前栈中没有空 ,则出栈     
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
