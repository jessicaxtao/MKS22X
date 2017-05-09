import java.util.*;

public class RunningMedian {

    private MyHeap lower;
    private MyHeap higher;
    private int sizeL, sizeH, med1, med2 = 0;

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
	    }else if(n < getMedian()){
		lower.add(n);
		sizeL++;
	    }
	}

	//balancing stuff
	if(sizeL + 1 < sizeH) {
	    lower.add(higher.remove());
	    sizeH++;
	    sizeL--;
	}else if(sizeH + 1 < sizeL) {
	    higher.add(lower.remove());
	    sizeH--;
	    sizeL++;
	}
    }

    public double getMedian() {
	if(sizeL == sizeH) {
	    return (double)(higher.peek() + lower.peek()) / 2;
	}else if(sizeL > sizeH) {
	    return lower.peek();
	}else{
	    return higher.peek();
	}
    }
}
