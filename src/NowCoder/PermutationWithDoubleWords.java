package NowCoder;

//�ݹ��㷨��������⣬�ܶ��㷨������ʹ�õݹ飬����ѧ�ᣬ�������˸���·����ֹ��·һ��


import java.util.HashSet;
public class PermutationWithDoubleWords {
	public static void f(char[] array,char[] word){
		HashSet<String> set=new HashSet<String>();
		for(int i=0;i<array.length;i++){
			//ѡ����һ��λ���ϵ���ĸ����ӡ����, �Ѿ���ѡ��������ĸ��ӵ�word��
			//��������ĸ�Ѿ�����������һ�Σ���������
			if(!set.contains(String.valueOf(array[i])))
					set.add(String.valueOf(array[i]));
			else
				continue;
			//��һ��λ���ϵ���ĸ�Ѿ���ѡ������������ѡ�ڶ���λ���ϵ���ĸ������ʹ�õݹ�İ취
			//ǰ���Ǵ�array����ȥ���Ѿ�����ѡ��������ĸ�����µ�array
			if(array.length>1){
				
				//����һ���µ����飬��СΪ��ǰ���鳤��-1������
				char[] newArray=new char[array.length-1];
				
				//������������ Ϊ[ 0 - i-1 ] ǰ�벿��
				for(int j=0;j<i;j++){
					newArray[j]=array[j];
				}
				
				//������������Ϊ [ i - array.length - 1 ] ��벿��
				for(int j=i+1;j<newArray.length+1;j++){
					newArray[j-1]=array[j];
				}
				
				//����f���еݹ�֮ǰ���ȼ����word�����word������Ҫ����Ľ��
				
				//����һ��newWord���ַ����飬����Ϊ��ǰ���鳤��+1�ĳ���
				char[] newWord=new char[word.length+1];
				
				
				for(int m=0;m<word.length;m++)
					newWord[m]=word[m];
				//���һ��Ԫ��Ϊ��һ���ַ�
				newWord[newWord.length-1]=array[i];
				
				//ʲôʱ��ݹ�Ҳ��Ҫ���պû��ᣬ�����ܴﵽ 
				f(newArray,newWord);
				
			}
			//����ݹ鵽����ʱ�򣬲��ݹ飬���Ԫ��
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
 * ���⣺�������ɸ���ĸ�����ʱ�����ظ�����ĸ����Ҫ�����ȫ����
 * @author waleking
 * �㷨˼������Brother Wang, double chong
 * 
 * �á�ȡ�������뷨������ȫ���У������a,b,c��
 * 1ȡ��a,��ȡ��b��c��ȡ��b��c�ķ��������b��c��ȫ���У�
 * ���b��c��ȫ����{bc,cb}�ٺ͵�һ��ȡ���ķ��ڵ�һ��λ�õ�a��ƴ�ӣ�����{abc,acb}
 * 2ȡ��b,��ȡ��a��c��������������ͬ��
 * 
 * �������ܵ�Ч���ǣ���ѭ����ȡ����һ��λ�õ���ĸ��+�ݹ飨����ʣ�µ�n-1����ĸ����ȫ���У���
 * ��ѭ�����ж�ȡ������ĸ��ȥ�أ���������ĸ�Ѿ���ȡ�������Ͳ���ȡ��������ֱ�������� 
 *
 * ��������
 * ���磬��'a','a','b',��c'����ȫ����
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