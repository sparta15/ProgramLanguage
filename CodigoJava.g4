grammar CodigoJava;

@header {
    import java.util.*;
    import java.io.*;
}

@parser::members {
    ArrayList< ArrayList <String> > metodos = new ArrayList();
}

prog :
      idspc CLASS ID '{' clase '}'
      {
        ArrayList< ArrayList <String> > aux;
        File fichero;
        FileWriter escrituraFichero;
        boolean isMetodo;

        aux = new ArrayList();
        isMetodo = false;

        for (int i = 0; i < metodos.size(); i++) {
          aux.add(new ArrayList<>());
          aux.get(aux.size() - 1).add(metodos.get(i).get(0));
        }

        for (int i = 0; i < metodos.size(); i++) {
          for (int j = 1; j < metodos.get(i).size(); j++) {
            isMetodo = false;
            for (int k = 0; k < aux.size(); k++) {
              if (metodos.get(i).get(j).equals(aux.get(k).get(0))) {
                isMetodo = true;
              }
            }
            if (isMetodo) {
              aux.get(i).add(metodos.get(i).get(j));
            }
          }
        }

        metodos = aux;

        try {
          fichero = new File("ficheroSalida.txt");
          escrituraFichero = new FileWriter(fichero, false);

          for (int i = 0; i < metodos.size(); i++) {
            escrituraFichero.write(metodos.get(i).get(0)+"\n");
            for(int j = 1; j < metodos.get(i).size(); j++){
              escrituraFichero.write("\t"+metodos.get(i).get(j)+"\n");
            }
          }

          escrituraFichero.close();
        } catch (IOException exception) {
          System.err.println(exception);
        }

      }
      ;

idspc :
      ID idspc
    | ';' idspc
    | ;

clase :
      ids ID metodoPadre=ID
      {
        metodos.add(new ArrayList<>());
        metodos.get(metodos.size() - 1).add($metodoPadre.text);
      }
      '(' params ')' '{' codigo '}' clase
    | ids ID ID '(' params ')' ';' clase
    | ids ID ID ';' clase
    | ids ID DIGIT ';' clase
    | ;

codigo :
      ids metodoHijo=ID
      {
        metodos.get(metodos.size() - 1).add($metodoHijo.text);
      }
      '(' codigo ')' codigo
    | ID codigo
    | DIGIT codigo
    | ';' codigo
    | '(' codigo ')' codigo
    | '{' codigo '}' codigo
    | ;

ids :
      ID ids
    | DIGIT ids
    | ;

params :
      ID params
    | ;


CLASS :
      'class'
;

ID :
      LETTER(LETTER | DIGIT)*
;

LETTER :
      [a-zA-Z]
;

DIGIT :
      [0-9]+
;

WS :
      [ \t\n]+ -> skip
;

MULTIPLE_LINE_COMMENT :
      '/*' .*? '*/' -> skip
;

ONE_LINE_COMMENT :
      '//' ~[\r\n]* -> skip
;

IMPORTS :
      'import' .*? ';\n' -> skip
;
