package NowCoder;

//递归算法处理的问题，很多算法都可以使用递归，可以学会，这样多了个套路，防止死路一条


import java.util.HashSet;
public class PermutationWithDoubleWords {
	public static void f(char[] array,char[] word){
		HashSet<String> set=new HashSet<String>();
		for(int i=0;i<array.length;i++){
			//选出第一个位置上的字母，打印出来, 已经挑选出来的字母添加的word中
			//如果这个字母已经被跳出来过一次，就跳过它
			if(!set.contains(String.valueOf(array[i])))
					set.add(String.valueOf(array[i]));
			else
				continue;
			//第一个位置上的字母已经被选出来，现在挑选第二个位置上的字母，可以使用递归的办法
			//前提是从array当中去掉已经被挑选出来的字母，用新的array
			if(array.length>1){
				
				//定义一个新的数组，大小为当前数组长度-1的数组
				char[] newArray=new char[array.length-1];
				
				//拷贝数组索引 为[ 0 - i-1 ] 前半部分
				for(int j=0;j<i;j++){
					newArray[j]=array[j];
				}
				
				//拷贝数组索引为 [ i - array.length - 1 ] 后半部分
				for(int j=i+1;j<newArray.length+1;j++){
					newArray[j-1]=array[j];
				}
				
				//调用f进行递归之前，先计算出word，这个word是最终要输出的结果
				
				//定义一个newWord的字符数组，长度为当前数组长度+1的长度
				char[] newWord=new char[word.length+1];
				
				
				for(int m=0;m<word.length;m++)
					newWord[m]=word[m];
				//最后一个元素为第一个字符
				newWord[newWord.length-1]=array[i];
				
				//什么时候递归也是要把握好机会，否则不能达到 
				f(newArray,newWord);
				
			}
			//如果递归到最后的时候，不递归，输出元素
			else{
				char[] newPrevious=new char[word.length+1];
				for(int m=0;m<word.length;m++)
					newPrevious[m]=word[m];
				newPrevious[newPrevious.length-1]=array[0];
				System.out.println(newPrevious);
				return;
			}
		}
	}
	
	public static void main(String[] args){
		char[] array={'a','a','a','c'};
		char[] word={};
		f(array,word);
	}
}





/**
 * 问题：给定若干个字母（这个时候有重复的字母），要求产生全排列
 * @author waleking
 * 算法思想来自Brother Wang, double chong
 * 
 * 用“取出”的想法来产生全排列，例如对a,b,c。
 * 1取出a,再取出b和c，取出b和c的方法会产生b与c的全排列，
 * 这个b，c的全排列{bc,cb}再和第一次取出的放在第一个位置的a做拼接，产生{abc,acb}
 * 2取出b,再取出a和c，方法和上述相同。
 * 
 * 看到的总的效果是：用循环（取出第一个位置的字母）+递归（对于剩下的n-1个字母产生全排列）。
 * 在循环体中对取出的字母做去重，如果这个字母已经被取出过，就不再取出，而是直接跳过。 
 *
 * 输出结果：
 * 例如，对'a','a','b',‘c'进行全排列
aabc
aacb
abac
abca
acab
acba
baac
baca
bcaa
caab
caba
cbaa
 */