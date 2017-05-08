import java.util.*;

public class MyHeap{
    
    private int size;
    private boolean max;
    private ArrayList<String> heap;

    public MyHeap(){
        max = true;
	size = 0;
	heap = new ArrayList<String>();
    }

    public MyHeap(boolean mode){
        type = mode;
        size = 0;
        heap = new ArrayList<String>();
    }

    public void add(String s){
        heap.add(s);
        size++;
        pushUp();
    }

    public String remove(){
        String s = heap.get(1);
	heap.remove(1);
        heap.add(1, arr.remove(size()));
        pushDown();
        return s;
    }

    public String peek(){
        return heap.get(1);
    }

    private void pushUp(){
        int index = size;
        if (type){
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) > 0){
                String temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
        else {
            while (index > 1 && heap.get(index).compareTo(heap.get(index / 2)) < 0){
                String temp = heap.set(index, heap.get(index / 2));
                heap.set(index / 2, temp);
                index /= 2;
            }
        }
    }

    private void pushDown(){
        int index = 1;
        boolean welp = true;
        if (type){
            while (index * 2 <= size && welp){
                int left = heap.get(index).compareTo(heap.get(index * 2));
                int right = heap.get(index).compareTo(heap.get(index * 2 + 1));
                if (left > 0 && right > 0) welp = false;
                else if (left > right){
                    String temp = heap.set(index, heap.get(index * 2 + 1));
                    heap.set(index * 2 + 1, temp);
                    index = index * 2 + 1;
                }
                else {
                    String temp = heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp); 
                    index *= 2;
                }
            }
        }
        else {
            while (index * 2 <= size && welp){
                int left = heap.get(index).compareTo(heap.get(index * 2));
                int right = heap.get(index).compareTo(heap.get(index * 2 + 1));
                if (left < 0 && right < 0) welp = false;
                else if (left < right){
                    String temp = heap.set(index, heap.get(index * 2 + 1));
                    heap.set(index * 2 + 1, temp);
                    index = index * 2 + 1;
                }
                else {
                    String temp = heap.set(index, heap.get(index * 2));
                    heap.set(index * 2, temp); 
                    index *= 2;
                }

            }
        }
    }

    public String toString(){
        String ans = "";
	for(int i = 0; i < heap.length; i++) {
	    ans += heap[i] + " ";
	}
	return ans;
    }

    public static void main(String[] args){
	MyHeap a=new MyHeap(false);
	a.add("hi");
	a.add("bye");
    // a.add("hello");
    // a.add("i");
    // a.add("123");
    // a.add("j");
	System.out.println("top "+a.peek());
	a.remove();
    // System.out.println("top "+a.peek());
    // a.remove();
    // System.out.println("top "+a.peek());
    // a.remove();
    // System.out.println("top "+a.peek());
    // a.remove();
    // System.out.println("top "+a.peek());
}

}
