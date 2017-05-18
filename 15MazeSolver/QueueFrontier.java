public class QueueFrontier implements Frontier {
    Queue<Location> frontier;

    public QueueFrontier() {
	frontier = new Queue<Location>();
    }

    public void add(Location z) {
	frontier.add(z);
    }

    public Location next() {
	return frontier.remove();
    }


    public Location peek(){
	return frontier.peek();
    }

    public int size(){
	return frontier.size();
    }

    public boolean hasNext(){
	return !(frontier.peek() == null);
    }

}
