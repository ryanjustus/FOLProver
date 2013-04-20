package prover.step;

import prover.Sentence;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/11/12
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Step implements Comparable<Step>{
	private final int num;
	private final Sentence derived;


	public Step(int num, Sentence derived){
		this.derived=derived;
		this.num=num;
	}

	public int getNum(){
		return num;
	}

	public Sentence getSentence(){
		return derived;
	}

	public int compareTo(Step other){
		return this.getNum()-other.getNum();
	}

	public abstract Source getSource();
}
