import java.util.*;

public class Quick {
    public static int quickselect(int[] data, int k){
        return quickselectH(data, k, 0, data.length - 1);
    }

    private static int quickselectH(int[] data, int k, int start, int end){
        if (end == start) return data[end];
        int pivot = part(data, start, end);
        if (pivot == k) return data[pivot];
        else if (pivot > k) return quickselectH(data, k, 0, pivot - 1);
        else return quickselectH(data, k, pivot + 1, data.length - 1);
    }

    public static void quicksort(int[] data){
        quicksortH(data, 0, data.length - 1);
    }

    private static void quicksortH(int[] data, int start, int end){
        if (start < end){
            int pivot = part(data, start, end);
            quicksortH(data, start, pivot - 1);
            quicksortH(data, pivot + 1, end);
        }
    }

    public static int part(int[] data, int start, int end) {
	Random rando = new Random();
	//int pivot = rando.nextInt(end - start + 1) + start;
	int pivot = 2;
	int temp;
	while(start <= end) {
	    while(data[start] <= data[pivot]) {
		start++;
	    }
	    while(data[end] > data[pivot]) {
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

    public static void main(String[] args) {
	int[] data = {2, 10, 15, 23, 0, 5};
	//System.out.println(part(data, 0, 3));
	//int b = quickselect(data, 3);
	//System.out.println(b);
	//quicksort(data);
	String c = "";
	System.out.println(part(data, 0, 5));
	for(int i = 0; i < data.length; i++){
	    c += data[i] + ",";
	}
	System.out.println(c);
    }
}
