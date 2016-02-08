theory tp89
imports Main 
 (* "~~/src/HOL/Library/Code_Target_Nat"*)  
begin

(* 
quickcheck_params [size=6,tester=narrowing,timeout=120,expect=no_counterexample]
nitpick_params [timeout=120]
*)

type_synonym transid= "nat*nat*nat"

datatype message= 
  Pay transid nat  
| Ack transid nat
| Cancel transid

type_synonym transaction= "transid * nat"

(*Datatype for the database [(transaction_id, montant_client,montant_vendeur,isCancelled)]
S'il y a des valeurs ceros dans le montant client ou montant vendeur ca signifie qu'aucun
message de ce type a ete lu.*)


datatype state = Cancelled 
                 |Validated 
                 |InProgress
(* -----Premier nat montant client quand la transaction est in progress
Deuxieme nat montant vendeur quand la transaction est in progress
Troisieme nat montant avec lequel la transaction a ete valide. Si ce n'est pas
validé doit etre zero. -------*)               
type_synonym transBdd = "(state*transid*nat*nat*nat) list"


(* ----- Exportation en Scala (Isabelle 2014) -------*)
(*--a partir d e un mensaje calculaun nuevoestado de la base de datos--*)
fun traiterMessage::"message\<Rightarrow>transBdd\<Rightarrow>transBdd"
where  "traiterMessage (Pay tr1 mc) [] =(if(mc>0) then [(InProgress,tr1,mc,0,0)] else [])"|
"traiterMessage (Ack tr1 mv) [] = (if(mv>0) then [(InProgress,tr1,0,mv,0)] else [])"|
"traiterMessage (Cancel tr1) [] =  [(Cancelled,tr1,0,0,0)]"|
"traiterMessage(Pay tr1 mc) ( (Cancelled, t, a, b, c)#xs) = (if(tr1\<noteq>t)then( (Cancelled, t, a, b, c)#(traiterMessage (Pay tr1 mc) xs))else (Cancelled, t, a, b, c)#xs)"|
"traiterMessage(Pay tr1 mc) ( (Validated, t, a, b, c)#xs) = (if(tr1\<noteq>t)then((Validated, t, a, b, c)#(traiterMessage (Pay tr1 mc) xs))else (Validated, t, a, b, c)#xs)"|
"traiterMessage(Pay tr1 mc) ( (InProgress, t, a, b, c)#xs) =(if((tr1=t)\<and>(a>=mc)) then ((InProgress, t, a, b, c)#xs) else (if((tr1=t)\<and>(b<=mc)\<and>(b>0))then((Validated,tr1,0,0,mc)#xs)else((InProgress, t, a, b, c)#traiterMessage (Pay tr1 mc) xs )))"|
"traiterMessage(Ack tr1 mv) ( (Cancelled, t, a, b, c)#xs) = (if(tr1\<noteq>t)then( (Cancelled, t, a, b, c)#(traiterMessage (Ack tr1 mv) xs))else (Cancelled, t, a, b, c)#xs)"|
"traiterMessage(Ack tr1 mv) ( (Validated, t, a, b, c)#xs) = (if(tr1\<noteq>t)then((Validated, t, a, b, c)#(traiterMessage (Ack tr1 mv) xs))else (Validated, t, a, b, c)#xs)"|
"traiterMessage(Ack tr1 mv) ( (InProgress, t, a, b, c)#xs) = (if( (tr1=t)\<and>(b<=mv)\<and>(b>0)) then ((InProgress, t, a, b, c)#xs) else (if((tr1=t)\<and>(a>=mv)\<and>(a>0))then((Validated,tr1,0,0,a)#xs)else((InProgress, t, a, b, c)#traiterMessage (Ack tr1 mv) xs) ))"|
"traiterMessage(Cancel tr1) ( (Cancelled, t, a, b, c)#xs) = (if(tr1\<noteq>t)then( (Cancelled, t, a, b, c)#(traiterMessage (Cancel tr1) xs))else (Cancelled, t, a, b, c)#xs)"|
"traiterMessage(Cancel tr1) ( (Validated, t, a, b, c)#xs) = (if(tr1\<noteq>t)then( (Validated, t, a, b, c)#(traiterMessage (Cancel tr1) xs))else((traiterMessage (Cancel tr1) xs)))"|
"traiterMessage(Cancel tr1) ( (InProgress, t, a, b, c)#xs) =(if(tr1\<noteq>t)then( (InProgress, t, a, b, c)#(traiterMessage (Cancel tr1) xs))else((traiterMessage (Cancel tr1) xs)))"



(*--trata y almacenas las transacciones validas--*)
fun export::"transBdd\<Rightarrow> transaction list"
where "export [] = []"  |
 "export( (Cancelled, tr1, mc,mv,mva) #xs) = (export xs) "|
 "export( (Validated, tr1, mc,mv,mva) #xs) = (tr1,mva)# (export xs) "|
 "export( (InProgress, tr1, mc,mv,mva) #xs) = (export xs) "


fun traiterMessageList::"message list \<Rightarrow> transBdd"
where "traiterMessageList  [] = []" |
      "traiterMessageList (m#lm) =( traiterMessage m ( traiterMessageList lm ))" 


(* ----- Proprietes attendues -------*)
(*1. Tous les transactions ont un montant superieur a 0*)
lemma "(((List.member (export (traiterMessageList ml)) (t v)))\<longrightarrow>(v>0)) "
quickcheck
sorry

(*2. Tout triple apparait une fois *)
lemma "((bdd\<noteq>[])\<and>( List.member (export (traiterMessageList bd))  x) \<longrightarrow>(\<not>( List.member( List.remove1 x (export (traiterMessageList bdd))  )) x))"
nitpick
sorry

(*3.Tout transaction valide peut etre annule*)
lemma "(\<not>(List.member (export (traiterMessageList ((Cancel t)#ml))) (t,v)))"
quickcheck
sorry

(*4.Tout transaction annulé l'est definitivement*)
lemma "(\<not>( List.member (export (traiterMessageList ((l(Cancel t)@l'))))  ( t, a)))"
quickcheck
sorry
(*5. Si un message Pay et Ack,lorsque montant pay et \<ge> montant ack , ont ete envoyés la transaction figure dans le transactions valides*)
lemma "((List.member (export(traiterMessageList(ml)))  (t, i))\<and>( List.member ml (Pay t i))\<and> ( List.member ml (Ack t j)))\<longrightarrow>(i\<ge>j)"
quickcheck
sorry
(*6. Toute transaction dans les transactions valides l'a eté par un message Pay et Ack... *)
lemma "((\<not>( List.member ml (Cancel t)))\<and>( List.member ml (Pay t i))\<and>(i\<ge>j)\<and> (j>0)\<and>
( List.member ml (Ack t j)))\<longrightarrow>((List.member (export(traiterMessageList(ml)))  (t, i)))"
quickcheck
sorry
(*7. Si un client a proposé un montant pour une transaction il ne peut pas proposer un montant inferieur.*)
lemma "((i>j)\<and>( List.member (traiterMessageList  ml)  (InProgress, tr, i,0,0))) \<longrightarrow>(\<not> ( List.member (traiterMessageList  ml)  (InProgress, tr, 0,j,0))) "
quickcheck
sorry
(*8. Toute transaction validé ne peut etre renegocié.*)
lemma "((k<i)\<and>(j>i)\<and>( List.member (traiterMessageList  ml)  (Validated, tr, i,0,0))) \<longrightarrow>((\<not> ( List.member (traiterMessageList  ml)  (InProgress, tr, j,0,0)))\<and>(\<not> ( List.member (traiterMessageList  ml)  (InProgress, tr,0,k,0)))) "
quickcheck
sorry

(*9.Le montant associé a une transaction valide correspond a un prix proposé par le client.*)
lemma "((List.member ( export(traiterMessageList(ml))) (t, m)) \<longrightarrow>( List.member ml (Pay t m)))"
quickcheck
sorry
(* Suppression de l'export des abstract datatypes (Isabelle 2014) *)
code_reserved Scala
  message

code_printing
  type_constructor message \<rightharpoonup> (Scala) "message"
  | constant Ack \<rightharpoonup> (Scala) "Ack"
  | constant Pay \<rightharpoonup> (Scala) "Pay"
  | constant Cancel \<rightharpoonup> (Scala) "Cancel"
  | code_module "" \<rightharpoonup> (Scala)



(* Directive d'exportation *)
export_code export traiterMessage  in Scala
    file  "~01122015.scala"     (* à adapter en fonction du chemin de votre projet TP89 *)


end

