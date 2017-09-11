package RecruitmentExamQuestions;
import java.util.Scanner;
public class JingDong1 {


    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long startTime=System.currentTimeMillis(); 
        System.out.println(solution(n));
        in.close();
        long endTime=System.currentTimeMillis(); 
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        }
    
	public static long solution(long n){
        if(n == 0){
            return 0;
        }
        long result = 1;
        long result_low = 1;
        long result_high = (long)10e4;
        boolean low = false;
        boolean high = false;
        while(true){
        	result = result_low + (long)(Math.random()*result_high);
            if(n>(result*(result+1)/2) && n<(result+1)*(result+2)/2){
                break;
            }
            else if(n<(result*(result+1)/2)){
            	result_high = (long)(result*(result+1)/2);
            	high = true;
            }
            else if(n>(result+1)*(result+2)/2){
            	result_low = (long)(result+1)*(result+2)/2;
            	low = true;
            }
            while(high && result_low>result_high){
            	result_high = result_high /2;
            }
            high = false;
            while(low && result_high<result_low){
            	result_low = result_low/2;
            }
            low = false;
        }
        
        
            
        return result+1;
    }

}