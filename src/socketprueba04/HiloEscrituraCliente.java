package socketprueba04;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HiloEscrituraCliente extends Thread{
	Socket servidor;
	public HiloEscrituraCliente(Socket servidor) {
		this.servidor = servidor;
	}
	public void run() {
		InetAddress ia= servidor.getInetAddress();
		OutputStream os;
		try {
			os = servidor.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
		System.out.println("Cliente: Escriba un mensaje que enviar al servidor");
		Scanner teclado = new Scanner(System.in);
		String cadena = "";
		while (true) {
			cadena = teclado.nextLine();
			dos.writeUTF(cadena);
		}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
