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
    char tipo[20];
    char id[2000];
    int dim;
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
    printf("en parea\n");
    // printf("prea = %d, token = %d, yytext = %s\n", preanalisis, token, yytext);
    if (preanalisis == token) {
        preanalisis = yylex();
    } else {
        printf ("Componente léxico inesperado en %s\n", yytext);
        exit (EXIT_FAILURE);
    }
}

void preArray() {
    printf("en preArray\n");
    dim = 0;
    array();
}

void simple () {
    printf("en simple\n");
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
    printf("en guardarId\n");
    struct ElementoLista* nuevoElemento = (struct ElementoLista*) malloc(sizeof(struct ElementoLista));
    // nuevoElemento->id = (char*) malloc(2000 * sizeof(char));
    // nuevoElemento->tipo = (char*) malloc(20 * sizeof(char));
    // nuevoElemento
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

//Puntero de este método esta mal --> Arreglar
void recorrerLista() {
    printf("en recorrerLista\n");
    struct ElementoLista *aux;
    int existe = 0;
    aux = head;

    while(aux != NULL) {
        if ( strcmp(aux->id, identificador) && strcmp(aux->tipo, tipo) ) {
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
    printf("en array\n");
    if(preanalisis == OPENARRAY) {
        parea(OPENARRAY);
        if (preanalisis == CLOSEARRAY) {
          parea(CLOSEARRAY);
          dim++;
          array();
        } else {
          preanalisis = yylex();
          ambito();
        }
    } else {
      getId();
    }
}

void getId() {
    printf("en getID\n");
    if (preanalisis == ID) {
      strcpy(identificador, yytext);
      parea(ID);
      // printf("en ID --> %s\n", yytext);
      recorrerLista();
    } else {
      preanalisis = yylex();
      ambito();
    }
}

void modificador () {
    printf("en modificador\n");
    if(preanalisis == STATIC) {
        parea(STATIC);
    }
    simple();

    // printf("yytext = %s\n", yytext);
    // strcpy(identificador, yytext);
    // printf("tres\n");
    // preanalisis = yylex();
    // printf("cuatro %c %d\n", preanalisis, preanalisis);
    // if(preanalisis == OPENPAREN) {
    //     recorrerLista(identificador, tipo);
    // }
}

void ambito () {
    printf("en ambito\n");
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
    printf("en escribirFichero\n");
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
