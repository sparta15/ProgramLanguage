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
        }
        ;

idspc : ID idspc
        | ';' idspc
        | ;

clase : ids tipo=ID metodo=ID
        {
            identificador_metodo=$metodo.text;
        }
        resto
        | ;

resto : '('
        {
              System.out.println("*********DEFINICION");
              System.out.println("Metodo padre: "+metodo_padre);
              System.out.println("Metodo Dentro: "+ identificador_metodo);
              if(metodo_padre == null){
                  listaMetodos.add(new ArrayList<>());
                  listaMetodos.get(listaMetodos.size() - 1).add(identificador_metodo);
              }
        }
         params ')' def
        | ';' clase ;

def : '{'
        {
                metodo_padre=identificador_metodo;
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
                    System.out.println("*************PADRES CONOCIDOS");
                    System.out.println("Metodo padre: "+metodo_padre);
                    System.out.println("Metodo hijo: "+ identificador_metodo);
                    for(int i=0;i<listaMetodos.size();i++){
                      if(listaMetodos.get(i).get(0).equals(metodo_padre)){
                          listaMetodos.get(i).add(identificador_metodo);
                      }
                    }
            }
         '('codigo ')' codigo
         |'{'codigo '}' codigo
         | DIGIT codigo
         | ;

params : ID params
         | ;

CLASS : 'class';
ID : LETTER(LETTER | DIGIT)*;  //Identificadores de variables
LETTER : [a-zA-Z];
DIGIT : [0-9]+;
WS : [ \t\n]+ -> skip;
SYSTEM : 'System'.*? ';' -> skip;