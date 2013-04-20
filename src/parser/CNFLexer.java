// $ANTLR 3.4 C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g 2012-11-16 12:21:26
package parser;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class CNFLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public CNFLexer() {} 
    public CNFLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CNFLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g"; }

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:66:9: ( ( 'a' .. 'z' ) ( CHARACTER )* )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:66:11: ( 'a' .. 'z' ) ( CHARACTER )*
            {
            if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:66:22: ( CHARACTER )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VARIABLE"

    // $ANTLR start "CONSTANT"
    public final void mCONSTANT() throws RecognitionException {
        try {
            int _type = CONSTANT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:68:9: ( ( 'A' .. 'Z' ) ( CHARACTER )* )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:68:11: ( 'A' .. 'Z' ) ( CHARACTER )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:68:22: ( CHARACTER )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONSTANT"

    // $ANTLR start "CHARACTER"
    public final void mCHARACTER() throws RecognitionException {
        try {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:71:19: ( ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHARACTER"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:72:10: ( ( ' ' | '\\t' | '\\f' | '\\n' | '\\r' )+ )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:72:22: ( ' ' | '\\t' | '\\f' | '\\n' | '\\r' )+
            {
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:72:22: ( ' ' | '\\t' | '\\f' | '\\n' | '\\r' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||(LA3_0 >= '\f' && LA3_0 <= '\r')||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:73:7: ( ',' )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:73:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:74:9: ( '(' )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:74:12: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:75:9: ( ')' )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:75:13: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:76:5: ( '|' )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:76:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:77:6: ( '~' )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:77:10: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:78:6: ( '.' )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:78:8: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "QUERY"
    public final void mQUERY() throws RecognitionException {
        try {
            int _type = QUERY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:79:9: ( '?' )
            // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:79:11: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUERY"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:8: ( VARIABLE | CONSTANT | WS | COMMA | LPAREN | RPAREN | OR | NOT | DOT | QUERY )
        int alt4=10;
        switch ( input.LA(1) ) {
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt4=1;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
            {
            alt4=2;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt4=3;
            }
            break;
        case ',':
            {
            alt4=4;
            }
            break;
        case '(':
            {
            alt4=5;
            }
            break;
        case ')':
            {
            alt4=6;
            }
            break;
        case '|':
            {
            alt4=7;
            }
            break;
        case '~':
            {
            alt4=8;
            }
            break;
        case '.':
            {
            alt4=9;
            }
            break;
        case '?':
            {
            alt4=10;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
            case 1 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:10: VARIABLE
                {
                mVARIABLE(); 


                }
                break;
            case 2 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:19: CONSTANT
                {
                mCONSTANT(); 


                }
                break;
            case 3 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:28: WS
                {
                mWS(); 


                }
                break;
            case 4 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:31: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 5 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:37: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 6 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:44: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 7 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:51: OR
                {
                mOR(); 


                }
                break;
            case 8 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:54: NOT
                {
                mNOT(); 


                }
                break;
            case 9 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:58: DOT
                {
                mDOT(); 


                }
                break;
            case 10 :
                // C:\\Users\\ryan\\Documents\\code\\ResolutionLab\\src\\parser\\CNF.g:1:62: QUERY
                {
                mQUERY(); 


                }
                break;

        }

    }


 

}