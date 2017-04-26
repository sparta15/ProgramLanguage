#include "lex.yy.c"

int main(){
	int aux;

  while( (aux = yylex()) != 0) {
    printf("\nyylex = %d\n", aux);
  }
	return 0;
}
