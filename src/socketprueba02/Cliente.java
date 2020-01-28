package socketprueba02;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//una conexión con host y puerto
		String host = "localhost";
		int puerto = 6000;
		Socket servidor = new Socket(host, puerto);
		InetAddress ia= servidor.getInetAddress();
		OutputStream os = servidor.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		System.out.println("Cliente: Escriba un mensaje que enviar al servidor");
		Scanner teclado = new Scanner(System.in);
		String cadena = "";
		while (true) {
			cadena = teclado.nextLine();
			dos.writeUTF(cadena);
		}
	}

}
