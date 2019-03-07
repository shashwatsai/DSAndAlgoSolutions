import java.util.*;

public class DistanceAtK{
	static int K;
	static List<Integer> ans;

	private static List<Integer> nodesAtDistanceK(TreeNode root, int target, int k){
		K = k;
		ans = new ArrayList<>();
		TreeNode targetNode = findTargetNode(root, target);
		helper(root, targetNode);
		return ans;
	}

	private static int helper(TreeNode root, TreeNode target){
		if(root == null){
			return -1;
		}else if(root == target){
			addNodes(root, 0);
			return 1;
		}else{
			int L = helper(root.left, target);
			int R = helper(root.right, target);

			if(L != -1){
				if(L == K) ans.add(root.val);
				addNodes(root.right, L+1);
				return L+1;
			}else if( R != -1){
				if(R == K) ans.add(root.val);
				addNodes(root.left, R+1);
				return R+1;
			}else{
				return -1;
			}
		}
	}

	private static void addNodes(TreeNode root, int dist){
		if(root == null) return;
		if(dist == K){
			ans.add(root.val);
		}else{
			addNodes(root.left, dist+1);
			addNodes(root.right, dist+1);
		}
	}

	private static TreeNode findTargetNode(TreeNode root, int target){
		if(root == null){
			return null;
		}

		if(root.val == target){
			return root;
		}

		TreeNode left = findTargetNode(root.left, target);
		TreeNode right = findTargetNode(root.right, target);

		if(left != null) return left;
		if(right != null) return right;

		return null;
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

		System.out.println(nodesAtDistanceK(root, 4, 2));

	}

}