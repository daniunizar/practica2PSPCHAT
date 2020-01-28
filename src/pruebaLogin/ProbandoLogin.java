package pruebaLogin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProbandoLogin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File ruta = new File ("./src/pruebaLogin/usuarios.txt");
		FileReader fr = new FileReader(ruta);
		BufferedReader br = new BufferedReader(fr);
		String linea="";

		Usuario usuario = new Usuario("Stuka")
		
		while ((linea = br.readLine()) != null) {
			System.out.println(linea);
			String [] partes = linea.split(" ");
			System.out.println(partes[0]);
			System.out.println(partes[1]);
			
		}
		
	}

}
