package pruebas;

import java.io.*;

public class Emisor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File ruta = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","pruebas2.Receptor");
		pb.directory(ruta);
		Process p = pb.start();
		
		//leemos
		InputStream is = p.getInputStream();
		int c;
		while((c=is.read())!=-1) {
			System.out.print((char)c);
		}
		
		
		//escribimos
		OutputStream os = p.getOutputStream();
		String respuesta = "Hola mundo!";
		os.write(respuesta.getBytes());
		os.close();
		is.close();
		//recibimos
		InputStream is2 = p.getInputStream();
		while((c=is2.read())!=-1) {
			System.out.print((char)c);
		}
		is2.close();
		
	}

}
