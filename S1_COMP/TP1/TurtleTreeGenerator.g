grammar TurtleTreeGenerator;
options{
	output=AST;
	ASTLabelType=CommonTree; 
}

tokens{
Doc;
Empty;
S;
P;
O;
}            

@parser::header{
package gramaticas;
}

@lexer::header{
package gramaticas;
}



doc  :	ls->^(Doc   ls);

ls   :s lsprime -> s  lsprime;

lsprime 	   :/*EMPTY*/->Empty
	   | ls;

s    :ENTITY  p  POINT ->^(S  ENTITY p);
                                        

p     :ENTITY lo pprime->^(P ENTITY  lo) pprime;
	
pprime 
	   :	->Empty/*EMPTY*/ 
	   | POINTCOMMA p->p;



lo  :o loprime-> o loprime;
	
loprime :/*EMPTY*/ -> Empty|COMMA lo-> lo;
	 
o  :	ENTITY->^( O ENTITY) |
                                            TEXT->^( O TEXT) ;

POINT	:'.';
COMMA	:',';
POINTCOMMA :';';
WS	: (' '|'\t'|'\n')+ {skip();} ;
CHAINE          :('a'..'z'|'A'..'Z'|'0'..'9'|' '|'-'|'&')+;
ENTITY	:'<'CHAINE'>';	
TEXT	:'"'CHAINE'"';

