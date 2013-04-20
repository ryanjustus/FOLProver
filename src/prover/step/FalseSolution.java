package prover.step;

import prover.Sentence;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/6/12
 * Time: 7:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class FalseSolution extends Step {
	public final static Source source = Source.EXAUSTIVE_SEARCH;
	public FalseSolution(int num){
		super(num, Sentence.EMPTY);
	}

	public String toString(){
		return getNum()+": "+source+"\n\tSolution: No";
	}

	public Source getSource(){
		return source;
	}
}
