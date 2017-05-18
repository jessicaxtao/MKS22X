public class MazeSolver {

    public MazeSolver(String fileything) {
	this(fileything, false);
    }

    public MazeSolver(String fileything, boolean animate) {
    }

    public void solve() {
	solve(1);
    }

    public void solve(int style) {
	if(style == 0) {
	    //DFS
	}else if(style == 1) {
	    //BFS
	}else if(style == 2) {
	    //BestFirst
	}else if(style == 3) {
	    //A*
	}
    }

    public String toString() {
    }
}
