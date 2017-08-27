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
 		////如果有右子树，则找右子树的最左节点
 		if(currentNode.right != null){
 			currentNode = currentNode.right;
 			
 			//当前节点的子节点有左节点，则继续找下去，直到叶子节点
 			while(currentNode.left != null) currentNode = currentNode.left;
 			return currentNode;
 		}
 		
 		////没右子树，则找第一个当前节点是父节点左孩子的节点
 		while(currentNode.parent != null){
 			//找到当前节点为父节点的左节点，则表示找到了当前节点的父节点，并返回此父节点，此父节点为下一个需要找的节点
 			if(currentNode.parent.left == currentNode) return currentNode.parent;
 			
 			//当前节点为父节点的右节点，则继续while循环
 			currentNode = currentNode.parent;
 		}
 		
 		////退到了根节点仍没找到，则返回null
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
