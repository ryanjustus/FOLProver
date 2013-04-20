package prover;

import junit.framework.TestCase;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/8/12
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConstantTest extends TestCase {
	public void testGetName() throws Exception {
		Constant c = Constant.fromString("C");
		assertTrue(c.getName().equals("C"));
	}

	public void testToString() throws Exception {
		Constant c = Constant.fromString("C");
		assertTrue(c.toString().equals("C"));
	}


	public void testCompareTo() throws Exception {
		Constant c1 = Constant.fromString("A");
		Constant c2 = Constant.fromString("C");
		assertTrue(c1.compareTo(c2)<0);
	}

	public void testFromString() throws Exception {
		Constant c1 = Constant.fromString("C");
		Constant c2 = Constant.fromString("C");
		assertTrue(c1.equals(c2));
		assertTrue(c1.toString().equals(c2.toString()));
	}

}
