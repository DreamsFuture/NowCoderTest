package FundamentalLearning;
import java.util.Scanner;
public class Search{
	public static void searchArr(){
    	int arrLength = 0;
     	int searchLength = 0;      
        Scanner in = new Scanner(System.in);
        arrLength = in.nextInt();
        searchLength = in.nextInt();
        int[] A = new int[arrLength];
        int[] B = new int[arrLength];
        int[][] Q = new int[searchLength][2];
        for(int i= 0;i<arrLength;i++){        
        	A[i] = in.nextInt();            
        }
        for(int i= 0;i<arrLength;i++){        
        	B[i] = in.nextInt();            
        }
        int sum = 0;
        for(int i= 0;i<searchLength;i++){ 
            for(int j= 0;j<arrLength;j++){        
        		if((A[j] >= Q[i][0])&&(B[j]>=Q[i][1])){
               	 sum++;
          		 }
       		 }
            System.out.println(sum);
        	 sum = 0;          
        }   
    }
	public static void main(String[] args){
		Search search = new Search();
        search.searchArr(); 
    }
}