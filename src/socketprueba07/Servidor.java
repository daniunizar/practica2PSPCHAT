package socketprueba07;
/*
 * Logro: Hemos conseguido que el cliente se loguee y contecte y envíe y el server le reciba
 * ----LO QUE PRETENDÍA
 *  * ACTUAL: TRATAR DE CORRER EL HILO LECTURA CLIENTE DESPUÉS DE VALIDAR CREDENCIALES
 * Estamos tratando de hacer:
 * -Cuando el cliente se conecta debe enviar (su socket, nombre, contraseña)
 * -El servidor debe comprobarlo en un fichero, y extraerá su rol
 * -Que cuando el cliente se conecta el Servidor compruebe credenciales
 * -Que si los credenciales fallan, tenga 3 intentos (debe volver al menú del cliente)
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
