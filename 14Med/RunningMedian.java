import java.util.*;

public class RunningMedian {

    private MyHeap lower;
    private MyHeap higher;

    public RunningMedian() {
	lower = new MyHeap(true);
	higher = new MyHeap(false);
    }

    public void add(int n) {
	if(lower.size() < higher.size()) {
	    lower.add(n);
	}else {
	    higher.add(n);
	}
    }

    public double getMedian() {
	if(lower.size() < higher.size()) {
	    return higher.peek();
	}else if(lower.size() > higher.size()) {
	    return lower.peek();
	}else{
	    return (higher.peek() + lower.peek()) / 2;
	}
    }
}
