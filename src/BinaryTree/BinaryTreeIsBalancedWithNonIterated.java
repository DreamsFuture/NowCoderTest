package BinaryTree;

public class BinaryTreeIsBalancedWithNonIterated {


	public class TreeNode {
		//构造方法
		public TreeNode(int val){ this.val = val;}
		
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;		
	}
	/*
	         递归的遍历方法，会重复计算很多次，例如判断根节点（节点1）是不是平衡，需要判断子节点2是否是平衡树，需要计算节点2的子节点是否是平衡，
	         以此类推，但是节点2计算了节点3,4后，节点1还会继续计算节点3,4，这就重复了3两次，4三次等等
	         
	         所以利用后序遍历的方式先遍历左右子树，再遍历父节点
	*/
	public boolean isBalanced(TreeNode root, int depth){
		
		int dep = 0;
		while(root.left != null || root.right != null) {
			root = root.left;
			root = root.right;
		}
		
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		
		if(left < right - 1 || left > right + 1){
			
			return false;			
		}
				
		return (isBalanced(root.left) && isBalanced(root.right));
	}
	
	
	//递归求深度
	public int TreeDepth(TreeNode root) {
		if (root == null) return 0; 
		
		//Dep[i] = max((left)Dep[i+1] + 1, (right)Dep[i+1] + 1)
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		return (left > right) ? (left + 1) : (right + 1);

	}
}
