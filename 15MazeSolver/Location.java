public class Location implements Comparable<Location> {

	int row, col, distToStart, distToGoal;
	Location prev;
	boolean aStar;

	public Location(int r, int c, Location previous, int distA, int distB, boolean a){
		row = r;
		col = c;
		prev = previous;
		distToStart = distA;
		distToGoal = distB;
		aStar = a;
	}

    public Location(int distB) {
	distToGoal = distB;
	aStar = false;
    }

    public int compareTo(Location other){
	if (aStar == true) {
	    return (distToStart + distToGoal) - (other.distToStart + other.distToGoal);
	}
	return distToGoal - other.distToGoal;
    }

    //accessors
    public int getRow() {
	return row;
    }

    public int getCol() {
	return col;
    }

    public int getDistToStart() {
	return distToStart;
    }

    public int getDistToGoal() {
	return distToGoal;
    }

    public boolean getAStar() {
	return aStar;
    }

        public void setAStar(boolean x) {
	    aStar = x;;
    }

    public Location getPrev() {
	return prev;
    }
}
