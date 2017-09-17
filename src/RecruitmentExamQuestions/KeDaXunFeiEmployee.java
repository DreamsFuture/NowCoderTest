package RecruitmentExamQuestions;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;

public class KeDaXunFeiEmployee {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(solve(n));
		in.close();
	}

	public static BigInteger solve(int n) {
		
		BigInteger totalNumberEmployee = BigInteger.valueOf(0);
		BigInteger fullTimeEmployee = BigInteger.valueOf(1);
		//�����ڵ�Ա�����뵽������
		Queue<BigInteger> queue = new LinkedList<BigInteger>();
		if (n <= 3) {
			return BigInteger.valueOf(1);
		}
		//����������������Ҳ��������������ֻ�������������ĸ�
		while (queue.size() < 3) {
			queue.offer(totalNumberEmployee);
		}
		//�·�-3 Ҳ����ѭ��������
		while (n - 3 > 0) {
			--n;
			fullTimeEmployee = fullTimeEmployee.add(queue.poll());
			queue.offer(fullTimeEmployee);
		}
		//����ѭ������Ѷ����е�������Ա������ʽԱ���������Ϳ�����
		while (!queue.isEmpty()) {
			totalNumberEmployee = totalNumberEmployee.add(queue.poll());
		}
		return totalNumberEmployee.add(fullTimeEmployee);
	}
}

/*
	��ʵ���⣬��һ��������쳲��������е���ʽ��f(n)=f(n-1)+f(n-3)

	�������ӵ���Ŀһģһ����

	��Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ������ĸ��º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ���������Ϊ���٣�  
	
	���������   ���ӵĹ���Ϊ����1,1,2,3,5,8,13,21....  
*/

/*
public class exp2{
    public static void main(String args[]){
       int i=0;
       for(i=1;i<=20;i++)
           System.out.println(f(i));
    }
    public static int f(int x)
    {
       if(x==1 || x==2)
           return 1;
       else
           return f(x-1)+f(x-2);
    }
}
��
public class exp2{
    public static void main(String args[]){
       int i=0;
       math mymath = new math();
       for(i=1;i<=20;i++)
           System.out.println(mymath.f(i));
    }
 
}
class math
{
    public int f(int x)
    {
       if(x==1 || x==2)
           return 1;
       else
           return f(x-1)+f(x-2);
    }
}
*/