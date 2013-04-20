package prover;

import junit.framework.TestCase;
import prover.step.Step;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/9/12
 * Time: 8:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class TheoremTest extends TestCase {
	public void testSolve() throws Exception {

		String s =
				"Angry(Bob)?\n" +
				"Hungry(x) | ~Happy(x).\n" +
				"~Person(y) | ~Problem(x) | Solved(y,x) | Frustrated(y).\n" +
				"~Frustrated(x) | Happy(x) | Angry(x).\n" +
				"~Hungry(Bob).\n" + //Toggling to Hungry(Bob) makes it not solvable
				"Person(Bob).\n" +
				"Problem(AI).\n" +
				"~Solved(Bob,AI).";

		Theorem t = Theorem.fromString(s);
		t = t.resolve();
		for(Step step: t.getSteps()) {
			System.out.println(step.toString());
		}

	}

	public void testSolve2() throws Exception {
		//Failure caused by
		/*

		Kills(Jack,Tuna)|~Cat(Tuna)|~Loves(a,Curiosity).
		~Animal(a)|~Kills(b,a)|~Loves(c,b).
		________________
		~Animal(a)|~Cat(Tuna)|~Loves(a,Curiosity)|~Loves(a,a).

		 */
		String s =
				"Kills(Curiosity,Tuna)? "+
				"Animal(F(x)) | Loves(G(x),x). "+
				"~Loves(x,F(x)) | Loves(G(x),x). "+
				"~Animal(y) | ~Kills(x,y) | ~Loves(z,x). "+
				"~Animal(x) | Loves(Jack,x). "+
				"Kills(Jack,Tuna) | Kills(Curiosity, Tuna). "+
				"Cat(Tuna). "+
				"~Cat(x) | Animal(x).";

		Theorem t = Theorem.fromString(s);
		t = t.resolve();
		int i=0;

		for(Step step: t.getSteps()) {
			System.out.println(step.toString());
		}
	}
}
