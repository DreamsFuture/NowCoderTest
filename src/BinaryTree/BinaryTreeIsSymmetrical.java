package BinaryTree;
/*
题目：对称的二叉树

给定一个二叉树，判断二叉树是否是对称的

*/
public class BinaryTreeIsSymmetrical {
	
	public class TreeNode{
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
	}
	
	
	public boolean isSymmetricalTree(TreeNode root){
		
		return isSymmetricalTree(root,root);
	}
	
	private boolean isSymmetricalTree(TreeNode root1, TreeNode root2){
		
		//单独列出两个当前节点root1和root2同时为null的情况
		if(root1 == null && root2 == null){
			return true;
		}
		
		//如果两个当前节点不同时为null，则其中一个为null，返回false
		if(root1 == null || root2 == null){
			return false;
		}
		
		//如果两个都不为null，则比较其值是否为相等，不相等则返回false
		if(root1.val != root2.val){
			return false;
		}
		
		//如果两个当前节点的各自子节点都不为null，且两个节点的值相等，则比较当前节点的各自左右子节点
		return isSymmetricalTree(root1.left, root2.right) && isSymmetricalTree(root1.right, root2.left); 
	}
	
	

}
