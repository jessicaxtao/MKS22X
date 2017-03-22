import java.util.*;

public class Quick {

    public static int quickselect(int[] data, int k){
        return quickselectH(data, k, 0, data.length - 1);
    }
    
    private static int quickselectH(int[] data, int k, int start, int end){
	while(start < end) {
	    int[] newPiv = part(data, start, end);
	    if(newPiv[0] <= k && newPiv[1] >= k) {
		return data[newPiv[0]];
	    }else if(newPiv[0] > k) {
		return quickselectH(data, k, start, newPiv[0] - 1);
	    }else {
		return quickselectH(data, k, newPiv[1] + 1, data.length - 1);
	    }
	}
	return data[end];
    }

    public static void quicksort(int[] data){
        quicksortH(data, 0, data.length - 1);
    }

    private static void quicksortH(int[] data, int start, int end){
	if (start < end){
	    int[] newPiv = part(data, start, end);
	    int lt = newPiv[0];
	    int gt = newPiv[1];
	    quicksortH(data, start, lt - 1);
	    quicksortH(data, gt + 1, end);
	}
    }

    private static void swap(int[] data, int a, int b) {
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }
    /*
    public static int part(int[] data, int start, int end) {
	Random rando = new Random();
	int pivot = rando.nextInt(end - start + 1) + start;
	int temp;
	while(start <= end) {
	    //AHHHHHH I SPENT SO LONG BECAUSE I PUT START <= END AFTER THE DATA[START] THING BECAUSE I ONLY REALIZED IT WAS A PROBLEM AFTERWARD AND THAT TOOK ME SO SO SO LONG TO FIND IM SO MAD AT MYSELF
	    while(start <= end && data[start] <= data[pivot]) {
		start++;
	    }
	    while(start <= end && data[end] > data[pivot]) {
		end--;
	    }
	    if(start <= end) {
		temp = data[start];
		data[start] = data[end];
		data[end] = temp;
	    }
	}
        temp = data[pivot];
   	data[pivot] = data[end];
	data[end] = temp;
	return end;
    }
    */
    public static int[] part(int[] data, int start, int end) {
	Random rando = new Random();
	int pivot = rando.nextInt(end - start + 1) + start;
	int v = data[pivot];
	swap(data, pivot, start);
	int lt = start + 1;
	int i = start;
	int gt = end;
	
	while(i <= gt){
	    if(data[i] < v) {
		swap(data, i, lt);
		lt++;
		i++;
	    }else if(data[i] == v) {
		i++;
	    }else {
		swap(data, i, gt);
		gt--;
	    }
	}
	int[] ans = {lt, gt};
	return ans;
    }
    /*
    public static void main(String[] args) {
	int[] data = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 15, 23, 0, 5};
	//int[] data = {5, 4, 2, 9, 0, 1, 3, 6, 8, 7};
	//System.out.println(part(data, 0, 3));
	  int b = quickselect(data, 37);
	  System.out.println(b);
	//quicksort(data);
	String c = "";
        //System.out.println(quickselect(data, 2));
	//System.out.println(part(data, 0, 5));
	quicksort(data);
	for(int i = 0; i < data.length; i++){
	    c += data[i] + ",";
	}
	c = c.substring(0,c.length() - 1);
	System.out.println(c);
    }
    *.

}
