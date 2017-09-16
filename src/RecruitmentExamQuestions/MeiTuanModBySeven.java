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


	1.  被7整除的特点：
		
    	若一个整数的个位数字去掉,再从余下的数中,减去个位数的2倍,如果差是7的倍数,则原数能被7整除。如果数字仍然太大不能直接观察出来，就重复此过程。

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
    			
    			if(modBySeven(s1)){
    				++num;
    			}
    			if(modBySeven(s2)){
    				++num;
    			}
    		}
    	}
    	return num;
    }
    
    //如果不用下面这个递归，则通过率只有70%
    public static boolean modBySeven(String s){
    	
    	int length = s.length();
    	if(length < 3){
    		if(Integer.valueOf(s)%7 == 0) return true;
    		else return false;
    	}
    	
    	String s1 = s.substring(0, length - 1);
    	String s2 = s.substring(length - 1);
    	
    	long n1 = Integer.valueOf(s1);
    	long n2 = Integer.valueOf(s2);
		
    	long n3 = n1 - 2*n2;
    	
    	return modBySeven(String.valueOf(n3));
    }
    
}

/*
判断一个数能否被7整除，有两种方法：
①割尾法：
若一个整数的个位数字截去，再从余下的数中，减去个位数的2倍，如果差是7的倍数，则原数能被7整除。
如果差太大或心算不易看出是否7的倍数，就需要继续上述「截尾、倍大、相减、验差」的过程，直到能清楚判断为止。
例如，判断133是否7的倍数的过程如下：13－3×2＝7，所以133是7的倍数；又例如判断6139是否7的倍数的过程如下：613－9×2＝595 ， 59－5×2＝49，
所以6139是7的倍数，余类推。 

割尾法：
证明过程：
  设p=a1+a2*10+a3*10^2+...+a(n-1)*10^(n-1)+an*10^n
    q=a2+a3*10+...+a(n-1)*10^(n-2)+an*10^(n-1)-2a1
  2p+q=21(a2+a3*10+...+an*10^(n-1))
  又因为21=7*3，所以若p是7的倍数,那么可以得到q是7的倍数
  

②末三法：
这个数的末三位数与末三位以前的数字所组成的数之差（反过来也行）能被7、11、13整除。这个数就能被7、11、13整除。
例如：1005928
末三位数：928，末三位之前：1005  1005-928=77 
因为7 | 77，所以7|1005928
末三法，简略证明：
设一个数为ABCDEF=ABC×1000+DEF=ABC×1001-ABC+DEF=ABC×7×13×11-(ABC-DEF),由此可见只要ABC-DEF能被7整除，则ABCDEF能被7整除。

*/