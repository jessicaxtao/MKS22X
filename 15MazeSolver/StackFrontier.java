public class StackFrontier implements Frontier{

    Stack<Location> frontier;

    public StackFrontier() {
	frontier = new Stack<Location>();
    }

    public void add(Location z) {
	frontier.push(z);
	size++;
    }

    public Location next() {
	size--;
	return frontier.pop();
    }

    public Location peek() {
	return frontier.peek();
    }

    public int size() {
	return size;
    }

    public boolean hasNext() {
	return !(frontier.peek() == null);
    }
}
