package prover;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/9/12
 * Time: 2:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class UnifierTest extends TestCase {
	public void testUnify() throws Exception {
		{
			System.out.println("*************");
			Sentence s1 = Sentence.fromString("P(x)|Q(x).");
			Sentence s2 = Sentence.fromString("~P(A).");
			System.out.println(s1);
			System.out.println(s2);
			System.out.println("------------");
			Sentence unified = Unifier.unify(s1,s2);
			System.out.println(unified);
		}

		{
			System.out.println("*************");
			Sentence s1 = Sentence.fromString("P(x)|Q(x).");
			Sentence s2 = Sentence.fromString("~P(A)|R(b).");
			System.out.println(s1);
			System.out.println(s2);
			System.out.println("------------");
			Sentence unified = Unifier.unify(s1,s2);
			System.out.println(unified);
		}

		{
			System.out.println("*************");
			Sentence s1 = Sentence.fromString(" P(x,G(A)) | Q(x).");
			Sentence s2 = Sentence.fromString("~P(A,G(y)) | R(y).");
			System.out.println(s1);
			System.out.println(s2);
			System.out.println("------------");
			Sentence unified = Unifier.unify(s1,s2);
			System.out.println(unified);
		}


		{
			System.out.println("*************");
			Sentence s1 = Sentence.fromString(" P(x,G(F(x))) | Q(x).");
			Sentence s2 = Sentence.fromString("~P(A,y) | R(y).");
			System.out.println(s1);
			System.out.println(s2);
			System.out.println("------------");
			Sentence unified = Unifier.unify(s1,s2);
			System.out.println(unified);
		}

		{
			System.out.println("*************");
			Sentence s1 = Sentence.fromString(" P(x,G(F(x))) | Q(x).");
			Sentence s2 = Sentence.fromString("~P(A,y) | R(y)|~Q(B).");
			System.out.println(s1);
			System.out.println(s2);
			System.out.println("------------");
			Sentence unified = Unifier.unify(s1,s2);
			System.out.println(unified);
		}
	}

	public void testReplace(){
		{
			System.out.println("*************");
			Sentence s1 = Sentence.fromString(" P(x,G(A)) | Q(x).");
			Sentence s2 = Sentence.fromString("~P(A,G(y)) | R(y).");
			System.out.println(s1);
			System.out.println(s2);
			System.out.println("------------");
			Sentence unified = Unifier.unify(s1,s2);
			System.out.println(unified);
		}

	}

	public void testUnifyVariable() throws Exception {

		//Simple mapping x->F(y)
		{
			System.out.println("Case 4");
			Variable x = Variable.fromString("x");
			Function f = Function.fromString("F(y)");
			Map<Variable,Parameter> varMap = new HashMap<Variable, Parameter>();
			boolean success = Unifier.unifyVariable(x,f,varMap);
			assertTrue(success);
			assertTrue(varMap.containsKey(x));
			assertTrue(varMap.containsValue(f));
			System.out.println(varMap);
		}

		//Fail on x->F(x) infinite recursion cases
		{
			System.out.println("Case 3");
			Variable x = Variable.fromString("x");
			Function f = Function.fromString("F(x)");
			Map<Variable,Parameter> varMap = new HashMap<Variable, Parameter>();
			boolean success = Unifier.unifyVariable(x,f,varMap);
			assertFalse(success);
			assertFalse(varMap.containsKey(x));
			assertFalse(varMap.containsValue(f));
			System.out.println(varMap);
		}

		//Case 1
		{
			System.out.println("Case 1");
			Variable x = Variable.fromString("x");
			Function gz = Function.fromString("F(A)");
			Function fy = Function.fromString("F(y)");

			//instantiate map with x->F(y)
			Map<Variable,Parameter> varMap = new HashMap<Variable, Parameter>();
			varMap.put(x,fy);


			boolean success = Unifier.unifyVariable(x,gz,varMap);
			System.out.println(varMap);
		}

		//Case 2
		{
			System.out.println("Case 2");
			Variable x = Variable.fromString("x");
			Variable y = Variable.fromString("y");
			Constant A = Constant.fromString("A");

			//instantiate map with x->F(y)
			Map<Variable,Parameter> varMap = new HashMap<Variable, Parameter>();
			varMap.put(y,A);


			boolean success = Unifier.unifyVariable(x,y,varMap);
			System.out.println(varMap);
		}


	}

	public void testIsNormalized(){
		Sentence s1 = Sentence.fromString("~Animal(a)|~Kills(b,a)|~Loves(c,b).");
		Sentence s2 = Sentence.fromString("Animal(F(a))|Loves(G(a),a).");
		Sentence unified = Unifier.unify(s1,s2);
		System.out.println(unified);
		System.out.println(unified.normalizeVarNames(new VariablePool()));
	}

	public void testFailure(){

		/*
			This is where it is failing
			Kills(Curiosity,Tuna)|Kills(Jack,Tuna).
			~Animal(y)|~Kills(x,y)|~Loves(z,x).
			------------------------
			~Animal(Tuna)|~Animal(a)|~Loves(b,Curiosity)|~Loves(b,c).
		 */
		Sentence s1 = Sentence.fromString("Kills(Curiosity,Tuna)|Kills(Jack,Tuna).");
		Sentence s2 = Sentence.fromString("~Animal(y)|~Kills(x,y)|~Loves(z,x).");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("----------------------------");
		System.out.println(Unifier.unify(s1,s2));


	}

	public void testFailure2(){

		/*
			This is where it is failing
			Kills(Curiosity,Tuna)|Kills(Jack,Tuna).
			~Animal(y)|~Kills(x,y)|~Loves(z,x).
			------------------------
			~Animal(Tuna)|~Animal(a)|~Loves(b,Curiosity)|~Loves(b,c).
		 */
		Sentence s1 = Sentence.fromString("Loves(G(b),b)|~Loves(b,F(b)).");
		Sentence s2 = Sentence.fromString("~Animal(c)|~Kills(d,c)|~Loves(e,d).");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("----------------------------");
		//Bad ~Animal(b)|~Kills(b,b)|~Loves(b,F(b)).
		System.out.println(Unifier.unify(s1,s2));


	}

	public void testFailure3(){

		/*
			This is where it is failing
			Kills(Curiosity,Tuna)|Kills(Jack,Tuna).
			~Animal(y)|~Kills(x,y)|~Loves(z,x).
			------------------------
			~Animal(Tuna)|~Animal(a)|~Loves(b,Curiosity)|~Loves(b,c).
		 */

		Sentence s1 = Sentence.fromString("~Kills(d,F(a))|Loves(G(a),a)|~Loves(e,d).");
		Sentence s2 = Sentence.fromString("~Animal(c)|~Kills(d,c)|~Loves(e,d).");

		//Bad ~Animal(b)|~Kills(b,b)|~Loves(b,F(b)).
		Sentence unified = Unifier.unify(s1,s2);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println("----------------------------");
		System.out.println(unified);

		/*
		Loves(G(a),a)/~Loves(e,d)
		{d=a, e=G(a)}
		15: Resolved: 14,3
			~Kills(d,F(a))|Loves(G(a),a)|~Loves(e,d).
			~Animal(c)|~Kills(d,c)|~Loves(e,d).
			------------------------
			~Animal(c)|~Kills(a,F(a))|~Loves(G(a),a).
		 */


	}


	public void testFailure4(){

		/*
			This is where it is failing
			Kills(Curiosity,Tuna)|Kills(Jack,Tuna).
			~Animal(y)|~Kills(x,y)|~Loves(z,x).
			------------------------
			~Animal(Tuna)|~Animal(a)|~Loves(b,Curiosity)|~Loves(b,c).
		 */

		Sentence s1 = Sentence.fromString("~Animal(c)|~Kills(a,c)|Loves(Jack,F(a)).");
		Sentence s2 = Sentence.fromString("~Animal(c)|~Kills(d,c)|~Loves(e,d).");

		//Bad ~Animal(b)|~Kills(b,b)|~Loves(b,F(b)).
		Sentence unified = Unifier.unify(s1,s2);

		System.out.println(s1);
		System.out.println(s2);
		System.out.println("----------------------------");
		System.out.println(unified);



		/*
			Loves(Jack,F(a))/~Loves(e,d)
			{d=F(a), e=Jack}
			44: Resolved: 20,3
				~Animal(c)|~Kills(a,c)|Loves(Jack,F(a)).
				~Animal(c)|~Kills(d,c)|~Loves(e,d).
				------------------------
				~Animal(c)|~Kills(a,c).

		 */


	}


	public void test3(){
		Predicate p1 = Predicate.fromString("Loves(G(x),x)");
		Predicate p2 = Predicate.fromString("~Loves(z,Jack)");
		HashMap<Variable,Parameter> varMap = new HashMap<Variable, Parameter>();
		boolean success = Unifier.unifyPredicate(p1,p2, varMap);
		System.out.println(success);
		System.out.println(varMap);

		Sentence s1 = Sentence.fromString("~Animal(Tuna) | ~Loves(z, Jack).");
		Sentence s2 = Sentence.fromString("Animal(F(x)) | Loves(G(x), x).");
		System.out.println(Unifier.unify(s1,s2));

	}

	public void testNullPointer(){
		Sentence s1 = Sentence.fromString("~Cat(Curiosity)|Loves(Jack,F(Jack)).");
		Sentence s2 = Sentence.fromString("Loves(G(b),b)|~Loves(b,F(b)).");

		Sentence union = Unifier.unify(s1,s2);
		System.out.println(union);
	}

	public void testFail(){

		Sentence s1 = Sentence.fromString("Frustrated(b)|~Person(b)|~Problem(c)|Solved(b,c).");
		Sentence s2 = Sentence.fromString("Problem(AI).");
		System.out.println(Unifier.unify(s1,s2));
	}

	public void testRecursion()	//Case recursion
	{

		{

			System.out.println("****************");
			Sentence s1 = Sentence.fromString("~Animal(b)|~Kills(F(a),F(a))|~Loves(a,a).");
			Sentence s2 = Sentence.fromString("Animal(F(a))|Loves(G(b),b).");

			Sentence unified = Unifier.unify(s1,s2);
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(unified);
		}
	}

	public void test2aaa(){
		Sentence s1 = Sentence.fromString("~Loves(e, Jack).");
		Sentence s2 = Sentence.fromString("~Loves(b, F(beer)) | Loves(G(beer), b).");
		Sentence unified = Unifier.unify(s1,s2);
		System.out.println(unified);
	}
}
