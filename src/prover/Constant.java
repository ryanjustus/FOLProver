package prover;

import org.antlr.runtime.tree.Tree;
import parser.CNFCompiler;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Constant implements Parameter{
	private final String name;
	public Constant(Tree ast){
		name = ast.getText();
	}

	private Constant(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public String toString(){
		return name;
	}

	public List<Variable> getVariables(){
		return Collections.EMPTY_LIST;
	}

	public List<Constant> getConstants(){
		return Arrays.asList(this);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + name.hashCode();
		return hash;
	}

	public Constant renameVariable(Map<Variable,Parameter> nameMap){
		return this;
	}

	public boolean equals(Object o){
		if(o instanceof Constant){
			return name.equals(((Constant) o).getName());
		}
		return false;
	}

	public int compareTo(Parameter o) {
		return this.toString().compareTo(o.toString());
	}

	public static Constant fromString(String source){
		return CNFCompiler.compileConstant(source);
	}
}
