public class Merge{
    public static void mergesort(int[] ary) {
	int len = ary.length / 2;
	int[] left = new int[len];
	int[] right = new int[ary.length - len];
	for(int i = 0; i < ary.length; i++) {
	    if(i < len) {
		left[i] = ary[i];
	    }else {
		right[i] = ary[i];
	    }
	}
	mergesort(left);
	mergesort(right);

	if(len == 1) {
	    merge(left, right);
	}
    }
    
  
