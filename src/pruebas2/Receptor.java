package pruebas2;

import java.io.*;

public class Receptor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hola, escribe algo");
		
		System.out.println("Hola, ME LEES?");
		
		System.out.println("Hola, Has llegado a la tercera syso");
		
		InputStreamReader is = new InputStreamReader(System.in);
		String texto="";
		int c;
		while ((c=is.read())!=-1){
			texto = texto+(char)c;
		}
		System.out.println(texto);
	}

}
