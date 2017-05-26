import java.util.*;

public class QueueFrontier implements Frontier {

    private LinkedList<Location> frontier;
    private int size;

    public QueueFrontier() {
	frontier = new LinkedList<Location>();
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

    public boolean hasNext() {
	return !frontier.isEmpty();
    }

}
