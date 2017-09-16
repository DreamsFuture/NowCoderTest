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


	1.  ��7�������ص㣺
		
    	��һ�������ĸ�λ����ȥ��,�ٴ����µ�����,��ȥ��λ����2��,�������7�ı���,��ԭ���ܱ�7���������������Ȼ̫����ֱ�ӹ۲���������ظ��˹��̡�

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
    			
    			if(modBySeven(s1)){
    				++num;
    			}
    			if(modBySeven(s2)){
    				++num;
    			}
    		}
    	}
    	return num;
    }
    
    //���������������ݹ飬��ͨ����ֻ��70%
    public static boolean modBySeven(String s){
    	
    	int length = s.length();
    	if(length < 3){
    		if(Integer.valueOf(s)%7 == 0) return true;
    		else return false;
    	}
    	
    	String s1 = s.substring(0, length - 1);
    	String s2 = s.substring(length - 1);
    	
    	long n1 = Integer.valueOf(s1);
    	long n2 = Integer.valueOf(s2);
		
    	long n3 = n1 - 2*n2;
    	
    	return modBySeven(String.valueOf(n3));
    }
    
}

/*
�ж�һ�����ܷ�7�����������ַ�����
�ٸ�β����
��һ�������ĸ�λ���ֽ�ȥ���ٴ����µ����У���ȥ��λ����2�����������7�ı�������ԭ���ܱ�7������
�����̫������㲻�׿����Ƿ�7�ı���������Ҫ������������β��������������Ĺ��̣�ֱ��������ж�Ϊֹ��
���磬�ж�133�Ƿ�7�ı����Ĺ������£�13��3��2��7������133��7�ı������������ж�6139�Ƿ�7�ı����Ĺ������£�613��9��2��595 �� 59��5��2��49��
����6139��7�ı����������ơ� 

��β����
֤�����̣�
  ��p=a1+a2*10+a3*10^2+...+a(n-1)*10^(n-1)+an*10^n
    q=a2+a3*10+...+a(n-1)*10^(n-2)+an*10^(n-1)-2a1
  2p+q=21(a2+a3*10+...+an*10^(n-1))
  ����Ϊ21=7*3��������p��7�ı���,��ô���Եõ�q��7�ı���
  

��ĩ������
�������ĩ��λ����ĩ��λ��ǰ����������ɵ���֮�������Ҳ�У��ܱ�7��11��13��������������ܱ�7��11��13������
���磺1005928
ĩ��λ����928��ĩ��λ֮ǰ��1005  1005-928=77 
��Ϊ7 | 77������7|1005928
ĩ����������֤����
��һ����ΪABCDEF=ABC��1000+DEF=ABC��1001-ABC+DEF=ABC��7��13��11-(ABC-DEF),�ɴ˿ɼ�ֻҪABC-DEF�ܱ�7��������ABCDEF�ܱ�7������

*/