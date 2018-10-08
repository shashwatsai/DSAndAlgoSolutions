public class MaximumPathSumBetweenNodes{

	class Res{
		int val;
	}

	public int maxPathSumBetweenNodesUtil(TreeNode root, Res res){
		if(root == null){
			return 0;
		}

		int l = maxPathSumBetweenNodesUtil(root.left, res);
		int r = maxPathSumBetweenNodesUtil(root.right, res);

		int max_left_or_right = Math.max(Math.max(l,r)+root.val, root.val);
		int max_including_root = Math.max(max_left_or_right, l+r+root.val);

		res.val = Math.max(res.val, max_including_root);

		return max_left_or_right;
	}

	public int maxPathSumBetweenNodes(TreeNode root){
		Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxPathSumBetweenNodesUtil(root, res);
        return res.val;
	}

	class TreeNode{
		TreeNode left, right;
		int val;
		TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}


	public void inOrder(TreeNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.val+"->");
			inOrder(root.right);
		}
	}

	public TreeNode addNode(int val){
		return new TreeNode(val);
	}
	

	public static void main(String [] args){
		MaximumPathSumBetweenNodes test = new MaximumPathSumBetweenNodes();
		MaximumPathSumBetweenNodes.TreeNode root = test.addNode(-5);
		root.left = test.addNode(2);
		root.right = test.addNode(10);
		root.left.left = test.addNode(2);
		root.left.right = test.addNode(3);
		root.left.right.left = test.addNode(-2);
		
		System.out.println(test.maxPathSumBetweenNodes(root));

	}
}