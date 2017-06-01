/**
* Universidad de Valladolid
* E.T.S Ingeniería Informática
* Grado en Ingeniería Informática
* Mención de Ingeniería de Software
*
* Curso 2016/2017
* Lenguajes de Programacion
* Practica 3 Fase b
*
* Diego Cristóbal, Ester
* Gutiérrez Casado, Carlos
* Lara Mongil, Víctor
* Pastor Díez, Guillermo
*/

#include "lex.yy.c"
#include <stdlib.h>

 struct ElementoLista {
    char tipo[20];
    char id[2000];
    int dim;
    struct ElementoLista *next;
};

struct ElementoLista *head;
struct ElementoLista *tail;

int preanalisis;
char *tipo;
char identificador[2000];
int dim;

void parea();
void array();
void modificador();
void ambito();
void simple();
void getId();
void debug();
void escribirFichero();

void parea (int token) {
    if (preanalisis == token) {
        preanalisis = yylex();
    } else {
        printf ("Componente léxico inesperado en %s\n", yytext);
        exit (EXIT_FAILURE);
    }
}

void preArray() {
    dim = 0;
    array();
}

void simple () {
    if (preanalisis == INT) {
        parea (INT);
        tipo = "INT";
        preArray();
    } else if (preanalisis == VOID) {
        parea (VOID);
        tipo = "VOID";
        preArray();
    } else if (preanalisis == CHAR) {
        parea (CHAR);
        tipo = "CHAR";
        preArray();
    } else if (preanalisis == STRING ) {
        parea (STRING);
        tipo = "STRING";
        preArray();
    } else if (preanalisis == DOUBLE) {
        parea (DOUBLE);
        tipo = "DOUBLE";
        preArray();
    }else if (preanalisis == SCANNER) {
        parea (SCANNER);
        tipo = "SCANNER";
        preArray();
    } else if (preanalisis == FLOAT ) {
        parea (FLOAT);
        tipo = "FLOAT";
        preArray();
    } else if (preanalisis == LONG ) {
        parea (LONG);
        tipo = "LONG";
        preArray();
    } else if (preanalisis == SHORT ) {
        parea (SHORT);
        tipo = "SHORT";
        preArray();
    } else if (preanalisis == BYTE ) {
        parea (BYTE);
        tipo = "BYTE";
        preArray();
    } else if (preanalisis == BOOLEAN ) {
        parea (BOOLEAN);
        tipo = "BOOLEAN";
        preArray();
    } else {
        preanalisis = yylex();
        ambito();
    }
}

void guardarId() {
    struct ElementoLista* nuevoElemento = (struct ElementoLista*) malloc(sizeof(struct ElementoLista));

    strcpy(nuevoElemento->id, identificador);
    strcpy(nuevoElemento->tipo, tipo);
    nuevoElemento->dim = dim;
    nuevoElemento->next = NULL;

    if (head == NULL) {
      head = tail = nuevoElemento;
    } else {
      tail->next = nuevoElemento;
      tail = nuevoElemento;
    }

    ambito();
}

void recorrerLista() {
    struct ElementoLista *aux;
    int existe = 0;
    aux = head;

    while(aux != NULL) {
        if ( (strcmp(aux->id, identificador) == 0) &&
             (strcmp(aux->tipo, tipo) == 0)  && aux->dim == dim) {
            existe = 1;
            break;
        }
        aux = aux->next;
    }

    if (!existe) {
      guardarId();
    } else {
      ambito();
    }
}

void array () {
    if(preanalisis == OPENARRAY) {
        parea(OPENARRAY);
        if (preanalisis == CLOSEARRAY) {
          parea(CLOSEARRAY);
          dim++;
          array();
        } else {
          ambito();
        }
    } else {
      getId();
    }
}

void getId() {
    if (preanalisis == ID) {
      strcpy(identificador, yytext);
      parea(ID);
    	if(preanalisis == OPENPAREN) {
      		parea(OPENPAREN);
      		recorrerLista();
    	}else{
             ambito();
    	}
    } else {
      ambito();
    }
}

void modificador () {
    if(preanalisis == STATIC) {
        parea(STATIC);
    }
    simple();
}

void ambito () {
    if(preanalisis == PUBLIC) {
        parea(PUBLIC);
    } else if (preanalisis == PRIVATE) {
        parea(PRIVATE);
    } else if (preanalisis == PROTECTED) {
        parea(PROTECTED);
    } if (preanalisis != 0) {
      modificador();
    } else {
      escribirFichero();
    }
}

void escribirFichero() {
    struct ElementoLista *aux = head;
    int i = 1;
    FILE *fichero = fopen("tipoMetodos.txt", "w");

    while(aux != NULL){
        fprintf(fichero, "%s : %s ", aux->id, aux->tipo);
        for (i = 0; i < aux->dim; i++) {
          fprintf(fichero, "[]");
        }
        fprintf(fichero, "\n");
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
