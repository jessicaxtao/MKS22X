public class FrontierPriorityQueue implements Frontier{
    PriorityQueue<Location> frontier;

    public FrontierPriorityQueue() {
	frontier = new FrontierPriorityQueue<Location>();
    }

    public void add(Location z) {
	frontier.add(z);
    }

    public Location next() {
    }
}
