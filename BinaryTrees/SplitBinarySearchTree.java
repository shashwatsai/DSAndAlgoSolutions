public class SplitBinarySearchTree{

	public static TreeNode[] splitBst(TreeNode root, int V){
		if(root == null){
			return new TreeNode[]{null, null};
		}
		if(root.val == V){
			TreeNode right = root.right;
			root.right = null;
			return new TreeNode[]{root, right};
		}else if(root.val > V){
			TreeNode [] nodes = splitBst(root.left, V);
			root.left = nodes[1];
			return new TreeNode[]{nodes[0], root};
		}else{
			TreeNode [] nodes = splitBst(root.right, V);
			root.right = nodes[0];
			return new TreeNode[]{root, nodes[1]};
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

		TreeNode [] res = splitBst(root, 5);
		System.out.println(res[0].val);
		System.out.println(res[1].val);
	}
}