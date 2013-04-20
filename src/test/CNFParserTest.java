package test;

import parser.*;
import prover.Theorem;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CNFParserTest extends junit.framework.TestCase {
	public void setUp() throws Exception {

	}

	public void tearDown() throws Exception {

	}


	public void testParser(){
		try{
			String s =
					"Kills(Curiosity,Tuna)?\n"+
					"Animal(F(x)) | Loves(G(x),x).\n"  +
					"~Loves(x,F(x)) | Loves(G(x,H(A)),x).\n"+
					"~Animal(y) | ~Kills(x,y) | ~Loves(z,x).\n"+
					"~Animal(x) | Loves(Jack,x).\n"+
					"Kills(Jack,Tuna) | Kills(Curiosity, Tuna).\n"+
					"Cat(Tuna).\n"+
					"~Cat(x) | Animal(x).\n";

			Theorem t = CNFCompiler.compileTheorem(s);
			System.out.println(t.toString());
		}catch(Exception e){
			e.printStackTrace(System.out);
			assertTrue(false);
		}
	}

}
