package socketprueba06;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//Definimos una conexión con host y puerto
		String host = "localhost";
		int puerto = 6000;
		Socket servidor = new Socket(host, puerto);
		
		//Definiremos las variables de usuario y contraseña
		String usuario;
		String contra;
		
		//Y el objeto compartido por todos los clientes
		String ob;
		
		//Creamos un hilo para escribir al servidor y otro para leer del servidor, y los iniciamos
		HiloLecturaCliente hiloLectura = new HiloLecturaCliente(servidor);
		HiloEscrituraCliente hiloEscritura = new HiloEscrituraCliente(servidor);
		hiloEscritura.start();
		hiloLectura.start();
		
	}

}
