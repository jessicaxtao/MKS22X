import java.util.*;


public class Merge {

    public static void mergesort(int[] ary) {
	if(ary.length == 1) {
	    return;
	}
	    int[] left = Arrays.copyOfRange(ary, 0, ary.length / 2);
	    int[] right = Arrays.copyOfRange(ary, ary.length / 2, ary.length);
	    mergesort(left);
	    mergesort(right);
	    mergeBack(left, right, ary);
    }

    public static void mergeBack(int[] left, int[] right, int[] orig) {
	int l = 0;
	int r = 0;
	int o = 0;
	
	for(int i = 0; l < left.length && r < right.length; i++) {
	    if(left[l] <= right[r]) {
		orig[i] = left[l];
		l++;
	    }else {
		orig[i] = right[r];
		r++;
	    }
	    o = i;
	}

	while(l < left.length) {
	    orig[o] = left[l];
	    o++;
	    l++;
	}

	while(r < right.length) {
	    orig[o] = right[r];
	    o++;
	    r++;
	}
    }

}
