package socketprueba04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HiloLecturaCliente extends Thread{
	Socket servidor;
	public HiloLecturaCliente(Socket servidor) {
		this.servidor = servidor;
	}
	public void run() {
		InetAddress ia= servidor.getInetAddress();
		InputStream is;
		while(true) {
		try {
			is = servidor.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
}
