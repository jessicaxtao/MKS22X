public class QueenBoard{
    private int[][]board;
    private int solutionCount = -1;
    
    public QueenBoard(int size){
	board = new int[size][size];
	clear();
    }

    private void clear() {
		for(int row = 0; row < board.length; row++) {
	    for(int col = 0; col < board.length; col++) {
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
	if(col == board.length) {
	    return true;
	}else {
	    for(int row = 0; row < board.length; row++) {
		if(board[row][col] == 0) {
		    addQueen(row, col);
		    if(solveH(col + 1)){
			return true;
		    }else {
			removeQueen(row, col);
		    }
	        }
	    }
	    return false;	    
	}
    }

    private void addQueen(int row, int col) {
	board[row][col] = -1;
	for(int r = col + 1; r < board.length; r++) {
	    board[row][r] += 1;
	}
	for(int r = row + 1, c = col + 1; r < board.length && c < board.length; r++, c++) {
	    board[r][c] += 1;
	}
	for(int r = 1, c = 1; (row - r) > -1 && (col + c) < board.length; r++, c++) {
		board[row - r][col + c] += 1;
	}
    }

    private void removeQueen(int row, int col) {
	board[row][col] = 0;
	for(int r = col + 1; r < board.length; r++) {
	    board[row][r] -= 1;
	}
	for(int r = row + 1, c = col + 1; r < board.length && c < board.length; r++, c++) {
	    board[r][c] -= 1;
	}
	for(int r = 1, c = 1; (row - r) > -1 && (col + c) < board.length; r++, c++) {
		board[row - r][col + c] -= 1;
	}
    }
    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    //instead of return true just keep adding the number up and adding the queen adn removing the queen and just check that ur at the last column

    private void countH(int col){
	if(col == board.length) {
	    solutionCount++;
	}else {
	    for(int row = 0; row < board.length; row++) {
		if(board[row][col] == 0) {
		    addQueen(row, col);
		    countH(col + 1);
		    removeQueen(row, col);
		}
	    }
	}
    }
    
    public void countSolution() {
	clear();
	solutionCount = 0;
	countH(0);
    }
    
    public int getSolutionCount(){
        return solutionCount;
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
		/*
		else if(board[row][col] > 0) {
		    ans += "" + board[row][col] + " ";
		}
		*/
		else{
		    ans += "_ ";
		}
	    }
	    ans += "\n";
	}
    	return ans;
    }
}
