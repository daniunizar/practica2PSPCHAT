package socketprueba03;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Hilo_Servidor extends Thread{
	//constructor
	Socket cliente;
	public Hilo_Servidor(Socket cliente) {
		this.cliente = cliente;
	}
	
	public void run(){
		InetAddress ia = cliente.getInetAddress();
		InputStream is;
		try {
			is = cliente.getInputStream();		
			DataInputStream dis = new DataInputStream(is);
			while (true) {
			System.out.println("Servidor: Recibimos el siguiente mensaje del cliente: " + dis.readUTF());
		}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
