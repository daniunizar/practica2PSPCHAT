package socketprueba04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		OutputStream os;
		try {
			os = cliente.getOutputStream();
			is = cliente.getInputStream();		
			
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			String cadena = "";
			while (true) {
			cadena = dis.readUTF();
			System.out.println("Servidor: Recibimos el siguiente mensaje del cliente: " + cadena);
			dos.writeUTF(cadena);
		}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
