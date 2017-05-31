grammar CodigoJavaGuille;

@header {
    import java.util.*;
    import java.io.*;
}

@parser::members {
    ArrayList < ArrayList<String> > listaMetodos = new ArrayList <ArrayList<String>>();
    File fichero;
    FileWriter escrituraFichero;
    String metodoActual;
    String identificador_metodo;
    String metodo_padre;
    String metodo_dentro;
}

prog : idspc CLASS ID '{' clase '}';

idspc : ID idspc
        | ';' idspc
        | ;

clase : ids tipo=ID metodo=ID
        {
            System.out.println("oooooooo");
            System.out.println("Identificador de metodo: "+$metodo.text);
            identificador_metodo=$metodo.text;
        }
        resto
        | ;

resto : '('
        {
              System.out.println("Entro");
              System.out.println("Metodo padre: "+metodo_padre);
              System.out.println("Metodo Dentro: "+ identificador_metodo);
        }
         params ')' def
        | ';' clase ;

def : '{'
        {
                metodo_padre=identificador_metodo;
                System.out.println("*************DEF");
                System.out.println("Metodo DEF: "+metodo_padre);
                //Add metodo listaMetodos
        }
        codigo '}'
        {
            metodo_padre=null;
        }
        clase
       | ';' clase ;

ids : ID ids
      | ;

codigo : identificador=ID
          {
              identificador_metodo=$identificador.text;
          }
         codigo
         | ';' codigo
         |
            {
                    System.out.println("*************DEBUG");
                    System.out.println("Metodo padre: "+metodo_padre);
                    System.out.println("Metodo hijo: "+ identificador_metodo);
                    //Add metodo listaMetodos
            }
         '('codigo ')' codigo
         |'{'codigo '}' codigo
         | ;

params : ID params
         | ;

CLASS : 'class';
ID : LETTER(LETTER | DIGIT)*;  //Identificadores de variables
LETTER : [a-zA-Z];
DIGIT : [0-9]+;
WS : [ \t\n]+ -> skip;
SYSTEM : 'System'.*? ';' -> skip;