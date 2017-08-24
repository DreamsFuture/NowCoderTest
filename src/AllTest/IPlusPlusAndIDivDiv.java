package AllTest;

public class IPlusPlusAndIDivDiv {
	
	
	public static void main(String[] args) {
		
		for(int i = 0;i < 10 ;i++){
			System.out.println(i);
		}
		
		int a = 1;
		int n = 1;
		
		int b = ++a;
		
		int c = n++;
		
		System.out.printf("b = %d, c = %d",b,c);
		System.out.println();
		System.out.println(b == c);
		
		for(int i = 0; i<10 ; ++i){
			System.out.println(i);
		}
		
	}

}
