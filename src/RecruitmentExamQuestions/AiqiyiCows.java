package RecruitmentExamQuestions;
/*
数据类型：

数据类型	 类型名 		位长	 取值范围			 		默认值

布尔型 	boolean		1 	true,false 				false
	
字节型	byte 		8 	-128-127 				0

字符型 	char 		16 	‘\\u000’-\uffff 		‘\u0000’

短整型 	short		16 	-32768-32767 			0

整型 		int 		32 	-2147483648,2147483647 	0

长整型 	long 		64 	-9.22E18,9.22E18 		0

浮点型 	float 		32 	1.4E-45-3.4028E+38 		0.0

双精度型 	double 		64 	4.9E-324,1.7977E+308 	0.0

*/

//爱奇艺题目：奶牛编号问题

import java.math.BigInteger;
import java.util.Arrays;

import java.util.Scanner;
public class AiqiyiCows {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = in.nextInt();
		}
        in.close();
        Arrays.sort(arr);
        AiqiyiCows solutionWay = new AiqiyiCows();
        //返回的BigInteger类型数据可以直接打印出来
        System.out.println(solutionWay.solution(n,arr));
        
}
	public BigInteger solution(int n, int[] arr){
        BigInteger num = BigInteger.valueOf(1);
        final BigInteger mode = BigInteger.valueOf(1000000007L);
        
        for(int i = 0; i < arr.length; i++){
        	if(arr[i] - i > 0){
        		num = num.multiply( BigInteger.valueOf(arr[i]-i)).mod(mode);
        	}
        	else{
        		num = BigInteger.valueOf(0);
        	} 	
        }
        return num;
    }
}






/*
使用BigInteger来处理数值精度任意的数据

用这样一组数字，0，1，1，2，3，5，8........，求第100个数是多少！

初看这道题很简单，我们只需要设定一个数组，然后往里面放入对应的值，除了前两个数字位，后面每个数字位都是前两个数字位的和。
刚开始我用了int数组来存放这组数，发现根本放不下去，到了第47位数的时候就存在数值溢出了，然后我换为long型数组，
同样放不下去，到了第93位数的时候也存在数值溢出了。这样，只能用BigInteger类了，这是java提供的可以存储任意精度的整数的类，
用它我们不需要考虑数值溢出的错误。即使我们求第1000个数值也没有什么问题。不过，它的数值运算必须以方法调用方式取代运算符方式来实现，
由于这么做复杂了许多，运算速度会比较慢，所以在确定数值不会溢出的情况下，是不推荐用这种型式来进行数值存储和运算的。以下是具体代码。
*/

/*
只是延伸学习，让我们了解基础数据类型的使用

读入： Scanner cin = Scanner (System.in);

while(cin.hasNext())//等价于!=EOF

n=cin.nextInt();//读入一个int型的数

n=cin.nextBigInteger();//读入一个大整数

输出： System.out.print(n);//打印n

System.out.println();//换行

System.out.printf("%d\n",n);//也可以类似c++里的输出方式

定义： int i,j,k,a[];

a = new int[100];

BigInteger n,m;

BigDecimal n;

String s;



这里特别要提出出的两种类型：

BigInteger 任意大的整数，原则上是，只要你的计算机的内存足够大，可以有无限位的

BigInteger 任意大的实数，可以处理小数精度问题。

BigInteger中一些常见的函数：

A=BigInteger.ONE

B=BigInteger.TEN

C=BigInteger.ZERO

一些常见的数的赋初值。将int型的数赋值给BigInteger，BigInteger.valueOf(k);

基本的函数：

valueOf:赋初值

add:+ a.add(b);

subtract:-

multiply:*

divide:/

remainder：this % val

divideAndRemainder：a[0]=this / val; a[1]=this % val

pow：a.pow(b)=a^b

gcd,abs:公约数，绝对值

negate：取负数

signum：符号函数

mod：a.mod(b)=a%b;

shiftLeft:左移，this << n ，this*2^n;

shiftRight:右移，this >> n，this/2^n;

and:等同于c++的&&,且；

or：||，或;

xor:异或，BigInteger xor(BigInteger val),this^val

not:!,非；

bitLength：返回该数的最小二进制补码表示的位的个数，即 *不包括* 符号位 (ceil(log2(this <0 ? -this : this + 1)))。
正数来说，这等价于普通二进制表示的位的个数。

bitCount：返回该数的二进制补码表示中不包扩符号位在内的位的个数。该方法在 BigIntegers 之上实现位向量风格的集合时很有用。

isProbablePrime：如果该 BigInteger 可能是素数，则返回 true ；如果它很明确是一个合数，则返回 false 。 
参数 certainty 是对调用者愿意忍受的不确定性的度量：如果该数是素数的概率超过了 1 - 1/2**certainty方法，则该方法返回 true 。执行时间正比于参数确定性的值。

compareTo：根据该数值是小于、等于、或大于 val 返回 -1、0 或 1；

equals：判断两数是否相等，也可以用compareTo来代替；

min，max：取两个数的较小、大者；

intValue，longValue，floatValue，double：把该数转换为该类型的数的值。
*/
