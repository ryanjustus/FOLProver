package prover;

import org.antlr.runtime.tree.Tree;
import parser.CNFCompiler;
import parser.CNFParser;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class Predicate implements Comparable<Predicate>{
	final boolean sign;
	final String name;
	private final List<Parameter> parameters;

	public Predicate(Predicate other){
		this.name=other.name;
		parameters = new ArrayList<Parameter>(other.parameters.size());
		parameters.addAll(other.parameters);
		this.sign=other.sign;
	}

	private Predicate(String name, boolean sign, List<Parameter> parameters){
		this.sign=sign;
		this.parameters=parameters;
		this.name=name;
	}

	public List<Parameter> getParameters(){
		return new ArrayList<Parameter>(parameters);
	}

	public String getName() {
		return name;
	}

	public Predicate(Tree ast){

		parameters = new ArrayList<Parameter>();
		if(ast.getType()==CNFParser.NOT){
			sign=false;
			ast = ast.getChild(0);
		}else{
			sign=true;
		}

		name = ast.getText();
		for(int i=0;i<ast.getChildCount();i++){
			Tree c = ast.getChild(i);
			Parameter p = null;
			switch(c.getType()){
				case CNFParser.CONSTANT:{
					p = new Constant(c);
					break;
				}
				case CNFParser.VARIABLE:{
					p = new Variable(c);
					break;

				}
				case CNFParser.FUNCTION:{
					p = new Function(c);
					break;
				}
				default:{
					throw new IllegalStateException("Invalid Token:" +c);
				}
			}
			parameters.add(p);
		}
	}

	public Predicate renameVariables(Map<Variable,Parameter> nameMap){
		List<Parameter> renamedParameters = new ArrayList<Parameter>(this.parameters.size());
		for(Parameter p: parameters){
			renamedParameters.add(p.renameVariable(nameMap));
		}
		return new Predicate(this.name,this.sign,renamedParameters);
	}

	public Predicate negate(){
		Predicate negative = new Predicate(this.name,!this.sign, this.parameters);
		return negative;
	}


	public String toString(){
		String ret = "";
		if(!sign)
			ret+="~";
		ret+=this.name+"(";
		ret+=parameters.get(0);
		for(int i=1;i<parameters.size();i++){
			ret+=","+parameters.get(i);
		}
		ret+=")";
		return ret;
	}

	Set<Constant> getConstants(){
		Set<Constant> constants = new HashSet<Constant>();
		for(Parameter p: parameters){
			if(p instanceof  Constant){
				constants.add((Constant)p);
			}
		}
		return constants;
	}

	public List<Variable> getVariables(){
		List<Variable> variables = new ArrayList<Variable>();
		for(Parameter p: parameters){
			List<Variable> sublist = p.getVariables();
			for(Variable v: sublist){
				if(!variables.contains(v)){
					variables.add(v);
				}
			}
		}
		return variables;
	}

	public Parameter getParameter(int idx){
		return parameters.get(idx);
	}

	public int hashCode(){
		int hash = 3;
		hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
		hash = 47 * hash + (this.sign ? 1 : 0);
		hash = 47 * hash + (this.parameters != null ? this.parameters.hashCode() : 0);
		return hash;

	}

	public boolean equals(Object o){
		if(o instanceof Predicate){
			Predicate p = (Predicate)o;
			if(name.equals(p.name) && sign==p.sign)
			{
				if(parameters.size()!=p.parameters.size())
					return false;
				for(int i=0;i<parameters.size();i++){
			       Parameter p1 = parameters.get(i);
				   Parameter p2 = p.parameters.get(i);
				   if(p1 instanceof Variable && p2 instanceof Variable){
					   return true;
				   }else{
					   return p1.equals(p2);
				   }
				}
			}
		}
		return false;
	}

	public int compareTo(Predicate o) {
		if(name.equals(o.name)){
			return toString().compareTo(o.toString());
		}else{
			return name.compareTo(o.name);
		}
	}

	public static Predicate fromString(String source){
		return CNFCompiler.compilePredicate(source);
	}
}
