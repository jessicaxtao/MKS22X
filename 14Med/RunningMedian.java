import java.util.*;

public class RunningMedian {

    private MyHeap lower;
    private MyHeap higher;
    private int sizeL = 0, sizeH = 0;

    public RunningMedian() {
	lower = new MyHeap(true);
	higher = new MyHeap(false);
    }

    public void add(int n){
	if(sizeL == 0 && sizeH == 0){
	    lower.add(n);
	    sizeL++;
	}else{
	    
	    if(n >= getMedian()){
		higher.add(n);
		sizeH++;
	    }else{
		lower.add(n);
		sizeL++;
	    }
	}

	//balancing stuff
	if(sizeH - sizeL > 1) {
	    lower.add(higher.remove());
	    sizeH--;
	    sizeL++;
	}else if(sizeL - sizeH > 1) {
	    higher.add(lower.remove());
	    sizeH++;
	    sizeL--;
	}

    }

    public double getMedian() {
	if(sizeL == sizeH) {
	    return ((higher.peek() + lower.peek()) / 2.0);
	}else if(sizeL-sizeH > 1 || sizeH-sizeL > 1) {
	     return ((higher.peek() + lower.peek()) / 2.0);
	}else if(sizeL - sizeH == 1) {
	    return lower.peek();
	}else if(sizeH - sizeL == 1){
	    return higher.peek();
	}else{
	    return -1;
	}
    }

}
