package BinaryTree;


public class GetNextNode {
	
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode parent = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}

 	public TreeLinkNode GetNextNodes(TreeLinkNode currentNode) {
 	
 		if(currentNode == null) return null;
 		////�����������������������������ڵ�
 		if(currentNode.right != null){
 			currentNode = currentNode.right;
 			
 			//��ǰ�ڵ���ӽڵ�����ڵ㣬���������ȥ��ֱ��Ҷ�ӽڵ�
 			while(currentNode.left != null) currentNode = currentNode.left;
 			return currentNode;
 		}
 		
 		////û�����������ҵ�һ����ǰ�ڵ��Ǹ��ڵ����ӵĽڵ�
 		while(currentNode.parent != null){
 			//�ҵ���ǰ�ڵ�Ϊ���ڵ����ڵ㣬���ʾ�ҵ��˵�ǰ�ڵ�ĸ��ڵ㣬�����ش˸��ڵ㣬�˸��ڵ�Ϊ��һ����Ҫ�ҵĽڵ�
 			if(currentNode.parent.left == currentNode) return currentNode.parent;
 			
 			//��ǰ�ڵ�Ϊ���ڵ���ҽڵ㣬�����whileѭ��
 			currentNode = currentNode.parent;
 		}
 		
 		////�˵��˸��ڵ���û�ҵ����򷵻�null
 		return null;
 		
 		
 		
 	}	
 		
 	
 	
 	
 	
 	
 		
 	/*	
 		
 		
 		if(currentNode == null){
 			return null;
 		}
 		
 		
 		TreeNode nextNode = null;
 		if(currentNode.left != null){
 			TreeNode nextRightNode = nextNode.right;
 			while(nextRightNode.left != null){
 				nextRightNode = nextRightNode.left;
 			}
 			nextNode = nextRightNode;
 		}
 		else if(currentNode.p)
 		
 		
 		return nextNode;

	}

	// Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
*/
}
