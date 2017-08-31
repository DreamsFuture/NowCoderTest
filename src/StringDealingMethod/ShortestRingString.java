package StringDealingMethod;
/*
题目：彩色宝石项链


有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。
有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，
我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。
如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。 

输入描述:

		我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，G代表玻璃等等，
		我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。每行代表一种情况。
		
输出描述:
	
	输出学者能够拿到的最多的宝石数量。每行一个
	

输入：

	ABCYDYE
	ATTMBQECPD
	
输出：
	1
	3

此方法可以实现题目的问题，但是超出了内存的容量

*/



import java.util.Scanner;
public class ShortestRingString {
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){	
			String s = in.nextLine();	
			char[] c = (s+s).toCharArray();
			int num = 0;	
			
			//i表示i个连续的字符串
			for(int i = 5; i < c.length; i++){	
				
				//j表示第j个字符开始，到j+i个字符之间共i个字符的子字符串
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
			System.out.println(num);	
		}
		in.close();	
	}
}


//所以判断如何不超出指定的时间复杂度和控件复杂度也是比较难的问题，需要好好处理