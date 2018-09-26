/*
	@author Shashwat Tiwari
	@email  shashwat1791@gmail.com
*/

import java.util.*;
import java.lang.*;

/*
	Returns the left view of a given binary tree

	Example:
			2
		   / \
		  /   \
		 3     4
		      / \
		     5   6
		    /
		    7

	Output: 2,3,5,7 	

*/
public class LeftView{

	static class TreeNode{
		TreeNode left, right;
		int val;

		TreeNode(int val){
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}

	private static int maxLevel = 0;



	public void leftViewTraversal(TreeNode root){
		leftViewTraversalUtil(root, 1);
	}

	public void leftViewTraversalUtil(TreeNode root, int level){
		if(root == null){
			return;
		}

		if(maxLevel < level){
			System.out.print(root.val + "->");
			maxLevel = level;
		}

		leftViewTraversalUtil(root.left, level + 1);
		leftViewTraversalUtil(root.right, level + 1);
	}

	public void leftViewLevelOrder(TreeNode root){
		
		if(root == null){
			return;
		}

		boolean flag = false;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		// marks the end of a particular level
		queue.offer(null);

		while(!queue.isEmpty()){
			TreeNode current = queue.poll();
			if(current != null){
				if(!flag){
					System.out.print(current.val+"->");
					flag = true;
				}

				if(current.left != null){
					queue.offer(current.left);
				}

				if(current.right != null){
					queue.offer(current.right);
				}

			}else if(!queue.isEmpty()){
				queue.offer(null);
				flag = false;
			}
		}

	}

	public static void main(String [] args){
		TreeNode root = new TreeNode(2);
		root.left     = new TreeNode(3);
		root.right    = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);

		LeftView test = new LeftView();
		test.leftViewTraversal(root);
		System.out.println();
		test.leftViewLevelOrder(root);
	}
}