package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
��Ŀ���Ѷ�������ӡ�ɶ���
���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�


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
		//��������ú�new��һ����ע������ڲ�����
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
