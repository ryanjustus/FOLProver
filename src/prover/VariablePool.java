package prover;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/6/12
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class VariablePool {
	private final Map<Variable,Variable> mapping;
	private final Set<Variable> rejected;

	public VariablePool(){
		mapping = new HashMap<Variable,Variable>();
		rejected = new HashSet<Variable>();
	}

	public void setUsed(Collection<Variable> vv){
		rejected.addAll(vv);
	}


	public Variable getUnused(Variable candidate){
		int counter=0;
		if(mapping.containsKey(candidate)){
			return mapping.get(candidate);
		}else{

			while(true){
				for(char c='a';c<'z';c++){
					Variable test = Variable.fromString((counter==0) ? String.valueOf(c) : String.valueOf(c)+counter);
					if(!rejected.contains(test) && !mapping.containsValue(test)){
						mapping.put(candidate,test);
						return test;
					}
				}
				counter++;
			}
		}
	}
}
