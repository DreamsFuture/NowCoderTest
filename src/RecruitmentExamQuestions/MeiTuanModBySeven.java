package RecruitmentExamQuestions;
import java.math.BigInteger;
import java.util.Scanner; 
/*
 美团2017年9月14日数据挖掘题目

题目描述：
她想用这些数制造出更多的能够被 7 整除的数。于是她从这 n 个数中选出两个数，然后将
输入
第一行包含一个整数n。2 ≤n≤ 105
第二行包含n个正整数ai。1 ≤ai≤109
样例输入
3
127 1996 12
样例输出
4

Hint
一共有 4 种组合方式，其中：把 12 写在 1996 前面得到 121996；把 127 写在 12 前面得到12712；
把 1996 写在 12 前面得到 199612；把 1996 写在 127 前面得到 1996127；
都是可以被 7 整除的，其余的组合方式不能被 7 整除。

*/
public class MeiTuanModBySeven {
    public static void main(String[] args){  
        Scanner in = new Scanner(System.in);  
        int n = in.nextInt();  
        Long[] data = new Long[n];
        for(int i = 0; i< n; ++i){
        	data[i] = in.nextLong();
        }
        in.close();
        System.out.println(solve(n,data));     
    }  
    public static int solve(int n, Long[] data){
    	int num = 0;
    	BigInteger constant1 = BigInteger.valueOf(7);
    	for(int i = 0; i<data.length;++i){
    		for(int j = i+1; j<data.length;++j){
    			String s1 = String.valueOf(data[i])+String.valueOf(data[j]);
    			String s2 = String.valueOf(data[j])+String.valueOf(data[i]);
    			BigInteger number1 = new BigInteger(s1);
    			BigInteger number2 = new BigInteger(s2);
    			number1 = number1.mod(constant1) ;
    			number2 = number2.mod(constant1) ;
    			if(number1.equals(BigInteger.valueOf(0))){
    				++num;
    			}
    			if(number2.equals(BigInteger.valueOf(0))){
    				++num;
    			}
    		}
    	}
    	return num;
    }
}