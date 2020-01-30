package socketprueba10;

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
		String host = null; //Introducir localhost por teclado
		int puerto = 0; //Introducir 6000 por teclado
		String ob; //objeto compartido a todos los clientes, con la lista de ellos actualizada ¿Util para enviar privados o sileciar?
		String nombreUsuario = null;
		String clave = null;
		Socket servidor;
		int eleccionMenu;
		Scanner teclado = new Scanner(System.in);
		boolean conectadoAlChat = false;
		ObjetoLogin objetoLogin = new ObjetoLogin();
		//MENÚ DEL USUARIO, LOS VALORES NO VÁLIDOS SE SOLUCIONAN CON UN TRY-CATCH
		System.out.println("Bienvenido.\nPara establecer la conexión con el chat vamos a necesitar una dirección IP, un puerto y sus credenciales");
		while(!conectadoAlChat) {
			System.out.println("Pulse 1 para introducir una dirección IP");
			System.out.println("Pulse 2 para introducir un puerto de conexión");
			System.out.println("Pulse 3 para introducir su nombre de usuario");
			System.out.println("Pulse 4 para introducir su cotraseña");
			System.out.println("Pulse 5 para entrar al chat");
			System.out.println("Pulse 6 para salir al chat");
			try {
				eleccionMenu = teclado.nextInt();
				teclado.nextLine();
				switch(eleccionMenu) {
				case 1:
					System.out.println("Introduzca una dirección IP");
					host = teclado.nextLine();
					System.out.println("\tLa dirección ip introducida es: "+host);
					break;
				case 2:
					System.out.println("Introduzca un puerto de conexión");
					puerto = teclado.nextInt();
					System.out.println("\tEl puerto introducido es: "+puerto);
					break;
				case 3: System.out.println("Introduzca su nombre de usuario");
				nombreUsuario = teclado.nextLine();
				System.out.println("\tSu nombre de usuario es: "+nombreUsuario);
				break;
				case 4: System.out.println("Introduzca su clave de usuario");
				clave = teclado.nextLine();
				System.out.println("\tSu clave de usuario es: "+clave);
				break;
				case 5: System.out.println("Tratando de conectar con el chat...");
				if(host!=null && puerto != 0 && nombreUsuario != null && clave != null ) {
					System.out.println("Realizando conexión");
					servidor = new Socket(host, puerto);
					HiloEscrituraCliente hiloEscritura = new HiloEscrituraCliente(servidor, nombreUsuario, clave, objetoLogin);
					HiloLecturaCliente hiloLectura = new HiloLecturaCliente(servidor, objetoLogin);
					hiloEscritura.start();
					hiloLectura.start();
					conectadoAlChat=true; //Salimos del bucle del menú de usuario
					System.out.println("Salimos del bucle del menú de cliente");
				} //end if case 5
				else {
					if (host == null) System.out.println("\tDebe introducir un valor para la IP");
					if (puerto == 0) System.out.println("\tDebe introducir un valor para el PUERTO");
					if (nombreUsuario == null) System.out.println("\tDebe introducir un NOMBRE DE USUARIO");
					if (clave == null) System.out.println("\tDebe introducir una CLAVE DE USUARIO");
				} //end else case 5
				break;
				case 6:
					System.out.println("Programa finalizado");
					System.exit(0);
				}//end switch
				System.out.println("Ya hemos salido del bucle del menú del cliente");

			} //end try
			catch (Exception e){
				System.out.println("Ha introducido un valor no válido");
				teclado.nextLine();
			} //end catch
		} //end while menú usuario
	} //end main
} //end clase Cliente


