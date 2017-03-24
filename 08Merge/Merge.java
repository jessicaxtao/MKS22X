public class Merge{
    public static void mergesort(int[] ary) {
	while(ary.length > 1){
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
	    mergeBack(left, right, ary);
	}
    }
    
    public static void mergeBack(int[] left, int[] right, int[] orig) {
	int l = 0;
	int r = 0;
	for(int i = 0; i < orig.length; i++) {
	    if(left[l] <= right[r]) {
		orig[i] = left[l];
		l++;
	    }else {
		orig[i] = right[r];
		r++;
	    }
	}
    }

    public static void main(String[] args) {
	int[] ary = {5, 7, 1, 2, 8, 2, 5, 7, 9, 0};
	mergesort(ary);
	String ans = "";
	for(int i = 0; i < ary.length; i++) {
	    ans+= ary[i] + " ,";
	}
    }
}
    
  
