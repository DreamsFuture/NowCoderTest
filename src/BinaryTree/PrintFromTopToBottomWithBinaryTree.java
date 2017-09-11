package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
题目：把二叉树打印成多行
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。


*/

public class PrintFromTopToBottomWithBinaryTree {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}
	}

	ArrayList<ArrayList<Integer>> Print(TreeNode root) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return result;
		}
		//这里的引用和new不一样，注意理解内部本质
		Queue<TreeNode> layer = new LinkedList<TreeNode>();

		ArrayList<Integer> layerList = new ArrayList<Integer>();

		layer.add(root);

		int start = 0, end = 1;

		while (!layer.isEmpty()) {

			TreeNode cur = layer.remove();
			layerList.add(cur.val);

			++start;

			if (cur.left != null) {
				layer.add(cur.left);
			}

			if (cur.right != null) {
				layer.add(cur.right);
			}

			if (start == end) {
				end = layer.size();
				start = 0;
				result.add(layerList);
				layerList = new ArrayList<Integer>();

			}
		}
		
		return result;

	}

}
