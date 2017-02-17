public class KnightBoard{
    private int[][]board;
    
    public KnightBoard(int row, int col){
	board = new int[row][col];
	clear();
    }

    private void clear() {
	for(int row = 0; row < board.length; row++) {
	    for(int col = 0; col < board.length; col++) {
		board[row][col] = 0;
	    }
	}
    }

    public boolean solve()
    {
	return solveH(0,0,1);
    }
    
    private boolean checker(int r, int c) {
	if(r > 0 && r < board.length) {
	
	}
	if(c < 0) {
	}
	if(board[r][c] == 0) {
	}
	return false;
    }
    //okay just do the thing where you check just make sure you check before you solve h also mak esure level == is right.
    private boolean solveH(int r, int c, int level){
	if(level == board[0].length * board.length) {
	    return true;
	}else{
	    if(solveH(r + 1, c + 2, level + 1)){
		board[r+1][c+2] = level + 1;
	    }
	    if(solveH(r + 2, c + 1, level + 1)){
		board[r+2][c+1] = level + 1;
	    }
	    if(solveH(r + 1, c - 2, level + 1)){
		board[r+1][c-2] = level + 1;
	    }
	    if(solveH(r + 2, c - 1, level + 1)){
		board[r+2][c-1] = level + 1;
	    }
	    if(solveH(r - 1, c - 2, level + 1)){
		board[r-1][c-2] = level + 1;
	    }
	    if(solveH(r - 2, c - 1, level + 1)){
		board[r-2][c-1] = level + 1;
	    }
	    if(solveH(r - 1, c + 2, level + 1)){
		board[r-1][c+2] = level + 1;
	    }
	    if(solveH(r - 2, c + 1, level + 1)){
		board[r-2][c+1] = level + 1;
	    }

	}
	return false;
    }

    public String toString(){
	String ans = "";
	for(int row = 0; row < board[0].length; row++) {
	    for(int col = 0; col < board[row].length; col++) {
		if(board[row][col] < 10) {
		    ans = " " + board[row][col] + " ";
		}else {
		    ans += board[row][col] + " ";
		}
	    }
	    ans += "\n";
	}
    	return "";
    }
}
