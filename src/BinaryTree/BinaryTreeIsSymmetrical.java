package BinaryTree;
/*
��Ŀ���ԳƵĶ�����

����һ�����������ж϶������Ƿ��ǶԳƵ�

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
		
		//�����г�������ǰ�ڵ�root1��root2ͬʱΪnull�����
		if(root1 == null && root2 == null){
			return true;
		}
		
		//���������ǰ�ڵ㲻ͬʱΪnull��������һ��Ϊnull������false
		if(root1 == null || root2 == null){
			return false;
		}
		
		//�����������Ϊnull����Ƚ���ֵ�Ƿ�Ϊ��ȣ�������򷵻�false
		if(root1.val != root2.val){
			return false;
		}
		
		//���������ǰ�ڵ�ĸ����ӽڵ㶼��Ϊnull���������ڵ��ֵ��ȣ���Ƚϵ�ǰ�ڵ�ĸ��������ӽڵ�
		return isSymmetricalTree(root1.left, root2.right) && isSymmetricalTree(root1.right, root2.left); 
	}
	
	

}
