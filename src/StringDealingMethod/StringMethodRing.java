package StringDealingMethod;

import java.util.Scanner;

public class StringMethodRing {

	// 处理数据并不需要一次性都获取到所有数据，所以推断牛客网里面的数据是一条一条执行
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(gem(sc.nextLine()));
		sc.close();
	}

	public static int gem(String s) {
		char[] ca = s.toCharArray();
		int len = s.length();
		for (int x = 5; x < len; x++) { // x为截取宝石的个数
			for (int y = 0; y < len; y++) {// y为x确定的情况下迭代的次数

				// 利用StringBuilder可以实现append这个函数，不需要知道具体有几个元素，尽管可以知道

				StringBuilder temp = new StringBuilder("");

				// 把数据拷贝到temp中
				for (int z = y; z < y + x; z++) {

					// %这个除法余数就是用于处理循环问题的，比s+s还要省空间
					temp.append(ca[z % len]);
				}

				// 把temp变成字符串数据
				String t = temp.toString();

				// 查看这个字符中是否包含这些字符
				if (t.contains("A") && t.contains("B") && t.contains("C") && t.contains("D") && t.contains("E")) {
					return len - x;
				}
			}
		}
		return 0;
		/*
		char[] c = (s+s).toCharArray();
		int num = 0;	
		//i表示i个连续的字符串
		for(int i = 5; i < c.length; i++){	
			//j表示第j个字符开始，到j+i个字符之间共i个字符的子字符串
			 
			//这里多次调用估计非常占用内存
			for(int j = 0; j < c.length - i; j++){
				if((s+s).substring(j, j+i).contains("A")&&
						(s+s).substring(j, j+i).contains("B")&&
						(s+s).substring(j, j+i).contains("C")&&
						(s+s).substring(j, j+i).contains("D")&&
						(s+s).substring(j, j+i).contains("E")){
					if(num < c.length - i - s.length()){
						num = c.length - i - s.length();
					}				
				}			
			}			
		}
		return num;	
		*/	
		}
}