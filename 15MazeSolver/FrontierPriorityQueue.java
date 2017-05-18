public class FrontierPriorityQueue implements Frontier{
    private MyHeap frontier;

    public FrontierPriorityQueue() {
	frontier = new MyHeap();
    }

    public void add(Location z) {
	frontier.add(z);
    }

    public Location next() {
	return frontier.remove();
    }

    public Location peek() {
	return frontier.peek();
    }

    public int size() {
	return frontier.size();
    }

    public boolean hasNext() {
	return !(frontier.peek() == null);
    }
}
