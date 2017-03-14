import java.util.ArrayList;
import java.lang.Math;
public class Problem {
    public static void combinationH(String s, ArrayList<String> words, int length) {
	words.add(s);
	if(words.size() == length) {
	    return;
	}
	for(int i = 0; i < s.length(); i++){
	    combinationH(s.substring(0, i) + s.substring(i+1), words, length);
	}
    }

    public static void main(String[] args) {
	Problem a = new Problem();
	ArrayList<String> words = new ArrayList<String>();
	String s = "abc";
	combinationH(s, words, s.length());
	String ans = "\"\", ";
	for(int i = 0; i < words.size(); i++) {
	    ans += words.get(i) + ", ";
	}
	System.out.println(ans);
    }
}
