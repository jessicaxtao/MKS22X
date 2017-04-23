import java.util.*;
public class MyDeque {
    String[] deque;
    int first, last, size;

    public MyDeque() {
	deque = new String[9];
	size = 0;
    }

    public void addFirst(String bob){
	if(bob == null){
	    throw new NullPointerException();
	}
	check(size + 1);
	if(size == 0) {
	    last--;
	    last = last % deque.length;
	}
	int index = first - 1 + deque.length % deque.length;
	deque[index] = bob;
	first--;
	size++;
    }

    public void addLast(String bob) {
	if(bob == null) {
	    throw new NullPointerException();
	}
	check(size + 1);
	if(size == 0) {
	    first++;
	    first = first + deque.length % deque.length;
	}
	int index = last + 1 % deque.length;
	deque[index] = bob;
	last++;
	size++;
	last = last % deque.length;
	
    }

    private void check(int index) {
	if(index > deque.length || index < 0) {
	    String[] old = deque;
	    deque = new String[deque.length * 2];
	    int a = 0;
	    if(last >= first) {
		for(int i = first; i <= last; i++) {
		    deque[a] = old[i];
		    index++;
		}
	    }else {
		for(int i = first; i < old.length; i++) {
		    deque[a] = old[i];
		    index++;
		}
		for(int i = 0; i < first; i++) {
		    deque[a] = old[i];
		    index++;
		}
	    }
	    first = 0;
	    last = size - 1;	    
	}
    }

    public String removeFirst() {
	String a = deque[first];
	first++;
	first = first % deque.length;
	size--;
	return a;
    }

    public String removeLast() {
	String a = deque[last];
	last--;
	last = last % deque.length;
	size--;
	return a;
    }

    public String getFirst(){
	return deque[first];
    }

    public String getLast(){
	return deque[last];
    }

    public String toString() {
	String ans = "";
	for(int i = 0; i < deque.length; i++) {
	    if(deque[i] == null) {
		ans += "null ";
	    }else {
		ans += deque[i].toString() + " ";
	    }
	}
	ans += "\n" + "first: " + first + " last: " + last;
	return ans;
    }
    /*
    public static void main(String[] args) {
	MyDeque a = new MyDeque();
	System.out.println(a);
	a.addLast("apple");
	a.addFirst("bob");
	a.addLast("cat");
	System.out.println(a);
    }
    */
}
