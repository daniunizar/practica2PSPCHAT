package socketprueba07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class HiloEscrituraCliente extends Thread{
	Socket servidor;
	String nombreUsuario;
	String clave;
	public HiloEscrituraCliente(Socket servidor, String nombreUsuario, String clave) {
		this.servidor = servidor;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
	}
	public void run() {
		InetAddress ia= servidor.getInetAddress();
		OutputStream os;
		InputStream isLog;
		Boolean logCorrecto = false;
		int respuesta = 0;
		try {
			os = servidor.getOutputStream();
			
			DataOutputStream dos = new DataOutputStream(os);
			
			Scanner teclado = new Scanner(System.in);
			String cadena = "";
			//El servidor cogerá el socket de nuestra conexión él solo. Falta enviarle usuario y contraseña

			//Le enviamos el usuario y clave
			dos.writeUTF(nombreUsuario + " " + clave);

			//recibimos resultado CORRECTO o INCORRECTO
			isLog = servidor.getInputStream();
			DataInputStream disLog = new DataInputStream(isLog);
			respuesta = disLog.read();
			if(respuesta==1) { //si log correcto...
				//Desde aquí el funcionamiento normal del chat: escribes en consola, y el servidor reenvía a todos los clientes
				System.out.println("Cliente: Ya puede enviar mensajes al chat desde esta consola");
				logCorrecto = true;
				while (true) {
					cadena = teclado.nextLine();
					dos.writeUTF(cadena);}//end while
			}else {//si log incorrecto...
				System.out.println("Fallo al recibir confirmacion de logueo desde Servidor, nos envió esto: "+respuesta);
			}


		} //end try
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //end catch

	} //end run
}
