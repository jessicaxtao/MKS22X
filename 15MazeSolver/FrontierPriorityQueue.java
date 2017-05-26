public class FrontierPriorityQueue implements Frontier{
    private MyHeap frontier;
    private int size;

    public FrontierPriorityQueue() {
	frontier = new MyHeap();
    }

    public void add(Location z) {
	frontier.add(z);
	size++;
    }

    public Location next() {
	size--;
	return frontier.remove();
    }

    public int size() {
	return size;
    }

}
