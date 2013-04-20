package prover;
import org.antlr.runtime.tree.Tree;
import parser.CNFCompiler;

import javax.xml.transform.Source;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sentence implements Comparable<Sentence>{
	//Using a sorted set makes comparison easier
	private final SortedSet<Predicate> preds;

	public static final Sentence EMPTY = new Sentence(Collections.EMPTY_SET);

	public Sentence(Tree ast){
		preds = new TreeSet<Predicate>();
		for(int i=0;i<ast.getChildCount();i++){
			Predicate p = new Predicate(ast.getChild(i));
			preds.add(p);
		}
	}


	public SortedSet<Predicate> getPredicates(){
		return new TreeSet<Predicate>(preds);
	}

	public boolean isEmpty(){
		return preds.isEmpty();
	}


	public Sentence(Sentence s){
		this.preds= new TreeSet<Predicate>(s.preds);
	}

	public Sentence(Set<Predicate> preds){
		this.preds= new TreeSet<Predicate>(preds);
	}


	Sentence union(Sentence other){
		Set<Predicate> preds = new TreeSet<Predicate>(this.preds);
		preds.addAll(other.preds);

		return new Sentence(preds);
	}


	Sentence removePredicate(Predicate p){
		Set<Predicate> preds = new HashSet<Predicate>(this.preds);
		preds.remove(p);
		return new Sentence(preds);
	}

	public String toString(){
		String ret = "";
		Iterator<Predicate> itr = preds.iterator();
		while(itr.hasNext()){
			ret+=itr.next().toString();
			if(itr.hasNext()){
				ret+="|";
			}
		}
		return ret+".";
	}

	public Set<Constant> getConstants(){
		Set<Constant> constants = new HashSet<Constant>();
		for(Predicate p: preds){
			constants.addAll(p.getConstants());
		}
		return constants;
	}


	public Sentence normalizeVarNames(VariablePool pool){
		List<Variable> allVars = this.getVariables();
		Sentence after = this;
		Map<Variable,Parameter> varMap = new HashMap<Variable, Parameter>();
		for(Variable v: allVars){
			varMap.put(v,pool.getUnused(v));
		}
		after = renameVariables(varMap);
		return after;
	}


	public Sentence renameVariables(Map<Variable,Parameter> nameMap){
		SortedSet<Predicate> renamed = new TreeSet<Predicate>();
		for(Predicate p: preds){
			renamed.add(p.renameVariables(nameMap));
		}
		return new Sentence(renamed);
	}



	public List<Variable> getVariables(){
		List<Variable> vars = new ArrayList<Variable>();
		for(Predicate p: preds){
			List<Variable> sublist = p.getVariables();
			for(Variable v: sublist){
				if(!vars.contains(v)){
					vars.add(v);
				}
			}
		}
		return vars;
	}

	public int hashCode(){
		return preds.hashCode();
	}

	public boolean equals(Object other){
		if(other instanceof Sentence){
			return preds.equals(((Sentence) other).preds);
		}
		return false;
	}

	public int compareTo(Sentence o) {
		return toString().compareTo(o.toString());
	}

	public static Sentence fromString(String source){
		return CNFCompiler.compileSentence(source);
	}
}
