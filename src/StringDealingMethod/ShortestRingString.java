package StringDealingMethod;
/*
��Ŀ����ɫ��ʯ����


��һ����ɫ��ʯ���������ɺܶ��ֲ�ͬ�ı�ʯ��ɵģ������챦ʯ������ʯ����ʯ����䣬����ȡ�
��һ������������ʹ͸���һ��ѧ�ߣ�������˵������Դ����������������������ϲ���챦ʯ������ʯ����ˮ����������ʯ�����֣�
��Ҫ��������н�ȡ������һС�λ����ң���һ���б���������е������ֱ�ʯ��ʣ�µĲ�������Դ��ߡ�
����޷��ҵ���һ��Ҳ�޷����ߡ������ѧ���ҳ�����з��������ܹ��õ����ı�ʯ�� 

��������:

		������ÿ���ַ�����һ�ֱ�ʯ��A��ʾ�챦ʯ��B��ʾ����ʯ��C������ˮ����D������䣬E������ʯ��F������ʯ��G�������ȵȣ�
		������һ��ȫ��Ϊ��д��ĸ���ַ����б�ʾ�����ı�ʯ���У�ע����������β��ӵġ�ÿ�д���һ�������
		
�������:
	
	���ѧ���ܹ��õ������ı�ʯ������ÿ��һ��
	

���룺

	ABCYDYE
	ATTMBQECPD
	
�����
	1
	3

�˷�������ʵ����Ŀ�����⣬���ǳ������ڴ������

*/



import java.util.Scanner;
public class ShortestRingString {
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()){	
			String s = in.nextLine();	
			char[] c = (s+s).toCharArray();
			int num = 0;	
			
			//i��ʾi���������ַ���
			for(int i = 5; i < c.length; i++){	
				
				//j��ʾ��j���ַ���ʼ����j+i���ַ�֮�乲i���ַ������ַ���
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


//�����ж���β�����ָ����ʱ�临�ӶȺͿؼ����Ӷ�Ҳ�ǱȽ��ѵ����⣬��Ҫ�úô���