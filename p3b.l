%{
#include "p3b.h"
%}

letra           [a-zA-Z];
palabra         {letra}+;
alf             [a-zA-Z0-9];
dig             [0-9];
numeros         {dig}+;
fraccion        [.]{numeros};
exponente       [eE][+-]?{numeros};
decimal         {numeros}+{fraccion}?{exponente}?;
id              {letra}({alf}|"_")*;

%%

\/\*(.|\n)*\/\*           ;
\/\/.*\n                  ;
[\t]+                     ;
\"(.|\n)*\"               ;
public" "+                return PUBLIC;
private" "+               return PRIVATE;
protected" "+             return PROTECTED;
static" "+                return STATIC;
abstract" "+              return ABSTRACT;
void(" "|"[")+            return VOID;
double(" "|"[")+          return DOUBLE;
int(" "|"[")+             return INT;
float(" "|"[")+           return FLOAT;
String(" "|"[")+          return STRING;
char(" "|"[")+            return CHAR;
Scanner(" "|"[")+         return SCANNER;
byte(" "|"[")+            return BYTE;
short(" "|"[")+           return SHORT;
long(" "|"[")+            return LONG;
boolean(" "|"[")+         return BOOLEAN;
"["                       return OPENARRAY;
"]"                       return CLOSEARRAY;
"("                       return OPENPAREN;
")"                       return CLOSEPAREN;
"!="                      |
">="                      |
"<="                      |
"<"                       |
">"                       |
"=="                      |
"+="                      |
"-="                      |
"*="                      |
"="                       |
"&&"                      |
"&"                       |
">>"                      |
"<<"                      |
"|"                       |
"||"                      |
"!"                       |
"++"                      |
"--"                      |
"+"                       |
"-"                       |
"*"                       |
"**"                      |
"/"                       |
"%"                       |
"^"                       |
"?"                       |
"{"                       |
"}"                       |
({id})                      return ID;

%%
