package BinaryTree;
/*
	��Ŀ������һ���Ŷ����������
	
	���͵ĵݹ����⣬���ڵݹ�����������Ҫע��һ�¼������裺
	
	1. �жϵݹ��������� if(root == null)���жϽ�����־���ܲ�ֹ�ڿ�ͷ��˵������else��Ҳ�����ж�if���������
	
	2. �ݹ鹫ʽ�� else{ f(n) = f(n-1) + a(n) }
	
	3. ���ڵݹ鲻�ϵ����Լ�������Ҫ���׷������ݵ��ظ����� return depth
	
	4. ����Ĳ���ҲҪע������ظ�ʹ�ã�����ע�����  root �����壬��ʱ����һ���������ã��Ϳ���û�з���void�������������������������������

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
			//�ж����������Ǹ�������ȸ���ֻȡ���ֵ�Ĳ��֣�����ʱ��Ϳռ临�Ӷ�
			int tmp = 0;
			if(root.right != null){
				tmp = Depth(root.right);
				if(depth < tmp) depth = tmp;
			}
			if(root.left != null){
				tmp = Depth(root.left);
				if(depth < tmp) depth = tmp;				
			}	
			++depth;  //����Ҫע�ⲻ�ܶ��ˣ���������˺ܶ�ֵ
		}
		return depth;
	}
}
