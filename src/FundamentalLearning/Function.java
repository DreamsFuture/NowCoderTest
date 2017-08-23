package FundamentalLearning;

import java.util.Scanner;
public class Function{
    
    public int[] GetResult(int[] input){
        if (input == null || input.length<=1){
			
			return null;
		}
        int flags = 0;
        int flags1 = 0;
        int[] output = new int[2]; 
        int[] output1 = new int[2];
       
        
        
        boolean flag = false;
        for(int i = 0;i<input.length;i++){
         	for(int j = i+1;j<input.length;j++){
             	if(input[j-1]<input[j]){
                	j++;
                    flag = true;
                    output1[0] = i;
                
                }
                else if (input[j-1]>input[j] && flag){
                	j++;
                }
                else {
                    i++;
                    flag = false;
                    output1[1] = j-1;
                    flags1 = output1[1] - output1[0];
                }
                
                
            }
            
            if (flags1<flags){
            	continue;
            
            }
            else{
            flags = flags1;
            output[0] = output1[0];
            output[1] = output1[1];
            }
        }
        
        return output;      
    }
    
    
    public static void main(String[] args) { 	
    	int[] output = new int[2];
        Scanner in = new Scanner(System.in);
        
        int arrLength = in.nextInt();
        int[] input = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
	        input[i] = in.nextInt();
	    }
               
        Function function = new Function();
        output = function.GetResult(input);

        for(int i=0;i<output.length;i++){
        	System.out.println(output[i]);
        }
        
    	
	}
    
    
    
}