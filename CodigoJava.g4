grammar CodigoJava;

@header {
    package tools;
    import java.util.*;
}

/*
@parser::members {
    ArrayList
}
*/

prog
    : idspc CLASS ID '{' clase '}' ;

idspc
        : ID idspc
        | ';' idspc
        | ;

clase : ids ID ID '(' params ')' '{' codigo '}' clase
        | ids ID ID '(' params ')' ';' clase
        | ids ID ID ';' clase
        | ;

ids : ID ids
      | ;

codigo : ID codigo
         | ';' codigo
         | '(' codigo ')' codigo
         | '{' codigo '}' codigo
         | ;

params : ID params
         | ;

CLASS : 'class';
ID : LETTER(LETTER | DIGIT)*;  //Identificadores de variables
LETTER : [a-zA-Z];
DIGIT : [0-9]+;
WS : [ \t\n]+ -> skip;

