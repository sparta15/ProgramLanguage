%{
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

	#include <stdio.h>
%}
letra     [a-zA-Z]
alf       [a-zA-Z0-9]
ambito 								("public"|"private"|"protected")
modificador	  				("static"|"abstract")
tipo 									("void"|"double"|"int"|"float"|"String"|"char"|"Scanner"|"byte"|"short"|"long"|"boolean")
id        {letra}({alf}|"_")*

%%

({ambito}" "+)?({modificador}" "+)?{tipo}" "+{id}" "*\( printf("metodo: %s\n", yytext);
. 		;
"\n" 	;
%%
int main( int argc, char** argv) {
    if ( argc > 1){
        yyin = fopen(argv[1],"r");
    }else{
        yyin = stdin;
    }
    yylex();
}
