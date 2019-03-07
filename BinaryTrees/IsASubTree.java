public class IsASubTree{

	private static boolean areIdenticle(TreeNode a, TreeNode b){
		if( a == null && b == null){
			return true;
		}

		if( a == null && b!= null){
			return false;
		}

		return (a.val == b.val) && areIdenticle(a.left, b.left) && areIdenticle(a.right, b.right);
	}

	private static boolean isASubTree(TreeNode a, TreeNode b){
		if((a == null && b!=null))
			return false;
		if(areIdenticle(a,b))
			return true;

		return areIdenticle(a.left, b) || areIdenticle(a.right, b);
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

		BinarySearchTree bst2 = new BinarySearchTree();
		TreeNode root2 = null;
		root2 = bst2.insert(root2,10);
		root2 = bst2.insert(root2,7);
		root2 = bst2.insert(root2,8);
		root2 = bst2.insert(root2,5);
		root2 = bst2.insert(root2,12);
		root2 = bst2.insert(root2,11);
		root2 = bst2.insert(root2,15);
		root2 = bst2.insert(root2,16);
		root2 = bst2.insert(root2,14);

		System.out.println(isASubTree(root, root2));
	}
}