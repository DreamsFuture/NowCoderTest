package StringDealingMethod;
/*
ǰ��

	��ǰHanLPʹ�á���̱༭���롱�����Ƽ�����Ч���д���ߣ���Ҫȱ���Ǹ���ƴ�����еı༭�����Ƽ���ʱ��ͬ���ֽ���ܳ��������༭����ȴ����ô��
	��ʱ�Ҿ���Ѱ��һ�ֲ���������㷨��ȥ��������������ƴ����һά���ϵ����Ƴ̶ȡ�

	���վ�������������Ӵ����������������Ϊ���䡣

����

	������Ӵ���Longest Common Substring��ָ���������ַ����е�������Ӵ���Ҫ���Ӵ�һ��������

	����������У�Longest Common Subsequence��ָ���������ַ����е�����������У���Ҫ��������������

*/


public class LongestCommonSubSequence {

	public static int compute(char[] str1, char[] str2) {
		int substringLength1 = str1.length;
		int substringLength2 = str2.length;

		// �����ά�����¼������A[i]��B[j]��LCS�ĳ���
		int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

		// �Ӻ���ǰ����̬�滮�������������⡣Ҳ�ɴ�ǰ����
		for (int i = substringLength1 - 1; i >= 0; i--) {
			for (int j = substringLength2 - 1; j >= 0; j--) {
				if (str1[i] == str2[j])
					opt[i][j] = opt[i + 1][j + 1] + 1;// ״̬ת�Ʒ���
				else
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);// ״̬ת�Ʒ���
			}
		}
		System.out.println("substring1:" + new String(str1));
		System.out.println("substring2:" + new String(str2));
		System.out.print("LCS:");

		int i = 0, j = 0;
		while (i < substringLength1 && j < substringLength2) {
			if (str1[i] == str2[j]) {
				System.out.print(str1[i]);
				i++;
				j++;
			} 
			else if (opt[i + 1][j] >= opt[i][j + 1])
				i++;
			else
				j++;
		}
		System.out.println();
		return opt[0][0];
	}

	public static int compute(String str1, String str2) {
		return compute(str1.toCharArray(), str2.toCharArray());
	}

	public static void main(String[] args) {

		String a = "Tom Hanks";
		String b = "Hankcs";

		System.out.println(LongestCommonSubSequence.compute(a, b));
		System.out.println(LongestCommonSubSequence.compute(b, a));

	}

}


// �ο����ӣ�http://www.hankcs.com/program/algorithm/implementation-and-application-of-nlp-longest-common-subsequence-longest-common-subsequence-of-java.html