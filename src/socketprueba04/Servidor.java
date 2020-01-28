package socketprueba04;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//El servidor necesita abrirse un puerto
		int puerto = 6000;
		ServerSocket ss = new ServerSocket(puerto);
		
		while (true) {
			Socket cliente = ss.accept(); //a la escucha
			Hilo_Servidor hilo = new Hilo_Servidor(cliente);
			hilo.start();
		}
		
	}

}
