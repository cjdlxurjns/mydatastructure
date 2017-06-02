
import java.util.*;

public class MyLinkedList<T> implements Iterable<T> {
	
	private int theSize;
	private int modCount = 0;
	private Node<T> beginMarker;
	private Node<T> endMarker;
	private static class Node<T>{
		Node<T> prev;
		Node<T> next;
		T val;
		Node(T v,Node<T> p,Node<T> n){
			val = v;prev = p;next = n;
		}
	}
	
	public MyLinkedList(){
		doClear();
	}
	public void clear(){
		doClear();
	}
	public void doClear(){
		beginMarker = new Node<T>(null,null,null);
		endMarker = new Node<T>(null,beginMarker,null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount++;
	}
	
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return theSize == 0;
	}
	
	public boolean add(T x){
		add(size(),x);
		return true;
	}
	
	public void add(int idx,T x){
		addBefore(getNode(idx,0,size()),x);
	}
	public T get(int idx){
		return getNode(idx).val;
	}
	
	public T set(int idx,T newVal){
		Node<T> p = getNode(idx);
		T oldVal = p.val;
		p.val = newVal;
		return oldVal;
	}
	
	public T remove(int idx){
		return remove(getNode(idx));
	}
	
	private void addBefore(Node<T> p,T x){
		Node<T> newNode = new Node<>(x,p.prev,p);
		newNode.prev.next = newNode;
		p.prev=newNode;
		theSize++;
		modCount++;
	}
	
	private T remove(Node<T> p){
		p.prev.next=p.next;
		p.next.prev=p.prev;
		theSize--;
		modCount++;
		return p.val;
	}
	
	private Node<T> getNode(int idx){
			return getNode(idx,0,size()-1);
	}
	
	private Node<T> getNode(int idx,int lower,int upper){
		Node<T> p;
		if(idx<lower||idx>upper)
			System.out.println("I am wrongggggggggggg");
		if(idx<size()/2){
			p=beginMarker.next;
			for(int i =0;i<idx;i++){
				p=p.next;
			}
		}else{
			p=endMarker;
			for(int i=size();i>idx;i++){
				p=p.prev;
			}
		}
		
		return p;
	}
	
	public Iterator<T> iterator(){
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>{
		private Node<T> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext(){
			return current !=endMarker;
		}
		
		public T next(){
			if(modCount!=expectedModCount){
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!hasNext()){
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			T nextItem = current.val;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		
		public void remove(){
			if(modCount!=expectedModCount){
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(!okToRemove){
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			MyLinkedList.this.remove(current.prev);
			expectedModCount++;
			okToRemove = false;
		}
	}
}


















