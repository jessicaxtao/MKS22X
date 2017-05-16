public class Location implements Comparable<Location> {

	int row, col, distA, distB;
	Location prev;
	boolean astar;

	public Location(int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar){
		row = r;
		col = c;
		prev = previous;
		distA = distToStart;
		distB = distToGoal;
		astar = aStar;
	}

	public int compareTo(Location other){
	    if (astar == true) {
		return (distA + distB) - (other.distA + other.distB);
	    }
		return distB - other.distB;
	}
}
