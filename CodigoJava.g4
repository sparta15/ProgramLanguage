grammar CodigoJava;

@header {
    import java.util.*;
    import java.io.*;
}

@parser::members {
    // lista bidimensional de los metodos, en la posicion cero de cada ArrayLis esta el padre,
    // el resto de la lista son las llamadas a metodos que se producen en ese padre
    ArrayList< ArrayList <String> > metodos = new ArrayList();
}

prog :
      idspc CLASS ID '{' clase '}'
      {
        // Procesamos el resultado

        ArrayList< ArrayList <String> > aux;
        File fichero;
        FileWriter escrituraFichero;
        boolean isMetodo;

        aux = new ArrayList();
        isMetodo = false;

        // Copiamos en aux los metodos "padre"
        for (int i = 0; i < metodos.size(); i++) {
          aux.add(new ArrayList<>());
          aux.get(aux.size() - 1).add(metodos.get(i).get(0));
        }

        // Añadimos a cada "padre" en aux los metodos "hijo" que sean metodos padre,
        // descartando asi cualquier llamada a un metodo que no sea de la clase
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

        // guardamos aux en metodos
        metodos = aux;

        // escribimos los resultados en el fichero
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

// "clase" se encarga de las definiciones de atributos y metodos.
clase :
      ids ID metodoPadre=ID
      {
        // si encontramos un metodo padre, lo añadimos
        metodos.add(new ArrayList<>());
        metodos.get(metodos.size() - 1).add($metodoPadre.text);
      }
      '(' params ')' '{' codigo '}' clase
    | ids ID ID '(' params ')' ';' clase
    | ids ID ID ';' clase
    | ids ID DIGIT ';' clase // evita errores con valores numericos
    | ;

codigo :
      ids metodoHijo=ID
      {
        // si encontramos un hijo lo añadimos. Como se parsea el codigo de forma
        // secuencial, el metodo que contiene a esta llamada sera el ultimo "padre" añadido
        metodos.get(metodos.size() - 1).add($metodoHijo.text);
      }
      '(' codigo ')' codigo
    | ID codigo
    | DIGIT codigo // evita errores con valores numericos
    | ';' codigo
    | '(' codigo ')' codigo
    | '{' codigo '}' codigo
    | ;

ids :
      ID ids
    | DIGIT ids // evita errores con valores numericos
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

// white spaces
WS :
      [ \t\n]+ -> skip
;

// comentarios de multiples lineas
MULTIPLE_LINE_COMMENT :
      '/*' .*? '*/' -> skip
;

// comentarios de linea
ONE_LINE_COMMENT :
      '//' ~[\r\n]* -> skip
;

// descarta los imports.
IMPORTS :
      'import' .*? ';\n' -> skip
;
