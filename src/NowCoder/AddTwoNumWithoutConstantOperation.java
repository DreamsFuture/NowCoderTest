package NowCoder;

public class AddTwoNumWithoutConstantOperation {
	
	
	public static void main(String[] args) {
		
		System.out.println(Add(5,7));
	}
	
	public static int Add(int num1,int num2) {
	    while( num2!=0 ){
	        int sum = num1 ^ num2;
	        int carray = (num1 & num2) << 1;
	        num1 = sum;
	        num2 = carray;
	    }
	    return num1;
	}

}
