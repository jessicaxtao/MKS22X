import java.util.*;

public class MazeSolver {
    private Maze maze;
    private Frontier frontman;
    private boolean animate;

    public MazeSolver(String fileything) {
	this(fileything, false);
    }

    public MazeSolver(String fileything, boolean anim) {
	maze = new Maze(fileything);
	animate = anim;
    }

    public void solve() {
	solve(1);
    }

    public void solve(int style) {
	
	frontman.add(maze.getStart());
	boolean solu = false;
	
	if(style == 0) {
	    frontman = new StackFrontier();
	}else if(style == 1) {
	    frontman = new QueueFrontier();
	}else if(style == 2) {
	    frontman = new FrontierPriorityQueue();
	}else if(style == 3) {
	    frontman = new FrontierPriorityQueue();
	    maze.getStart().setAStar(true);
	    maze.getEnd().setAStar(true);
	}else {
	    System.out.println("uhhh?");
	}
	frontman.add(maze.getStart());
	while(frontman.hasNext()) {
	    Location x = frontman.next();
	    if(distance(x, maze.getEnd()) == 0) {
		maze.set(x.getRow(), x.getCol(), 'E');
		while (x.getPrev() != maze.getStart()) {
		    maze.set(x.getPrev().getRow(), x.getPrev().getCol(), '@');
		    x = x.getPrev();
		}
		System.out.println(this);
		return;
	    }

	    ArrayList<Location> nearby = surrounding(x);
	    for(int i = 0; i < nearby.size(); i++) {
		maze.set(nearby.get(i).getRow(), nearby.get(i).getCol(), '?');
		frontman.add(nearby.get(i));
	    }

	    System.out.println(this.toString());
	}
    }

    private int distance(Location a, Location b) {
	//manhattan distance
	int diffR = a.getRow() - b.getRow();
	int diffC = a.getCol() - b.getCol();
	return Math.abs(diffR) + Math.abs(diffC);
    }

    private ArrayList<Location> surrounding(Location bob) {
	ArrayList<Location> list = new ArrayList<Location>();
	if(maze.get(bob.getRow() + 1, bob.getCol()) == ' ') {
	    if(maze.get(bob.getRow() + 1, bob.getCol()) == 'E'){
		//dist = distToEnd(bob.getRow() + 1, bob.getCol());
		list.add(new Location(bob.getRow() + 1, bob.getCol(), bob, bob.getDistToStart() + 1, bob.getDistToGoal(), bob.getPrev().aStar));
	    }
	}
	if(maze.get(bob.getRow(), bob.getCol() + 1) == ' ') {
	    if(maze.get(bob.getRow(), bob.getCol() + 1) == 'E'){
		//dist = distToEnd(bob.getRow(), bob.getCol() + 1);
		list.add(new Location(bob.getRow(), bob.getCol() + 1, bob, bob.getDistToStart() + 1, bob.getDistToGoal(), bob.getPrev().aStar));
	    }
	}
	if(maze.get(bob.getRow() - 1, bob.getCol()) == ' ') {
	    if(maze.get(bob.getRow() - 1, bob.getCol()) == 'E'){
		//dist = distToEnd(bob.getRow() - 1, bob.getCol());
		list.add(new Location(bob.getRow() - 1, bob.getCol(), bob, bob.getDistToStart() + 1, bob.getDistToGoal(), bob.getPrev().aStar));
	    }
	}
	if(maze.get(bob.getRow(), bob.getCol() - 1) == ' ') {
	    if(maze.get(bob.getRow(), bob.getCol() - 1) == 'E'){
		//dist = distToEnd(bob.getRow(), bob.getCol() - 1);
		list.add(new Location(bob.getRow(), bob.getCol() - 1, bob, bob.getDistToStart() + 1, bob.getDistToGoal(), bob.getPrev().aStar));
	    }
	}
	return list;
    }

}
