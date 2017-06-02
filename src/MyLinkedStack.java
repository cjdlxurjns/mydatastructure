

public class MyLinkedStack<T> {
	
	private static class Node<T>{
		T data;
		Node<T> next;
		public Node(T d,Node<T> p){
			data = d;
			next = p;
		}
	}
	Node<T> top;
	private int theSize;
	public MyLinkedStack(){
		doClear();
	}
	public void Clear(){
		doClear();
	}
	private void doClear(){
		top = new Node<T>(null,null);
		theSize = 0;
	}
	public int size(){
		return theSize;
	}
	public void add(T t){
		Node<T> newNode = new Node<T>(t,top);
		top = newNode;
		theSize++;
	}
	
	public void remove(){
		if(top.next==null)
			return;
		top = top.next;
		theSize--;
	}
	public T getTop(){
		return top.data;
	}
}
