package prover;

import org.antlr.runtime.tree.Tree;
import parser.CNFCompiler;
import parser.CNFParser;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 9:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Function implements Parameter{
	private final String name;
	private final Parameter parameter;

	public Function(Tree t){
		name = t.getChild(0).getText();

		Tree c = t.getChild(1);
		switch(c.getType()){
			case CNFParser.CONSTANT:{
				parameter = new Constant(c);
				break;
			}
			case CNFParser.VARIABLE:{
				parameter = new Variable(c);
				break;

			}
			case CNFParser.FUNCTION:{
				parameter = new Function(c);
				break;
			}
			default:{
				throw new IllegalStateException("Invalid Token:" +c);
			}
		}
	}

	private Function(String name, Parameter p){
		this.name=name;
		this.parameter=p;

	}

	public Function renameVariable(Map<Variable,Parameter> nameMap){
		Parameter renamed = parameter.renameVariable(nameMap);
		if(renamed==null){
			throw new NullPointerException();
		}
		return  new Function(name, renamed);
	}


	public List<Variable> getVariables() {
		return new ArrayList<Variable>(parameter.getVariables());
	}

	public List<Constant> getConstants() {
		return new ArrayList<Constant>(parameter.getConstants());
	}

	public Parameter getParameter(){
		return parameter;
	}

	public String getName(){
		return name;
	}

	public int hashCode(){
		int hash = 3;
		hash = 59 * hash + name.hashCode();
		hash = 59 * hash + parameter.hashCode();
		return hash;
	}

	public boolean equals(Object o){
		if(o instanceof Function){
			Function f = (Function)o;
			return (name.equals(f.name) && parameter.equals(f.parameter));
		}
		return false;
	}

	public String toString(){
		String ret = "";
		ret+=this.name+"(";
		ret+=parameter.toString();
		ret+=")";
		return ret;
	}

	public int compareTo(Parameter o) {
		return this.toString().compareTo(o.toString());
	}

	public static Function fromString(String source){
		return CNFCompiler.compileFunction(source);
	}
}
