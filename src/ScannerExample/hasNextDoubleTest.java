package ScannerExample;
import java.util.Scanner;
public class hasNextDoubleTest {


 
/* 
hasNextDouble  �����˷�Double���ַ��������������������β����:end, f,=-,...�ȣ�ֻҪ�Ƿ�Double�Ϳ��ԣ�

�������hasNextLine,�Ͳ���Ū�ˣ���������ֹ�����������޷�����ѭ��

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
  
        System.out.println(m+"�����ĺ�Ϊ"+sum);  
        System.out.println(m+"������ƽ��ֵ��"+(sum/m));  
    }  
}
/*
���룺
1 2 2 3 3 3 3 3 3 3 e
�����
10�����ĺ�Ϊ26.0
10������ƽ��ֵ��2.6
-------------------------------
���룺
 45 1 5 13
 51 5 

 5 145 1 
 515 1 5
 515 21 
end
�����
14�����ĺ�Ϊ1328.0
14������ƽ��ֵ��94.85714285714286

-----------------------------

���룺
21 11515122 21 212  21 21 -

�����
6�����ĺ�Ϊ1.1515418E7
6������ƽ��ֵ��1919236.3333333333





*/

