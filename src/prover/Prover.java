package prover;

import parser.CNFCompiler;
import prover.step.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/6/12
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Prover {
	public static void main(String[] args){
	 	solve2();
	}

	public static void solve1(){
		try{
			String s =
					"Angry(Bob)?\n" +
							"Hungry(x) | ~Happy(x).\n" +
							"~Person(y) | ~Problem(x) | Solved(y,x) | Frustrated(y).\n" +
							"~Frustrated(x) | Happy(x) | Angry(x).\n" +
							"~Hungry(Bob).\n" +
							"Person(Bob).\n" +
							"Problem(AI).\n" +
							"~Solved(Bob,AI).";

			Theorem t = CNFCompiler.compileTheorem(s);
			System.out.println(t.toString());
			Theorem solved = t.resolve();
			int i=1;
			for(Step step: solved.getSteps()){
				System.out.println((i++)+"::"+step);
			}

		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}

	public static void solve2(){
		try{
			String s =
				"Kills(Curiosity,Tuna)?\n"+
				"Animal(F(x)) | Loves(G(x),x).\n"  +
				"~Loves(x,F(x)) | Loves(G(x),x).\n"+
				"~Animal(y) | ~Kills(x,y) | ~Loves(z,x).\n"+
				"~Animal(x) | Loves(Jack,x).\n"+
				"Kills(Jack,Tuna) | Kills(Curiosity, Tuna).\n"+
				"Cat(Tuna).\n"+
				"~Cat(x) | Animal(x).\n";

			Theorem t = CNFCompiler.compileTheorem(s);
			System.out.println(t.toString());
			Theorem solved = t.resolve();
			int i=1;
			for(Step step: solved.getSteps()){
				System.out.println((i++)+"::"+step);
			}

		}catch(Exception e){
			e.printStackTrace(System.out);
		}
	}
}
