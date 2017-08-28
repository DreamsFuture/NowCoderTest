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
 		//如果有右子树，则找右子树的最左节点
 		if(currentNode.right != null){
 			currentNode = currentNode.right;
 			
 			//当前节点的子节点如果有左子节点，则继续找下去，直到叶子节点
 			while(currentNode.left != null) currentNode = currentNode.left;
 			return currentNode;
 		}
 		
 		//如果当前节点没有右子树，则向上找到当前节点的先祖，如果先祖中第一次出现先祖节点是某个节点的左子节点，则表示我们找到了当前节点的下一个节点
 		while(currentNode.parent != null){
 			
 			if(currentNode.parent.left == currentNode) return currentNode.parent;
 			
 			//当前节点为父节点的右节点，则继续while循环
 			currentNode = currentNode.parent;
 		}
 		
 		//如果一直往先祖方向找，退到了根节点仍没找到，则返回null
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
