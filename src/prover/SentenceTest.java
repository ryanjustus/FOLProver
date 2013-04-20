package prover;

import junit.framework.TestCase;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/9/12
 * Time: 6:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class SentenceTest extends TestCase {
	public void testGetPredicates() throws Exception {

	}

	public void testIsEmpty() throws Exception {
		Sentence s1 = Sentence.fromString("P(x).");
		Set<Predicate> preds = s1.getPredicates ();
		for(Predicate p: preds){
			s1 = s1.removePredicate(p);
		}
		assertTrue(s1.isEmpty());
	}


	public void testNormalizeVarNames() throws Exception {
		{
			Sentence s = Sentence.fromString("P(x).");
			Sentence after = Sentence.fromString("P(a).");
			Sentence normalized = s.normalizeVarNames(new VariablePool());
			System.out.println(normalized);
			assertEquals(s.normalizeVarNames(new VariablePool()), after);
		}

		{
			Sentence s = Sentence.fromString("P(x)|P(y).");
			Sentence after = Sentence.fromString("P(a)|P(b).");
			Sentence normalized = s.normalizeVarNames(new VariablePool());
			System.out.println(normalized);
			assertEquals(s.normalizeVarNames(new VariablePool()), after);
		}

		{
			Sentence s = Sentence.fromString("P(x)|Q(x).");
			Sentence after = Sentence.fromString("P(a)|Q(a).");
			Sentence normalized = s.normalizeVarNames(new VariablePool());
			System.out.println(normalized);
			assertEquals(s.normalizeVarNames(new VariablePool()), after);
		}

		{
			Sentence s = Sentence.fromString("P(x)|Q(F(G(z,x),y)).");
			Sentence after = Sentence.fromString("P(a)|Q(F(G(b,a),c)).");
			Sentence normalized = s.normalizeVarNames(new VariablePool());
			System.out.println(normalized);
			assertEquals(s.normalizeVarNames(new VariablePool()), after);
		}

		{

			Sentence s = Sentence.fromString("P(x)|Q(F(G(z,x),y)).");
			Sentence after = Sentence.fromString("P(a)|Q(F(G(b,a),c)).");
			Sentence normalized = s.normalizeVarNames(new VariablePool());
			System.out.println(normalized);

			Sentence s2 = Sentence.fromString("P(x)|Q(F(G(z,x),y)).");
			Sentence after2 = Sentence.fromString("P(a)|Q(F(G(b,a),c)).");
			VariablePool pool2 = new VariablePool();
			pool2.setUsed(after.getVariables());
			Sentence normalized2 = s.normalizeVarNames(pool2);
			System.out.println(normalized2);
			assertEquals(s.normalizeVarNames(new VariablePool()), after);
		}

	}

	public void testNormalizedFail(){
		Sentence s1 = Sentence.fromString(" ~Kills(b,a)|Loves(G(d),d)|~Loves(c,b).");
		Sentence precalced = Sentence.fromString(" ~Kills(a,b)|Loves(G(c),c)|~Loves(d,a).");
		assertEquals(precalced,s1.normalizeVarNames(new VariablePool()));
	}

	public void testRenameVariables() throws Exception {

	}

	public void testGetVariables() throws Exception {
		Sentence s = Sentence.fromString("P(x)|Q(F(G(A,x),y)).");
		List<Variable> vars = s.getVariables();
		System.out.println(vars);
	}


	public void testUnion(){

		Sentence s1 = Sentence.fromString("~Animal(c)|~Kills(a,c).");
		Sentence s2 = Sentence.fromString("~Animal(c)|~Kills(F(a),c).");

		assertEquals(s1.union(s2),s2.union(s1));
		assertEquals(Sentence.fromString("~Animal(c)|~Kills(a,c)|~Kills(F(a),c)."),s1.union(s2));
	}
	public void testHashCode() throws Exception {

	}

	public void testEquals() throws Exception {

	}

	public void testCompareTo() throws Exception {

	}

	public void testFromString() throws Exception {

	}

}
