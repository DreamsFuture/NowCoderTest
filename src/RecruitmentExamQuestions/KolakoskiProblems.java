package RecruitmentExamQuestions;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KolakoskiProblems {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int n = in.nextInt(); // 输出多少行
		int m = in.nextInt(); // 给定数组长度
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = in.nextInt();
		}
		int[] ansArr = new int[n];// 结果数组
		int slowPoint = 0;
		int fastPoint;
		int index;
		if (arr[0] == 1) {
			ansArr[0] = arr[0];
			for (int i = 1; i < arr[1] + 1; i++) {
				ansArr[i] = arr[1];
			}
			fastPoint = ansArr[2];
			index = arr[1] + 1;
			slowPoint = (slowPoint + 2) % m;
			System.out.println(fastPoint);
		} else {
			for (int i = 0; i < arr[0]; i++) {
				ansArr[i] = arr[0];
			}
			index = arr[0];
			fastPoint = arr[1];
			slowPoint = 1;
			System.out.println(fastPoint);
		}
		int temp = 0;
		for (int i = index; i < n; i++) {
			if (temp < ansArr[fastPoint]) {
				ansArr[i] = arr[slowPoint];
				temp++;
				if (temp == ansArr[fastPoint]) {
					temp = 0;
					fastPoint++;
					slowPoint = (slowPoint + 1) % m;
				}
			}
		}
		System.out.println(Arrays.toString(ansArr));
	}
}
