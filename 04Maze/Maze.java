import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
        //COMPLETE CONSTRUCTOR
	int r = 0;
	int c = 0;
	String ans = "";
	animate = false;
	
	try {
	    Scanner bob = new Scanner(new File(filename));
	    while(bob.hasNextLine()) {
		String line = bob.nextLine();
		ans += line;
		r++;
		c = line.length();
	    }
	}catch(FileNotFoundException e) {
	    System.out.println("Check the file name");
	    System.exit(1);
	}

	if(check(ans) == false) {
	    System.out.println("Check the starts and the ends");
	    System.exit(1);
	}

	maze = new char[r][c];
	while (ans.length() > 0) {
	    for(int i = 0; i < maze.length; i++) {
		for(int j = 0; j < maze[0].length; j++) {
		    maze[i][j] = ans.charAt(0);
		    ans = ans.substring(1);		    
		}
	    }
	}
    }

    private boolean check (String maze) {
	for(int i = 0; i < maze.length(); i++) {
	    if(maze.charAt(i) == 'S' || maze.charAt(i) == 'E') {
		return true;
	    }
	}
	return false;
    }
    
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;
            //Initialize starting row and startint col with the location of the S.
	    for(int i = 0; i < maze.length; i++) {
		for(int j = 0; j < maze[i].length; j++) {
		    if(maze[i][j] == 'S') {
			startr = i;
			startc = j;
		    }
		}
	    }
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solveH(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
        private boolean solveH(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	
	if (maze[row][col]=='E'){
	    return true;
	}

	if (maze[row][col]==' '){
	    
	    maze[row][col] = '@';
	    
	    if(row < maze.length - 1 && maze[row + 1][col] != '#') {
		if(solveH(row+1,col)) {
		    return true;
		}
	    }
	    if(col < maze[0].length - 1 && maze[row][col+1] != '#') {
		if(solveH(row, col + 1)) {
		    return true;
		}
	    }
	    if(row >= 1 && maze[row-1][col] != '#') {
		if(solveH(row-1,col)) {
		    return true;
		}
	    }
	    if(col >= 1 && maze[row][col-1] != '#') {
		if(solveH(row,col-1)) {
		    return true;
		}
	    }
	    
	    maze[row][col] = '.';
     	}

        return false; //so it compiles
    }
    public String toString(){
	String str = "";
	for (int i = 0; i < maze.length; i++){
	    for (int j = 0; j < maze[0].length; j++){
		str += maze[i][j];
	    }
	    if (i < maze.length - 1){
		str += "\n";
	    }
	}
	return str;
    }

}
