{%
//Lenguajes de Programación
#define NUMERO_RESERVADAS 60
#define NUMERO_IDENTIFICADORES 100
#define NUMERO_MAX_CARACTERES 35
#define NUMEROS 200
#define ERROR_LECTURA -1
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct {
    char key [NUMERO_MAX_CARACTERES];
    int value;
}HashMap;

HashMap TableReservadas[NUMERO_RESERVADAS];
HashMap TableIdentificadores[NUMERO_IDENTIFICADORES];
HashMap TableDigitos[NUMEROS];

int contadorReservadas = 0;
int contadorId = 0;
int contadorNumeros = 0;

%}
%%
"/*(.|\n)*/";
"//".*"\n"  ;
[\t]+       ;
.|\n        ;
{letra}     [a-zA-Z];
{palabra}   {letra}+;
{alf}       [a-zA-Z0-9];
{dig}       [0-9];
{numeros}   {dig}+;
{fraccion}  [.]{numeros};
{exponente} [eE][+-]?{numeros};
{decimal}   {numeros}{fraccion}?{exponente}?;
{id}        {letra}({alf}|"_")*;
abstract        {TableReservadas[0].value ++;}
assert          {TableReservadas[1].value ++;}
boolean         {TableReservadas[2].value ++;}
break           {TableReservadas[3].value ++;}
byte            {TableReservadas[4].value ++;}
case            {TableReservadas[5].value ++;}
catch           {TableReservadas[6].value ++;}
char            {TableReservadas[7].value ++;}
class           {TableReservadas[8].value ++;}
const           {TableReservadas[9].value ++;}
continue        {TableReservadas[10].value ++;}
default         {TableReservadas[11].value ++;}
do              {TableReservadas[12].value ++;}
double          {TableReservadas[13].value ++;}
else            {TableReservadas[14].value ++;}
enum            {TableReservadas[15].value ++;}
extends         {TableReservadas[16].value ++;}
final           {TableReservadas[17].value ++;}
finally         {TableReservadas[18].value ++;}
float           {TableReservadas[19].value ++;}
for             {TableReservadas[20].value ++;}
goto            {TableReservadas[21].value ++;}
if              {TableReservadas[22].value ++;}
implemts        {TableReservadas[23].value ++;}
import          {TableReservadas[24].value ++;}
instaceof       {TableReservadas[25].value ++;}
int             {TableReservadas[26].value ++;}
interface       {TableReservadas[27].value ++;}
long            {TableReservadas[28].value ++;}
native          {TableReservadas[29].value ++;}
new             {TableReservadas[30].value ++;}
package         {TableReservadas[31].value ++;}
private         {TableReservadas[32].value ++;}
protected       {TableReservadas[33].value ++;}
public          {TableReservadas[34].value ++;}
return          {TableReservadas[35].value ++;}
short           {TableReservadas[36].value ++;}
static          {TableReservadas[37].value ++;}
stricfp         {TableReservadas[38].value ++;}
super           {TableReservadas[39].value ++;}
switch          {TableReservadas[40].value ++;}
synchronized    {TableReservadas[41].value ++;}
this            {TableReservadas[42].value ++;}
throw           {TableReservadas[43].value ++;}
throws          {TableReservadas[44].value ++;}
transient       {TableReservadas[45].value ++;}
try             {TableReservadas[46].value ++;}
void            {TableReservadas[47].value ++;}
volatile        {TableReservadas[48].value ++;}
while           {TableReservadas[49].value ++;}
"!="        |
">="        |
"<="        |
"<"         |
">"         |
"=="        |
"+="        |
"-="        |
"*="        |
""          |
"="         |
"&&"        |
"&"         |
">>"        |
"<<"        |
"|"         |
"||"        |
"!"         |
"++"        |
"--"        |
"+"         |
"-"         |
"*"         |
"**"        |
"/"         |
"%"         |
"^"         |
"?"         |
"{"         |
"}"         |
"("         |
")"         ;
decimal     { sumarNumero(); }
id          { sumaId(); }

%%

void inicializarTablaReservadas() {
    strcpy(TableReservadas[0].key, "abstract");
    strcpy(TableReservadas[1].key, "assert");
    strcpy(TableReservadas[2].key, "boolean");
    strcpy(TableReservadas[3].key, "break");
    strcpy(TableReservadas[4].key, "byte");
    strcpy(TableReservadas[5].key, "case");
    strcpy(TableReservadas[6].key, "catch");
    strcpy(TableReservadas[7].key, "char");
    strcpy(TableReservadas[8].key, "class");
    strcpy(TableReservadas[9].key, "const");
    strcpy(TableReservadas[10].key, "continue");
    strcpy(TableReservadas[11].key, "default");
    strcpy(TableReservadas[12].key, "do");
    strcpy(TableReservadas[13].key, "double");
    strcpy(TableReservadas[14].key, "else");
    strcpy(TableReservadas[15].key, "enum");
    strcpy(TableReservadas[16].key, "extends");
    strcpy(TableReservadas[17].key, "final");
    strcpy(TableReservadas[18].key, "finally");
    strcpy(TableReservadas[19].key, "float");
    strcpy(TableReservadas[20].key, "for");
    strcpy(TableReservadas[21].key, "goto");
    strcpy(TableReservadas[22].key, "if");
    strcpy(TableReservadas[23].key, "implemts");
    strcpy(TableReservadas[24].key, "import");
    strcpy(TableReservadas[25].key, "instaceof");
    strcpy(TableReservadas[26].key, "int");
    strcpy(TableReservadas[27].key, "interface");
    strcpy(TableReservadas[28].key, "long");
    strcpy(TableReservadas[29].key, "native");
    strcpy(TableReservadas[30].key, "new");
    strcpy(TableReservadas[31].key, "package");
    strcpy(TableReservadas[32].key, "private");
    strcpy(TableReservadas[33].key, "protected");
    strcpy(TableReservadas[34].key, "public");
    strcpy(TableReservadas[35].key, "return");
    strcpy(TableReservadas[36].key, "short");
    strcpy(TableReservadas[37].key, "static");
    strcpy(TableReservadas[38].key, "stricfp");
    strcpy(TableReservadas[39].key, "super");
    strcpy(TableReservadas[40].key, "switch");
    strcpy(TableReservadas[41].key, "synchronized");
    strcpy(TableReservadas[42].key, "this");
    strcpy(TableReservadas[43].key, "throw");
    strcpy(TableReservadas[44].key, "throws");
    strcpy(TableReservadas[45].key, "transient");
    strcpy(TableReservadas[46].key, "try");
    strcpy(TableReservadas[47].key, "void");
    strcpy(TableReservadas[48].key, "volatile");
    strcpy(TableReservadas[49].key, "while");
}

void sumaId(char yylex[]) {
    int i = 0;
    int presente = 0;
    for(i;i<NUMERO_IDENTIFICADORES;i++){
        if(strcmp(yylex, TableIdentificadores[i].key)==0){
            TableIdentificadores[i].value++;
            presente=1;
        }
    }
    if(presente == 0) {
        strcpy(TableIdentificadores[contadorId].key, yylex);
        TableIdentificadores[contadorId].value++;
        contadorId++;
    }
}

void sumarNumero(char yylex[]) {
    int i = 0;
    int presente = 0;
    for(i;i<NUMEROS;i++){
        if(strcmp(yylex, TableNumeros[i].key)==0){
            TableIdentificadores[i].value++;
            presente=1;
        }
    }
    if(presente==0){
        strcpy(TableNumeros[contadorNumeros].key, yylex);
        TableNumeros[contadorNumeros].value++;
        contadorNumeros++;
    }
}


void escribeReservadas(){
    FILE *ficheroReservadas = ficheroReservadas.open("reserv.txt", "w");
     if (ficheroReservadas  == NULL) {
        fprintf(stderr,"Error de fichero.\n");
        exit(ERROR_LECTURA);
    }
    int i;
    for(i=0;i<NUMERO_RESERVADAS;i++){
        if(TableReservadas[i].value != 0){
            fprintf(fichero, "%s : %d", TableReservadas[i].key, TableReservadas[i].value);
        }
    }
    fclose(fichero);
}

void escribeIds () {
    FILE *ficheroIds = ficheroIds.open("identi.txt", "w");
     if (ficheroIds  == NULL) {
        fprintf(stderr,"Error de fichero.\n");
        exit(ERROR_LECTURA);
    }
    int i;
    for(i=0;i<NUMERO_IDENTIFICADORES;i++){
        if(TableIdentificadores[i].value != 0){
            fprintf(fichero, "%s : %d", TableIdentificadores[i].key, TableIdentificadores[i].value);
        }
    }
    fclose(ficheroIds);
}

void escribeNumeros () {
    FILE *ficheroNumeros = ficheroNumeros.open("numero.txt", "w");
    if (ficheroNumeros  == NULL) {
        fprintf(stderr,"Error de fichero.\n");
        exit(ERROR_LECTURA);
    }
    int i;
    for(i=0;i<NUMEROS;i++){
        if(TableDigitos[i].value != 0){
            fprintf(fichero, "%s : %d", TableNumeros[i].key, TableNumeros[i].value);
        }
    }
    fclose(ficheroNumeros);
}
int main( int argc, char** argv) {
    if ( argc > 1){
        yyin = fopen(argv[1],"r");
    }else{
        yyin = stdin;
    }
    inicializarTablaReservadas();
    yylex();
    escribeReservadas();
    escribeIds();
    escribeNumeros();
}
