package parser;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import prover.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryan
 * Date: 11/4/12
 * Time: 5:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CNFCompiler {

	public static Sentence compileSentence(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new CNFLexer(input));

			//parser generates abstract syntax tree
			CNFParser parser = new CNFParser(tokens);

			CNFParser.sentence_return ret = parser.sentence();
			CommonTree ast = (CommonTree) ret.tree;
			//printTree(ast,0);

			Sentence s = new Sentence(ast);
			return s;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	public static Query compileQuery(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new CNFLexer(input));

			//parser generates abstract syntax tree
			CNFParser parser = new CNFParser(tokens);

			CNFParser.query_return ret = parser.query();
			CommonTree ast = (CommonTree) ret.tree;
			//printTree(ast,0);

			Query s = new Query(ast);
			return s;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	public static Predicate compilePredicate(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new CNFLexer(input));

			//parser generates abstract syntax tree
			CNFParser parser = new CNFParser(tokens);

			CommonTree ast;
			if(expression.trim().charAt(0)=='~'){
				CNFParser.negation_return ret = parser.negation();
				ast = (CommonTree) ret.tree;
				//printTree(ast,0);
			}else{

				CNFParser.predicate_return ret = parser.predicate();
				ast = (CommonTree) ret.tree;
				//printTree(ast,0);
			}
			Predicate s = new Predicate(ast);

			return s;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	public static Constant compileConstant(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new CNFLexer(input));

			//parser generates abstract syntax tree
			CNFParser parser = new CNFParser(tokens);

			CNFParser.constant_return ret = parser.constant();
			CommonTree ast = (CommonTree) ret.tree;
			//printTree(ast,0);

			Constant s = new Constant(ast);
			return s;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	public static Variable compileVariable(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new CNFLexer(input));

			//parser generates abstract syntax tree
			CNFParser parser = new CNFParser(tokens);

			CNFParser.variable_return ret = parser.variable();
			CommonTree ast = (CommonTree) ret.tree;
			//printTree(ast,0);

			Variable s = new Variable(ast);
			return s;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	public static Function compileFunction(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new CNFLexer(input));

			//parser generates abstract syntax tree
			CNFParser parser = new CNFParser(tokens);

			CNFParser.function_return ret = parser.function();
			CommonTree ast = (CommonTree) ret.tree;
			//printTree(ast,0);

			Function s = new Function(ast);
			return s;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	public static Theorem compileTheorem(String expression) {
		try {
			//lexer splits input into tokens
			ANTLRStringStream input = new ANTLRStringStream(expression);
			TokenStream tokens = new CommonTokenStream(new CNFLexer(input));

			//parser generates abstract syntax tree
			CNFParser parser = new CNFParser(tokens);

			CNFParser.theorem_return ret = parser.theorem();
			CommonTree ast = (CommonTree) ret.tree;
			//printTree(ast,0);

			Theorem s = new Theorem(ast);
			return s;
		} catch (RecognitionException e) {
			throw new IllegalStateException("Recognition exception is never thrown, only declared.");
		}
	}

	public static void printTree(CommonTree t, int indent) {
		if ( t != null ) {

			StringBuffer sb = new StringBuffer(indent);

			for ( int i = 0; i < indent; i++ )
				sb = sb.append("   ");
			for ( int i = 0; i < t.getChildCount(); i++ ) {
				System.out.println(sb.toString() + t.getChild(i).toString());
				printTree((CommonTree)t.getChild(i), indent+1);
			}
		}
	}

}
