class AVLNode{

	AVLNode left, right;
	int val, height;

	public AVLNode(int val){
		this.left = this.right = null;
		this.val = val;
		this.height = 1;
	}
}

public class AVLTree{

	private AVLNode leftRotate(AVLNode x){
        AVLNode y = x.right; 
        AVLNode T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        //  Update heights 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
  
        // Return new root 
        return y; 
	}

	private AVLNode rightRotate(AVLNode y){
        AVLNode x = y.left; 
        AVLNode T2 = x.right; 
  
        // Perform rotation 
        x.right = y; 
        y.left = T2; 
  
        // Update heights 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
  
        // Return new root 
        return x; 
	}

	public AVLNode insert(AVLNode root, int data){
		if(root == null){
			return new AVLNode(data);
		}else if(root.val > data){
			root.left = insert(root.left, data);
		}else if(root.val < data){
			root.right = insert(root.right, data);
		}else{
			return root;
		}

		root.height = 1 + Math.max(height(root.left), 
                              height(root.right)); 

		// get the balance
		int balance = getBalance(root);

		// left left case
		if(balance > 1 && root.left.val > data){
			return rightRotate(root);
		}

		// right right case
		if(balance < -1 && root.right.val < data){
			return leftRotate(root);
		}

		// left right case
		if(balance > 1 && root.left.val < data){
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// right left case
		if(balance < -1 && root.right.val > data){
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;

	}

	private int getBalance(AVLNode root){
		return height(root.left) - height(root.right);
	}

	private int height(AVLNode root){
		if(root == null) return 0;
		return root.height;
	}

	private void preOrder(AVLNode root){
		if(root != null){
			System.out.print(root.val+"-");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String [] args){
		AVLTree tree = new AVLTree();
		AVLNode root = null;
		root = tree.insert(root, 10);
		root = tree.insert(root, 11);
		root = tree.insert(root, 12);
		root = tree.insert(root, 13);
		root = tree.insert(root, 14);
		root = tree.insert(root, 15);
		root = tree.insert(root, 16);

		tree.preOrder(root);
	}

}