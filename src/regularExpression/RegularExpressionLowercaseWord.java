package regularExpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionLowercaseWord {
	
	/*
	 * 
	 * \\w+ 正则表达式表示三种字符“下划线_”，“数字0-9”，“字母a-zA-Z”
	 * 
	 */
	
	
	public static void main(String[] args) {
		// 匹配\\w+的使用方法
		Matcher n = Pattern.compile("(\\w+)").matcher("_ 5414 aewa * % @ dfasdfa");
		while(n.find()){
			System.out.println(n.group());
			System.out.println("Word start: "+n.start());
			System.out.println("Word end:   "+n.end());
		}
		// 匹配 group（）函数的情况
		Matcher m = Pattern.compile("(\\w+)(.*sd.*)").matcher("_5414aewa * % @ dfasdfa");
		while(m.find()){
			System.out.println(m.group(2));
			System.out.println("Group start: "+m.start());
			System.out.println("Group end:   "+m.end());
		}
		// 匹配单词边界问题
		Matcher Boundaries = Pattern.compile("wor\b").matcher("_5414aewa * % @ dwor word dfa");
		while(Boundaries.find()){
			System.out.println(Boundaries.group());
			System.out.println("Boundaries start: "+Boundaries.start());
			System.out.println("Boundaries end:   "+Boundaries.end());
			// ---------------------------有问题，实现不了-------------------------------
		}	
	}
}
