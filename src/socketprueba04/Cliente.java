package socketprueba04;

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
		HiloLecturaCliente hiloLectura = new HiloLecturaCliente(servidor);
		HiloEscrituraCliente hiloEscritura = new HiloEscrituraCliente(servidor);
		hiloEscritura.start();
		hiloLectura.start();
		
	}

}
