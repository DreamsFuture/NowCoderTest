package ScannerExample;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class ScannerWithManyRows {
	
/*	
	�����ȷ�������ж��ٸ�������Ҫ�Լ�������ֹ�������������ֹ��������ͨ��������ʽ������
	
	1. ��������������У�
	2. ���ػ�ĳ����ֹ�źŵ��ַ����Ϳ���break��

*/	
	
	//��������������
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//��ʼ��������10�Ŀռ䣬���Բ������out of index
		ArrayList<int[]> arrayInteger = new ArrayList<int[]>();
		
		//int[] ends = {0,0,0,0,0,0};
		String s = new String();
		while(input.hasNextLine()){
			
			//һ��Ҫ��ins�ŵ����ѭ�����棬�ŵ����棬arrayInteger������Ԫ�ض���һ����
			int[] ins = new int[6];
			s = input.nextLine();
			int count = 0;
			
			for(int i = 0; i < s.length(); ++i, ++i){
				   char c = s.charAt(i);//�����ȡ�ַ����е��ַ�

				   ins[i/2] = (int)(c-'0');//�ַ�����-�ַ�0����ʵ�ʵ�����ֵ����ֵ����������   (int) ������뵽������
				   if((int)(c-'0') == 0) ++count;				   
				}
			
			//���������뵽arrayInteger�Ļ������е�һ��Ԫ����ʵ����ins����ĵ�һ��Ԫ�ص�λ�ã����ins���޸��ˣ����һ��Ԫ�ص�ֵҲ��ı�
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
		
	
		
		
		//�����ַ�������
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> arr = new ArrayList<Integer>();
		int count = 0;
		//��������жϾͲ�����ѭ����
		while (sc.hasNext()) {
			int a = sc.nextInt();
			arr.add(a);
			//6�ı�����ʼ���ҽ��յ�������Ϊ0����count = 1
			if(arr.size()%6 == 1 && a == 0)	count = 1;
			
			//����м䲻Ϊ6�ı���������aΪ0��count��ʼ����
			else if( a == 0) count++;

			//������������ʾֵ��Ϊ0
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
		
		//�ַ�����ĳ�ʼ��һ��Ҫ������''��������Ч������Ĵ���û����
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





