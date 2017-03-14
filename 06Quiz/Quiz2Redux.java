import java.util.*;
public class Quiz2Redux {
    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	help(s, words, 0, "");
	Collections.sort(words);
	return words;
    }
    private static void help(String s, ArrayList<String> words, int index, String add) {
	if(index == s.length()){
	    words.add(add);
	    return;
	}
	help(s, words, index + 1, add + s.charAt(index));
	help(s, words, index + 1, add);	
    }
    /*
    public static void main(String[] args){
        if(combinations("abcdef").size() == 64) {
	    System.out.println("yes");
	}
    }
    */
}
