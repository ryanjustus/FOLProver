package prover;

import prover.step.Step;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/18/12
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		File f;
		if(args.length==0){
			System.out.println("Usage: java -jar ResolutionLab.jar input.txt");
			return;
		}else{
			f = new File(args[0]);
			if(!f.exists()){
				System.out.println("Unknown file: "+f);
				return;
			}
		}

		Scanner s = new Scanner(f);
		String t = "";
		while(s.hasNextLine()){
			t+=s.nextLine();
		}
		Theorem theorem = Theorem.fromString(t);
		theorem = theorem.resolve();
		for(Step step: theorem.getSteps()) {
			System.out.println(step.toString());
		}
	}
}
