
import java.util.*;

public class MyArrayList<T> implements Iterable<T> {
	private static int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private T[] theItems;
	
	public MyArrayList(){
		doClear();
	}
	
	public void Clear(){
		doClear();
	}
	
	private void doClear(){
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size(){
		return theSize;
	}
	
	public boolean isEmpty(){
		return theSize == 0;
	}
	
	public void trimToSize(){
		ensureCapacity(theSize);
	}
	
	public T get(int index){
		return theItems[index];
	}
	
	public T set(int index,T newval){
		T old = theItems[index];
		theItems[index] = newval;
		return old;
	}
	
	public void ensureCapacity(int newCapacity){
		if(newCapacity<theSize){
			return;
		}
		T[] oldItems = theItems;
		theItems = (T[])new Object[newCapacity];
		for(int i =0;i<theSize;i++){
			theItems[i] = oldItems[i];
		}
	}
	public void add(T val){
		add(size(),val);
	}
	
	public void add(int index,T val){
		if(theItems.length == size()){
			ensureCapacity(size()*2 + 1);
		}
		for(int i = theSize;i>index;i--){
			 theItems[i]=theItems[i-1];
		}
		theItems[index]=val;
		
		theSize++;
	}
	
	public T remove(int index){
		T removeItem = theItems[index];
		for(int i = index;i<size()-1;i++){
			theItems[i] = theItems[i+1];
		}
		
		theSize--;
		return removeItem;
	}
	
	public Iterator<T> iterator(){
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T>{
		private int current = 0;
		public boolean hasNext(){
			return current<size();
		}
		public T next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return theItems[current++];
		}
		
		public void remove(){
			MyArrayList.this.remove(--current);
		}
	}
}
