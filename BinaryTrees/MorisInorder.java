public class MorisInorder{


	public static void inOrderTraversal(TreeNode root){
		TreeNode current = root;
		while(current != null){
			if(current.left == null){
				System.out.print(current.val+"->");
				current = current.right;
			}else{
				TreeNode predecessor = current.left;

				while(predecessor.right != null && predecessor.right != current){
					predecessor = predecessor.right;
				}

				if(predecessor.right == null){
					predecessor.right = current;
					current = current.left;
				}else{
					predecessor.right = null;
					System.out.print(current.val+"->");
					current = current.right;
				}

			}
		}

	}

	public static void inOrderRecur(TreeNode root){
		if(root != null){
			inOrderRecur(root.left);
			System.out.print(root.val+"->");
			inOrderRecur(root.right);
		}
	}


	static class TreeNode {
		 int val;
		 TreeNode left, right;

		 TreeNode(int val){
		 	this.val = val;
		 	this.left = this.right = null;
		 }
	}

	public static void main(String ... args){
		TreeNode root = new TreeNode(7);
		root.left     = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(1);
		root.right.left = new TreeNode(12);
		inOrderRecur(root);
		System.out.println();
		inOrderTraversal(root);
		System.out.println();
	}
}