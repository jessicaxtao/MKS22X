import java.util.*;

public class MyLinkedList implements Iterable<Integer> {

    private class LNode{

        private int element;
        private LNode next;

        private LNode(int ele){
            element = ele;
        }

        private LNode(int ele, LNode n){
            element = ele;
            next = n;
        }

    }

    private LNode start;
    private int size;

    public MyLinkedList(){

    }

    private LNode getNthNode(int n) {
	for(int i = 0; i < n; i++) {
	
    }

    private void addAfter(LNode location, LNode toBeAdded) {
	add(size-1, tobeAdded);
    }

    private void remove(LNode target) {
    }

    public String toString() {
        String s = "[";
        LNode current = start;
        for (int i = 0; i < size; i++) {
            s = s + current.element + ", ";
            current = current.next;
        }
        if (size == 0) return s + "]";
        return s.substring(0, s.length() - 2) + "]";
    }

    public boolean add(int value) {
        add(size -1, value);
	return true;
    }

    public int size() {
        return size;
    }

    public int get(int index) {
        if (index >= size) {
	    throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        LNode current = start;
        while (counter < index) {
            current = current.next;
            counter++;
        }
        return current.element;
    }

    public void set(int index, int value) {
        if (index >= size) {
	    throw new IndexOutOfBoundsException();
	}
        int counter = 0;
        LNode current = start;
        while (counter < index) {
            current = current.next;
            counter++;
        }
        current.element = value;
    }

    public int indexOf(int value) {
        int counter = 0;
        LNode current = start;
        while (current.element != value) {
            if (current.next == null) {
		return -1;
	    }
            current = current.next;
            counter++;
        }
        return counter;
    }

    public void add(int index, int value) {
        if(index >= size) {
	    throw new IndexOutOfBoundsException();
	}

        int counter = 0;
        LNode current = start;
        while(counter < index) {
            current = current.next;
            counter++;
        }

        current = new LNode(value, current);
        counter = 0;
        LNode currentN = start;
	while(counter < (index - 1)) {
            currentN = currentN.next;
            counter++;
        }
        currentN.next = current;
        size++;
    }

    public int remove(int index) {
        if(index >= size) {
	    throw new IndexOutOfBoundsException();
	}

        int counter = 0;
        LNode current = start;
        while (counter < index - 1) {
            current = current.next;
            counter++;
        }

        LNode now = current.next.next;
        current.next = now;
        size--;
        return index;
    }

    public static void main(String[] args) {
	MyLinkedList a = new MyLinkedList();
	a.add(3);
	a.add(4);
	a.add(5);
	System.out.println(a);
	a.remove(2);
	System.out.println(a);
	a.add(1,8);
	System.out.println(a);
	System.out.println(a.get(2));
	a.set(2, 99);
	System.out.println(a);
    }

}
