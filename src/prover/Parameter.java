package prover;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 7:19 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Parameter extends Comparable<Parameter>{
	String getName();
	Parameter renameVariable(Map<Variable,Parameter> nameMap);
	List<Variable> getVariables();
	List<Constant> getConstants();
}
