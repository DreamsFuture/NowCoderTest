package ScannerTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static List<String> list = new ArrayList<String>();
	public static String a;
	public static String b;

	/** ������������������ʵ����ĿҪ��Ĺ��� **/
	/** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/ 
    public static void match(String str, String nstr) {
          String[] level = nstr.split();
          String[] result = new String[6];
          ArrayList<Integer> index = new ArrayList<Integer>();
          for(int i = 0;i<6;i++){
        	  index[i] = (int)Integer.parseInt(level[i]);
          }
          int j = 1;
              for(int i = 1;i<6;i++){
                  result[0] = level[i];
                  index.remove((int)Integer.parseInt(level[i]));
                  while((j<6)){
                      if(result[i-1]!= a || result[i-1]!=b ) {
                           result[j] = level[insert(index)];
                           j++;
                       }
                   
                  }
                  list.add(result.toString()); 
              
              }
              
                  
    }

public int static insert(int[] index){

}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		a = s.next();
		b = s.next();
		match("", "123455");
		System.out.println(list.size());
	}
}