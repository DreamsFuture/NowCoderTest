

//0-1����������ǣ�һ����Ʒֻ����һ�������߲���


public class DynamicPlanningAndGreedyAlgorithm {
	public static void main(String[] args) {  
        int[] v = {0, 60, 100, 120};  
        int[] w = {0, 10, 20, 30};  
        int weight = 50;  
        
    }  

	// ̰���㷨���㱳������
	public static double ksack(double[] values, double[] weights, int capacity) {
		double load = 0;
		int i = 0;
		double w = 0;
		while (load < capacity && i < values.length) {
			if (weights[i] <= (capacity - load)) {
				w += values[i];
				load += weights[i];
			} 
			else {
				double r = (capacity - load) / weights[i];
				w += r * values[i];
				load += weights[i];
			}
			i++;
		}
		return w;
	}

	// �ݹ���㱳������
	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int knapsack(int cappcity, int[] size, int[] value, int n) {
		if (n == 0 || cappcity == 0) {
			return 0;
		}
		if (size[n - 1] > cappcity) {
			return knapsack(cappcity, size, value, n - 1);
		} 
		else {
			return max(value[n - 1] + knapsack(cappcity - size[n - 1], size, value, n - 1),
					knapsack(cappcity, size, value, n - 1));
		}
	}

	// ��̬�滮��������
	public static long dKnapsack(int cappcity, int[] size, int[] value, int n) {
		int[][] maxValue = new int[n][cappcity + 1];
		//��ʼ������ֵ
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < cappcity; j++) {
				maxValue[i][j] = 0;
			}
		}
		//n��ʾ����n����Ʒ����i����Ʒ����ʾ��i����Ʒ�������������Ϊw��������ֵΪmaxValue[i][w]
		for (int i = 0; i < n; i++) {
			for (int w = 0; w < cappcity; w++) {
				if (i == 0 || w == 0) {
					maxValue[i][w] = 0;
				} 
				else if (size[i - 1] <= w) {
					maxValue[i][w] = max(value[i - 1] + maxValue[i - 1][w - size[i - 1]], maxValue[i - 1][w]);
				} 
				else {
					maxValue[i][w] = maxValue[i - 1][w];
				}
			}
		}
		return maxValue[n][cappcity];
	}

}
