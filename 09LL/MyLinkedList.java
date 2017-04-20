import java.util.*;

public class MyLinkedList implements Iterable<Integer> {

    private class LNode {
	
        private int element;
        private LNode next, prev;

        public LNode(int ele){
            this.element = ele;
        }
	
	public String toString() {
	    return "" + element;
	}
	
    }

    public class MyLinkedListIterator implements Iterator<Integer> {
	
	private MyLinkedList bob;
	private LNode current;

	public MyLinkedListIterator(MyLinkedList george) {
	    current = george.head;
	    this.bob = george;
	}

	public boolean hasNext() {
	    return current.next != null;
	}

	public Integer next() {
	    if(hasNext()) {
		int val = current.element;
		current = current.next;
		return val;
	    }else{
		throw new NoSuchElementException();
	    }
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
	
    }
    
    public Iterator<Integer> iterator() {
	return new MyLinkedListIterator(this);
    }

    LNode head = null, tail = null;
    int size = 0;

    public MyLinkedList(){
    }

    public int size() {
	return size;
    }
    
    private LNode getNthNode(int n) {
        if(n < 0 || n >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = null;
	if(n > size/2) {
	    current = tail;
	    for(int i = size; i > n + 1; i--){
		current = current.prev;
	    }
	}else{
	    current = head;
	    for(int i = n; i > 0; i--) {
		current = current.next;
	    }
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded) {
	if(size == 0) {
	    head = toBeAdded;
	    tail = toBeAdded;
	}else if(location.next == null) {
	    tail = toBeAdded;
	    location.next = toBeAdded;
	    toBeAdded.prev = location;
	    toBeAdded.next = null;
	}else if(location.prev == null) {
	    head = toBeAdded;
	    location.prev = toBeAdded;
	    toBeAdded.next = location;
	    toBeAdded.prev = null;
	}else{
	    toBeAdded.prev = location;
	    toBeAdded.next = location.next;
	    location.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
    }

    private void remove(LNode target) {
	if(size == 1) {
	    head = null;
	    tail = null;
	}else if(target == head) {
	    head.next.prev = null;
	    head = head.next;
	}else if(target == tail) {
	    tail.prev.next = null;
	    tail = tail.prev;
	}else {
	    target.prev.next = target.next;
	    target.next.prev = target.prev;
	}
    }

    public String toString() {
        String s = "[";
        LNode current = head;
        for (int i = 0; i < size; i++) {
            s = s + current.element + ", ";
            current = current.next;
        }
	
        if (size == 0) {
	    return s + "]";
	}
	
        return s.substring(0, s.length() - 2) + "]";
    }

    public boolean add(int value) {
	LNode a = new LNode(value);
	addAfter(tail, a);
	size++;
	return true;
    }

    public void add(int index, int value) {
	try{
	    LNode a = getNthNode(index);
	    LNode b = new LNode(value);
	    addAfter(a, b);
	    size++;
	}catch(NullPointerException e) {
	    throw new NullPointerException();
	}
    }

    public int remove(int index) {
	if(index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	try{
	    LNode a = getNthNode(index);
	    remove(a);
	    size--;
	    return a.element;
	}catch(NullPointerException e){
	    throw new NullPointerException();
	}
    }

    public int get(int index) {
	LNode n = getNthNode(index);
	return n.element;
    }

    public int set(int index, int value) {
	LNode n = getNthNode(index);
	int temp = n.element;
	n.element = value;
	return temp;
    }

    public int indexOf(int value) {
	int index = 0;
	LNode current = head;
	if(index == size) {
	    return -1;
	}
	while(current.element != value) {
	    index++;
	    current = current.next;
	}
	return index;
    }

}
