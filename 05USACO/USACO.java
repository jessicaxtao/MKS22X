//Khyber was my partner
import java.util.*;
import java.io.*;

public class USACO {
    int[][] lake;
    int R, C, E, N = -1;
    int volume = 0;

    int n, M, T, R1, C1, R2, C2 = -1;
    int[][] cow;

    public int silver(String filename) {
	try{
	    Scanner scanny = new Scanner(new File(filename));
	    n = Integer.parseInt(scanny.next());
	    M = Integer.parseInt(scanny.next());
	    T = Integer.parseInt(scanny.next());
	    cow = new int[n][M];
	    scanny.nextLine();
	    
	    String line = "";
	    for(int i = 0; i < n; i++) {
		line = scanny.nextLine();
		//System.out.println(line);
		for (int r = 0; r < M; r++) {
		    if (line.charAt(r) == '*') {
			cow[i][r] = -1;
		    }
		    if (line.charAt(r) == '.') {
			cow[i][r] = 0;
		    }
		}
	    }  
	    R1 = Integer.parseInt(scanny.next()) - 1;
	    C1 = Integer.parseInt(scanny.next()) - 1;
	    R2 = Integer.parseInt(scanny.next()) - 1;
	    C2 = Integer.parseInt(scanny.next()) - 1;
	}catch(FileNotFoundException e) {
	    System.out.println("check your filename");
	    System.exit(1);
	}
	return silverH(cow, T);
    }
    
   private int silverH(int[][] cow, int time){
	int times = 0;
	
	for(int i = 0; i <= time; i++){
	    int[][] count = new int[n][M];
	    for (int r = 0; r < n; r++){
		for (int c = 0; c < M; c++){
		    if (i == 0){
			count[R1][C1] = 1;
		    }
		    if(cow[r][c]==-1){
			count[r][c] = -1;
		    }
		    if(r >= 1 && cow[r-1][c] > 0){
			count[r][c] += cow[r-1][c];
		    }
		    if(c >= 1 && cow[r][c-1] > 0){
			count[r][c] += cow[r][c-1];
		    }
		    if(r < n - 1 && cow[r+1][c] > 0){
		        count[r][c] += cow[r+1][c];
		    }
		    if(c < M - 1 && cow[r][c+1] > 0){
		        count[r][c] += cow[r][c+1];
		    }
		    if(cow[r][c]==-1){
			count[r][c] = -1;
		    }

		}
	    }
	    cow = count;
	}

	times = cow[R2][C2];

	return times;
    }

    public USACO() {
    }
    
    public int bronze(String filename) {
	int[][] stompInstruc;
	
	try {
	    Scanner bob = new Scanner(new File(filename));
	    R = Integer.parseInt(bob.next());
	    C = Integer.parseInt(bob.next());
	    E = Integer.parseInt(bob.next());
	    N = Integer.parseInt(bob.next());
	    	    
	    lake = new int[R][C];
	    for(int i = 0; i < R; i++) {
		for(int j = 0; j < C; j++) {
		    lake[i][j] = Integer.parseInt(bob.next());
		}
	    }
	    
	    stompInstruc = new int[N][3];
	    for(int i = 0; i < N; i++) {
		for(int j = 0; j < 3; j++) {
		    stompInstruc[i][j] = Integer.parseInt(bob.next());
		}
	    }

	    for(int i = 0; i < N; i++) {
		stomp(stompInstruc[i][0] - 1, stompInstruc[i][1] - 1, stompInstruc[i][2]);
	    }
	}catch(FileNotFoundException e) {
	    System.out.println("uh check the file name");
	    System.exit(1);
	}
	volume();
	return volume;
    }

    public void stomp(int R_s, int C_s, int D_s) {
	int highest = 0;
	for(int i = 0; i < 3; i++) {
	    for(int j = 0; j < 3; j++) {
		if(R_s + i < R && C_s + j < C) {
		    if(lake[R_s + i][C_s + j] > highest) {
			highest = lake[R_s + i][C_s + j];
		    }
		}
	    }
	}
	int diggyLevel = highest - D_s;
	//realized that this was the easier way to go through the thing welp
	for(int i = R_s; i < R_s + 3; i++) {
	    for(int j = C_s; j < C_s + 3; j++) {
		if(i < R && j < C) {
		    if(lake[i][j] > diggyLevel) {
			lake[i][j] = diggyLevel;
		    }
		}
	    }
	}
	    
    }

    public void volume() {
	int aggDepth = 0;
	for(int i = 0; i < lake.length; i++) {
	    for(int j = 0; j < lake[i].length; j++) {
		if((E - lake[i][j]) > 0) {
		    aggDepth += (E - lake[i][j]);
		}
	    }
	}
	volume = aggDepth * 72 * 72;
    }

    public static void main(String[] args) {
	USACO x = new USACO();
	System.out.println(x.silver("testfile2"));
    }
}
