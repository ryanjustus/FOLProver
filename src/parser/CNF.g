grammar CNF;

options {
    language=Java;
    output=AST;
    ASTLabelType=CommonTree; // type of $stat.tree ref etc...
    backtrack=true;
}



tokens {
    // define pseudo-operations
    FUNCTION;
}

@lexer::header {package parser;}
@parser::header {package parser;}



/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/


theorem
	:	sentence* query sentence* EOF!;

sentence
	:  expression (OR! expression)*DOT^;

query
	: expression (OR! expression)*QUERY^;
	
expression
	: predicate | negation;	

negation 
	:	NOT^ predicate ;

predicate 
	:	CONSTANT^ predicateTuple;

predicateTuple
	:	LPAREN! ( function | variable | constant ) (COMMA! ( function | variable | constant ))* RPAREN! ;

variable 
	:	 VARIABLE;

constant 
	: 	CONSTANT;

function
	:	CONSTANT functionTuple -> ^(FUNCTION CONSTANT functionTuple);

functionTuple
	:	LPAREN! ( function | variable | constant ) RPAREN!;

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/



VARIABLE: ('a'..'z') CHARACTER* ;

CONSTANT: ('A'..'Z') CHARACTER* ;


fragment CHARACTER: ('0'..'9' | 'a'..'z' | 'A'..'Z' | '_') ;
WS       :           (' '|'\t'|'\f'|'\n'|'\r')+{ skip(); };
COMMA	: 	',';
LPAREN 	: 	'(' ;
RPAREN 	:  	')' ;
OR 	:  	'|' ;
NOT 	:  	'~' ;
DOT 	:	'.';
QUERY   :	'?';


