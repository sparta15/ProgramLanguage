%{
	/**
	* Universidad de Valladolid
	* E.T.S Ingeniería Informática
	* Grado en Ingeniería Informática
	* Mención de Ingeniería de Software
	*
	* Curso 2016/2017
	* Lenguajes de Programacion
	* Practica 3 Fase a
	*
	* Diego Cristóbal, Ester
	* Gutiérrez Casado, Carlos
	* Lara Mongil, Víctor
	* Pastor Díez, Guillermo
	*/
	 
	#include <stdio.h>

	#define NUMERO_RESERVADAS 60
	#define NUMERO_IDENTIFICADORES 100
	#define NUMERO_MAX_CARACTERES 35
	#define NUMEROS 200
	#define ERROR_LECTURA -1

	typedef struct {
		char key [NUMERO_MAX_CARACTERES];
		int value;
	} HashMap;

	HashMap tableReservadas[NUMERO_RESERVADAS];
	HashMap tableIdentificadores[NUMERO_IDENTIFICADORES];
	HashMap tableDigitos[NUMEROS];

	int contadorReservadas = 0;
	int contadorId = 0;
	int contadorNumeros = 0;

	void sumaId();
	void sumarNumero();
%}

letra     [a-zA-Z]
palabra   {letra}+
alf       [a-zA-Z0-9]
dig       [0-9]
numeros   {dig}+
fraccion  [.]{numeros}
exponente [eE][+-]?{numeros}
decimal   {numeros}{fraccion}?{exponente}?
id        {letra}({alf}|"_")*

%%
\/\*(.|\n)*\/\* ;
\/\/.*\n     		;
[\t]+           ;
\".*\"					;
abstract        tableReservadas[0].value ++;
assert          tableReservadas[1].value ++;
boolean         tableReservadas[2].value ++;
break           tableReservadas[3].value ++;
byte            tableReservadas[4].value ++;
case            tableReservadas[5].value ++;
catch           tableReservadas[6].value ++;
char            tableReservadas[7].value ++;
class           tableReservadas[8].value ++;
const           tableReservadas[9].value ++;
continue        tableReservadas[10].value ++;
default         tableReservadas[11].value ++;
do              tableReservadas[12].value ++;
double          tableReservadas[13].value ++;
else            tableReservadas[14].value ++;
enum            tableReservadas[15].value ++;
extends         tableReservadas[16].value ++;
final           tableReservadas[17].value ++;
finally         tableReservadas[18].value ++;
float           tableReservadas[19].value ++;
for             tableReservadas[20].value ++;
goto            tableReservadas[21].value ++;
if              tableReservadas[22].value ++;
implemts        tableReservadas[23].value ++;
import          tableReservadas[24].value ++;
instaceof       tableReservadas[25].value ++;
int             tableReservadas[26].value ++;
interface       tableReservadas[27].value ++;
long            tableReservadas[28].value ++;
native          tableReservadas[29].value ++;
new             tableReservadas[30].value ++;
package         tableReservadas[31].value ++;
private         tableReservadas[32].value ++;
protected       tableReservadas[33].value ++;
public          tableReservadas[34].value ++;
return          tableReservadas[35].value ++;
short           tableReservadas[36].value ++;
static          tableReservadas[37].value ++;
stricfp         tableReservadas[38].value ++;
super           tableReservadas[39].value ++;
switch          tableReservadas[40].value ++;
synchronized    tableReservadas[41].value ++;
this            tableReservadas[42].value ++;
throw           tableReservadas[43].value ++;
throws          tableReservadas[44].value ++;
transient       tableReservadas[45].value ++;
try             tableReservadas[46].value ++;
void            tableReservadas[47].value ++;
volatile        tableReservadas[48].value ++;
while           tableReservadas[49].value ++;
{decimal}     	sumarNumero(yytext);
{id}          	sumaId(yytext);
\n                      /* ignore end of line */;
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
")"         {}

%%

void inicializarTablaReservadas() {
    strcpy(tableReservadas[0].key, "abstract");
    strcpy(tableReservadas[1].key, "assert");
    strcpy(tableReservadas[2].key, "boolean");
    strcpy(tableReservadas[3].key, "break");
    strcpy(tableReservadas[4].key, "byte");
    strcpy(tableReservadas[5].key, "case");
    strcpy(tableReservadas[6].key, "catch");
    strcpy(tableReservadas[7].key, "char");
    strcpy(tableReservadas[8].key, "class");
    strcpy(tableReservadas[9].key, "const");
    strcpy(tableReservadas[10].key, "continue");
    strcpy(tableReservadas[11].key, "default");
    strcpy(tableReservadas[12].key, "do");
    strcpy(tableReservadas[13].key, "double");
    strcpy(tableReservadas[14].key, "else");
    strcpy(tableReservadas[15].key, "enum");
    strcpy(tableReservadas[16].key, "extends");
    strcpy(tableReservadas[17].key, "final");
    strcpy(tableReservadas[18].key, "finally");
    strcpy(tableReservadas[19].key, "float");
    strcpy(tableReservadas[20].key, "for");
    strcpy(tableReservadas[21].key, "goto");
    strcpy(tableReservadas[22].key, "if");
    strcpy(tableReservadas[23].key, "implemts");
    strcpy(tableReservadas[24].key, "import");
    strcpy(tableReservadas[25].key, "instaceof");
    strcpy(tableReservadas[26].key, "int");
    strcpy(tableReservadas[27].key, "interface");
    strcpy(tableReservadas[28].key, "long");
    strcpy(tableReservadas[29].key, "native");
    strcpy(tableReservadas[30].key, "new");
    strcpy(tableReservadas[31].key, "package");
    strcpy(tableReservadas[32].key, "private");
    strcpy(tableReservadas[33].key, "protected");
    strcpy(tableReservadas[34].key, "public");
    strcpy(tableReservadas[35].key, "return");
    strcpy(tableReservadas[36].key, "short");
    strcpy(tableReservadas[37].key, "static");
    strcpy(tableReservadas[38].key, "stricfp");
    strcpy(tableReservadas[39].key, "super");
    strcpy(tableReservadas[40].key, "switch");
    strcpy(tableReservadas[41].key, "synchronized");
    strcpy(tableReservadas[42].key, "this");
    strcpy(tableReservadas[43].key, "throw");
    strcpy(tableReservadas[44].key, "throws");
    strcpy(tableReservadas[45].key, "transient");
    strcpy(tableReservadas[46].key, "try");
    strcpy(tableReservadas[47].key, "void");
    strcpy(tableReservadas[48].key, "volatile");
    strcpy(tableReservadas[49].key, "while");
}

void sumaId(char yylex[]) {
    int i;
    int presente = 0;
    for(i=0;i<NUMERO_IDENTIFICADORES;i++){
        if(strcmp(yylex, tableIdentificadores[i].key)==0){
            tableIdentificadores[i].value++;
	    printf("hola");
            presente=1;
        }
    }
    if(presente == 0) {
        strcpy(tableIdentificadores[contadorId].key, yylex);
        tableIdentificadores[contadorId].value++;
        contadorId++;
    }
}

void sumarNumero(char yylex[]) {
    int a;
    int presente = 0;
    for(a=0;a<NUMEROS;a++){
        if(strcmp(yylex, tableDigitos[a].key)==0){
            tableDigitos[a].value++;

	    printf("hola");
	    printf("%d", tableDigitos[a].value++);
            presente=1;
        }
    }
    if(presente==0){
        strcpy(tableDigitos[contadorNumeros].key, yylex);
        tableDigitos[contadorNumeros].value++;
        contadorNumeros++;
    }
}


void escribeReservadas(){
    FILE *ficheroReservadas = fopen("reserv.txt", "w");
    // if (ficheroReservadas  == NULL) {
       // fprintf(stderr,"Error de fichero.\n");
        //exit(ERROR_LECTURA);
    //}
    int i;
    for(i=0;i<NUMERO_RESERVADAS;i++){
        if(tableReservadas[i].value != 0){
            fprintf(ficheroReservadas, "%s : %d\n", tableReservadas[i].key, tableReservadas[i].value);
        }
    }
    fclose(ficheroReservadas);
}

void escribeIds () {
    FILE *ficheroIds = fopen("identi.txt", "w");
     //if (ficheroIds  == NULL) {
       // fprintf(stderr,"Error de fichero.\n");
        //exit(ERROR_LECTURA);
    //}
    int i;
    for(i=0;i<NUMERO_IDENTIFICADORES;i++){
        if(tableIdentificadores[i].value != 0){
            fprintf(ficheroIds, "%s : %d\n", tableIdentificadores[i].key, tableIdentificadores[i].value);
        }
    }
    fclose(ficheroIds);
}

void escribeNumeros () {
    FILE *ficheroNumeros = fopen("numero.txt", "w");
    //if (ficheroNumeros  == NULL) {
      //  fprintf(stderr,"Error de fichero.\n");
       // exit(ERROR_LECTURA);
   // }
    int i;
    for(i=0;i<NUMEROS;i++){
        if(tableDigitos[i].value != 0){
            fprintf(ficheroNumeros, "%s : %d\n", tableDigitos[i].key, tableDigitos[i].value);
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
