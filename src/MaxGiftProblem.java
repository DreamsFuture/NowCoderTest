import java.util.Scanner;

//Eclipse�Ķ�֪�� Ctrl + Shift + F �����ݼ������ã������Զ�����д�Ĵ����Ű棬��������Ķ���

public class MaxGiftProblem {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] index = new int[8][8];
		index[0][0] = input.nextInt();
		for (int i = 1; i < 8; i++) {
			index[0][i] = input.nextInt() + index[0][i - 1];
		}
		
		
		for (int i = 1; i < 8; i++) {
			index[i][0] = input.nextInt() + index[i - 1][0];
			for (int j = 1; j < 8; j++) {
				if (index[i][j - 1] > index[i - 1][j]) {
					index[i][j] = input.nextInt() + index[i][j - 1];
				} else {
					index[i][j] = input.nextInt() + index[i - 1][j];
				}
			}
		}
		System.out.println(index[7][7]);
	}
}