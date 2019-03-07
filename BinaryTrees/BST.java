import java.util.*;

class TreeNode{

	TreeNode left, right;
	int val;

	TreeNode(int val){
		this.left = null;
		this.right = null;
		this.val = val;
	}
}

public class BST{

	public TreeNode insert(TreeNode root, int val){
		if(root == null)
			return new TreeNode(val);

		if(root.val < val){
			root.right = insert(root.right, val);
		}else{
			root.left = insert(root.left, val);
		}

		return root;
	}

	public TreeNode delete(TreeNode root, int val){
		if(root == null){
			return null;
		}

		if(root.val < val){
			root.right = delete(root.right, val);
		}else if(root.val > val){
			root.left = delete(root.left, val);
		}else{
			if(root.left == null){
				return root.right;
			}else if(root.right == null){
				return root.left;
			}

			// find inorder successor
			root.val = findMin(root.right);
			root.right = delete(root.right, root.val);
		}

		return root;

	}


	private int findMin(TreeNode root){
        int minv = root.val; 
        while (root.left != null) 
        { 
            minv = root.left.val; 
            root = root.left; 
        } 
        return minv; 
	}

	public void inOrder(TreeNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.val + "->");
			inOrder(root.right);
		}
	}

	public void inOrderIter(TreeNode root){
		Stack<TreeNode> stack = new Stack<>(); 
		if(root == null){
			return;
		}

		while(root != null){
			stack.push(root);
			root = root.left;
		}

		while(!stack.isEmpty()){
			TreeNode current = stack.pop();
			System.out.print(current.val + "->");

			if(current.right != null){
				TreeNode temp = current.right;
				while(temp != null){
					stack.push(temp);
					temp = temp.left;
				}
			}
		}

		System.out.print("\b\b");
	}

	public void preOrderIter(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();

		if(root == null)
			return;

		if(root != null)
			stack.push(root);

		while(!stack.isEmpty()){
			TreeNode current = stack.pop();
			System.out.print(current.val + "->");

			if(current.right != null)
				stack.push(current.right);
			if(current.left != null){
				stack.push(current.left);
			}
		}

	}

	public static void main(String [] args){
		TreeNode root = null;
		BST bst = new BST();
		root = bst.insert(root,10);
		root = bst.insert(root,5);
		root = bst.insert(root,15);
		root = bst.insert(root,7);
		root = bst.insert(root,4);
		root = bst.insert(root,14);
		root = bst.insert(root,17);

		bst.inOrderIter(root);
		System.out.println();
		root = bst.delete(root, 10);
		bst.inOrderIter(root);
		System.out.println();
	}

}