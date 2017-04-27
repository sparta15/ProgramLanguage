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
    char *tipo;
    char *id;
    struct ElementoLista *next;
};

struct ElementoLista *head;
struct ElementoLista *tail;

// struct ListaIdentificar {
//     struct ElementoLista *head;
//     struct ElementoLista *end;
// };

int preanalisis;
char *tipo;
char *identificador;

void parea();
void array();
void modificador();
void ambito();
char * simple();
void debug();

void parea (int token) {
    if (preanalisis == token) {
        preanalisis = yylex();
    } else {
        printf ("Componente léxico inesperado en %s\n", yytext);
        exit (EXIT_FAILURE);
    }
}
char * simple () {
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
    } else if (preanalisis == BYTE ) {
        parea (BYTE);
        return "BYTE";
    } else if (preanalisis == BOOLEAN ) {
        parea (BOOLEAN);
        return "BOOLEAN";
    } else {
        printf ("Error sintáctico en %s\n ", yytext);
        exit (EXIT_FAILURE);
    }
}

//
// void debug () {
//     struct ElementoLista *aux;
//     int i = 1;
//     aux = head;
//
//     while (aux != NULL) {
//       printf("%d: %s %s\n", i, aux->tipo, aux->id);
//       aux = aux->next;
//     }
// }


void guardarId(char* id, char* tipo) {
    struct ElementoLista* nuevoElemento = (struct ElementoLista*) malloc(sizeof(struct ElementoLista));
    strcpy(id, nuevoElemento->id);
    strcpy(tipo, nuevoElemento->tipo);
    nuevoElemento->next = NULL;
    if (head == NULL) {
      head = tail = nuevoElemento;
    } else {
      tail->next = nuevoElemento;
      tail = nuevoElemento;
    }
}

//Puntero de este método esta mal --> Arreglar
void recorrerLista(char* id, char* tipo) {
    printf("recorrerLista: metodo encontrado");
    struct ElementoLista *aux;
    int existe = 0;
    aux = head;

    while(aux != NULL) {
        if ( strcmp(aux->id, id) && strcmp(aux->tipo, tipo) ) {
            existe = 1;
            break;
        }
        aux = aux->next;
    }

    if (!existe) {
      guardarId(id, tipo);
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
    strcpy(tipo, simple());
    array();
    strcpy(identificador, yytext);
    preanalisis = yylex();
    if(preanalisis == '(') {
        recorrerLista(identificador, tipo);
    }
}

void ambito () {
    if(preanalisis == PUBLIC) {
        parea(PUBLIC);
    } else if (preanalisis == PRIVATE) {
        parea(PRIVATE);
    } else if (preanalisis == PROTECTED) {
        parea(PROTECTED);
    }
    modificador();
}

void escribirFichero() {
    struct ElementoLista *aux = head;
    FILE *fichero = fopen("tipoMetodos.txt", "w");
    while(aux != NULL){
        fprintf(fichero, "%s : %s\n", aux->id, aux->tipo);
        aux = aux->next;
    }
    fclose(fichero);
}

int main(){
    head = NULL;
    tail = NULL;

    preanalisis = yylex();
    ambito();

     // yylex() devuelve 0 en el fin de fichero
    if (preanalisis == 0) {
        printf ("OK\n");
    } else {
        printf ("Sobra algo\n");
    }
    return 0;
}
