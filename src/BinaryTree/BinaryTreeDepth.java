package BinaryTree;

/*
 * ��Ŀ�������������
 * ����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
*/
public class BinaryTreeDepth {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
		//���췽��
		public TreeNode(int val) {this.val = val;}
	}
	
	public int TreeDepth(TreeNode root) {
		if (root == null) return 0; 
		
		//Dep[i] = max((left)Dep[i+1] + 1, (right)Dep[i+1] + 1)
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);

		return (left > right) ? (left + 1) : (right + 1);

	}
}
