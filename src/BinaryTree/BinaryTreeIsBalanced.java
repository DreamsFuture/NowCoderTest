package BinaryTree;

//可以直接import同一个package中的定义的TreeNode
//import BinaryTree.BinaryTreeDepth.TreeNode;

public class BinaryTreeIsBalanced {
	
	public class TreeNode {
		//构造方法
		public TreeNode(int val){ this.val = val;}
		
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;		
	}
	
	public boolean isBalanced(TreeNode root){
		
		if(root == null) return false;
		
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		
		if(left < right - 1 || left > right + 1){
			
			return false;			
		}
				
		return (isBalanced(root.left) && isBalanced(root.right));
	}
	
	public int TreeDepth(TreeNode root) {
		if (root == null) return 0; 
		
		//Dep[i] = max((left)Dep[i+1] + 1, (right)Dep[i+1] + 1)
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		return (left > right) ? (left + 1) : (right + 1);

	}
}
