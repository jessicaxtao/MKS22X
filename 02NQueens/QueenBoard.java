public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
	for(int row = 0; row < size; row++) {
	    for(int col = 0; col < size; col++) {
		board[row][col] = 0;
	    }
	}
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){
	if(col >= board[0].length) {
	    return false;
	}else {
	    for(int row = 0; row < board[0].length; row++) {
		if(board[row][col] == 0) {
		    
		}
	    }
	}
    }

    private boolean addQueen(int row, int col) {
	board[row][col] = -1;
	for (int i = 0; i < board[0].length; i++) {
	    if(board[row][i] != -1) {
		board[row][i] += 1;
	    }
	}
    }

    private boolean removeQueen(int row, int col) {
	
    }
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    
    public int getSolutionCount(){
    	return -1;
    }
    
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String ans = "";
	for(int row = 0; row < board[0].length; row++) {
	    for(int col = 0; col < board[row].length; col++) {
		if(board[row][col] == 'Q') {
		    ans += "Q";
		}else{
		    ans += "_";
		}
	    }
	    ans += "\n";
	}
    	return ans;
    }

    public static void main(String[] args) {
	Queenboard a = new Queenboard(4);
	a.solve();
	System.out.println(a);
    }
}
