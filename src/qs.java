import java.util.*;

public class qs {
	public static int partition(int[] array,int lo,int hi){
		int key = array[lo];
		while(lo<hi){
			while(array[hi]>=key&&hi>lo){
				hi--;
			}
			array[lo]=array[hi];
			while(array[lo]<=key&&lo<hi){
				lo++;
			}
			array[hi]=array[lo];
		}
		array[hi] = key;
		return hi;
	}
	public static void sort(int[] array,int lo,int hi){
		if(lo>=hi){
			return;
		}
		int index=partition(array,lo,hi);
		sort(array,lo,index-1);
		sort(array,index+1,hi);
	}
	public static void main(String[] args){
		Random rand =new Random(47);
		int[] a = new int[1000];
		for(int i=0;i<1000;i++){
			a[i]=rand.nextInt(10000);
		}
		sort(a,0,999);
		for(int i=0;i<1000;i++){
			System.out.print(a[i]+" ");
			if(i%20==0)
				System.out.print("\n");
		}
	}
}
