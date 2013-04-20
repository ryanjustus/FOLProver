package prover.step;

import prover.Sentence;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/6/12
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrueSolution extends Step {
	final Step s1;
	final Step s2;
	final static Source source = Source.RESOLUTION;

	public TrueSolution(Step s1, Step s2, int num){
		super(num, Sentence.EMPTY);
		this.s1=s1;
		this.s2=s2;
	}

	public int hashCode(){
		int hash = 5;
		hash = 97 * hash + s1.hashCode();
		hash = 97 * hash + s2.hashCode();
		return hash;
	}

	public boolean equals(Object o){
		if(o instanceof Resolved){
			Resolved d = (Resolved)o;
			return (s1.equals(d.s1) && s2.equals(d.s2));
		}
		return false;
	}

	public String toString(){
		return getNum()+": Solution: "+s1.getNum()+","+s2.getNum()+"\n\t"+
				s1.getSentence()+"\n\t"+
				s2.getSentence()+"\n\t"+
				"------------------------\n\t"+
				"Contradiction -> Yes";
	}

	public Source getSource(){
		return source;
	}
}
