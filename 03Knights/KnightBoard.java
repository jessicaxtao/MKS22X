public class KnightBoard{
    private int[][]board;
    
    public KnightBoard(int row, int col){
	board = new int[row][col];
    }
    /*
    private void clear() {
	for(int row = 0; row < board.length; row++) {
	    for(int col = 0; col < board.length; col++) {
		board[row][col] = 0;
	    }
	}
    }
    */
    public boolean solve()
    {
	return solveH(0,0,1);
    }
    /*
    private boolean checker(int r, int c) {
	if(r > 0 && r < board.length && c > 0 && c < board[r].length) {
	    return true;
	}
	return false;
    }
    */
    private boolean solveH(int r, int c, int level){
	if(level > board[0].length * board.length) {
	    return true;
	}
	
	if (r<0 || r >= board.length || c<0 || c>= board[0].length){return false;}
	
	if(board[r][c] == 0) {
	    board[r][c] = level;
	    if(solveH(r + 1, c + 2, level + 1)){
		return true;
	    }
	    if(solveH(r + 2, c + 1, level + 1)){
		return true;
	    }
	    if(solveH(r + 1, c - 2, level + 1)){
		return true;
	    }
	    if(solveH(r + 2, c - 1, level + 1)){
		return true;
	    }
	    if(solveH(r - 1, c - 2, level + 1)){
		return true;
	    }
	    if(solveH(r - 2, c - 1, level + 1)){
		return true;
	    }
	    if(solveH(r - 1, c + 2, level + 1)){
		return true;
	    }
	    if(solveH(r - 2, c + 1, level + 1)){
		return true;
	    }
	    board[r][c] = 0;
	}
	return false;
    }

    public String toString(){
	String ans = "";
	for(int row = 0; row < board.length; row++) {
	    for(int col = 0; col < board[row].length; col++) {
		if(board[row][col] < 10) {
		    ans += " " + board[row][col] + " ";
		}else {
		    ans += board[row][col] + " ";
		}
	    }
	    ans += "\n";
	}
    	return ans;
    }
    public static void main (String[] args) {
	KnightBoard k = new KnightBoard(7,7);
	k.solve();
	System.out.println(k);
    }
}
