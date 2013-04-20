package prover;

import org.antlr.runtime.tree.Tree;
import parser.CNFCompiler;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Variable implements Parameter {
	final String name;
	public Variable(Tree ast){
		name = ast.getText();
	}

	private Variable(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}
	public String toString(){
		return name;
	}

	public Parameter renameVariable(Map<Variable,Parameter> nameMap){
		if(nameMap.containsKey(this)){
			return nameMap.get(this);
		}else{
			return this;
		}
	}

	public List<Variable> getVariables() {
		return Arrays.asList(this);
	}

	public List<Constant> getConstants() {
		return Collections.emptyList();
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + name.hashCode();
		return hash;
	}

	public boolean equals(Object o){
		if(o instanceof Variable){
			return name.equals(((Variable) o).getName());
		}
		return false;
	}

	public int compareTo(Parameter o) {
		return this.toString().compareTo(o.toString());
	}

	public static Variable fromString(String source){
		return CNFCompiler.compileVariable(source);
	}
}