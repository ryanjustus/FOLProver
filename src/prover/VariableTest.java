package prover;

import junit.framework.TestCase;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/8/12
 * Time: 7:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class VariableTest extends TestCase {
	public void testGetName() throws Exception {
		Variable v = Variable.fromString("x");
		assertTrue(v.getName().equals("x"));
	}

	public void testRenameVariables() throws Exception {
		Variable v = Variable.fromString("x");

		Map<Variable,Parameter> nameMap = new HashMap<Variable, Parameter>();
		nameMap.put(Variable.fromString("x"), Variable.fromString("y"));
		Parameter after=v.renameVariable(nameMap);

		assertTrue(after.getName().equals("y"));

		assertTrue(v.getName().equals("x")); //Variable is immutable so it shouldn't change

		nameMap.clear();
		nameMap.put(Variable.fromString("y"), Variable.fromString("z"));
		after = v.renameVariable(nameMap);
		System.out.println(v);
		System.out.println(nameMap);
		System.out.println(after);
		assertTrue(after.getName().equals("x")); //Shouldn't have changed because name didn't match from variable
	}


	public void testEquals() throws Exception {
		assertEquals(Variable.fromString("x"), Variable.fromString("x"));
		assertFalse(Variable.fromString("x").equals(Variable.fromString("y")));
	}

}
