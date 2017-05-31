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

prog : idspc CLASS ID '{' clase '}'
       //Apertura de fichero y escritura de listaMetodos
    {
        try {
            File fichero = new File("ficheroSalida.txt");
            FileWriter escrituraFichero = new FileWriter(fichero, false);
            for(int i=0; i< listaMetodos.size(); i++){
                for(int j = 0; j< listaMetodos.get(i).size(); j++){
                    if(j == 0) {
                        escrituraFichero.write(listaMetodos.get(i).get(j)+"\n");
                    } else {
                        escrituraFichero.write("\t"+listaMetodos.get(i).get(j)+"\n");
                    }
                }
            }
            /*
            System.out.println("DEBUG: escribiendofichero:");
            for(int j = 0 ; j < listaMetodos.size(); j++){
                for(int a = 0; a < listaMetodos.get(j).size(); a++) {
                    System.out.println(listaMetodos.get(j).get(a));
                }
            }
            */
            escrituraFichero.close();
        } catch(IOException exception){};
    };

idspc : ID idspc
        | ';' idspc
        | ;

clase : tipo=ID metodo=ID ids resto
        | ;

resto : '(' params ')' def
        | def
        | ';' clase ;

def : '{' codigo '}' clase
       | ';' clase ;

ids : ID ids
      | ;

codigo : identificador=ID
          {
              identificador_metodo=$identificador.text;
          }
         codigo
         | ';' codigo
         | '('
         {
              System.out.println("Metodo padre: "+metodo_padre);
              System.out.println("Metodo Dentro: "+ identificador_metodo);
          }
          codigo ')' codigo
         |'{'
            {
                metodo_padre=identificador_metodo;
                System.out.println("*************DEBUG");
                System.out.println("Metodo: "+metodo_padre);
                //Add metodo listaMetodos
            }
         codigo '}' codigo
         | ;

params : ID params
         | ;

CLASS : 'class';
ID : LETTER(LETTER | DIGIT)*;  //Identificadores de variables
LETTER : [a-zA-Z];
DIGIT : [0-9]+;
WS : [ \t\n]+ -> skip;
