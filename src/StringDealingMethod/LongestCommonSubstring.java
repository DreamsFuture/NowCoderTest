package StringDealingMethod;

public class LongestCommonSubstring {
	
	//先static修饰，再int
	public static int commonSubstring(char[] str1, char[] str2){
		
		int longest = 0;
		
		int length1 = str1.length;
		int length2 = str2.length;
		
		if(length1 == 0 || length2 == 0) return 0;
		
		for(int i = 0; i < length1; ++i){
			int n = i;
			int m = 0;
			int len = 0;
			while(m < length2 && n < length1){
				
				if(str1[n] == str2[m]){					
					++len;
					if(longest < len) longest = len;					
				}
				else{
					len = 0;					
				}
				++n;
				++m;				
			}					
		}
		return longest;
	}
	
	public static void main(String[] args) {
		String s1 = "AWEINAGSSSTTS";
		String s2 = "AWINAGTSSSTTSRRTAQAWEINAGAWEINAGSSSTTS";
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		//要比较两次，
		int longest1 = commonSubstring(arr1, arr2);
		System.out.println(longest1);
		int longest2 = commonSubstring(arr2, arr1);
		System.out.println(longest2);
		int longest = (longest1 > longest2) ? longest1:longest2;
		System.out.println(longest);
	}

}
