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
		    addQueen(row, col);
		    return solveH(col + 1);
	        }	
	    }
	    //how to go back?
	}
	return false;
    }

    private void addQueen(int row, int col) {
	board[row][col] = -1;
	for(int r = row + 1; r < board[0].length; r++) {
	    board[row][r] += 1;
	}
	//r and c would have to be equal anyway
	for(int r = row + 1; r < board[0].length; r++) {
	    board[r][r] += 1;
	}
	for(int r = 1; r < board[0].length - row; r++) {
	    board[row - r][col + r] += 1;
	}
    }

    private void removeQueen(int row, int col) {
	board[row][col] = 0;
	for(int r = 0; r < board[0].length; r++) {
	    board[r][col] -= 1;
	}
	for(int c = 0; c < board[0].length; c++) {
	    board[row][c] -= 1;
	}
	for(int r = 0; r < board[0].length - row; r++) {
	    board[row + r][col + r] -= 1;
	}
	for(int r = 0; r < board[0].length - row; r++) {
	    board[row + r][col - r] -= 1;
	}
	for(int r = 0; r < board[0].length - row; r++) {
	    board[row - r][col + r] -= 1;
	}
	for(int r = 0; r < board[0].length - row; r++) {
	    board[row - r][col - r] -= 1;
	}
    }
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    //instead of return true just keep adding the number up and adding the queen adn removing the queen and just check that ur at the last column
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
		if(board[row][col] == -1) {
		    ans += "Q ";
		}
		else if(board[row][col] > 0) {
		    ans += "" + board[row][col] + " ";
		}
		else{
		    ans += "_ ";
		}
	    }
	    ans += "\n";
	}
    	return ans;
    }

    public static void main(String[] args) {
	QueenBoard a = new QueenBoard(5);
	//a.solve();
	//System.out.println(a);
	a.addQueen(2,2);
	System.out.println(a);
    }
}
