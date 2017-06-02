

public class MyArrayStack<T>{
	
	private static int INIT_SIZE = 10;
	public T[] array;
	private int top;
	
	public MyArrayStack(){
		doClear();
	}
	
	public void Clear(){
		doClear();
	}
	
	public int size(){
		return top;
	}
	private void doClear(){
		top = 0;
		ensureCapacity(INIT_SIZE);
	}
	
	private void ensureCapacity(int size){
		if(size<top)
			return;
		
		T[] old = array;
		array = (T[])new Object[size];
		for(int i=0;i<size();i++){
			array[i]=old[i];
		}
	}
	
	public void add(T newval){
		if(top==array.length){
			ensureCapacity(size()*2);
		}
		array[top] = newval;
		top++;
		
	}
	
	public void remove(){
		if(top==0){
			return;
		}
		
		top--;
	}
	
	public T getTop(){
		return array[top-1];
	}
	
}