package regularExpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionLowercaseWord {
	
	/*
	 * 
	 * \\w+ ������ʽ��ʾ�����ַ����»���_����������0-9��������ĸa-zA-Z��
	 * 
	 */
	
	
	public static void main(String[] args) {
		// ƥ��\\w+��ʹ�÷���
		Matcher n = Pattern.compile("(\\w+)").matcher("_ 5414 aewa * % @ dfasdfa");
		while(n.find()){
			System.out.println(n.group());
			System.out.println("Word start: "+n.start());
			System.out.println("Word end:   "+n.end());
		}
		// ƥ�� group�������������
		Matcher m = Pattern.compile("(\\w+)(.*sd.*)").matcher("_5414aewa * % @ dfasdfa");
		while(m.find()){
			System.out.println(m.group(2));
			System.out.println("Group start: "+m.start());
			System.out.println("Group end:   "+m.end());
		}
		// ƥ�䵥�ʱ߽�����
		Matcher Boundaries = Pattern.compile("wor\b").matcher("_5414aewa * % @ dwor word dfa");
		while(Boundaries.find()){
			System.out.println(Boundaries.group());
			System.out.println("Boundaries start: "+Boundaries.start());
			System.out.println("Boundaries end:   "+Boundaries.end());
			// ---------------------------�����⣬ʵ�ֲ���-------------------------------
		}	
	}
}
