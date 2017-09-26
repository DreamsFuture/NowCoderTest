package RecruitmentExamQuestions;
import java.util.Scanner;
public class PerfectWorldScoreMaximum {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int[] score = new int[n];
        int[] time = new int[n];
        
        for(int i = 0; i<n; ++i){
            score[i] = in.nextInt();
        }
        for(int i = 0; i<n; ++i){
            time[i] = in.nextInt();
        }
        
        int totalTime = in.nextInt();
        in.close();
        
        System.out.println(solution(score,time,totalTime,n));
        }
    

	public static int solution(int[] score, int[] time, int totalTime, int n){
        
        int[][] dp = new int[totalTime+1][n+1];
        
        for(int i = 0; i < totalTime + 1; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 0; i< n+1; i++){
            dp[0][i] = 0;
        }
       //只给totalTime=10分钟时间，看获得的最大分数
        
        for(int i = 1; i < totalTime + 1; ++i){
        	for(int j = 1; j < n + 1; ++j){
        	
                dp[i][j] = dp[i][j-1];
                
                //判断
                if(time[j-1] <= i){
                	//减去time[j-1]是为了把score[j-1]包括进去，也就是加上这个，然后再加上前dp[i - time[j-1]][j]的值是否会更大
                	int tmp = dp[i-time[j-1]][j-1] + score[j-1] ;
                	//这个是获取每一个前面的j，进行比较，比较的其实是所有的值
                    if(dp[i][j] < tmp ){
                        dp[i][j] = tmp;
                    }
                }
                
                System.out.print(dp[i][j]);
                System.out.print(' ');
                if(j == n) System.out.println();    
            }
        }
        return dp[totalTime][n];
    }
}

/*
5
5 4 3 5 2 
2 2 3 5 1
10

*/