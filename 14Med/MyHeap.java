import java.util.*;

public class MyHeap {
    
    private int size;
    private boolean max;
    private ArrayList<Integer> heap;

    public MyHeap(){
        max = true;
	size = 0;
	heap = new ArrayList<Integer>();
	heap.add(null);
    }

    public MyHeap(boolean mode) {
        max = mode;
        size = 0;
        heap = new ArrayList<Integer>();
	heap.add(null);
    }

    public void add(Integer s) {
        heap.add(s);
	pushUp();
        size++;
    }

    public Integer remove() {
	Integer ans = heap.get(1);
	heap.set(1,heap.get(size));
	heap.remove(size);
	pushDown();
	size--;
	return ans;
    }

    public Integer peek() {
        return heap.get(1);
    }
    
    public Integer size() {
	return this.size;
    }

    private void pushUp() {
	int index = size;
        if(max == true){
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) > 0){
                swap(index, index / 2);
		index /= 2;
            }
        }
        else {
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) < 0){
                swap(index, index / 2);
		index /= 2;
            }
        }
    }

    private void pushDown() {
	int index = 1;
	while(index < size / 2) {
	    if(max == true){
		if(heap.get(index).compareTo(heap.get(index*2)) < 0) {
		    swap(index, index * 2 + 1);
		}
		if(heap.get(index).compareTo(heap.get(index*2+1)) < 0) {
		    swap(index, index * 2);
		}
	    }else{
		if(heap.get(index).compareTo(heap.get(index*2)) > 0) {
		    swap(index, index * 2);
		}
		if(heap.get(index).compareTo(heap.get(index*2+1)) > 0) {
		    swap(index, index * 2 + 1);
		}	
	    }
	    index*=2;
	}
 
    }

    private void swap(int a, int b) {
	Integer temp = heap.get(a);
	heap.set(a, heap.get(b));
	heap.set(b, temp);
    }
    
    public String toString() {
        String ans = "";
	for(int i = 0; i < size; i++) {
	    ans += heap.get(i) + " ";
	}
	return ans;
    }

}
