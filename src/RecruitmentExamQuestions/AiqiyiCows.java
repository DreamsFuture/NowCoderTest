package RecruitmentExamQuestions;
/*
�������ͣ�

��������	 ������ 		λ��	 ȡֵ��Χ			 		Ĭ��ֵ

������ 	boolean		1 	true,false 				false
	
�ֽ���	byte 		8 	-128-127 				0

�ַ��� 	char 		16 	��\\u000��-\uffff 		��\u0000��

������ 	short		16 	-32768-32767 			0

���� 		int 		32 	-2147483648,2147483647 	0

������ 	long 		64 	-9.22E18,9.22E18 		0

������ 	float 		32 	1.4E-45-3.4028E+38 		0.0

˫������ 	double 		64 	4.9E-324,1.7977E+308 	0.0

*/

//��������Ŀ����ţ�������

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
        //���ص�BigInteger�������ݿ���ֱ�Ӵ�ӡ����
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
ʹ��BigInteger��������ֵ�������������

������һ�����֣�0��1��1��2��3��5��8........�����100�����Ƕ��٣�

���������ܼ򵥣�����ֻ��Ҫ�趨һ�����飬Ȼ������������Ӧ��ֵ������ǰ��������λ������ÿ������λ����ǰ��������λ�ĺ͡�
�տ�ʼ������int��������������������ָ����Ų���ȥ�����˵�47λ����ʱ��ʹ�����ֵ����ˣ�Ȼ���һ�Ϊlong�����飬
ͬ���Ų���ȥ�����˵�93λ����ʱ��Ҳ������ֵ����ˡ�������ֻ����BigInteger���ˣ�����java�ṩ�Ŀ��Դ洢���⾫�ȵ��������࣬
�������ǲ���Ҫ������ֵ����Ĵ��󡣼�ʹ�������1000����ֵҲû��ʲô���⡣������������ֵ��������Է������÷�ʽȡ���������ʽ��ʵ�֣�
������ô����������࣬�����ٶȻ�Ƚ�����������ȷ����ֵ�������������£��ǲ��Ƽ���������ʽ��������ֵ�洢������ġ������Ǿ�����롣
*/

/*
ֻ������ѧϰ���������˽�����������͵�ʹ��

���룺 Scanner cin = Scanner (System.in);

while(cin.hasNext())//�ȼ���!=EOF

n=cin.nextInt();//����һ��int�͵���

n=cin.nextBigInteger();//����һ��������

����� System.out.print(n);//��ӡn

System.out.println();//����

System.out.printf("%d\n",n);//Ҳ��������c++��������ʽ

���壺 int i,j,k,a[];

a = new int[100];

BigInteger n,m;

BigDecimal n;

String s;



�����ر�Ҫ��������������ͣ�

BigInteger ������������ԭ�����ǣ�ֻҪ��ļ�������ڴ��㹻�󣬿���������λ��

BigInteger ������ʵ�������Դ���С���������⡣

BigInteger��һЩ�����ĺ�����

A=BigInteger.ONE

B=BigInteger.TEN

C=BigInteger.ZERO

һЩ���������ĸ���ֵ����int�͵�����ֵ��BigInteger��BigInteger.valueOf(k);

�����ĺ�����

valueOf:����ֵ

add:+ a.add(b);

subtract:-

multiply:*

divide:/

remainder��this % val

divideAndRemainder��a[0]=this / val; a[1]=this % val

pow��a.pow(b)=a^b

gcd,abs:��Լ��������ֵ

negate��ȡ����

signum�����ź���

mod��a.mod(b)=a%b;

shiftLeft:���ƣ�this << n ��this*2^n;

shiftRight:���ƣ�this >> n��this/2^n;

and:��ͬ��c++��&&,�ң�

or��||����;

xor:���BigInteger xor(BigInteger val),this^val

not:!,�ǣ�

bitLength�����ظ�������С�����Ʋ����ʾ��λ�ĸ������� *������* ����λ (ceil(log2(this <0 ? -this : this + 1)))��
������˵����ȼ�����ͨ�����Ʊ�ʾ��λ�ĸ�����

bitCount�����ظ����Ķ����Ʋ����ʾ�в���������λ���ڵ�λ�ĸ������÷����� BigIntegers ֮��ʵ��λ�������ļ���ʱ�����á�

isProbablePrime������� BigInteger �������������򷵻� true �����������ȷ��һ���������򷵻� false �� 
���� certainty �ǶԵ�����Ը�����ܵĲ�ȷ���ԵĶ�������������������ĸ��ʳ����� 1 - 1/2**certainty��������÷������� true ��ִ��ʱ�������ڲ���ȷ���Ե�ֵ��

compareTo�����ݸ���ֵ��С�ڡ����ڡ������ val ���� -1��0 �� 1��

equals���ж������Ƿ���ȣ�Ҳ������compareTo�����棻

min��max��ȡ�������Ľ�С�����ߣ�

intValue��longValue��floatValue��double���Ѹ���ת��Ϊ�����͵�����ֵ��
*/
