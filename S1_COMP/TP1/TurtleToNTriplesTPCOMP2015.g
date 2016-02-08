grammar TurtleToNTriplesTPCOMP2015;
@parser::header{
package gramaticas;
}

@lexer::header{
package gramaticas;
}


prog	 returns [String value]   :	doc{System.out.println($doc.value.replaceAll("null","").trim());};

doc returns [String value]   :e=s{$value+=$e.value;}
                                            g=docprime {$value+=$g.value;};

docprime   returns [String value] 
	   :/*EMPTY*/{$value+="";}
	   | e=doc{$value+=$e.value;};

s returns [String value]   :e=ENTITY
                                        f= p{$value+=$f.value.replaceAll("\n","\n"+$e.text +" ");}
                                        POINT
                                        ;
                                        

p returns [String value]
	:e=ENTITY f=lo{$value+=$f.value.replaceAll("\n","\n"+$e.text +" ");} g=pprime{$value+=$g.value;};
	
pprime  returns [String value]
	   :	{$value+="";}/*EMPTY*/ 
	   | POINTCOMMA f=p{$value+=""+$f.value;};



lo returns [String value] :	
	                      e=o{$value+="\n"+$e.value+".";}                                            
	                       f=loprime{$value+=$f.value;}  ;
	
loprime returns [String value]:
	/*EMPTY*/ {$value+="";}
	|COMMA
	 f=lo{$value+=$f.value;} ;
	 
o returns [String value] :	e=ENTITY{$value+=$e.text;}|
                                            f=TEXT{$value+=$f.text;};

POINT	:'.';
COMMA	:',';
POINTCOMMA :';';
WS	: (' '|'\t'|'\n')+ {skip();} ;
CHAINE          :('a'..'z'|'A'..'Z'|'0'..'9'|' '|'-'|'&')+;
ENTITY	:'<'CHAINE'>';	
TEXT	:'"'CHAINE'"';


