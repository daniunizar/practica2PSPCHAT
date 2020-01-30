package socketprueba11;

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
	ObjetoLogin objetoLogin;
	public HiloEscrituraCliente(Socket servidor, String nombreUsuario, String clave, ObjetoLogin objetoLogin) {
		this.servidor = servidor;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.objetoLogin = objetoLogin;
	}
	public void run() {
		InetAddress ia= servidor.getInetAddress();
		OutputStream os;
		try {
			while(objetoLogin.getValorLogeado()==false && objetoLogin.dimeIntentos()>0) {
				os = servidor.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				String cadena = "";
				//El servidor cogerá el socket de nuestra conexión él solo. Falta enviarle usuario y contraseña

				//Le enviamos el usuario y clave
				dos.writeUTF(nombreUsuario + " " + clave);
				try { //DORMIMOS UN RATO PARA DAR TIEMPO A ACTUALIZAR SI ESTAMOS LOGUEADOS O NO
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//y si la da por correcta, pasaremos a logueados y entramos en este bucle
				if(objetoLogin.getValorLogeado() == true) { //si log correcto...
					//Desde aquí el funcionamiento normal del chat: escribes en consola, y el servidor reenvía a todos los clientes
					System.out.println("Cliente Escritura: Ya puede enviar mensajes al chat desde esta consola");
					Scanner teclado = new Scanner(System.in);
					while (objetoLogin.getValorLogeado()==true) {
						cadena = teclado.nextLine();
						dos.writeUTF(cadena);}//end while
				}else {//si log incorrecto...
					System.out.println("Cliente Escritura: Log incorrecto");
					if(objetoLogin.dimeIntentos()>0) {
					Scanner teclado = new Scanner(System.in);
					System.out.println("Introduzca el nombre de usuario:");
					nombreUsuario = teclado.nextLine();
					System.out.println("Introduzca su clave:");
					clave = teclado.nextLine();}else {
						System.out.println("Cliente Escritura: No le quedan más intentos");
					}

				}
			}
			System.out.println("Cliente escritura: No quedan más intentos para loguearse");
		} //end try
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //end catch

	} //end run
}
