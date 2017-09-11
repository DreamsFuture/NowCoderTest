package BinaryTree;

public class BinaryTreeIsBalancedWithNonIterated {


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
	         
	         �������ú�������ķ�ʽ�ȱ��������������ٱ������ڵ�
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
	
	
	//�ݹ������
	public int TreeDepth(TreeNode root) {
		if (root == null) return 0; 
		
		//Dep[i] = max((left)Dep[i+1] + 1, (right)Dep[i+1] + 1)
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		return (left > right) ? (left + 1) : (right + 1);

	}
}
