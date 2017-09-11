package BinaryTree;
/*
	题目：计算一个颗二叉树的深度
	
	典型的递归问题，对于递归问题的求解需要注意一下几个步骤：
	
	1. 判断递归结束的语句 if(root == null)，判断结束标志可能不止在开头，说不定在else中也会有判断if条件的情况
	
	2. 递归公式： else{ f(n) = f(n-1) + a(n) }
	
	3. 由于递归不断调用自己，所以要明白返回数据的重复利用 return depth
	
	4. 传入的参数也要注意可以重复使用，并且注意参数  root 的意义，有时候传入一个数组引用，就可能没有返回void，如果传入的是索引，就是其他情况了

*/
public class TheDepthOfBinaryTree {
	public class TreeNode{
		int val = 0;
		TreeNode right = null;
		TreeNode left = null;
	}
	public static int Depth(TreeNode root){
		int depth = 0;
		if(root == null){
			return 0;
		}
		else{			
			//判断左右子树那个树的深度更大，只取最大值的部分，减少时间和空间复杂度
			int tmp = 0;
			if(root.right != null){
				tmp = Depth(root.right);
				if(depth < tmp) depth = tmp;
			}
			if(root.left != null){
				tmp = Depth(root.left);
				if(depth < tmp) depth = tmp;				
			}	
			++depth;  //这里要注意不能丢了，否则会少了很多值
		}
		return depth;
	}
}
