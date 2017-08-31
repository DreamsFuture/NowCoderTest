package StringDealingMethod;

import java.util.Scanner;

public class StringMethodRing {

	// �������ݲ�����Ҫһ���Զ���ȡ���������ݣ������ƶ�ţ���������������һ��һ��ִ��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(gem(sc.nextLine()));
		sc.close();
	}

	public static int gem(String s) {
		char[] ca = s.toCharArray();
		int len = s.length();
		for (int x = 5; x < len; x++) { // xΪ��ȡ��ʯ�ĸ���
			for (int y = 0; y < len; y++) {// yΪxȷ��������µ����Ĵ���

				// ����StringBuilder����ʵ��append�������������Ҫ֪�������м���Ԫ�أ����ܿ���֪��

				StringBuilder temp = new StringBuilder("");

				// �����ݿ�����temp��
				for (int z = y; z < y + x; z++) {

					// %������������������ڴ���ѭ������ģ���s+s��Ҫʡ�ռ�
					temp.append(ca[z % len]);
				}

				// ��temp����ַ�������
				String t = temp.toString();

				// �鿴����ַ����Ƿ������Щ�ַ�
				if (t.contains("A") && t.contains("B") && t.contains("C") && t.contains("D") && t.contains("E")) {
					return len - x;
				}
			}
		}
		return 0;
		/*
		char[] c = (s+s).toCharArray();
		int num = 0;	
		//i��ʾi���������ַ���
		for(int i = 5; i < c.length; i++){	
			//j��ʾ��j���ַ���ʼ����j+i���ַ�֮�乲i���ַ������ַ���
			 
			//�����ε��ù��Ʒǳ�ռ���ڴ�
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