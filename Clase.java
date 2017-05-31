import java.util.Scanner.*;
public class Clase {
	// Un programa de prueba
	double campo1;
	static double campo2 = 100;

	public Clase () {
	    // constructor 
	    this.campo1 = 1;
	}

	public int algo () {
		return (int) this.campo1;
	}
	
	public int[] algo () {
		int[] unacosa;
        	unacosa = new int[5];
		return unacosa;
	}
	
	public Clase transformado (Clase param) {
		Clase intermedia;
		intermedia = new Clase();
		intermedia.campo1 = param.campo1 +1;
		return intermedia;
	}

	public static void main (String args [] ){
	
		/* un comentario en 2 ó tres 
		   líneas */
		int dos=2, tres = 1;
		Clase c = new Clase();
		/* un comentario en 2 ó tres * / /*  
		   líneas */
		System.out.println ("Hola 99 ");
		/* 88 un comentarrio */ System.out.print  ("Valor 122= " + dos + 2 + " y ") ; /* 77 otro comentario */
		System.out.println  (" valor 1 : " + tres*tres + " son 2 líneas");
		for (int i=1; i<= 10; i++) {
			dos = (int) ((double)dos/2);
			int j= i;
			while (j>0) {
				j--;
			}
			tres = (/* vaya sitio raro */ int) 3;
		}
			
	}
}
