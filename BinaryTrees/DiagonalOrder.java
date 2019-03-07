import java.util.*;

public class DiagonalOrder{

	private static void diagonalOrderPrint(TreeNode root){
		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		while(!queue.isEmpty()){
			TreeNode current = queue.poll();

			if(current != null){
				while(current != null){
					System.out.print(current.val+" ");
					if(current.left != null){
						queue.offer(current.left);
					}

					current = current.right;
				}
			}else{
				if(!queue.isEmpty()){
					// mark the end of the current level
					queue.offer(null);
				}
				System.out.println();
			}
		}

	}

	public static void main(String ... args){
		TreeNode root = null;
		BST bst = new BST();
		root = bst.insert(root,10);
		root = bst.insert(root,5);
		root = bst.insert(root,15);
		root = bst.insert(root,7);
		root = bst.insert(root,4);
		root = bst.insert(root,14);
		root = bst.insert(root,17);

		diagonalOrderPrint(root);
	}
}