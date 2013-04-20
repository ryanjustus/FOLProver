package prover;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/8/12
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class FunctionTest extends TestCase {
	public void testRenameVariables() throws Exception {
		{
			Function f = Function.fromString("F(x,A,y)");
			Map<Variable,Parameter> nameMap = new HashMap<Variable, Parameter>();
			nameMap.put(Variable.fromString("x"), Variable.fromString("a"));
			Function renamed = f.renameVariable(nameMap);
			assertEquals(renamed,Function.fromString("F(a,A,y)"));
		}

		{
			Function f = Function.fromString("F(x,A,y)");
			//Nothing should change here
			Map<Variable,Parameter> nameMap = new HashMap<Variable, Parameter>();
			nameMap.put(Variable.fromString("fake"), Variable.fromString("a"));
			Function renamed = f.renameVariable(nameMap);
			assertEquals(f,renamed);
		}

		{
			//Harder deep rename
			Function f = Function.fromString("F(x,A,G(x,F(A,B,x)))");
			Map<Variable,Parameter> nameMap = new HashMap<Variable, Parameter>();
			nameMap.put(Variable.fromString("x"), Variable.fromString("a"));
			Function renamed = f.renameVariable(nameMap);
			assertEquals(renamed,Function.fromString("F(a,A,G(a,F(A,B,a)))"));
		}
	}

}
