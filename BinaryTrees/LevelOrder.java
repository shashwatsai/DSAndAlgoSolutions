import java.lang.*;
import java.util.*;


public class LevelOrder{

	private ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		ArrayList<Integer> nodes = new ArrayList<>();

		if(root == null){
			return res;
		}

		queue.offer(root);
		// mark the end of the level
		queue.offer(null);

		while(!queue.isEmpty()){
			// dequeue the top element from the queue
			TreeNode current = queue.poll();
			if(current != null){
				nodes.add(current.val);
				if(current.left != null){
					queue.offer(current.left);
				}

				if(current.right!= null){
					queue.offer(current.right);
				}
			}else{
				if(!queue.isEmpty()){
					queue.offer(null);
				}

				// change the reference
				res.add(nodes);
				nodes = new ArrayList<>();
			}
		}

		return res;
	}

	public static void main(String [] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		ArrayList<ArrayList<Integer>> res = new LevelOrder().levelOrder(root);
		System.out.println(res);
	}
}