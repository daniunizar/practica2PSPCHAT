package socketprueba06;
/*
 * Tenemos el men� del cliente. Una vez se conecta el mensaje llega a todos los clientes.
 * Siguiente paso: Que cuando el cliente se conecta el Servidor compruebe credenciales
 * Siguiente paso: Que si los credenciales fallan, tenga 3 intentos (debe volver al men� del cliente)
 * */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//El servidor necesita abrirse un puerto
		int puerto = 6000;
		ServerSocket ss = new ServerSocket(puerto);
		ObjetoCompartido ob = new ObjetoCompartido();
		ob.crearLista();
		while (true) {
			Socket cliente = ss.accept(); //a la escucha
			ob.anadirLista(cliente);
			
			Hilo_Servidor hilo = new Hilo_Servidor(cliente, ob);
			hilo.start();
		}
		
	}

}
