package GreedyAlgorithm;
import java.util.Arrays;
/*
完全背包问题
一个旅行者有一个最多能用m公斤的背包，现在有n种物品，每件的重量分别是W1，W2，...,Wn,
每件的价值分别为C1,C2,...,Cn.若的每种物品的件数足够多.
求旅行者能获得的最大总价值。


贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的仅是在某种意义上的局部最优解。
贪心算法不是对所有问题都能得到整体最优解，但对范围相当广泛的许多问题他能产生整体最优解或者是整体最优解的近似解。

贪心算法的基本思路
	1.建立数学模型来描述问题。
	2.把求解的问题分成若干个子问题。
	3.对每一子问题求解，得到子问题的局部最优解。　　
	4.把子问题的解局部最优解合成原来解问题的一个解。　　
	实现该算法的过程：　　
	从问题的某一初始解出发；　　
	while 能朝给定总目标前进一步 do　　
		求出可行解的一个解元素；　　
	由所有解元素组合成问题的一个可行解。

 [背包问题]有一个背包，背包容量是M=150。有7个物品，物品可以分割成任意大小。 
要求尽可能让装入背包中的物品总价值最大，但不能超过总容量。 
物品 A  B  C  D  E  F  G 
重量(weight) 35 30 60 50 40 10 25 
价值(value) 10 40 30 50 35 40 30 
*一、首先顶一个权值数组，里面存放的是r[i]=value[i]/weight[i]，在这里表示单位重量。然后定义一个与之对应的index数组 
*r[i]={2/7,4/3,0.5,1,7/8,4,1.2}     index[i]=[0,1,2,3,4,5,6] 
*二、对r数组进行降序排列，同时相应更改index数组 
*r[i]={4,4/3,1.2,1,7/8,0.5,2/7}     index[i]={5,1,6,3,4,2,0} 
*三、根据index数组产生新的weight_new[i]=weight[index[i]],value_new[i]=value[index[i]]可以得到： 
*weight_new[i]={10,30,25,50,40,60,35}   value_new[i]={40,40,30,50,35,30,10}，同时定义一个 
*x[weight_new.length]={0,0,0,0,0,0,0} 
*四、利用新的weight_new做如下操作 
*for(int i=0;i<weight_new.length;i++){ 
*     if(weight_new[i]<M){ 
*         x[i]=1; 
*         M=M-weight_new[i]; 
*     } 
*} 
*此时可以得到一个x数组。 
*五，再根据x[i]从value_new[i]中拿到value相加，和即为价值最大 
*int totalMaxValue=0; 
*for(int i=0;i<value_new.lenght;i++){ 
*    if(x[i] == 1){ 
*        totalMaxValue=totalMaxValue+value_new[i]; 
*    } 
*} 
*/  

public class PackageProblemsWithGreedyAlgorithm {
	public static void main(String[] args) {
		int[] weight = new int[] { 35, 30, 60, 50, 40, 10, 25 };
		int[] value = new int[] { 10, 40, 30, 50, 35, 40, 30 };
		PackageProblemsWithGreedyAlgorithm.packageGreedy(weight, value, 150);
	}

	// 利用贪心算法，计算重量为固定值，价值最大可以为多少
	public static void packageGreedy(int[] weight, int[] value, int capacity) {
		/*
		 * 1、计算单位价值 2、按单位重量价值 r[i]=v[i]/w[i]降序排列
		 */
		int len = weight.length;
		double[] r = new double[len];
		int[] index = new int[len];
		for (int i = 0; i < len; i++) {
			r[i] = (double) value[i] / (double) weight[i];
			index[i] = i;
		}
		// 降序排列
		double temp = 0;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (r[i] < r[j]) {
					temp = r[i];
					r[i] = r[j];
					r[j] = temp;
					int x = index[i];
					index[i] = index[j];
					index[j] = x;
				}
			}
		}
		/* 排序后的重量和价值分别存到weight_new[]和value_new[]中 */
		int[] weight_new = new int[len];
		int[] value_new = new int[len];
		for (int i = 0; i < len; i++) {
			weight_new[i] = weight[index[i]];
			value_new[i] = value[index[i]];
		}
		/* 打印按单位价值降序之后的物品和物品价值序列 */
		System.out.println(Arrays.toString(weight_new));
		System.out.println(Arrays.toString(value_new));
		int[] x = new int[len];
		for (int i = 0; i < len; i++) {
			x[i] = 0;
		}
		/* 按照贪心策略求解并打印解向量 */
		for (int i = 0; i < len; i++) {
			if (weight_new[i] < capacity) {
				x[i] = 1;
				capacity = capacity - weight_new[i];
			}
		}
		System.out.println("The solution vector is:" + Arrays.toString(x));
		/* 计算最大的价值 */
		int maxValue = 0;
		for (int i = 0; i < len; i++) {
			if (x[i] == 1)
				maxValue += value_new[i];
		}
		System.out.println("Now,the largest values of objects in the pack is:" + maxValue);
	}
}


/*
输出结果为：

[10, 30, 25, 50, 40, 60, 35]          贪婪算法首先要做的就是尽量减少随机性因素，所以要进行排序处理
[40, 40, 30, 50, 35, 30, 10]
The solution vector is:[1, 1, 1, 1, 0, 0, 0]
Now,the largest values of objects in the pack is:160


*/


