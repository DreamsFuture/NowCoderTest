package BinaryTree;

//����ֱ��importͬһ��package�еĶ����TreeNode
//import BinaryTree.BinaryTreeDepth.TreeNode;

public class BinaryTreeIsBalanced {
	
	public class TreeNode {
		//���췽��
		public TreeNode(int val){ this.val = val;}
		
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;		
	}
	/*
	         �ݹ�ı������������ظ�����ܶ�Σ������жϸ��ڵ㣨�ڵ�1���ǲ���ƽ�⣬��Ҫ�ж��ӽڵ�2�Ƿ���ƽ��������Ҫ����ڵ�2���ӽڵ��Ƿ���ƽ�⣬
	         �Դ����ƣ����ǽڵ�2�����˽ڵ�3,4�󣬽ڵ�1�����������ڵ�3,4������ظ���3���Σ�4���εȵ�
	*/
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
