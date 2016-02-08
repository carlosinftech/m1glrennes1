tree grammar ArpenteurNDescriptions;

options{
	tokenVocab=TurtleTreeGenerator; 
	ASTLabelType=CommonTree; // type of $stat.tree 
}

@header{
package gramaticas;
}

doc returns [String value]  :^(Doc   ls{System.out.println("Nombre de descriptions dans l'arbre: "+$ls.value);});

ls  returns [int value]  : s{$value += 1; }  lsprime {$value += $lsprime.value ;};

lsprime returns [int value]    :/*EMPTY*/Empty{$value += 0;}
	   | ls{$value += $ls.value; };

s  :^(S  e=ENTITY p );
                                        

p   :^(P e=ENTITY  lo) pprime;
	
pprime 	   :	Empty/*EMPTY*/ 
	   | p;

lo returns [String value] : o  loprime ;
	
loprime returns [String value]:/*EMPTY*/ Empty| lo;
	 
o returns [String value] :	^( O ENTITY)  |
                                            ^( O TEXT) ;

