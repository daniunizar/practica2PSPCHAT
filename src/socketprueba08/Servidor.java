package socketprueba08;
/*
Hemos conseguido crear un chat con login que funcione.
Hemos metido lo de los 3 intentos, pero no est� testeado. S�lo se ha comprobado que se logueen correctamente y hablen entre ellos:
-Solucionar: 
---Que el logueo se haga desde un fichero con nombre, clave y rol
---Que si fallas el logueo tengas 3 intentos y no crashee  */
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
