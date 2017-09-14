package RecruitmentExamQuestions;
import java.math.BigInteger;
import java.util.Scanner; 
/*
 ����2017��9��14�������ھ���Ŀ

��Ŀ������
��������Щ�������������ܹ��� 7 �������������������� n ������ѡ����������Ȼ��
����
��һ�а���һ������n��2 ��n�� 105
�ڶ��а���n��������ai��1 ��ai��109
��������
3
127 1996 12
�������
4

Hint
һ���� 4 ����Ϸ�ʽ�����У��� 12 д�� 1996 ǰ��õ� 121996���� 127 д�� 12 ǰ��õ�12712��
�� 1996 д�� 12 ǰ��õ� 199612���� 1996 д�� 127 ǰ��õ� 1996127��
���ǿ��Ա� 7 �����ģ��������Ϸ�ʽ���ܱ� 7 ������

*/
public class MeiTuanModBySeven {
    public static void main(String[] args){  
        Scanner in = new Scanner(System.in);  
        int n = in.nextInt();  
        Long[] data = new Long[n];
        for(int i = 0; i< n; ++i){
        	data[i] = in.nextLong();
        }
        in.close();
        System.out.println(solve(n,data));     
    }  
    public static int solve(int n, Long[] data){
    	int num = 0;
    	BigInteger constant1 = BigInteger.valueOf(7);
    	for(int i = 0; i<data.length;++i){
    		for(int j = i+1; j<data.length;++j){
    			String s1 = String.valueOf(data[i])+String.valueOf(data[j]);
    			String s2 = String.valueOf(data[j])+String.valueOf(data[i]);
    			BigInteger number1 = new BigInteger(s1);
    			BigInteger number2 = new BigInteger(s2);
    			number1 = number1.mod(constant1) ;
    			number2 = number2.mod(constant1) ;
    			if(number1.equals(BigInteger.valueOf(0))){
    				++num;
    			}
    			if(number2.equals(BigInteger.valueOf(0))){
    				++num;
    			}
    		}
    	}
    	return num;
    }
}