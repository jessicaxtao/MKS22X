import java.util.*;

public class Quick {
    public static int quickselect(int[] data, int k){
        return quickselectH(data, k, 0, data.length - 1);
    }

    private static int quickselectH(int[] data, int k, int start, int end){
	while(start <= end) {
	    int newPiv = part(data, start, end);
	    if(newPiv == k) {
		return data[newPiv];
	    }else if(newPiv > k) {
		return quickselectH(data, k, 0, newPiv - 1);
	    }else {
		return quickselectH(data, k, newPiv + 1, data.length - 1);
	    }
	}
	return data[end];
    }

    public static void quicksort(int[] data){
        quicksortH(data, 0, data.length - 1);
    }

    private static void quicksortH(int[] data, int start, int end){
        if (start <= end){
            int newPiv = part(data, start, end);
            quicksortH(data, start, newPiv - 1);
            quicksortH(data, newPiv + 1, end);
        }
    }

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
    /*
    public static void main(String[] args) {
	int[] data = {2, 10, 15, 23, 0, 5};
	//System.out.println(part(data, 0, 3));
	//int b = quickselect(data, 3);
	//System.out.println(b);
	//quicksort(data);
	String c = "";
        //System.out.println(quickselect(data, 2));
	//System.out.println(part(data, 0, 5));
	quicksort(data);
	for(int i = 0; i < data.length; i++){
	    c += data[i] + ",";
	}
	System.out.println(c);
    }
    */
}
