/*
	@author Shashwat Tiwari
	@email  shashwat1791@gmail.com
*/

import java.util.*;
import java.lang.*;

class TreeNode{

	TreeNode left, right;
	int val;

	TreeNode(int val){
		this.left  = null;
		this.right = null;
		this.val = val;
	}
}

public class BinarySearchTree{

	private TreeNode prev;

	public TreeNode insert(TreeNode root, int data){
		if(root == null){
			root = new TreeNode(data);
		}else if(root.val > data){
			root.left = insert(root.left, data);
		}else{
			root.right = insert(root.right, data);
		}

		return root;
	}


	public boolean isBST(TreeNode root){
		//return this.isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		//return this.isBSTUtil2(root, null, null);
		prev = null;
		return this.isBSTUtil3(root);
	}

	private boolean isBSTUtil(TreeNode root, int min, int max){
		if(root == null){
			return true;
		}

		if(root.val < min || root.val > max){
			return false;
		}

		return (isBSTUtil(root.left, min, root.val) && isBSTUtil(root.right, root.val , max));

	}

	private boolean isBSTUtil2(TreeNode root, TreeNode left, TreeNode right){
		if(root == null){
			return true;
		}

		if(left != null && left.val > root.val){
			return false;
		}

		if(right != null && right.val < root.val){
			return false;
		}

		return (isBSTUtil2(root.left, left, root) && isBSTUtil2(root.right, root, right));
	}

	private boolean isBSTUtil3(TreeNode root){
		if(root != null){
			if(!isBSTUtil3(root.left)){
				return false;
			}

			if(prev != null && root.val <= prev.val){
				return false;
			}
			prev = root;
			return isBSTUtil3(root.right);
		}

		return true;
	}

	public void inOrder(TreeNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.val + "->");
			inOrder(root.right);
		}
	}


	public static void main(String [] args){
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = null;
		root = bst.insert(root,10);
		root = bst.insert(root,7);
		root = bst.insert(root,8);
		root = bst.insert(root,5);
		root = bst.insert(root,12);
		root = bst.insert(root,11);
		root = bst.insert(root,15);
		root = bst.insert(root,16);
		root = bst.insert(root,14);

		TreeNode fakeRoot = new TreeNode(1);
		fakeRoot.left = new TreeNode(3);
		fakeRoot.right = new TreeNode(2);


		bst.inOrder(fakeRoot);
		System.out.println();
		System.out.println(bst.isBST(fakeRoot));
	}
}