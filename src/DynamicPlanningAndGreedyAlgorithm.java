
/*
0-1背包问题：给定n种物品和一个背包。物品i的重量是Wi，其价值为Vi，背包的容量为C。应如何选择装入背包的物品，使得装入背包中物品的总价值最大?
     注：在选择装入背包的物品时，对每种物品i只有2种选择，即装入背包或不装入背包。不能将物品i装入背包多次，也不能只装入部分的物品i。

0-1背包问题就是，一件物品只能拿一件，或者不拿

*/
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

/*
0-1背包问题

初步分析
    对于这个问题，一开始确实有点不太好入手。一堆的物品，每一个都有一定的质量和价值，我们能够装入的总重量有限制，该怎么来装使得价值最大呢？
    对于这n个物品，每个物品我们可能会选，也可能不选，那么我们总共就可能有2^n种组合选择方式。如果我们采用这种办法来硬算的话，则整体的时间复杂度就达到指数级别的，肯定不可行。
    现在我们换一种思路。既然每一种物品都有价格和重量，我们优先挑选那些单位价格最高的是否可行呢？
    比如在下图中，我们有3种物品，他们的重量和价格分别是10, 20, 30 kg和60, 100, 120。
    
    动态规划 
    既然前面两种办法都不可行，我们再来看看有没有别的方法。我们再来看这个问题。我们需要选择n个元素中的若干个来形成最优解，假定为k个。
    那么对于这k个元素a1, a2, ...ak来说，它们组成的物品组合必然满足总重量<=背包重量限制，而且它们的价值必然是最大的。
    因为它们是我们假定的最优选择嘛，肯定价值应该是最大的。假定ak是我们按照前面顺序放入的最后一个物品。它的重量为wk，它的价值为vk。
    既然我们前面选择的这k个元素构成了最优选择，如果我们把这个ak物品拿走，对应于k-1个物品来说，它们所涵盖的重量范围为0-(W-wk)。
    假定W为背包允许承重的量。假定最终的价值是V，剩下的物品所构成的价值为V-vk。这剩下的k-1个元素是不是构成了一个这种W-wk的最优解呢？
    我们可以用反证法来推导。假定拿走ak这个物品后，剩下的这些物品没有构成W-wk重量范围的最佳价值选择。那么我们肯定有另外k-1个元素，他们在W-wk重量范围内构成的价值更大。
    如果这样的话，我们用这k-1个物品再加上第k个，他们构成的最终W重量范围内的价值就是最优的。这岂不是和我们前面假设的k个元素构成最佳矛盾了吗？
    所以我们可以肯定，在这k个元素里拿掉最后那个元素，前面剩下的元素依然构成一个最佳解。
    现在我们经过前面的推理已经得到了一个基本的递推关系，就是一个最优解的子解集也是最优的。可是，我们该怎么来求得这个最优解呢？我们这样来看。
    假定我们定义一个函数c[i, w]表示到第i个元素为止，在限制总重量为w的情况下我们所能选择到的最优解。那么这个最优解要么包含有i这个物品，要么不包含，肯定是这两种情况中的一种。
    如果我们选择了第i个物品，那么实际上这个最优解是c[i - 1, w-wi] + vi。而如果我们没有选择第i个物品，这个最优解是c[i-1, w]。
    这样，实际上对于到底要不要取第i个物品，我们只要比较这两种情况，哪个的结果值更大不就是最优的么？
    在前面讨论的关系里，还有一个情况我们需要考虑的就是，我们这个最优解是基于选择物品i时总重量还是在w范围内的，如果超出了呢？我们肯定不能选择它，这就和c[i-1, w]一样。
    另外，对于初始的情况呢？很明显c[0, w]里不管w是多少，肯定为0。因为它表示我们一个物品都不选择的情况。c[i, 0]也一样，当我们总重量限制为0时，肯定价值为0。
    这样，基于我们前面讨论的这3个部分，我们可以得到一个如下的递推公式：
    
    
    
    1、问题的描述 有编号分别为a,b,c,d,e的五件物品，它们的重量分别是2,4,2,1,3，它们的价值分别是3,5,6,4,6，现在给你个承重为10的背包，
    		如何让背包里装入的物品具有最大的价值总和？

    贪心算法的思想：贪心原则为单位价值最大且重量最小，不超过背包最大承重量为约束条件。也就是说，存在单位重量价值相等的两个包，则选取重量较小的那个背包。
*/