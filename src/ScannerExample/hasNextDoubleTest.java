package ScannerExample;
import java.util.Scanner;
public class hasNextDoubleTest {


 
/* 
hasNextDouble  遇到了非Double的字符就立即跳出来，比如结尾输入:end, f,=-,...等，只要是非Double就可以，

但是如果hasNextLine,就不好弄了，必须有终止条件，否则无法跳出循环

*/

    public static void main(String[] args)   
    {  
        Scanner scan = new Scanner(System.in);  
  
        double sum = 0;  
        int m = 0;  
  
        while(scan.hasNextDouble())  
        {  
            double x = scan.nextDouble();  
            m = m + 1;  
            sum = sum + x;  
        }  
  
        System.out.println(m+"个数的和为"+sum);  
        System.out.println(m+"个数的平均值是"+(sum/m));  
    }  
}
/*
输入：
1 2 2 3 3 3 3 3 3 3 e
输出：
10个数的和为26.0
10个数的平均值是2.6
-------------------------------
输入：
 45 1 5 13
 51 5 

 5 145 1 
 515 1 5
 515 21 
end
输出：
14个数的和为1328.0
14个数的平均值是94.85714285714286

-----------------------------

输入：
21 11515122 21 212  21 21 -

输出：
6个数的和为1.1515418E7
6个数的平均值是1919236.3333333333





*/

