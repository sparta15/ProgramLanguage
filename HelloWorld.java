public class HelloWorld {

     public static int[][] pruebaArrays(){
       if (metodo(metodo(true))) {
         return new int[3][2];
       }
       return null;
    }


    public static void main(String[] args) {
        System.out.println("Hello, World");
      	int aux = 3;
      	int aux2 = 4;
      	String aux3 = "aux3string con espacios \n y saltos";
      	float aux4asd = 33.2;
      	String fallo = "public";
        pruebaArrays();
    }

    private boolean metodo(boolean asd) {
      return true;
    }

}
