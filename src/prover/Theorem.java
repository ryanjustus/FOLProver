package prover;

import org.antlr.runtime.tree.Tree;
import parser.CNFCompiler;
import parser.CNFParser;
import prover.step.*;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 7:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Theorem  {

	private final Map<Sentence,Step> sentences;
	public Theorem(Tree ast){
		sentences = new HashMap<Sentence,Step>();
		int count=1;
		Query query=null;
		Set<Variable> used = new HashSet<Variable>();
		for(int i=0;i<ast.getChildCount();i++){
			Tree c = ast.getChild(i);
			if(c.getType()== CNFParser.QUERY){
				query = new Query(c);

			}else{
				VariablePool pool = new VariablePool();
				pool.setUsed(used);

				Sentence s = new Sentence(c);
				//System.out.println("READ: "+s);
				s = s.normalizeVarNames(pool);
				//System.out.println("RENAMED: "+s);
				used.addAll(s.getVariables());

				Step step = new Given(s,count++);
				//System.out.println(step);
				sentences.put(s,step);
			}
		}
		if(query!=null){
			Set<Sentence> queryNegations = query.getSentences();
			for(Sentence neg: queryNegations){
				VariablePool pool = new VariablePool();
				pool.setUsed(used);

				neg = neg.normalizeVarNames(pool);
				used.addAll(neg.getVariables());

				Step step = new QueryNegation(query,neg,count++);
				//System.out.println(step);
				sentences.put(neg,step);
			}
		}
	}

	public Theorem normalize(){
		Map<Sentence,Step> n = new HashMap<Sentence,Step>(sentences.size());
		for(Map.Entry<Sentence,Step> s: sentences.entrySet()){
			n.put(s.getKey().normalizeVarNames(new VariablePool()),s.getValue());
		}
		return new Theorem(n);
	}

	public List<Step> getSteps(){
		List<Step> steps = new ArrayList<Step>(sentences.values());
		Collections.sort(steps);
		return steps;
	}

	public Theorem(Map<Sentence,Step> sentences){
		this.sentences=new HashMap<Sentence,Step>(sentences);
	}

	public Theorem resolve(){

		Theorem t = new Theorem(this.sentences);
		List<Sentence> sentences = new ArrayList<Sentence>();
		//Queue<Sentence> q = new LinkedList<Sentence>();
		//Stack<Sentence> q = new Stack<Sentence>();

		PriorityQueue<Sentence> q  = new PriorityQueue<Sentence>(t.sentences.size(),new Comparator<Sentence>() {
			public int compare(Sentence o1, Sentence o2) {
				int i =  o1.getPredicates().size()-o2.getPredicates().size();
				if(i==0){
					return o1.compareTo(o2);
				}else{
					return i;
				}
			}
		});


		q.addAll(t.sentences.keySet());
		//System.out.println("Initial: "+q.toString());
		int i=t.sentences.size()+1;
		while(!q.isEmpty()){
			Sentence s1 = q.poll();
			//Sentence s1 = q.pop();
			for(Sentence s2: sentences){
				//System.out.println(s1+" ^ "+s2);
				Sentence union = Unifier.unify(s1,s2);
				if(union.isEmpty()){
					t.sentences.put(Sentence.EMPTY,new TrueSolution(t.sentences.get(s1),t.sentences.get(s2),i++));
					return t;
				}
				else if(!t.sentences.containsKey(union)){
					Step s = new Resolved(t.sentences.get(s1),t.sentences.get(s2),union,i++);
					//System.out.println(s);

					t.sentences.put(union, s);

					q.add(union);
				}
			}
			sentences.add(s1);
		}

		t.sentences.put(Sentence.EMPTY, new FalseSolution(i));
		//System.out.println("NO SOLUTION FOUND");
		return t;
	}

	public String toString(){
		String ret = "";
		for(Sentence s: sentences.keySet()){
			ret+=s+"\n";
		}
		return ret;
	}

	public static Theorem fromString(String source){
		return CNFCompiler.compileTheorem(source);
	}
}
