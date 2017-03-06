import java.util.*;
import java.io.*;

public class MakeLake {
    private int[][] lake;
    public MakeLake(String filename) {
	try {
	    Scanner bob = new Scanner(new File(filename));
	    int R = Integer.parseInt(bob.next());
	    int C = Integer.parseInt(bob.next());
	    int E = Integer.parseInt(bob.next());
	    int N = Integer.parseInt(bob.next());
	    
	    lake = new int[R][C];
	    for(int i = 1; i < R+2; i++) {
	    }
	    
	    
	    }catch(FileNotFoundException e) {

	}
    }

    public void stomp() {
    }

    public int volume() {
	int aggDepth = 0;
	for(int i = 0; i < lake.length; i++) {
	    for(int j = 0; j < lake[i].length; j++) {
		aggDepth += lake[i][j];
	    }
	}
        return aggDepth * 72 * 72;
    }

    public static void main(String[args]) {
	System.out.println(volume());
    }
}
