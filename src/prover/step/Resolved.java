package prover.step;

import prover.Sentence;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/6/12
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Resolved extends Step {
	final Step s1;
	final Step s2;
	final static Source source = Source.RESOLUTION;
	public Resolved(Step s1, Step s2, Sentence derived, int num){
		super(num,derived);
		this.s1=s1;
		this.s2=s2;
	}

	public Source getSource(){
		return source;
	}

	public String toString(){
		return getNum()+": Resolved: "+s1.getNum()+","+s2.getNum()+"\n\t"+
				s1.getSentence()+"\n\t"+
				s2.getSentence()+"\n\t"+
				"------------------------\n\t"+
				getSentence();
	}
}
