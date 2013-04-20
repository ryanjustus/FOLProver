package prover;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/9/12
 * Time: 7:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class PredicateTest extends TestCase {
	public void testGetParameters() throws Exception {

	}

	public void testGetName() throws Exception {
		{
			Predicate p = Predicate.fromString("P(x)");
			System.out.println(p);
			assertEquals(p.getName(),"P");
		}

		{
			Predicate p = Predicate.fromString("~P(x)");
			System.out.println(p);
			assertEquals(p.getName(),"P");
		}
	}

	public void testRenameVariables() throws Exception {
		{
			Predicate p = Predicate.fromString("~P(x)");
			Predicate precalced = Predicate.fromString("~P(a)");
			Map<Variable,Parameter> nameMap = new HashMap<Variable, Parameter>();
			nameMap.put(Variable.fromString("x"), Variable.fromString("a"));
			p=p.renameVariables(nameMap);
			assertEquals(p,precalced);
		}

		{
			Predicate p = Predicate.fromString("~P(x,y)");
			Predicate precalced = Predicate.fromString("~P(a,y)");
			Map<Variable,Parameter> nameMap = new HashMap<Variable, Parameter>();
			nameMap.put(Variable.fromString("x"), Variable.fromString("a"));
			p=p.renameVariables(nameMap);
			assertEquals(p,precalced);
		}

		{
			Predicate p = Predicate.fromString("~P(F(x),y)");
			Predicate precalced = Predicate.fromString("~P(F(y),y)");
			Map<Variable,Parameter> nameMap = new HashMap<Variable, Parameter>();
			nameMap.put(Variable.fromString("x"), Variable.fromString("y"));
			p=p.renameVariables(nameMap);
			assertEquals(p,precalced);
		}

	}

	public void testNegate() throws Exception {
		{
			Predicate p = Predicate.fromString("P(x)");
			Predicate n = Predicate.fromString("~P(x)");
			assertEquals(p.negate(),n);

		}

		{
			Predicate p = Predicate.fromString("P(x)");
			Predicate n = Predicate.fromString("~P(x)");
			assertEquals(p,n.negate());
		}
	}

}
