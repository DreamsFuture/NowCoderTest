import java.util.Scanner;

//Eclipse的都知道 Ctrl + Shift + F 这个快捷键的作用，就是自动将书写的代码排版，变得易于阅读。

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