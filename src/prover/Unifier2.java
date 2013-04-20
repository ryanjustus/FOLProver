package prover;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/9/12
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Unifier2 {

	public static Sentence unify(Sentence s1, Sentence s2){
		List<Predicate> l1 = new ArrayList<Predicate>(s1.getPredicates());
		List<Predicate> l2 = new ArrayList<Predicate>(s2.getPredicates());
		for(int i=0;i<l1.size();i++){
			Predicate p1 = l1.get(i);
			for(int j=0;j<l2.size();j++){
				Predicate p2 = l2.get(j);
				Map<Variable,Parameter> varMap = new HashMap<Variable, Parameter>();
				if(unifyPredicate(p1,p2,varMap)){
					s1 = s1.removePredicate(p1).renameVariables(varMap);
					s2 = s2.removePredicate(p2).renameVariables(varMap);
					Sentence union = s1.union(s2);
					return union;

				}
			}
		}
		return s1;
	}




	public static boolean unifyPredicate(Predicate p1, Predicate p2, Map<Variable,Parameter> varMap){

		return p1.getName().equals(p2.getName()) &&
				p1.sign!=p2.sign &&
				unify(p1.getParameters(),p2.getParameters(), varMap);
	}

	public static boolean unify(List<Parameter> l1, List<Parameter> l2, Map<Variable,Parameter> varMap){
		if(l1.size()!=l2.size()){
			throw new IllegalStateException("list parameter length mismatch");
		}

		//Iterative form of tail call recursion
		for(int i=0;i<l1.size();i++){
			Parameter p1 = l1.get(i);
			Parameter p2 = l2.get(i);
			if(!unifyParameter(p1, p2, varMap)){
				return false;
			}
		}
		return true;
	}

	public static boolean unifyParameter(Parameter p1, Parameter p2, Map<Variable,Parameter> varMap){
		//System.out.println("Unify Parameter: "+p1+"/"+p2);
		if(p1.equals(p2)){
			return true;
		}else if(p1 instanceof Variable){
			//System.out.println("CASE p1 var");
			return unifyVariable((Variable)p1, p2, varMap);
		}else if(p2 instanceof Variable){
			return unifyVariable((Variable)p2,p1,varMap);
		}
		else if(p1 instanceof Function && p2 instanceof Function){
			Function f1 = (Function)p1;
			Function f2 = (Function)p2;
			if(f1.getName().equals(f2.getName())){
				return unifyParameter(f1.getParameter(),f2.getParameter(),varMap);
			}else{
				return false;
			}
		}else{
			return false;
		}
	}


	public static boolean unifyVariable(Variable var, Parameter x, Map<Variable,Parameter> varMap){
		//System.out.println("Unify Variable: "+var+"/"+x);
		//Case 1
		if(varMap.containsKey(var)){
			//System.out.println("CASE 1");
			Parameter val = varMap.get(var);
			varMap.put(var,x);
			return  unifyParameter(val,x,varMap);
		}
		//Case 2
		else if(varMap.containsKey(x)){
			//System.out.println("CASE 2"+var+x);
			Parameter val = varMap.get(x);
			HashMap<Variable, Parameter> sub = new HashMap<Variable, Parameter>();
			boolean success = unifyParameter(var, val,sub);

			if(success){
				varMap.put((Variable)x,sub.get(var));
				varMap.put(var,val);
			}
			return success;
		}
		//Case 3
		else if(x.getVariables().contains(var)){
			//System.out.println("CASE 3");
			return false;
		}else{
			//System.out.println("CASE 4");
			//Case 4

			for(Map.Entry<Variable,Parameter> entry: varMap.entrySet()){
				Parameter p = entry.getValue();
				if(p.getVariables().contains(var)){
					Map<Variable,Parameter> sub = new HashMap<Variable, Parameter>();
					sub.put(var,x);
					Parameter renamed = p.renameVariable(sub);
					varMap.put(var,x);
					entry.setValue(renamed);

				}
			}

			x = x.renameVariable(varMap);

			varMap.put(var,x);
			//Final recursion test
			for(Map.Entry<Variable,Parameter> entry: varMap.entrySet()){
				if(entry.getValue().getVariables().contains(entry.getKey())){
					return false;
				}
			}
			return true;
		}
	}
}
