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
		//试用期的员工放入到队列中
		Queue<BigInteger> queue = new LinkedList<BigInteger>();
		if (n <= 3) {
			return BigInteger.valueOf(1);
		}
		//填充队列至满三个，也就是整个队列中只保存三个或者四个
		while (queue.size() < 3) {
			queue.offer(totalNumberEmployee);
		}
		//月份-3 也就是循环周期数
		while (n - 3 > 0) {
			--n;
			fullTimeEmployee = fullTimeEmployee.add(queue.poll());
			queue.offer(fullTimeEmployee);
		}
		//结束循环，则把队列中的试用期员工和正式员工加起来就可以了
		while (!queue.isEmpty()) {
			totalNumberEmployee = totalNumberEmployee.add(queue.poll());
		}
		return totalNumberEmployee.add(fullTimeEmployee);
	}
}

/*
	其实本题，是一个类似于斐波那契数列的形式：f(n)=f(n-1)+f(n-3)

	与生兔子的题目一模一样：

	题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？  
	
	程序分析：   兔子的规律为数列1,1,2,3,5,8,13,21....  
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
或
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