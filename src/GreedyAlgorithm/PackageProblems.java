package GreedyAlgorithm;
import java.util.Arrays;
/* [��������]��һ������������������M=150����7����Ʒ����Ʒ���Էָ�������С�� 
Ҫ�󾡿�����װ�뱳���е���Ʒ�ܼ�ֵ��󣬵����ܳ����������� 
��Ʒ A  B  C  D  E  F  G 
����(weight) 35 30 60 50 40 10 25 
��ֵ(value) 10 40 30 50 35 40 30 
*һ�����ȶ�һ��Ȩֵ���飬�����ŵ���r[i]=value[i]/weight[i]���������ʾ��λ������Ȼ����һ����֮��Ӧ��index���� 
*r[i]={2/7,4/3,0.5,1,7/8,4,1.2}     index[i]=[0,1,2,3,4,5,6] 
*������r������н������У�ͬʱ��Ӧ����index���� 
*r[i]={4,4/3,1.2,1,7/8,0.5,2/7}     index[i]={5,1,6,3,4,2,0} 
*��������index��������µ�weight_new[i]=weight[index[i]],value_new[i]=value[index[i]]���Եõ��� 
*weight_new[i]={10,30,25,50,40,60,35}   value_new[i]={40,40,30,50,35,30,10}��ͬʱ����һ�� 
*x[weight_new.length]={0,0,0,0,0,0,0} 
*�ġ������µ�weight_new�����²��� 
*for(int i=0;i<weight_new.length;i++){ 
*     if(weight_new[i]<M){ 
*         x[i]=1; 
*         M=M-weight_new[i]; 
*     } 
*} 
*��ʱ���Եõ�һ��x���顣 
*�壬�ٸ���x[i]��value_new[i]���õ�value��ӣ��ͼ�Ϊ��ֵ��� 
*int totalMaxValue=0; 
*for(int i=0;i<value_new.lenght;i++){ 
*    if(x[i] == 1){ 
*        totalMaxValue=totalMaxValue+value_new[i]; 
*    } 
*} 
*/  

public class PackageProblems {
	public static void main(String[] args) {
		int[] weight = new int[] { 35, 30, 60, 50, 40, 10, 25 };
		int[] value = new int[] { 10, 40, 30, 50, 35, 40, 30 };
		PackageProblems.packageGreedy(weight, value, 150);
	}

	// ����̰���㷨����������Ϊ�̶�ֵ����ֵ������Ϊ����
	public static void packageGreedy(int[] weight, int[] value, int capacity) {
		/*
		 * 1�����㵥λ��ֵ 2������λ������ֵ r[i]=v[i]/w[i]��������
		 */
		int len = weight.length;
		double[] r = new double[len];
		int[] index = new int[len];
		for (int i = 0; i < len; i++) {
			r[i] = (double) value[i] / (double) weight[i];
			index[i] = i;
		}
		// ��������
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
		/* �����������ͼ�ֵ�ֱ�浽weight_new[]��value_new[]�� */
		int[] weight_new = new int[len];
		int[] value_new = new int[len];
		for (int i = 0; i < len; i++) {
			weight_new[i] = weight[index[i]];
			value_new[i] = value[index[i]];
		}
		/* ��ӡ����λ��ֵ����֮�����Ʒ����Ʒ��ֵ���� */
		System.out.println(Arrays.toString(weight_new));
		System.out.println(Arrays.toString(value_new));
		int[] x = new int[len];
		for (int i = 0; i < len; i++) {
			x[i] = 0;
		}
		/* ����̰�Ĳ�����Ⲣ��ӡ������ */
		for (int i = 0; i < len; i++) {
			if (weight_new[i] < capacity) {
				x[i] = 1;
				capacity = capacity - weight_new[i];
			}
		}
		System.out.println("The solution vector is:" + Arrays.toString(x));
		/* �������ļ�ֵ */
		int maxValue = 0;
		for (int i = 0; i < len; i++) {
			if (x[i] == 1)
				maxValue += value_new[i];
		}
		System.out.println("Now,the largest values of objects in the pack is:" + maxValue);
	}
}


/*
������Ϊ��

[10, 30, 25, 50, 40, 60, 35]          ̰���㷨����Ҫ���ľ��Ǿ���������������أ�����Ҫ����������
[40, 40, 30, 50, 35, 30, 10]
The solution vector is:[1, 1, 1, 1, 0, 0, 0]
Now,the largest values of objects in the pack is:160


*/


