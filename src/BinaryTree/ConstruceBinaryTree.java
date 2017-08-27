package BinaryTree;



public class ConstruceBinaryTree {
	
	public static void main(String[] args) {
		
		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] inOrder = {4,7,2,1,5,3,8,6};
		ConstruceBinaryTree tree = new ConstruceBinaryTree();
		TreeNode root =   tree.reConstructBinaryTree(preOrder, inOrder);
		System.out.println(root.val);// output 1;
		
	}
	
	
	
	
	//Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	//public 函数用于外部调用，输入的参数也不同
	public TreeNode reConstructBinaryTree(int[] preOrder, int[] inOrder){
		TreeNode root = reConstructBinaryTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
		return root;
	}
	
	//前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
	private TreeNode reConstructBinaryTree(int[] preOrder,int startPre, int endPre, int[] inOrder, int startIn, int endIn){
		
		if(startPre > endPre || startIn > endIn) return null;
		
		TreeNode root = new TreeNode(preOrder[startPre]);
		
		for(int i = startIn; i <= endIn; i++){
			if(inOrder[i] == preOrder[startPre]){
				root.left = reConstructBinaryTree(preOrder, startPre+1, startPre+i-startIn, inOrder, startIn, i-1);
				root.right = reConstructBinaryTree(preOrder, i-startIn+startPre+1, endPre, inOrder, i+1, endIn);				
			}
		
		}
		
		return root;
	}
	
	
	

}
