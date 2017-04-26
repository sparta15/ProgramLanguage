//
//  analizadorDescendente.c
//
//
//  Created by Guillermo Pastor Diez on 26/4/17.
//
//

#include "lex.yy.c"
#include <stdlib.h>

 struct ElementoLista {
    char *tipo,
    char *id,
    struct ElementoLista *next;
};

struct ListaIdentificar {
    struct ElementoLista *head;
    struct ElementoLista *fin;
}

int preanalisis;

void parea();
void array();
void modificador();
void ambito();
void simple();

void parea (int token) {
    if (preanalisis == token) {
        preanalisis = yylex();
    } else {
        printf ("Componente léxico inesperado en %s\n", yytext);
        exit (EXIT_FAILURE);
    }
}

void simple () {
    if (preanalisis == INT) {
        parea (INT);
        return "INT";
    } else if (preanalisis == CHAR) {
        parea (CHAR);
        return "CHAR";
    } else if (preanalisis == STRING ) {
        parea (STRING);
        return "STRING";
    } else if (preanalisis == DOUBLE) {
        parea (DOUBLE);
        return "DOUBLE";
    } else if (preanalisis == FLOAT ) {
        parea (FLOAT);
        return "FLOAT";
    } else if (preanalisis == LONG ) {
        parea (LONG);
        return "LONG";
    } else if (preanalisis == SHORT ) {
        parea (SHORT);
        return "SHORT";
    } else if (preanalisis == BOOLEAN ) {
        parea (BOOLEAN);
        return "BOOLEAN";
    } else {
        printf ("Error sintáctico en %s\n ", yytext);
        exit (EXIT_FAILURE);
    }
}

void array () {
    if(preanalisis = '[') {
        parea('[');
        if(preanalisis != ']') {
            preanalisis = yylex();
        } else {
            parea(']');
        }
        array();
    }
}

void modificador () {
    if(preanalisis == STATIC) {
        parea(STATIC);
    }
    char* tipo = simple();
    array();
    char* id = preanalisis;
    preanalisis = yylex();
    if(preanalisis == '(') {
        guardarId(&id, &tipo);
    }
}

void ambito () {
    if(preanalisis == PUBLIC) {
        parea(PUBLIC);
    } else if (preanalisis == PRIVATE) {
        parea(PRIVATE);
    } else if (preanalisis == PROTECTED) {
        parea(PROTECTED);
    } else if (preanalisis == DEFAULT) {
        parea(DEFAULT);
    }
    modificador();
}



void guardarId(struct node** lastElement, id, tipo) {
    struct ElementoLista* nuevoElemento = (struct ElementoLista*) malloc(sizeof(struct ElementoLista));
    nuevoElemento->id = id;
    nuevoElemento->tipo = tipo;
    nuevoElemento->next = NULL;
    lastElement->next = nuevoElemento;
    lastElement = nuevoElement;
    return;
}

void recorrerLista(&id, &tipo) {
    if(ListaEnlazada.next != NULL){
        if((ListaEnlazada.id == id) && (ListaEnlazada.tipo == tipo)){
            break;
        }else {
            guardarId(&id, &tipo);
        }
    }else {
        ListaEnlazada.
    }
}

main(){
    struct ElementoLista* head = NULL;
    preanalisis = yylex();
    ambito();
    if (preanalisis == 0) // yylex() devuelve 0 en el fin de fichero
        prINTf ("OK\n");
    else
        prINTf ("Sobra algo\n");
}

