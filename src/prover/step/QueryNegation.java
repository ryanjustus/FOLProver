package prover.step;

import prover.Query;
import prover.Sentence;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/11/12
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class QueryNegation extends Step {
	Query q;
	Sentence derived;
	final static Source source = Source.QUERY_NEGATION;

	public QueryNegation(Query q, Sentence derived, int num){
		super(num,derived);
		this.q=q;
		this.derived=derived;
	}

	public String toString(){
		return getNum()+": "+source+"\n\t"+q+"\n\t------------------------\n\t"+derived;
	}

	public Source getSource(){
		return source;
	}
}
