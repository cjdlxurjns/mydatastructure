

public class BinarySearchTree {
	private static class BinaryNode{
		int element;
		BinaryNode left;
		BinaryNode right;
		BinaryNode(int element){
			this(element,null,null);
		}
		BinaryNode(int element,BinaryNode left,BinaryNode right){
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	private BinaryNode root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public boolean contains(int x){
		return contains(x,root);
	}
	
	public int findMin(){
		return findMin(root).element;
	}
	public int findMax(){
		return findMax(root).element;
	}
	
	public void insert(int x){
		root = insert(x,root);
	}
	public void remove(int x){
		root = remove(x,root);
	}
	
	private boolean contains(int x,BinaryNode t){
		if(t==null)
			return false;
		
		if(x<t.element){
			return contains(x,t.left);
		}
		else if(x>t.element){
			return contains(x,t.right);
		}
		else return true;
	}
	
	private BinaryNode findMin(BinaryNode t){
		if(t == null){
			return null;
		}
		else if(t.left==null){
			return t;
		}
		else return findMin(t.left);
	}
	private BinaryNode findMax(BinaryNode t){
		if(t==null){
			return null;
		}
		else if(t.right==null){
			return t;
		}
		else return findMax(t.right);
	}
	
	private BinaryNode insert(int x,BinaryNode t){
		if(t==null){
			return new BinaryNode(x);
		}
		
		if(x<t.element){
			t.left = insert(x,t.left);
		}
		else if(x>t.element){
			t.right = insert(x,t.right);
		}
		else ;
		
		return t;
	}
	
	private BinaryNode remove(int x,BinaryNode t){
		if(t==null){
			return t;
		}
		
		if(x<t.element){
			t.left=remove(x,t.left);
		}
		else if(x>t.element){
			t.right = remove(x,t.right);
		}
		else if(t.left!=null&&t.right!=null){
			t.element = findMin(t.right).element;
			t.right = remove(t.element,t.right);
		}
		else t=(t.left!=null)?t.left:t.right;
		
		return t;
	}
}






















