package NowCoder;

/*本质问题：可以比较大的全排列方法

实际问题：字符串的排列（包括重复的字符）

输入一个字符串,按字典序打印出该字符串中字符的所有排列。

例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

*/



import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		permutation.PermutationSolution("1212");
		/*
		 * for(String s : arraystring){ System.out.println(s); }
		 */
	}

	public ArrayList<String> PermutationSolution(String str) {
		ArrayList<String> res = new ArrayList<String>();
		if (str != null && str.length() > 0) {

			// 把字符里面要排列的内容，一个一个独立起来，然后进行排序
			char[] seq = str.toCharArray();
			
			

			Arrays.sort(seq); // 排列

			// 把数组里面的字符进行合起来变成字符串
			res.add(String.valueOf(seq)); // 先输出一个解
			int len = seq.length;
			while (true) {
				int p = len - 1, q;
				// 从后向前找一个seq[p - 1] < seq[p]
				while (p >= 1 && seq[p - 1] >= seq[p])
					--p;
				// 判断是否全部拍好，是否最后一个，不是则跳过if内部的语句，否则就跳出while循环
				if (p == 0)
					break; // 已经是“最小”的排列，退出

				// 从p向后找最后一个比seq[p]大的数，先按条件走，然后往回走一个步，
				q = p;
				--p;

				// 一直判断后面大于之前找的那个，然后后面--q，就是回到小于的前一个
				while (q < len && seq[q] > seq[p])  
					
					// 等于的话也算，这样可以把重复的单词也计算进去
					q++;
				--q;

				// 交换这两个位置上的值
				swap(seq, q, p);

				// 将p位置之后的序列元素*倒序*排列
				reverse(seq, p + 1);

				// 把这个排好序的组合放入到list中去
				res.add(String.valueOf(seq));
				System.out.println(seq);
			}
		}
		return res;
	}

	// 倒叙排列函数，这就是一个排序问题了，利用？？？
	public static void reverse(char[] seq, int start) {
		int len;
		if (seq == null || (len = seq.length) <= start)
			return;

		// 没有比较元素的大小，这个怎么排序？ 注意：len前面只定义了，但是在if条件判断里面进行了赋值，这种简洁性，减少代码，但是增加了阅读的难度
		for (int i = 0; i < ((len - start) >> 1); i++) {
			
			//i < ((len - start) >> 1 其功能就是i < ((len - start) /2 并没有什么区别			
			int p = start + i;
			int q = len - 1 - i;
			if (p != q)
				swap(seq, p, q);
//				System.out.println(seq);
		}
	}

	public static void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

	// 另外一个倒序排列的函数,之前是顺序，现在只要把其倒序一下就行了
	private void reverse1(char[] chars, int k) {
		if (chars == null || chars.length <= k)
			return;
		int len = chars.length;
		for (int i = 0; i < (len - k) / 2; i++) {
			int m = k + i;
			int n = len - 1 - i;
			if (m <= n)
				swap(chars, m, n);
		}
	}

}


/**
     * 2、字典序排列算法
     *
     * 可参考解析： http://www.cnblogs.com/pmars/archive/2013/12/04/3458289.html  （感谢作者）
     *
     * 一个全排列可看做一个字符串，字符串可有前缀、后缀。
     * 生成给定全排列的下一个排列.所谓一个的下一个就是这一个与下一个之间没有其他的。
     * 这就要求这一个与下一个有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。
     *
     * [例]839647521是1--9的排列。1—9的排列最前面的是123456789，最后面的987654321，
     * 从右向左扫描若都是增的，就到了987654321，也就没有下一个了。否则找出第一次出现下降的位置。
     *
     * 【例】 如何得到346987521的下一个
     * 第1步，从**尾部往前**找第一个P(i-1) < P(i)的位置
     * 3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
     * 最终找到6是*第一个变小*的数字，记录下6的位置i-1
     *
     * 第2步，从i位置**往后**找到*最后一个大于或者等于6*的数
     * 3 4 6 -> 9 -> 8 -> 7 5 2 1
     * 最终找到7的位置，记录位置为m
     *
     * 第3步，交换位置i-1和m的值
     * 3 4 7 9 8 6 5 2 1
     * 第4步，**倒序i位置后**的所有数据
     * 3 4 7 1 2 5 6 8 9
     * 则347125689为346987521的下一个排列
	 
	 123(排序) ->132 ->132(逆序) ->231 ->213(逆序) ->231 ->231(逆序) ->321 ->312(逆序) ->321 ->321(逆序)
	 
	 123 132 213 231 312 321 

	 1122(排序) 1221(前小后大交换)  1212(逆序) 1221  1221   1221(逆序)  2121   2211  2112(逆序)  

     *
     * @param str
     * @return
     
*/