package AllTest;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		StringBuilder strings = new StringBuilder();
		strings.append("xyz");
		strings.append("123456");
		strings.append("abc");
		
		System.out.println(strings);
		
		strings.reverse();
		
		System.out.println(strings);
	}
	
	
	
}


/*����Ľ����


xyz123456abc
cba654321zyx



*/



