package DynamicPlanning;

public class GetTranslationCount {
	
	public static int TranslationCount(String[] s){
		int[] count = new int[s.length];
		
		
		
		//初始化数据
		count[0] = 1;
		
		for(int i = 1;i<s.length;i++){
			int  j =0;
			
			int num = Integer.parseInt(s[i-1])*10 + Integer.parseInt(s[i]);
//			System.out.println(num);
			if(num<=25&&i-2>0){
				//在前2个的基础上加2，
				j = count[i-2] + 2;
			}
			else{
				//如果不符合，则只能加1
				j = count[i-1] +1 ;
			}
			
			
			count[i] = j;
			
			
		}
		
		
		
		return count[s.length-1];
	}
	
	public static void main(String[] args) {
		
		String[] s = {"1","2","2","5","8"};
		System.out.println(TranslationCount(s));
		
	}

}
