package Leetcode_Solution;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    	
    	
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        while (in.hasNextInt()) {//注意while处理多个case
            
            
            
            for(int i = 0;i<n;i++){
                a[i] = in.nextInt();
            }
        }
        long max = 0;
        
        for(int i =0;i<n;i++){
        	if(max<a[i]*a[i]){
        		max = a[i];
        	}
        }
        
        
        long res = ca(a);
        
        
        
        System.out.println(max);
        
    }
    
    public static long ca(int[] a){
    	long max = 0;
    	
    	for(int i = a.length;i>0;i++){
    		for(int j=)
    	}
    	
    	
    	
    	
    	return max;
    }
    
    //不会迭代处理这个问题，取出的种类，不熟悉
}





/*
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //多层嵌套使用，不会灵活使用
        ArrayList<ArrayList> arr= new ArrayList<ArrayList>();
        ArrayList result = new ArrayList();
        while (in.hasNextInt()) {
            int n = in.nextInt();
            
            for(int i = 0; i<n;i++){
            	ArrayList<Integer> array = new ArrayList<Integer>();
            	array.add(in.nextInt());
            	array.add(in.nextInt());
            	arr.add(array);
            }
            
            
        }
        
        for (int i = 0; i<arr.size();i++){
        	
        	for(int j = i+1; j<arr.size();j++){
        		Integer[] a = (Integer[]) arr.get(i).toArray();
        		Integer[] b = (Integer[]) arr.get(i).toArray();
        		if(a[0]>b[0]&&a[1]<b[1]){
        			
        			result.add(a);
        		}
        	}
        	
        }
        
        for(int i =0;i<result.size();i++){
        	System.out.println(result.get(i));
        	System.out.println("\n");
        }
        
        
        
        
    }
}

*/
















/*








public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int []nn=new int[n];
        for(int i=0;i<nn.length;i++)
        {
            nn[i]=input.nextInt();
        }
		
		input.close();
		
		int result = part(nn,n);
		System.out.println(result);
		
	}
	

	public static int part(int[] data,int N){
		
		int num = 0;
		for(int i = 1;i<N-1;i++){
			
			
			for(int j = i+1;j<N;j++){
				
					float S1 = 0;
					float S2 = 0;
					float S3 = 0;
					for(int m = 0;m<i;m++){
						S1 +=data[m];
					}
					 
					for(int n =i;n<j;n++ ){
						S2 +=data[n];
					}
					for(int k =j;k<N;k++ ){
						S3 +=data[k];
					}
					
					if(Math.abs(S1-S2)<=1.0 && Math.abs(S2-S3)<=1.0 && Math.abs(S1-S3)<=1.0){
						num++;
					}
					
				}
			}
		
		
		
		
		return num;
	}
	
}
*/