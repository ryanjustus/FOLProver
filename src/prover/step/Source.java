package prover.step;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/11/12
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Source {
	GIVEN("Given"),
	RESOLUTION("Resolution"),
	QUERY_NEGATION("Query Negation"),
	EXAUSTIVE_SEARCH("Exaustive Search");

	private final String text;
	Source(String text){
		this.text=text;
	}

	public String toString(){
		return text;
	}
}
