package ScannerExample;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class ScannerWithManyRows {
	
/*	
	如果不确定输入有多少个，则需要自己定义终止输入的条件，终止条件可以通过两个方式来处理：
	
	1. 输入的数量（不行）
	2. 当截获到某个终止信号的字符，就可以break了

*/	
	
	//处理整型类数据
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//初始化，给了10的空间，所以不会出现out of index
		ArrayList<int[]> arrayInteger = new ArrayList<int[]>();
		
		//int[] ends = {0,0,0,0,0,0};
		String s = new String();
		while(input.hasNextLine()){
			
			//一定要吧ins放到这个循环里面，放到外面，arrayInteger的所有元素都是一样的
			int[] ins = new int[6];
			s = input.nextLine();
			int count = 0;
			
			for(int i = 0; i < s.length(); ++i, ++i){
				   char c = s.charAt(i);//逐个获取字符串中的字符

				   ins[i/2] = (int)(c-'0');//字符数字-字符0就是实际的数字值，赋值给数字数组   (int) 必须放入到括号中
				   if((int)(c-'0') == 0) ++count;				   
				}
			
			//如果这里加入到arrayInteger的话，其中第一个元素其实给了ins数组的第一个元素的位置，如果ins被修改了，则第一个元素的值也会改变
			arrayInteger.add(ins);
			
			if(count == 6) break;
			/*
			 * System.out.println(arrayInteger.get(arrayInteger.size()-1));
			 * if(arrayInteger.get(arrayInteger.size()-1) == ends) break;
			*/
			
		}
		
		input.close();
		int[][] datas = new int[arrayInteger.size()][6];
		
		for(int i = 0; i < arrayInteger.size(); i++){
			
			datas[i] = arrayInteger.get(i);
			
			for(int j = 0;j < 6; j++){
				
				System.out.print(datas[i][j]);
				System.out.print(' ');
				if(j == 5) System.out.println();
			}
		}
		
	
		
		
		//处理字符类数据
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> arr = new ArrayList<Integer>();
		int count = 0;
		//有了这个判断就不会死循环了
		while (sc.hasNext()) {
			int a = sc.nextInt();
			arr.add(a);
			//6的倍数开始并且接收到的数据为0，令count = 1
			if(arr.size()%6 == 1 && a == 0)	count = 1;
			
			//如果中间不为6的倍数，但是a为0，count开始计数
			else if( a == 0) count++;

			//如果其他情况表示值不为0
			else if( a !=0) count = 0;
			if(count == 6)	break;
		}
		
		sc.close();
		
		int length = arr.size()/6;
		int[][] m = new int[length][6]; 
		
		for(int i = 0;i<length ;i++){
			
			for(int j = 0;j<6;j++){
				
				m[i][j] = arr.get(6*i+j);
				
				System.out.print(m[i][j]);
				System.out.print(' ');
				if(j == 5) System.out.println();
			}		
		}

	/*	
		Scanner in = new Scanner(System.in);
		
		ArrayList<char[]> arrayString = new ArrayList<char[]>();
		
		//字符数组的初始化一定要单引号''，否则无效，下面的代码没有用
		char[] end = {'0','0','0','0','0','0'};
		
		while(in.hasNextLine()){
			arrayString.add(in.nextLine().toCharArray());
			System.out.println(arrayString.get(arrayString.size()-1));
			if(Arrays.equals(arrayString.get(arrayString.size()-1), end)) break;
			
		}
		
		int arrayLength = arrayString.size();
		
		char[][] data = new char[arrayLength][6];
		
		for(int i = 0; i < arrayLength; i++){
			for(int j = 0;j < 6; j++){
				System.out.print(data[i][j]);
				System.out.print(' ');
				if(j == 5) System.out.println();
			}
		}
		
		*/
		
	
		
	}
}





