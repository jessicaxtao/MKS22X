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
        size++;
        pushUp();
    }

    public Integer remove() {
        Integer s = heap.set(1, heap.remove(size));
        size--;
        pushDown();
        return s;
    }

    public Integer peek() {
        return heap.get(1);
    }
    
    public Integer size() {
	return this.size;
    }

    private void pushUp() {
        int index = size;
        if (max == true){
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) > 0){
                Integer temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
        else {
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) < 0){
                Integer temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
    }

    private void pushDown() {
        int index = 1;
        boolean bounds = true;
        if (max == true){
            while (index * 2 <= size && bounds) {
                int left = heap.get(index).compareTo(heap.get(index * 2));
                int right = heap.get(index).compareTo(heap.get(index * 2 + 1));
                if (left > 0 && right > 0) {
		    bounds = false;
		}
                else if (left > right) {
                    Integer temp = heap.set(index, heap.get(index * 2 + 1));
                    heap.set(index * 2 + 1, temp);
                    index = index * 2 + 1;
                }
                else {
                    Integer temp = heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp); 
                    index *= 2;
                }
            }
        }
        else {
            while (index * 2 <= size && bounds) {
                int left = heap.get(index).compareTo(heap.get(index * 2));
                int right = heap.get(index).compareTo(heap.get(index * 2 + 1));
                if (left < 0 && right < 0) {
		    bounds = false;
		}
                else if (left < right) {
                    Integer temp = heap.set(index, heap.get(index * 2 + 1));
                    heap.set(index * 2 + 1, temp);
                    index = index * 2 + 1;
                }
                else {
                    Integer temp = heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp); 
                    index *= 2;
                }

            }
        }
    }

    public String toString() {
        String ans = "";
	for(int i = 0; i < size; i++) {
	    ans += heap.get(i) + " ";
	}
	return ans;
    }

    public static void main(String[] args) {
	MyHeap a = new MyHeap(true);
	a.add(9);
	a.add(3);
	System.out.println(2+a.peek());
	a.remove();
    }

}
