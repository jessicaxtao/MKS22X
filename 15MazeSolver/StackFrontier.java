import java.util.*;

public class StackFrontier implements Frontier{

    private Stack<Location> frontier;
    private int size;

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

    public int size() {
	return size;
    }

    public boolean hasNext() {
	return !frontier.isEmpty();
    }
}
