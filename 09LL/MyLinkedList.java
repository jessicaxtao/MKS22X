public class MyLinkedList() {
    private LNode start;
    private int size;

    private class LNode() {
	int start;
	List end;
	public LNode(int value) {
	    start = value;
	    end = null;	    
	}
	public LNode(int value, List a) {
	    start = value;
	    end = a;	    
	}
    }


    public MyLinkedList() {

    }

    public boolean add(int value) {
	LNode temp;
    }

    public String toString() {
	LNode current = start;
	for(int i = 0; i < start.size(); i++) {
	    ans += current.get(0);
	    current = current.next();
	} 
    }
}
