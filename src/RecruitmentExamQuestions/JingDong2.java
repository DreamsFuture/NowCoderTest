package RecruitmentExamQuestions;


import java.util.Scanner;
public class JingDong2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        JingDong2 jingdong = new JingDong2();
        System.out.println(jingdong.solution(n));
        in.close();
        }
    
	public long solution(long n){
        if(n == 0){
            return 0;
        }
        long result = 0;
        final long m = (long) (1e9+7);
        
        result+= Math.pow(n, n) + (n-1)*n;
        
        for(int a = 2;a<=n;a++){
        	for(int b = 2;a<=n;a++){
        		for(int c = 2;a<=n;a++){
        			for(int d = 2;a<=n;a++){
        	        	if(a!=b && c!=d && a!=c){
        	        		if(Math.pow(a, b) == Math.pow(c,d)){
        	        			result ++;
        	        		}
        	        	}
        	        }
                }
            }
        }
            
        return result%m;
    }

}