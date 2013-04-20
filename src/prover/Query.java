package prover;

import org.antlr.runtime.tree.Tree;
import parser.CNFCompiler;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 7:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Query  {
	private Set<Sentence> sentences;
	Set<Predicate> preds = new HashSet<Predicate>();

	public Query(Tree ast) {
		sentences = new HashSet<Sentence>();
		for(int i=0;i<ast.getChildCount();i++){
			Tree c = ast.getChild(i);
			Predicate p = new Predicate(c);
			preds.add(p);
			p=p.negate();
			Set<Predicate> predSet = new HashSet<Predicate>();
			predSet.add(p);
			sentences.add(new Sentence(predSet));
		}
	}
	public Set<Sentence> getSentences(){
		return new HashSet<Sentence>(sentences);
	}

	public String toString(){
		String ret = "";
		Iterator<Predicate> itr = preds.iterator();
		while(itr.hasNext()){
			ret+=itr.next().toString();
			if(itr.hasNext()){
				ret+="|";
			}
		}
		return ret+"?";
	}

	public static Query fromString(String source){
		return CNFCompiler.compileQuery(source);
	}
}
