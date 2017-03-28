import java.util.*;
public class Merge {

    public static void mergesort(int[] ary) {
	if(ary.length > 1) {
	    int[] left = Arrays.copyOfRange(ary, 0, ary.length / 2);
	    int[] right = Arrays.copyOfRange(ary, ary.length / 2, ary.length);
	    mergesort(left);
	    mergesort(right);
	    mergeBack(left, right, ary);
	}
    }
    
    private static void mergeBack(int[] left, int[] right, int[] orig){
	int l = 0;
	int r = 0;
	
	for(int i = 0; i < orig.length; i++){
	    if(l < left.length && r < right.length){
		if(left[l] < right[r]){
		    orig[i] = left[l];
		    l++;
		}else{
		    orig[i] = right[r];
		    r++;
		}
	    }else{
		if(l < left.length){
		    orig[i] = left[l];
		    l++;
		}else{
		    orig[i] = right[r];
		    r++;
		}
	    }
	}
    }

}
