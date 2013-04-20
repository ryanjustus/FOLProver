// $ANTLR 3.4 C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g 2012-11-16 12:21:26
package parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class CNFParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHARACTER", "COMMA", "CONSTANT", "DOT", "FUNCTION", "LPAREN", "NOT", "OR", "QUERY", "RPAREN", "VARIABLE", "WS"
    };

    public static final int EOF=-1;
    public static final int CHARACTER=4;
    public static final int COMMA=5;
    public static final int CONSTANT=6;
    public static final int DOT=7;
    public static final int FUNCTION=8;
    public static final int LPAREN=9;
    public static final int NOT=10;
    public static final int OR=11;
    public static final int QUERY=12;
    public static final int RPAREN=13;
    public static final int VARIABLE=14;
    public static final int WS=15;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public CNFParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CNFParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return CNFParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g"; }


    public static class theorem_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "theorem"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:27:1: theorem : ( sentence )* query ( sentence )* EOF !;
    public final CNFParser.theorem_return theorem() throws RecognitionException {
        CNFParser.theorem_return retval = new CNFParser.theorem_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF4=null;
        CNFParser.sentence_return sentence1 =null;

        CNFParser.query_return query2 =null;

        CNFParser.sentence_return sentence3 =null;


        CommonTree EOF4_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:28:2: ( ( sentence )* query ( sentence )* EOF !)
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:28:4: ( sentence )* query ( sentence )* EOF !
            {
            root_0 = (CommonTree)adaptor.nil();


            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:28:4: ( sentence )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==CONSTANT) ) {
                    int LA1_1 = input.LA(2);

                    if ( (synpred1_CNF()) ) {
                        alt1=1;
                    }


                }
                else if ( (LA1_0==NOT) ) {
                    int LA1_2 = input.LA(2);

                    if ( (synpred1_CNF()) ) {
                        alt1=1;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:28:4: sentence
            	    {
            	    pushFollow(FOLLOW_sentence_in_theorem95);
            	    sentence1=sentence();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentence1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            pushFollow(FOLLOW_query_in_theorem98);
            query2=query();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, query2.getTree());

            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:28:20: ( sentence )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==CONSTANT||LA2_0==NOT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:28:20: sentence
            	    {
            	    pushFollow(FOLLOW_sentence_in_theorem100);
            	    sentence3=sentence();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, sentence3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_theorem103); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "theorem"


    public static class sentence_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sentence"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:30:1: sentence : expression ( OR ! expression )* DOT ^;
    public final CNFParser.sentence_return sentence() throws RecognitionException {
        CNFParser.sentence_return retval = new CNFParser.sentence_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token OR6=null;
        Token DOT8=null;
        CNFParser.expression_return expression5 =null;

        CNFParser.expression_return expression7 =null;


        CommonTree OR6_tree=null;
        CommonTree DOT8_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:31:2: ( expression ( OR ! expression )* DOT ^)
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:31:5: expression ( OR ! expression )* DOT ^
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_sentence114);
            expression5=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression5.getTree());

            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:31:16: ( OR ! expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==OR) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:31:17: OR ! expression
            	    {
            	    OR6=(Token)match(input,OR,FOLLOW_OR_in_sentence117); if (state.failed) return retval;

            	    pushFollow(FOLLOW_expression_in_sentence120);
            	    expression7=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression7.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            DOT8=(Token)match(input,DOT,FOLLOW_DOT_in_sentence123); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DOT8_tree = 
            (CommonTree)adaptor.create(DOT8)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(DOT8_tree, root_0);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sentence"


    public static class query_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "query"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:33:1: query : expression ( OR ! expression )* QUERY ^;
    public final CNFParser.query_return query() throws RecognitionException {
        CNFParser.query_return retval = new CNFParser.query_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token OR10=null;
        Token QUERY12=null;
        CNFParser.expression_return expression9 =null;

        CNFParser.expression_return expression11 =null;


        CommonTree OR10_tree=null;
        CommonTree QUERY12_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:34:2: ( expression ( OR ! expression )* QUERY ^)
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:34:4: expression ( OR ! expression )* QUERY ^
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_query133);
            expression9=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expression9.getTree());

            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:34:15: ( OR ! expression )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==OR) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:34:16: OR ! expression
            	    {
            	    OR10=(Token)match(input,OR,FOLLOW_OR_in_query136); if (state.failed) return retval;

            	    pushFollow(FOLLOW_expression_in_query139);
            	    expression11=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, expression11.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            QUERY12=(Token)match(input,QUERY,FOLLOW_QUERY_in_query142); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            QUERY12_tree = 
            (CommonTree)adaptor.create(QUERY12)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(QUERY12_tree, root_0);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "query"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:36:1: expression : ( predicate | negation );
    public final CNFParser.expression_return expression() throws RecognitionException {
        CNFParser.expression_return retval = new CNFParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        CNFParser.predicate_return predicate13 =null;

        CNFParser.negation_return negation14 =null;



        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:37:2: ( predicate | negation )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONSTANT) ) {
                alt5=1;
            }
            else if ( (LA5_0==NOT) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:37:4: predicate
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_predicate_in_expression153);
                    predicate13=predicate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate13.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:37:16: negation
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_negation_in_expression157);
                    negation14=negation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, negation14.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class negation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "negation"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:39:1: negation : NOT ^ predicate ;
    public final CNFParser.negation_return negation() throws RecognitionException {
        CNFParser.negation_return retval = new CNFParser.negation_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NOT15=null;
        CNFParser.predicate_return predicate16 =null;


        CommonTree NOT15_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:40:2: ( NOT ^ predicate )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:40:4: NOT ^ predicate
            {
            root_0 = (CommonTree)adaptor.nil();


            NOT15=(Token)match(input,NOT,FOLLOW_NOT_in_negation168); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NOT15_tree = 
            (CommonTree)adaptor.create(NOT15)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(NOT15_tree, root_0);
            }

            pushFollow(FOLLOW_predicate_in_negation171);
            predicate16=predicate();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicate16.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "negation"


    public static class predicate_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "predicate"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:42:1: predicate : CONSTANT ^ predicateTuple ;
    public final CNFParser.predicate_return predicate() throws RecognitionException {
        CNFParser.predicate_return retval = new CNFParser.predicate_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token CONSTANT17=null;
        CNFParser.predicateTuple_return predicateTuple18 =null;


        CommonTree CONSTANT17_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:43:2: ( CONSTANT ^ predicateTuple )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:43:4: CONSTANT ^ predicateTuple
            {
            root_0 = (CommonTree)adaptor.nil();


            CONSTANT17=(Token)match(input,CONSTANT,FOLLOW_CONSTANT_in_predicate182); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CONSTANT17_tree = 
            (CommonTree)adaptor.create(CONSTANT17)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(CONSTANT17_tree, root_0);
            }

            pushFollow(FOLLOW_predicateTuple_in_predicate185);
            predicateTuple18=predicateTuple();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, predicateTuple18.getTree());

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "predicate"


    public static class predicateTuple_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "predicateTuple"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:45:1: predicateTuple : LPAREN ! ( function | variable | constant ) ( COMMA ! ( function | variable | constant ) )* RPAREN !;
    public final CNFParser.predicateTuple_return predicateTuple() throws RecognitionException {
        CNFParser.predicateTuple_return retval = new CNFParser.predicateTuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LPAREN19=null;
        Token COMMA23=null;
        Token RPAREN27=null;
        CNFParser.function_return function20 =null;

        CNFParser.variable_return variable21 =null;

        CNFParser.constant_return constant22 =null;

        CNFParser.function_return function24 =null;

        CNFParser.variable_return variable25 =null;

        CNFParser.constant_return constant26 =null;


        CommonTree LPAREN19_tree=null;
        CommonTree COMMA23_tree=null;
        CommonTree RPAREN27_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:2: ( LPAREN ! ( function | variable | constant ) ( COMMA ! ( function | variable | constant ) )* RPAREN !)
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:4: LPAREN ! ( function | variable | constant ) ( COMMA ! ( function | variable | constant ) )* RPAREN !
            {
            root_0 = (CommonTree)adaptor.nil();


            LPAREN19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_predicateTuple194); if (state.failed) return retval;

            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:12: ( function | variable | constant )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==CONSTANT) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==LPAREN) ) {
                    alt6=1;
                }
                else if ( (LA6_1==COMMA||LA6_1==RPAREN) ) {
                    alt6=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA6_0==VARIABLE) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:14: function
                    {
                    pushFollow(FOLLOW_function_in_predicateTuple199);
                    function20=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function20.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:25: variable
                    {
                    pushFollow(FOLLOW_variable_in_predicateTuple203);
                    variable21=variable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variable21.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:36: constant
                    {
                    pushFollow(FOLLOW_constant_in_predicateTuple207);
                    constant22=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant22.getTree());

                    }
                    break;

            }


            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:47: ( COMMA ! ( function | variable | constant ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:48: COMMA ! ( function | variable | constant )
            	    {
            	    COMMA23=(Token)match(input,COMMA,FOLLOW_COMMA_in_predicateTuple212); if (state.failed) return retval;

            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:55: ( function | variable | constant )
            	    int alt7=3;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==CONSTANT) ) {
            	        int LA7_1 = input.LA(2);

            	        if ( (LA7_1==LPAREN) ) {
            	            alt7=1;
            	        }
            	        else if ( (LA7_1==COMMA||LA7_1==RPAREN) ) {
            	            alt7=3;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return retval;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 7, 1, input);

            	            throw nvae;

            	        }
            	    }
            	    else if ( (LA7_0==VARIABLE) ) {
            	        alt7=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:57: function
            	            {
            	            pushFollow(FOLLOW_function_in_predicateTuple217);
            	            function24=function();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, function24.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:68: variable
            	            {
            	            pushFollow(FOLLOW_variable_in_predicateTuple221);
            	            variable25=variable();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, variable25.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:46:79: constant
            	            {
            	            pushFollow(FOLLOW_constant_in_predicateTuple225);
            	            constant26=constant();

            	            state._fsp--;
            	            if (state.failed) return retval;
            	            if ( state.backtracking==0 ) adaptor.addChild(root_0, constant26.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            RPAREN27=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_predicateTuple231); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "predicateTuple"


    public static class variable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variable"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:48:1: variable : VARIABLE ;
    public final CNFParser.variable_return variable() throws RecognitionException {
        CNFParser.variable_return retval = new CNFParser.variable_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token VARIABLE28=null;

        CommonTree VARIABLE28_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:49:2: ( VARIABLE )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:49:5: VARIABLE
            {
            root_0 = (CommonTree)adaptor.nil();


            VARIABLE28=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_variable244); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            VARIABLE28_tree = 
            (CommonTree)adaptor.create(VARIABLE28)
            ;
            adaptor.addChild(root_0, VARIABLE28_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variable"


    public static class constant_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constant"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:51:1: constant : CONSTANT ;
    public final CNFParser.constant_return constant() throws RecognitionException {
        CNFParser.constant_return retval = new CNFParser.constant_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token CONSTANT29=null;

        CommonTree CONSTANT29_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:52:2: ( CONSTANT )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:52:5: CONSTANT
            {
            root_0 = (CommonTree)adaptor.nil();


            CONSTANT29=(Token)match(input,CONSTANT,FOLLOW_CONSTANT_in_constant255); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CONSTANT29_tree = 
            (CommonTree)adaptor.create(CONSTANT29)
            ;
            adaptor.addChild(root_0, CONSTANT29_tree);
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constant"


    public static class function_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "function"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:54:1: function : CONSTANT functionTuple -> ^( FUNCTION CONSTANT functionTuple ) ;
    public final CNFParser.function_return function() throws RecognitionException {
        CNFParser.function_return retval = new CNFParser.function_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token CONSTANT30=null;
        CNFParser.functionTuple_return functionTuple31 =null;


        CommonTree CONSTANT30_tree=null;
        RewriteRuleTokenStream stream_CONSTANT=new RewriteRuleTokenStream(adaptor,"token CONSTANT");
        RewriteRuleSubtreeStream stream_functionTuple=new RewriteRuleSubtreeStream(adaptor,"rule functionTuple");
        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:55:2: ( CONSTANT functionTuple -> ^( FUNCTION CONSTANT functionTuple ) )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:55:4: CONSTANT functionTuple
            {
            CONSTANT30=(Token)match(input,CONSTANT,FOLLOW_CONSTANT_in_function264); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONSTANT.add(CONSTANT30);


            pushFollow(FOLLOW_functionTuple_in_function266);
            functionTuple31=functionTuple();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_functionTuple.add(functionTuple31.getTree());

            // AST REWRITE
            // elements: CONSTANT, functionTuple
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 55:27: -> ^( FUNCTION CONSTANT functionTuple )
            {
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:55:30: ^( FUNCTION CONSTANT functionTuple )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FUNCTION, "FUNCTION")
                , root_1);

                adaptor.addChild(root_1, 
                stream_CONSTANT.nextNode()
                );

                adaptor.addChild(root_1, stream_functionTuple.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "function"


    public static class functionTuple_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionTuple"
    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:57:1: functionTuple : LPAREN ! ( function | variable | constant ) RPAREN !;
    public final CNFParser.functionTuple_return functionTuple() throws RecognitionException {
        CNFParser.functionTuple_return retval = new CNFParser.functionTuple_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LPAREN32=null;
        Token RPAREN36=null;
        CNFParser.function_return function33 =null;

        CNFParser.variable_return variable34 =null;

        CNFParser.constant_return constant35 =null;


        CommonTree LPAREN32_tree=null;
        CommonTree RPAREN36_tree=null;

        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:58:2: ( LPAREN ! ( function | variable | constant ) RPAREN !)
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:58:4: LPAREN ! ( function | variable | constant ) RPAREN !
            {
            root_0 = (CommonTree)adaptor.nil();


            LPAREN32=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionTuple285); if (state.failed) return retval;

            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:58:12: ( function | variable | constant )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==CONSTANT) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==LPAREN) ) {
                    alt9=1;
                }
                else if ( (LA9_1==RPAREN) ) {
                    alt9=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA9_0==VARIABLE) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:58:14: function
                    {
                    pushFollow(FOLLOW_function_in_functionTuple290);
                    function33=function();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, function33.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:58:25: variable
                    {
                    pushFollow(FOLLOW_variable_in_functionTuple294);
                    variable34=variable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, variable34.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:58:36: constant
                    {
                    pushFollow(FOLLOW_constant_in_functionTuple298);
                    constant35=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant35.getTree());

                    }
                    break;

            }


            RPAREN36=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionTuple302); if (state.failed) return retval;

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionTuple"

    // $ANTLR start synpred1_CNF
    public final void synpred1_CNF_fragment() throws RecognitionException {
        // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:28:4: ( sentence )
        // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:28:4: sentence
        {
        pushFollow(FOLLOW_sentence_in_synpred1_CNF95);
        sentence();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_CNF

    // Delegated rules

    public final boolean synpred1_CNF() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_CNF_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_sentence_in_theorem95 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_query_in_theorem98 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_sentence_in_theorem100 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_EOF_in_theorem103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_sentence114 = new BitSet(new long[]{0x0000000000000880L});
    public static final BitSet FOLLOW_OR_in_sentence117 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_expression_in_sentence120 = new BitSet(new long[]{0x0000000000000880L});
    public static final BitSet FOLLOW_DOT_in_sentence123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_query133 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_OR_in_query136 = new BitSet(new long[]{0x0000000000000440L});
    public static final BitSet FOLLOW_expression_in_query139 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_QUERY_in_query142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_predicate_in_expression153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_negation_in_expression157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_negation168 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_predicate_in_negation171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANT_in_predicate182 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_predicateTuple_in_predicate185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_predicateTuple194 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_function_in_predicateTuple199 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_variable_in_predicateTuple203 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_constant_in_predicateTuple207 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_COMMA_in_predicateTuple212 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_function_in_predicateTuple217 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_variable_in_predicateTuple221 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_constant_in_predicateTuple225 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_RPAREN_in_predicateTuple231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_variable244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANT_in_constant255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTANT_in_function264 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_functionTuple_in_function266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_functionTuple285 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_function_in_functionTuple290 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_variable_in_functionTuple294 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_constant_in_functionTuple298 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RPAREN_in_functionTuple302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentence_in_synpred1_CNF95 = new BitSet(new long[]{0x0000000000000002L});

}