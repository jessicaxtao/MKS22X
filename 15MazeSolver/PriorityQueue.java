public class PriorityQueue{
    private MyHeap arr;
    
    public PriorityQueue(){
	arr = new MyHeap(false); 
    }

    public Location remove(){
	return arr.remove();
    }
    
    public void add(Location d){
	arr.add(d);
    }
}
