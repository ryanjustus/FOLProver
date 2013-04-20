package prover.step;

import prover.Sentence;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/10/12
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Given extends Step {
	private final Sentence s;
	final static Source source = Source.GIVEN;
 	public Given(Sentence s, int num){
		 super(num,s);
		 this.s=s;
	 }


	public String toString(){
		return getNum()+": "+source+"\n\t"+s;
	}

	public Source getSource(){
		return source;
	}
}
