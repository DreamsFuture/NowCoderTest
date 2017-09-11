package RecruitmentExamQuestions;
import java.util.Scanner;
public class AiqiyiDoubleTT {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] arr = s.toCharArray(); 
        System.out.println(solution(arr));
        }
    
   public static int solution(char[] arr){
	   int num = 0;
	   int max = 0;
	   for(int i = 0; i < arr.length; i++){
		   int m = i;
		   int n = i+1;
		   
		   while(n< arr.length){
			   if(arr[m]==arr[n]){
				   ++m;
				   ++n;
				   ++num;
			   }
			   else{
				   ++n;
			   }
		   }
		   
		   if(max<num){
			   max = num;
		   }
		   
		   
		   
	   }
	   
	   
	   return num;
   }
    
    
}
