

//0-1背包问题就是，一件物品只能拿一件，或者不拿


public class DynamicPlanningAndGreedyAlgorithm {
	public static void main(String[] args) {  
        int[] v = {0, 60, 100, 120};  
        int[] w = {0, 10, 20, 30};  
        int weight = 50;  
        
    }  

	// 贪婪算法计算背包问题
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

	// 递归计算背包问题
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

	// 动态规划背包问题
	public static long dKnapsack(int cappcity, int[] size, int[] value, int n) {
		int[][] maxValue = new int[n][cappcity + 1];
		//初始化数组值
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < cappcity; j++) {
				maxValue[i][j] = 0;
			}
		}
		//n表示的是n个物品，第i个物品，表示拿i个物品，如果包裹容量为w，则最大价值为maxValue[i][w]
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
