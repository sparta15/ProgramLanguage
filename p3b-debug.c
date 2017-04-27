#include "lex.yy.c"

int main(){
	int aux;

  while( (aux = yylex()) != 0) {
		printf("yylex = %d\n", aux);
    if (aux == ID) {
			printf("id = %s\n", yytext);
		}
  }
	return 0;
}
