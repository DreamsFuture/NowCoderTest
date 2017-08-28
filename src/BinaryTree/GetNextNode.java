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
 		//�����������������������������ڵ�
 		if(currentNode.right != null){
 			currentNode = currentNode.right;
 			
 			//��ǰ�ڵ���ӽڵ���������ӽڵ㣬���������ȥ��ֱ��Ҷ�ӽڵ�
 			while(currentNode.left != null) currentNode = currentNode.left;
 			return currentNode;
 		}
 		
 		//�����ǰ�ڵ�û�����������������ҵ���ǰ�ڵ�����棬��������е�һ�γ�������ڵ���ĳ���ڵ�����ӽڵ㣬���ʾ�����ҵ��˵�ǰ�ڵ����һ���ڵ�
 		while(currentNode.parent != null){
 			
 			if(currentNode.parent.left == currentNode) return currentNode.parent;
 			
 			//��ǰ�ڵ�Ϊ���ڵ���ҽڵ㣬�����whileѭ��
 			currentNode = currentNode.parent;
 		}
 		
 		//���һֱ�����淽���ң��˵��˸��ڵ���û�ҵ����򷵻�null
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
