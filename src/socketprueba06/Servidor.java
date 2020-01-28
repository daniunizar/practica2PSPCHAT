package socketprueba06;
/*
 * Cuando un cliente envía un mensaje, llega a todos, incluido a él mismo.
 * Estamos tratandode solucionar eso con un objeto compartido que sirva de criterio
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
		//El servidor necesita abrirse un puerto
		int puerto = 6000;
		ServerSocket ss = new ServerSocket(puerto);
		ObjetoCompartido ob = new ObjetoCompartido();
		ob.crearLista();
		while (true) {
			Socket cliente = ss.accept(); //a la escucha
			ob.anadirLista(cliente); //añadimos el cliente que nos contacta a la lista compartida
			
			Hilo_Servidor hilo = new Hilo_Servidor(cliente, ob);//Creamos un nuevo hilo y lo iniciamos
			hilo.start();
		}
		
	}

}
