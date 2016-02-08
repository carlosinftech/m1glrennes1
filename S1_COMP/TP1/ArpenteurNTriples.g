tree grammar ArpenteurNTriples;

options{
	tokenVocab=TurtleTreeGenerator; 
	ASTLabelType=CommonTree; // type of $stat.tree 
}

@header{
package gramaticas;
}

doc returns [String value]  :^(Doc   ls{System.out.println($ls.value.replaceAll("null","").trim());});

ls  returns [String value]  : s{$value += $s.value; }  lsprime{$value += $lsprime.value ;};

lsprime returns [String value]    :/*EMPTY*/Empty{$value += "";}
	   | ls{$value += $ls.value; };

s returns [String value]  :^(S  e=ENTITY p {$value += $p.value.replaceAll("\n","\n"+$e.text +" ");});
                                        

p returns [String value]  :^(P e=ENTITY  lo{$value += $lo.value.replaceAll("\n","\n"+$e.text +" ");}) pprime{$value += $pprime.value;};
	
pprime  returns [String value]
	   :	Empty{$value += "";}/*EMPTY*/ 
	   | p{$value += $p.value;};

lo returns [String value] : o{$value += $o.value;}  loprime{$value += $loprime.value ;} ;
	
loprime returns [String value]:/*EMPTY*/ Empty{$value += "";}| lo{$value +=  $lo.value;};
	 
o returns [String value] :	^( O ENTITY) {$value += "\n" + $ENTITY.text + " ." ;} |
                                            ^( O TEXT){$value += "\n" + $TEXT.text + " ."; } ;

