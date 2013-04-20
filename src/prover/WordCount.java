package prover;
import java.util.*;
public class WordCount {
	static Map<String,Integer> wordCount = new HashMap<String,Integer>();
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext("[\\S]+"))
			increment(s.next("[\\S]+"));
	}
	static void increment(String word){
		if(!wordCount.containsKey(word))
			wordCount.put(word,1);
		else
			wordCount.put(word,wordCount.get(word)+1);
	}
}
