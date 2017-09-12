package Stack;

import java.util.Stack;


/*
	我们来考虑f(4), 我们给4个元素编号为a,b,c,d, 那么考虑：元素a只可能出现在1号位置，2号位置，3号位置和4号位置(很容易理解，一共就4个位置，比如abcd,元素a就在1号位置)。 
		1) 如果元素a在1号位置，那么只可能a进栈，马上出栈，此时还剩元素b、c、d等待操作，就是子问题f(3) 
		2) 如果元素a在2号位置，那么一定有一个元素比a先出栈，即有f(1)种可能顺序（只能是b），还剩c、d，即f(2) 
		3) 如果元素a在3号位置，那么一定有两个元素比1先出栈，即有f(2)种可能顺序（只能是b、c），还剩d，即f(1) 
		4) 如果元素a在4号位置，那么一定是a先进栈，最后出栈，那么元素b、c、d的出栈顺序即是此小问题的解，即 f(3)

	结合所有情况，即f(4) = f(3) + f(2) * f(1) + f(1) * f(2) + f(3) 
	为了规整化，我们定义f(0) = 1；于是f(4)可以重新写为： 
	f(4) = f(0) * f(3) + f(1) * f(2) + f(2) * f(1) + f(3) * f(0) 
	然后我们推广到n，推广思路和n=4时完全一样，于是我们可以得到： 
	f(n) = f(0)*f(n-1) + f(1)*f(n-2) + … + f(n-1)*f(0) 

*/
public class PopOrderFromStack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 测试列举所有出栈顺序
		Stack<String> stack = new Stack<String>();
		orderList(stack, "", "1234");
	}

	public static void orderList(Stack<String> stack, String result, String input) {
		// 利用对象克隆的方法，先把栈复制下来以免操作后影响下面
		Stack<String> temp = (Stack<String>) stack.clone();
		
		//public String substring(int beginIndex,int endIndex) Returns a string that is a substring of this string. 
		String subStr = input.substring(0, 1);  // "12"
		
		//public String substring(int beginIndex) Returns a string that is a substring of this string. 
		input = input.substring(1);  // "34"
		
		
		temp.push(subStr);
		
		// 判断终止条件
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
输出结果：

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