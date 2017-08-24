package NowCoder;

//��Ŀ�㷨�����⣬������Ϊѧϰ�Ľ��飬����������⻹��������������ϰ

/*1������Ǯ����
������penny��penny�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ����ֵ�Ļ��ҿ���ʹ�������ţ��ٸ���һ������aim(С�ڵ���1000)����Ҫ�ҵ�Ǯ������Ǯ�ж����ַ�����
��������penny�����Ĵ�С(С�ڵ���50)��ͬʱ����һ������aim���뷵���ж����ַ������Դճ�aim��
����������
[1,2,4],3,3
���أ�2
��������dp[n][m]Ϊʹ��ǰn�л��Ҵճɵ�m����������ô�ͻ������������
          ʹ�õ�n�ֻ��ң�dp[n-1][m]+dp[n-1][m-peney[n]]
           ���õ�n�ֻ��ң�dp[n-1][m]��Ϊʲô��ʹ�õ�n�ֻ����أ���Ϊpenney[n]>m��
     �����Ϳ��������m>=penney[n]ʱ dp[n][m] = dp[n-1][m]+dp[n-1][m-peney[n]]������dp[n][m] = dp[n-1][m]

*/



public class DynamicPlanningFindMoneyMethods {
	
	public static void main(String[] args) {
		int[] penny = {1,2,5};
		int n = 3;
		int aim = 8;
		countWays(penny,n,aim);
	
	}

	public static int countWays(int[] penny, int n, int aim) {
		// write code here
		if (n == 0 || penny == null || aim < 0) {
			return 0;
		}
		int[][] pd = new int[n + 1][aim + 1];
		for (int i = 0; i <= n; i++) {
			pd[i][0] = 1;
		}	
		for (int i = 1; penny[0] * i <= aim; i++) {
			pd[0][penny[0] * i] = 1;
		}		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= aim; j++) {
				if (j >= penny[i]) {
					pd[i][j] = pd[i - 1][j] + pd[i][j - penny[i]];
				} else {
					pd[i][j] = pd[i - 1][j];
				}
			}
		}
		
		for(int i = 0;i<=n;i++){
			for(int j = 0;j<=aim;j++){
				System.out.printf("pd[%d][%d]",i,j);
				System.out.print(pd[i][j]);
				System.out.print(' ');
				if(j==aim){
					System.out.println('\n');
				}
			}
		}
		
		return pd[n - 1][aim];
	}

}