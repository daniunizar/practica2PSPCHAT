package socketprueba06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Hilo_Servidor extends Thread{
	//constructor
	Socket cliente;
	ObjetoCompartido ob;
	public Hilo_Servidor(Socket cliente, ObjetoCompartido ob) {
		this.cliente = cliente;
		this.ob = ob;
	}
	
	public void run(){
		InetAddress ia = cliente.getInetAddress();
		InputStream is;
		OutputStream os;
		try {
			
			is = cliente.getInputStream();		
			
			
			DataInputStream dis = new DataInputStream(is);
			String cadena = "";
			while (true) {
			cadena = dis.readUTF();
			System.out.println("Servidor: Recibimos el siguiente mensaje del cliente: " + cadena);
			//enviar a todos el mensaje recibido
			ArrayList <Socket> miLista = new ArrayList<>();
			miLista = ob.dimeListaUsuarios();
			for(Socket elemento : miLista) {
				Socket cliente = elemento;
				os = cliente.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF(cadena);
			}
			
		}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
